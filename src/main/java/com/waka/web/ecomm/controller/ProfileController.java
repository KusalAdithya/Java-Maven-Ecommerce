package com.waka.web.ecomm.controller;

import com.waka.web.mvc.core.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProfileController extends Controller {
    public void index(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().write("Hello from Profile Controller");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
