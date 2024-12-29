package com.waka.web.ecomm.route;

import com.waka.web.ecomm.controller.AccountController;
import com.waka.web.ecomm.controller.HomeController;
import com.waka.web.ecomm.controller.ProfileController;
import com.waka.web.mvc.core.interfaces.BaseRouter;
import com.waka.web.mvc.core.route.RouterMap;

public class Web implements BaseRouter {
    @Override
    public void registerRouter() {
        // Register your routes here
        RouterMap.get("/", new HomeController(), "index");
        RouterMap.get("/profile", new ProfileController(), "index");
        RouterMap.get("/account", new AccountController(), "index");
    }
}
