<%-- 
    Document   : TambahLayanan
    Created on : Jul 7, 2019, 1:38:47 PM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="MenuAdmin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body onload="tampil()">
        
        <div id="divform" >
             <form:form id="poli" action="savePoli.htm" modelAttribute="poliDto" method="POST">
                <center><label style="font-size: 20px">Tambah Poli </label></center>
                <br>          
                <label > Nama Poli</label>
               <form:input path="nama_poli" id="nm" class="validate validate[required, maxSize[100]]"/>
               
                <label >Keterangan</label>
               <form:input path="keterangan" class="validate validate[required]"/>
              
                <form:button type="submit" class="submit" id="save">Save</form:button>

            </form:form>
        </div>
                
    </body>
</html>
