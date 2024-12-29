package com.waka.web.ecomm.controller;

import com.waka.web.ecomm.entity.Users;
import com.waka.web.ecomm.util.JPAUtil;
import com.waka.web.mvc.core.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeController extends Controller {

    public void index(HttpServletRequest request, HttpServletResponse response) {
        view("index", request, response);

    }
}
