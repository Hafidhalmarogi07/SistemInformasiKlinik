<%-- 
    Document   : tambahdokter
    Created on : Jul 6, 2019, 10:26:12 AM
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
        <title>Tambah Data Dokter</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body onload="tampil()">
       
        <div id="divform" >
            <form:form id="dokter" action="saveDokter.htm" modelAttribute="dokterDto" method="POST">
                <center><label style="font-size: 20px">Tambah Data Dokter </label></center>
                <br>
                <label > Nama Dokter</label>
                <form:input path="nama_dokter" id="nm" class="validate validate[required, maxSize[100]]"/>
                <label >Spesialis</label>
                <form:input path="spesialis" class="validate validate[required]"/>
                <label >Tarif Dokter</label>
                <form:input path="tarif" class="validate validate[required]"/>

                <form:button type="submit" class="submit" id="save">Save</form:button>

            </form:form>
        </div>


    </body>
</html>
