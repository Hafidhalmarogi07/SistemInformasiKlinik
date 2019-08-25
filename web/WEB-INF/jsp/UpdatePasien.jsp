<%-- 
    Document   : UpdatePasien
    Created on : Jul 7, 2019, 4:57:41 PM
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
        <title>Update Pasien</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body>
        <div id="divform" >
            <form:form id="pasienUpdate" action="updatePasien.htm" modelAttribute="pasienDto" method="POST">
                <form:hidden path="kode_pasien" value="${pasienDto.kode_pasien}" />
                <center><label style="font-size: 20px">Update Data Pasien </label></center>

                <label style="font-size: 20px">Kode Pasien</label>
                <label style="font-size: 20px">:</label>
                <label style="font-size: 20px">${pasienDto.kode_pasien}</label>
                <br>

                <label > Nama Pasien</label>
                <form:input path="nama_pasien" id="nm" value="${pasienDto.nama_pasien}" />
                <label >Tanggal Lahir</label>
                <form:input path="tanggal_lahir" id="tl" value="${pasienDto.tanggal_lahir}" type="date" />

                <label style="font-size: 20px">Jenis Kelamin  :  </label>
                <div class="form-group" value="${pasienDto.jenis_kelamin}" >
                    <form:radiobutton path="jenis_kelamin" value="Laki-laki"/>Laki-laki
                    <form:radiobutton path="jenis_kelamin" value="perempuan"/>Perempuan
                </div>
                <label> Telepon </label>
                <form:input path="telepon" id="tlpn" value="${pasienDto.telepon}" />
                <label>Alamat</label>
                <form:input path="alamat" id="almt" value="${pasienDto.alamat}"/>
                <label>Keterangan </label>
                <form:input path="keterangan" id="ket" value="${pasienDto.keterangan}" />
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>



        <%--        
                
               
                <center><table>      
                        <tr>
                            <td>Nama Pasien</td>
                            <td width="25px">:</td>
                            <td><form:input path="nama_pasien" id="nm" value="${pasienDto.nama_pasien}" /></td>
                        </tr>
                        <tr>
                            <td>Tanggal Lahir</td>
                            <td>:</td>
                            <td><form:input path="tanggal_lahir" id="tl" value="${pasienDto.tanggal_lahir}" type="date" /></td>
                        </tr>
                        <tr>
                            <td>Jenis Kelamin</td>
                            <td>:</td>
                            <td>
                            <div class="form-group" value="${pasienDto.jenis_kelamin}" >
                                    <form:radiobutton path="jenis_kelamin" value="Laki-laki"/>Laki-laki
                                    <form:radiobutton path="jenis_kelamin" value="perempuan"/>Perempuan
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Telepon</td>
                            <td>:</td>
                            <td><form:input path="telepon" id="tlpn" value="${pasienDto.telepon}" /></td>
                        </tr>
                        <tr>
                            <td>Alamat</td>
                            <td>:</td>
                            <td><form:input path="alamat" id="almt" value="${pasienDto.alamat}"/></td>
                        </tr>

                <tr>
                    <td>Keterangan </td>
                    <td>:</td>
                    <td><form:input path="keterangan" id="ket" value="${pasienDto.keterangan}" /></td>
                </tr>      
                <tr>
                    <td colspan="2">
                <form:button type="submit" id="update">Save</form:button>
                </td>
                </tr>
            </table>
        </center>--%>
    </body>
</html>
