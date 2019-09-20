<%-- 
    Document   : UpdateRekamMedis
    Created on : Sep 4, 2019, 10:52:40 AM
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
        <title>Update Rekam Medis</title>
         <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body>
        <div id="divform" >
            <form:form id="rekam" action="updateRekamMedis.htm" modelAttribute="rekamMedisDto" method="POST">
                <center><label style="font-size: 20px">Tambah Rekam Meids </label></center>
                <br>

                <form:hidden path="kode_rekam" /> 
                <label > Kode Rekam Medis</label>
                <label>:</label>
                <label>${rekamMedisDto.kode_rekam}</label>
                <br>
                <label > Kode Kunjungan</label>
                <label>:</label>
                <label>${rekamMedisDto.kode_kunjungan}</label>
                <form:hidden path="kode_kunjungan" />
                <br>
                <label >Keluhan</label>
                <form:input path="keluhan" id="tl" />
                <label> Diagnosa </label>
                <form:input path="diagnosa" id="tlpn" />
                <label>Tindakan</label>
                <form:input path="tindakan" id="almt" />
                <label>Resep </label>
                <form:input path="resep" class="validate validate[required]"/>
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>
    </body>
</html>
