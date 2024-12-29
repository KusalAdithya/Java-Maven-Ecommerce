package com.waka.web.mvc.core.route;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

public class Routing {
    private static HashMap<String, HashMap<String, RouteModel>> routerList;

    public Routing() {
        routerList = RouterMap.getAllRouteList();
    }

    public void start(String url, HttpServletRequest request, HttpServletResponse response) {
        String httpRequestMethod = getHttpRequestMethod(request);// Get the request method
        RouteModel routeModel = routerList.get(httpRequestMethod).get(url);
        loadClass(routeModel, request, response);
    }

    public static boolean hasRoute(String requestMethod, String url) {
        return routerList.containsKey(requestMethod) && routerList.get(requestMethod).containsKey(url); // Check if the route exists & CHECK METHOD AND URL

    }

    private String getHttpRequestMethod(HttpServletRequest request) {
        return request.getMethod();
    }

    private void loadClass(RouteModel routeModel, HttpServletRequest request, HttpServletResponse response) {
        try {
            Method method = routeModel.getController().getClass().getDeclaredMethod(routeModel.getMethod(), HttpServletRequest.class, HttpServletResponse.class);
            Object[] args = new Object[2];
            args[0] = request;
            args[1] = response;
            method.invoke(routeModel.getController(), args);

        } catch (NoSuchMethodException e) {
            Logger.getLogger("Routing").severe("Method not found");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            Logger.getLogger("Routing").severe("IllegalAccessException");
        }
    }
}
