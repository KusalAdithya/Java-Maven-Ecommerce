<%--
  Created by IntelliJ IDEA.
  User: perer
  Date: 1/17/2025
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your account has been disabled</h1>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://com.waka.template/jsp-template" prefix="layout" %>

<layout:extends name="base">
    <layout:put block="contents" type="REPLACE">

        <!-- breadcrumb start-->
        <section class="breadcrumb">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="breadcrumb_iner  text-center">
                            <div class="breadcrumb_iner_item">
                                <h2>Your account has been disabled!</h2>
                                <h5>Please contact Aranoz customer support at <a href="mailto:support@aranoz.com">support@aranoz.com</a></h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- breadcrumb start-->
    </layout:put>
</layout:extends>