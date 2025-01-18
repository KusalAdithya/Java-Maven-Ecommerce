<%@ page import="com.waka.web.ecomm.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: perer
  Date: 1/17/2025
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://com.waka.template/jsp-template" prefix="layout" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<layout:extends name="base">
    <layout:put block="contents" type="REPLACE">

        <!-- breadcrumb start-->
        <section class="breadcrumb ">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="breadcrumb_iner text-center">
                            <div class="breadcrumb_iner_item">
                                <h2>Please Verify Your Email</h2>

                                <c:if test="${sessionScope.user != null}">
                                    <h6>We have sent an email to <strong>${sessionScope.user.email}</strong> to verify
                                        your email address & activate your account.</h6>
                                    <button class="btn_3">Resend Verification link</button>
                                </c:if>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- breadcrumb start-->
    </layout:put>
</layout:extends>
