<%-- 
    Document   : DataPasien
    Created on : Jul 6, 2019, 11:28:26 AM
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
        <title>Data Pasien</title>
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
                width:150px;
            }
        </style>
    </head>
    <body style="background-color: #f2f2f2">
        <br></br>
        <c:url var="tambahDataPasien" value="/doTambahDataPasien.htm">        
        </c:url>       
        <a href="${tambahDataPasien}" style="padding-left: 40px"><button id="sbm">Tambah Pasien</button></a>
    <center>          
        <table id="customers">
            <tr>
                <th>No</th> 
                <th>Kode Pasien</th>            
                <th>Nama Pasien</th> 
                <th>Tanggal Lahir</th>
                <th>Jenis Kelamin</th>
                <th>No Telpn</th>
                <th>Alamat</th>
                <th>Keterangan</th>         
                <th >Delete</th>
                <th>Update</th>
            </tr>        
            <c:set var="index" value="1"/>
            <c:set var="untk" value="p00"/>
            <c:forEach var="listPasien" items="${listPasienDto}">
                <tr>  
                    <td>${index}</td>                
                    <td>${listPasien.kode_pasien}</td>
                    <td>${listPasien.nama_pasien}</td>
                    <td>${listPasien.tanggal_lahir}</td>
                    <td>${listPasien.jenis_kelamin}</td>
                    <td>${listPasien.telepon}</td>
                    <td>${listPasien.alamat}</td>
                    <td>${listPasien.keterangan}</td> 
                    <c:url var="deletePasien" value="/deleteDataPasien.htm">
                        <c:param name="kode_pasien" value="${listPasien.kode_pasien}"/>
                    </c:url>
                    <c:url var="updatePasien" value="/getDataUpdatePasien.htm">
                        <c:param name="kode_pasien" value="${listPasien.kode_pasien}"/>
                    </c:url>
                    <td width="5%" class="hov"><a href="${deletePasien}"><img src="boostrap/icon/delete.png" width="100%" ></a></td>
                    <td width="5%" class="hov"><a href="${updatePasien}"><img src="boostrap/icon/edit.png" width="100%" ></a></td>
                </tr>            
                <c:set var="index" value="${index+1}"/>
                <c:set var="untk" value="${listPasien.kode_pasien}"/>
            </c:forEach>
        </table>       
    </center>
</body>
</html>
