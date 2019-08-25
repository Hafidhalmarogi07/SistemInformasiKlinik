<%-- 
    Document   : cobalogin
    Created on : Jun 30, 2019, 2:02:03 PM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            if (session.getAttribute("username") == null) {
                response.sendRedirect("index.htm");
            }
        %>
    </head>
    <body>
        <form:form action="doLogin.htm" modelAttribute="formDto" method="POST" enctype="multipart/form-data">
            <input id="user"type="text" class="form-control" placeholder="Username" path="username" name="username" required />
            <input  placeholder="Password" class="form-control" id="pass" type="password" data-type="password" path="password" name="password" required />
            <div class="group">
                <input type="submit" class="button w3-btn w3-round-xxlarge w3-dark-grey" value="Sign In"/>
            </div>
            <!--                    <button class="w3-btn w3-round-xxlarge w3-dark-grey" type="submit">Sign in</button>-->
        </form:form>
    </body>
</html>
