package com.waka.web.ecomm.controller;

import com.waka.web.ecomm.dao.SettingsDao;
import com.waka.web.ecomm.dao.UsersDao;
import com.waka.web.ecomm.entity.SiteSetting;
import com.waka.web.ecomm.entity.Users;
import com.waka.web.ecomm.mail.VerificationMail;
import com.waka.web.ecomm.provider.MailServiceProvider;
import com.waka.web.ecomm.util.Encryption;
import com.waka.web.ecomm.util.JPAUtil;
import com.waka.web.ecomm.util.Role;
import com.waka.web.ecomm.util.Status;
import com.waka.web.mvc.core.controller.Controller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class AccountController extends Controller {

    public void index(HttpServletRequest request, HttpServletResponse response) {

        Optional<SiteSetting> settingsDao = new SettingsDao().getAppName();
        if (settingsDao.isPresent()) {
            SiteSetting appName = settingsDao.get();
            request.setAttribute("appName", appName.getValue() + " - Login");
        }

        view("login", request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Users> query = entityManager.createNamedQuery("Users.checkLogin", Users.class)
                .setParameter("email", email)
                .setParameter("password", Encryption.encrypt(password));

        try {
            Users user = query.getSingleResult();

            if (user != null) {
                request.getSession().setAttribute("user", user);
                redirect("", response); // Redirect to home page
            } else {
                redirect("account", response);
            }
        } catch (Exception e) {
            redirect("account", response);
        }

    }

    public void signup(HttpServletRequest request, HttpServletResponse response) {

        Optional<SiteSetting> settingsDao = new SettingsDao().getAppName();
        if (settingsDao.isPresent()) {
            SiteSetting appName = settingsDao.get();
            request.setAttribute("appName", appName.getValue() + " - Signup");
        }

        view("signup", request, response);

    }

    public void register(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsersDao usersDao = new UsersDao();
        boolean emailExists = usersDao.emailExists(email);
        if (!emailExists) {
            try {
                Users user = new Users();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(Encryption.encrypt(password));
                user.setRole(Role.customer);
                user.setStatus(Status.inactive);
                //verification code generate
                String verificationCode = UUID.randomUUID().toString();
                user.setVerificationCode(verificationCode);

                usersDao.createUser(user); //save user

                //sending email verification ----------------------------------------------
                VerificationMail mail = new VerificationMail(email,verificationCode);
                MailServiceProvider.getInstance().sendMail(mail);
            }catch (Exception e) {
                e.printStackTrace();
            }

            redirect("account", response);
        }

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        redirect("", response);
    }

    public void verifyEmail(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getParameter("token");
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Users> query = entityManager.createQuery("SELECT u FROM Users u WHERE u.verificationCode=:verificationCode", Users.class);
        query.setParameter("verificationCode",token);
        try {
            Users user = query.getSingleResult();
            user.setEmailVerifiedAt(new Date());
            user.setStatus(Status.active);

            entityManager.getTransaction().begin();
            entityManager.merge(user); // update user data -------------
            entityManager.getTransaction().commit();

            redirect("account",response);

        }catch (NoResultException e){
            e.printStackTrace();
        }

    }

    public void verifyError(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("user") == null) {
            redirect("account", response);
            return;
        }

        Optional<SiteSetting> settingsDao = new SettingsDao().getAppName();
        if (settingsDao.isPresent()) {
            SiteSetting appName = settingsDao.get();
            request.setAttribute("appName", appName.getValue() + " - Verify Email");
        }

        view("errorPages/verify_email", request, response);
    }

    public void verifyAccount(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("user") == null) {
            redirect("account", response);
            return;
        }

        Optional<SiteSetting> settingsDao = new SettingsDao().getAppName();
        if (settingsDao.isPresent()) {
            SiteSetting appName = settingsDao.get();
            request.setAttribute("appName", appName.getValue() + " - Verify Account");
        }

        view("errorPages/verify_account", request, response);
    }
}
