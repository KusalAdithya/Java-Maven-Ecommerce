package com.waka.web.ecomm.dao;

import com.waka.web.ecomm.entity.Users;
import com.waka.web.ecomm.util.JPAUtil;
import com.waka.web.ecomm.util.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UsersDao {

    private final EntityManager entityManager;

    public UsersDao() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public Users getUserById(Long id) {
        return entityManager.find(Users.class, id);
    }

    public Optional<Users> getUserByEmail(String email) {
        TypedQuery<Users> query = entityManager.createNamedQuery("Users.findByEmail", Users.class)
                .setParameter("email", email);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public void createUser(Users user) {
        executeInsideTransaction(() -> {
            if (user.getCreatedAt() == null) {
                user.setCreatedAt(new Date());
            }
            entityManager.persist(user);
        });
    }

    public void updateUser(Users user) {
        executeInsideTransaction(() -> entityManager.merge(user));
    }

    public void deleteUser(Long id) {
        executeInsideTransaction(() -> {
            Users user = entityManager.find(Users.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        });
    }

    public boolean emailExists(String email) {
        return getUserByEmail(email).isPresent();
    }

    public boolean checkEmailVerified(String email){
        try {
            // Check if email is verified
            Optional<Users> user = getUserByEmail(email);
            return user.filter(u->u.getEmailVerifiedAt() != null).isPresent();
        }catch (NoResultException e) {
           return false;
        }
    }

    public boolean checkUserStatus(String email){
        try {
            // Check if user is active
            Optional<Users> user = getUserByEmail(email);
            return user.filter(u->u.getStatus()== Status.active).isPresent();
        }catch (NoResultException e) {
           return false;
        }
    }

    public List<Users> listAllUsers() {
        String jpql = "SELECT u FROM Users u";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        return query.getResultList();
    }

    public void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    private void executeInsideTransaction(Runnable action) {
        entityManager.getTransaction().begin();
        try {
            action.run();
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace(); // Preserve exception semantics
        }
    }
}
