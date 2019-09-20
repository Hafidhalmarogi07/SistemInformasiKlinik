<%-- 
    Document   : UpdateDokter
    Created on : Jul 7, 2019, 2:27:19 PM
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
        <title>Update Data Dokter</title>
         <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body>
        <div id="divform" >
            <form:form id="dokterUpdate" action="updateDokter.htm" modelAttribute="dokterDto" method="POST">
                <form:hidden path="kode_dokter" value="${dokterDto.kode_dokter}" />
                <center><label style="font-size: 20px">Udate Data Dokter </label></center>
                <label style="font-size: 20px">Kode Dokter</label>
                <label style="font-size: 20px">:</label>
                <label id="idps" style="font-size: 20px">${dokterDto.kode_dokter}</label>
                <br>
                <label > Nama Dokter</label>
                <form:input path="nama_dokter" id="nm" value="${dokterDto.nama_dokter}"/> 
                <label >Spesialis</label>
                <form:input path="spesialis" id="sp" value="${dokterDto.spesialis}" class="validate validate[required, maxSize[100]]"/>
                <label >Tarif Dokter</label>
                <form:input path="tarif" id="sp" value="${dokterDto.tarif}" class="validate validate[required, maxSize[100]]"/>  
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>
    </body>
</html>
