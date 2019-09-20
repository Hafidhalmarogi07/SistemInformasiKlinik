<%-- 
    Document   : DataKaryawan
    Created on : Jul 24, 2019, 6:23:35 PM
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
        <title>Data Karyawan</title>
        <style>
            #customers {
                font-family: "Times New Roman", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 95%;
            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr:nth-child(even){background-color: white;}

            #customers tr:hover {background-color: #ddd;}

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: center;
                background-color: #4CAF50;
                color: white;

            }

            #sbm{
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 10px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 2px 2px;
                cursor: pointer;
                border-radius: 12px;
                width:175px;
            }
        </style>
    </head>
    <body>
       <br/>
        <br/>
        <c:url var="tambahDataKaryawan" value="/doTambahDataKaryawan.htm">        
        </c:url>
        <a href="${tambahDataKaryawan}" style="padding-left: 40px"><button id="sbm">Tambah Karyawan</button></a>
    <center>
        <table id="customers">
            <tr>
                <th>No</th> 
                <th>Id Karyawan</th>            
                <th>Nama Karyawan</th> 
                <th>Jenis Kelamin</th>               
                <th>Alamat</th>
                <th>Nomor Tlpn</th>
                <th>Password</th>
                <th>Status Bagian</th>
                <th> Kode Poli</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>        
            <c:set var="index" value="1"/>
            <c:forEach var="listKaryawan" items="${listKaryawanDto}">
                <tr style="height: 10px">  
                    <td >${index}</td>
                    <td>${listKaryawan.id_karyawan}</td>
                    <td>${listKaryawan.nama_karyawan}</td>
                    <td>${listKaryawan.jenis_kelamin}</td>
                    <td>${listKaryawan.alamat}</td>
                    <td>${listKaryawan.telp}</td>
                    <td>${listKaryawan.password}</td>
                    <td>${listKaryawan.bagian}</td> 
                    <td>${listKaryawan.kode_poli}</td> 
                    <c:url var="deleteKaryawan" value="/deleteDataKaryawan.htm">
                        <c:param name="id_Karyawan" value="${listKaryawan.id_karyawan}"/>
                    </c:url>
                    <c:url var="updateKaryawan" value="/getDataUpdateKaryawan.htm">
                        <c:param name="id_Karyawan" value="${listKaryawan.id_karyawan}"/>
                    </c:url>
                    <td width="3%" class="hov"><a href="${deleteKaryawan}"><img src="boostrap/icon/delete.png" width="100%" ></a></td>
                    <td width="3%" class="hov"><a href="${updateKaryawan}"><img src="boostrap/icon/edit.png" width="100%"></a></td>
                </tr>            
                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </table>
        <br> <br>
    </center>
    </body>
</html>
