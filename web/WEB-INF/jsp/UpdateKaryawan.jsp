<%-- 
    Document   : UpdateKaryawan
    Created on : Jul 27, 2019, 9:21:04 PM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="HalamanUtama.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Data Karyawan</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body>
        <div id="divform" >
            <form:form id="karyawanUpdate" action="updateKaryawan.htm" modelAttribute="karyawanDto" method="POST">
                <form:hidden path="id_karyawan" value="${karyawanDto.id_karyawan}" />
                <label>Nama Karyawan</label>
               <form:input path="nama_karyawan" value="${karyawanDto.nama_karyawan}"id="nama_karyawan" />
                <label>Password </label>
                <form:input path="password" id="password" value="${karyawanDto.password}"class="validate validate[required]"/>
                <label>Alamat </label>
                <form:input path="alamat" id="alamat" value="${karyawanDto.alamat}" class="validate validate[required]"/>
                <label>Bagian </label>
                <form:input path="bagian" id="bagian" value="${karyawanDto.bagian}" class="validate validate[required]"/>
                <label>Telepon </label>
                <form:input path="telp" id="telp" value="${karyawanDto.telp}" class="validate validate[required]"/>
                <label>Kode Poli </label>
                <form:input path="kode_poli" id="kode_poli"  value="${karyawanDto.kode_poli}" class="validate validate[required]"/>
              
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        
        </div>
 
    </body>
</html>
