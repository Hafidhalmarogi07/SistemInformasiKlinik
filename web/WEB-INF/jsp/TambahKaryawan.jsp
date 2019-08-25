<%-- 
    Document   : TambahKaryawan
    Created on : Jul 27, 2019, 9:05:56 PM
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
        <title>Tambah Data Karyawan</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </head>
    <body>
       <div id="divform" >
            <form:form id="karyawan" action="saveKaryawan.htm" modelAttribute="karyawanDto" method="POST">
                <center><label style="font-size: 20px">Tambah Karyawan </label></center>
                <br>      
                <label> Nama Karyawan </label>
                <form:input path="nama_karyawan" id="nama_karyawan" />
                <label>Password </label>
                <form:input path="password" id="password" class="validate validate[required]"/>
                <label>Alamat </label>
                <form:input path="alamat" id="alamat" class="validate validate[required]"/>
                <label>Bagian </label>
                <form:input path="bagian" id="bagian" class="validate validate[required]"/>
                <label>Telepon </label>
                <form:input path="telp" id="telp" class="validate validate[required]"/>
                <label>Kode Poli </label>
                <form:input path="kode_poli" id="kode_poli" class="validate validate[required]"/>
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>
    </body>
</html>
