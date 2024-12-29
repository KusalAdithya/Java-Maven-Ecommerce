package com.waka.web.ecomm.controller;

import com.waka.web.ecomm.entity.Users;
import com.waka.web.ecomm.util.JPAUtil;
import com.waka.web.mvc.core.controller.Controller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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


        Users user = query.getSingleResult();
        System.out.println(user);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            redirect("index", response);
        } else {
            request.setAttribute("error", "Invalid email or password");
            view("account", request, response);
        }
    }
}
