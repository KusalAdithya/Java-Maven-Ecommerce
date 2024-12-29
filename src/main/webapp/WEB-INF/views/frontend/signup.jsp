<%--
  Created by IntelliJ IDEA.
  User: perer
  Date: 12/5/2024
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://com.waka.template/jsp-template" prefix="layout" %>

<layout:extends name="base">
    <layout:put block="header" type="REPLACE">
        <title>aranoz - Signup</title>
    </layout:put>
    <layout:put block="contents" type="REPLACE">

        <!-- breadcrumb start-->
        <section class="breadcrumb breadcrumb_bg">
            <div class="container">
                <div class="row justify-content-center h-25">
                    <div class="col-lg-8">
                        <div class="breadcrumb_iner">
                            <div class="breadcrumb_iner_item">
                                <h2>Signup</h2>
                                <p>Home <span>-</span>Signup</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- breadcrumb start-->

        <!--================Register part Area =================-->
        <section class="login_part padding_top">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>Have been here before?</h2>
                                <p>There are advances being made in science and technology
                                    everyday, and a good example of this is the</p>
                                <a href="#" class="btn_3">Log in</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_form">
                            <div class="login_part_form_iner">
                                <h3>New Here ?<br>
                                    Please Sign up now</h3>
                                <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                                    <div class="col-md-12 form-group p_star">
                                        <input type="text" class="form-control" id="email" name="name"
                                               placeholder="Email">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="password" class="form-control" id="password" name="password"
                                               placeholder="New Password">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="password" class="form-control" id="cpassword" name="cpassword"
                                               placeholder="Confirm Password">
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <button class="btn_3">
                                            log in
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================Register_part end =================-->
    </layout:put>
</layout:extends>
