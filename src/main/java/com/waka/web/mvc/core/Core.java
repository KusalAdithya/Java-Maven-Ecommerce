package com.waka.web.mvc.core;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Core", urlPatterns = "/app/*", loadOnStartup = 1)
public class Core extends HttpServlet {

    @Override
    public void init() throws ServletException {
        MVC mvc = new MVC();
    }

    @Override
    public void service(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        String path = servletRequest.getRequestURI().substring(servletRequest.getContextPath().length());
        MVC.getInstance().doRouting(path.substring(4), servletRequest, servletResponse); // Remove /app from the path
    }
}
