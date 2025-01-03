package com.waka.web.ecomm.controller;

import com.waka.web.ecomm.entity.Users;
import com.waka.web.ecomm.util.JPAUtil;
import com.waka.web.mvc.core.controller.Controller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AccountController extends Controller {
    public void index(HttpServletRequest request, HttpServletResponse response) {
        view("login", request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");



        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Users> query = entityManager.createNamedQuery("Users.checkLogin", Users.class)
                .setParameter("email", email)
                .setParameter("password", password);

        try {
            Users user = query.getSingleResult();

            if (user != null) {
                request.getSession().setAttribute("user", user);
            redirect("", response); // Redirect to home page
            } else {
                redirect("account", response);
            }
        }catch (Exception e){
            redirect("account", response);
        }

    }

    public void logout (HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("user");
        redirect("", response);
    }
}
