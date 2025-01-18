package com.waka.web.ecomm.controller;

import com.waka.web.ecomm.dao.SettingsDao;
import com.waka.web.ecomm.entity.SiteSetting;
import com.waka.web.mvc.core.controller.Controller;
import com.waka.web.mvc.core.interfaces.Authenticate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;

@Authenticate
public class DashboardController extends Controller {

    public void index(HttpServletRequest request, HttpServletResponse response) {
        Optional<SiteSetting> settingsDao = new SettingsDao().getAppName();
        if (settingsDao.isPresent()) {
            SiteSetting appName = settingsDao.get();
            request.setAttribute("appName", appName.getValue() + " - Dashboard");
        }
        view("DashBoard/dashboard", request, response);

    }
}
