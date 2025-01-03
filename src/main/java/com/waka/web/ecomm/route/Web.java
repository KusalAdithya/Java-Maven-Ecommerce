package com.waka.web.ecomm.route;

import com.waka.web.ecomm.controller.AccountController;
import com.waka.web.ecomm.controller.HomeController;
import com.waka.web.mvc.core.interfaces.BaseRouter;
import com.waka.web.mvc.core.route.RouterMap;

public class Web implements BaseRouter {
    @Override
    public void registerRouter() {
        // Register your routes here
        RouterMap.get("/", new HomeController(), "index");
        RouterMap.get("/profile", new HomeController(), "profile");
        RouterMap.get("/account", new AccountController(), "index");
        RouterMap.post("/login_action", new AccountController(), "login");
        RouterMap.get("/logout_action", new AccountController(), "logout");
    }
}
