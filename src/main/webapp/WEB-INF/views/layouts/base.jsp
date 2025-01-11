<%--
  Created by IntelliJ IDEA.
  User: perer
  Date: 11/28/2024
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://com.waka.template/jsp-template" prefix="layout" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${requestScope.appName}</title>

    <link rel="icon" href="img/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/all.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/magnific-popup.css">
    <!-- swiper CSS -->
    <link rel="stylesheet" href="css/slick.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <layout:block name="dashboardStyle">
        <%--      dashboardStyle--%>
<%--        <link rel="icon" href="img/favicon.png">--%>
<%--        <!-- Bootstrap CSS -->--%>
<%--        <link rel="stylesheet" href="css/bootstrap.min.css">--%>
<%--        <!-- animate CSS -->--%>
<%--        <link rel="stylesheet" href="css/animate.css">--%>
<%--        <!-- owl carousel CSS -->--%>
<%--        <link rel="stylesheet" href="css/owl.carousel.min.css">--%>
<%--        <!-- font awesome CSS -->--%>
<%--        <link rel="stylesheet" href="css/all.css">--%>
<%--        <!-- flaticon CSS -->--%>
<%--        <link rel="stylesheet" href="css/flaticon.css">--%>
<%--        <link rel="stylesheet" href="css/themify-icons.css">--%>
<%--        <!-- font awesome CSS -->--%>
<%--        <link rel="stylesheet" href="css/magnific-popup.css">--%>
<%--        <!-- swiper CSS -->--%>
<%--        <link rel="stylesheet" href="css/slick.css">--%>
<%--        <!-- style CSS -->--%>
<%--        <link rel="stylesheet" href="css/style.css">--%>
    </layout:block>
</head>
<body>

<layout:block name="dashboardHeader">

    <jsp:include page="../includes/header.jsp"/>

</layout:block>

    <layout:block name="contents">
<%--      contents--%>
    </layout:block>

<layout:block name="dashboardFooter">

    <jsp:include page="../includes/footer.jsp"/>

</layout:block>



<layout:block name="dashboardJs">
    <%--      dashboardJs--%>
<%--    <script src="js/jquery-1.12.1.min.js"></script>--%>
<%--    <!-- popper js -->--%>
<%--    <script src="js/popper.min.js"></script>--%>
<%--    <!-- bootstrap js -->--%>
<%--    <script src="js/bootstrap.min.js"></script>--%>
<%--    <!-- easing js -->--%>
<%--    <script src="js/jquery.magnific-popup.js"></script>--%>
<%--    <!-- swiper js -->--%>
<%--    <script src="js/swiper.min.js"></script>--%>
<%--    <!-- swiper js -->--%>
<%--    <script src="js/masonry.pkgd.js"></script>--%>
<%--    <!-- particles js -->--%>
<%--    <script src="js/owl.carousel.min.js"></script>--%>
<%--    <script src="js/jquery.nice-select.min.js"></script>--%>
<%--    <!-- slick js -->--%>
<%--    <script src="js/slick.min.js"></script>--%>
<%--    <script src="js/jquery.counterup.min.js"></script>--%>
<%--    <script src="js/waypoints.min.js"></script>--%>
<%--    <script src="js/contact.js"></script>--%>
<%--    <script src="js/jquery.ajaxchimp.min.js"></script>--%>
<%--    <script src="js/jquery.form.js"></script>--%>
<%--    <script src="js/jquery.validate.min.js"></script>--%>
<%--    <script src="js/mail-script.js"></script>--%>
<%--    <!-- custom js -->--%>
<%--    <script src="js/custom.js"></script>--%>
</layout:block>

<!-- jquery plugins here-->
<script src="js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- easing js -->
<script src="js/jquery.magnific-popup.js"></script>
<!-- swiper js -->
<script src="js/swiper.min.js"></script>
<!-- swiper js -->
<script src="js/masonry.pkgd.js"></script>
<!-- particles js -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<!-- slick js -->
<script src="js/slick.min.js"></script>
<script src="js/jquery.counterup.min.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/contact.js"></script>
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/mail-script.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>
</body>
</html>