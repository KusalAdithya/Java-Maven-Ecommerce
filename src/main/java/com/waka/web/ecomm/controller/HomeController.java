package com.waka.web.ecomm.controller;

import com.waka.web.ecomm.entity.SiteSetting;
import com.waka.web.ecomm.entity.Users;
import com.waka.web.ecomm.util.JPAUtil;
import com.waka.web.mvc.core.controller.Controller;
import com.waka.web.mvc.core.interfaces.Authenticate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class HomeController extends Controller {

    public void index(HttpServletRequest request, HttpServletResponse response) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<SiteSetting> query = entityManager.createQuery("SELECT s FROM SiteSetting s WHERE s.name=: name", SiteSetting.class);
        query.setParameter("name", "app_name");
        SiteSetting appName = query.getSingleResult();
        request.setAttribute("appName", appName.getValue());


        view("index", request, response);
    }


    @Authenticate
    public void profile(HttpServletRequest request, HttpServletResponse response) {
        view("profile", request, response);
    }
}
