<%-- 
    Document   : TambahPasien
    Created on : Jul 7, 2019, 1:53:34 PM
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
        <title>JSP Page</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body >
       
       
        <div id="divform" >
            <form:form id="pasien" action="savePasien.htm" modelAttribute="pasienDto" method="POST">
               <center><label style="font-size: 20px">Tambah Pasien </label></center>
                <br>

                <form:input path="kode_pasien" id="idpas"  type="hidden" />
              
                <label > Nama Pasien</label>
                <form:input path="nama_pasien" id="nm" class="validate validate[required, maxSize[100]]"/>
                <label >Tanggal Lahir</label>
                <form:input path="tanggal_lahir" id="tl"  type="date" style="width:30%"/>
              
                <label style="font-size: 20px">Jenis Kelamin  :  </label>
                <input type="radio" path="jenis_kelamin" name="jenis_kelamin" value="Laki-laki" /><label style="font-size: 18px; ">Laki-laki </label>
                <input type="radio" path="jenis_kelamin"  name="jenis_kelamin" value="perempuan" /><label style="font-size: 18px;">Perempuan</label>
                <br>
                <label> Telepon </label>
                <form:input path="telepon" id="tlpn" />
                <label>Alamat</label>
                <form:input path="alamat" id="almt" />
                <label>Keterangan </label>
                <form:input path="keterangan" class="validate validate[required]"/>
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>
    </body>
</html>
