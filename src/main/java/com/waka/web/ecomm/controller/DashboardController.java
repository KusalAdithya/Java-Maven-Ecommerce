package com.waka.web.ecomm.controller;

import com.waka.web.mvc.core.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DashboardController extends Controller {

    public void index(HttpServletRequest request, HttpServletResponse response) {
        view("dashboard", request, response);

    }
}
