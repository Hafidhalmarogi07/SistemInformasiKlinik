<%-- 
    Document   : Datadokter
    Created on : Jul 5, 2019, 11:29:21 PM
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
        <title>Data Dokter</title>
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
                width:170px;
            }
        </style>
    </head>
    <body>
        <br></br>
        <c:url var="tambahDataDokter" value="/doTambahDataDokter.htm">        
        </c:url>
        <a href="${tambahDataDokter}" style="padding-left: 40px"><button id="sbm">Tambah Dokter</button></a>   
    <center>
     <table id="customers">
        <tr>
            <th>No</th> 
            <th>Kode Dokter</th>            
            <th>Nama Dokter</th>            
            <th>Spesialis</th> 
            <th>Tarif Dokter</th> 
            <th >Delete</th>
            <th>Update</th>
        </tr>        
        <c:set var="index" value="1"/>
        <c:forEach var="listDokter" items="${listDokterDto}">
            <tr>  
                <td>${index}</td>
                <td>${listDokter.kode_dokter}</td>
                <td>${listDokter.nama_dokter}</td>
                <td>${listDokter.spesialis}</td>
                 <td>${listDokter.tarif}</td>
                <c:url var="deleteDokter" value="/deleteDataDokter.htm">
                     <c:param name="kode_dokter" value="${listDokter.kode_dokter}"/>
                </c:url>
                <c:url var="updateDokter" value="/getDataUpdateDokter.htm">
                    <c:param name="kode_dokter" value="${listDokter.kode_dokter}"/>
                </c:url>
                <td width="5%" class="hov"><a href="${deleteDokter}"><img src="boostrap/icon/delete.png" width="100%" ></a></td>
                <td width="5%" class="hov"><a href="${updateDokter}"><img src="boostrap/icon/edit.png" width="100%" ></a></td>
            </tr>            
            <c:set var="index" value="${index+1}"/>
        </c:forEach>
        </table>
        <br> <br>
    </center>
    </body>
</html>
<script>
</script>
