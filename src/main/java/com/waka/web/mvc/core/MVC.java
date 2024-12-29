package com.waka.web.mvc.core;

import com.waka.web.ecomm.route.Web;
import com.waka.web.mvc.core.interfaces.BaseRouter;
import com.waka.web.mvc.core.route.RouterMap;
import com.waka.web.mvc.core.route.Routing;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MVC {
    private static MVC mvc;
    private RouterMap routerMap;
    private Routing routing;
    private BaseRouter baseRouter;

    public MVC() {
        if (mvc == null) {
            mvc = this;
            routerMap = new RouterMap();
            routing = new Routing();
            baseRouter = new Web();
            baseRouter.registerRouter();
        }
    }

    public static MVC getInstance() {
        if (mvc == null) {
            mvc = new MVC();
        }
        return mvc;
    }

    public void doRouting(String url, HttpServletRequest request, HttpServletResponse response) {
        routing.start(url, request, response);
    }
}
