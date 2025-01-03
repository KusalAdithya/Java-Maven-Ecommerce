package com.waka.web.mvc.core.route;

import com.waka.web.ecomm.entity.Users;
import com.waka.web.mvc.core.controller.Controller;
import com.waka.web.mvc.core.interfaces.Authenticate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

public class Routing {
    private static HashMap<String, HashMap<String, RouteModel>> routerList;

    public Routing() {
        routerList = RouterMap.getAllRouteList();
    }

    public static boolean hasRoute(String requestMethod, String url) {
        return routerList.containsKey(requestMethod) && routerList.get(requestMethod).containsKey(url); // Check if the route exists & CHECK METHOD AND URL

    }

    public void start(String url, HttpServletRequest request, HttpServletResponse response) {
        String httpRequestMethod = getHttpRequestMethod(request);// Get the request method
        RouteModel routeModel = routerList.get(httpRequestMethod).get(url);
        loadClass(routeModel, request, response);
    }

    private String getHttpRequestMethod(HttpServletRequest request) {
        return request.getMethod();
    }

    private void loadClass(RouteModel routeModel, HttpServletRequest request, HttpServletResponse response) {
        try {
            Class<? extends Controller> aClass = routeModel.getController().getClass();
            Method method = aClass.getDeclaredMethod(routeModel.getMethod(), HttpServletRequest.class, HttpServletResponse.class);

            //Authentication
            if (aClass.isAnnotationPresent(Authenticate.class)) {
                Authenticate authenticate = aClass.getAnnotation(Authenticate.class);

                if (!validateAuthentication(request, authenticate.value())) {
                    response.sendRedirect("account");
                    return;
                }
            } else if (method.isAnnotationPresent(Authenticate.class)) {
                Authenticate authenticate = method.getAnnotation(Authenticate.class);

                if (!validateAuthentication(request, authenticate.value())) {
                    response.sendRedirect("account");
                    return;
                }
            }
            method.invoke(routeModel.getController(), request, response);

        } catch (NoSuchMethodException e) {
            Logger.getLogger("Routing").severe("Method not found");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            Logger.getLogger("Routing").severe("IllegalAccessException");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateAuthentication(HttpServletRequest request, String[] value) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return false;
        }

        if (value != null && value.length == 0) {
            return true;
        }

        Users user = (Users) session.getAttribute("user");
        boolean hasRole = false;
        for (String role : value) {
            if (role.equals((user.getRole().toString()))) {
                hasRole = true;
                break;
            }
        }
        return hasRole;
    }
}
