package com.waka.web.ecomm.dao;

import com.waka.web.ecomm.entity.SiteSetting;
import com.waka.web.ecomm.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class SettingsDao {

    private final EntityManager entityManager;

    public SettingsDao() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public Optional<SiteSetting> getAppName() {
        TypedQuery<SiteSetting> query = entityManager.createQuery("SELECT s FROM SiteSetting s WHERE s.name=: name", SiteSetting.class);
        query.setParameter("name", "app_name");
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public boolean appNameExist() {
        return getAppName().isPresent();
    }
}
