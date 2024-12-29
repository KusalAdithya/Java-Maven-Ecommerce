package com.waka.web.mvc.core.route;

import com.waka.web.mvc.core.controller.Controller;

import java.util.HashMap;

public class RouterMap {
    private static HashMap<String, RouteModel> httpGetRouterList;
    private static HashMap<String, RouteModel> httpPostRouterList;

    public RouterMap() {
        if (httpGetRouterList == null) { // Get Method
            httpGetRouterList = new HashMap<>();
        }

        if (httpPostRouterList == null) { // Post Method
            httpPostRouterList = new HashMap<>();
        }
    }

    public static void get(String urlPattern, Controller controller, String methodName) {
        httpGetRouterList.put(urlPattern, new RouteModel(methodName, controller));
    }

    public static void post(String urlPattern, Controller controller, String methodName) {
        httpPostRouterList.put(urlPattern, new RouteModel(methodName, controller));
    }

    public static HashMap<String, HashMap<String, RouteModel>> getAllRouteList() {
        HashMap<String, HashMap<String, RouteModel>> routes = new HashMap<>();
        routes.put("GET", httpGetRouterList);
        routes.put("POST", httpPostRouterList);
        return routes;
    }

}
