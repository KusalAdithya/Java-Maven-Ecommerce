package com.waka.web.mvc.core.route;

import com.waka.web.mvc.core.controller.Controller;

public class RouteModel {
    private final String METHOD;
    private final Controller CONTROLLER;

    public RouteModel(String METHOD, Controller CONTROLLER) {
        this.METHOD = METHOD;
        this.CONTROLLER = CONTROLLER;
    }

    public String getMethod() {
        return METHOD;
    }

    public Controller getController() {
        return CONTROLLER;
    }
}
