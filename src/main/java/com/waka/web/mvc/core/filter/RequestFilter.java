package com.waka.web.mvc.core.filter;

import com.waka.web.mvc.core.route.Routing;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "RequestFilter", urlPatterns = "/*")
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());

        if (Routing.hasRoute(httpServletRequest.getMethod(), path)) {
            httpServletRequest.getRequestDispatcher("/app" + path).forward(request, response); // Forward the request to the core servlet
        } else {
            chain.doFilter(request, response);
        }

    }
}
