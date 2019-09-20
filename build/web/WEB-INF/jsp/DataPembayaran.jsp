<%-- 
    Document   : DataPembayaran
    Created on : Sep 4, 2019, 2:27:20 PM
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
        <title>Data Pembayaran</title>
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
       <br></br>
        <c:url var="tambahDataPembayaran" value="/TambahPembayaranAdmin.htm">        
        </c:url>       
        <a href="${tambahDataPembayaran}" style="padding-left: 40px"><button id="sbm">Tambah Pembayaran</button></a>
    <center>          
        <table id="customers">
            <tr>
                <th>NO</th> 
                <th>Kode_pembayaran</th> 
                <th>Kode_kunjungan</th>            
                <th>Tarif_dokter</th>            
                <th>Tarif obat</th>         
                <th>Tindakan</th> 
                <th>Tarif_tindakan</th>
                <th>Total Pembayaran</th>
                <th >Delete</th>
                <th>Update</th>
            </tr>        
            <c:set var="index" value="1"/>
            <c:forEach var="listPembayaran" items="${listPembayaranDto}">
                <tr style="height: 10px">  
                    <td >${index}</td>
                    <td>${listPembayaran.kode_pembayaran}</td>
                    <td>${listPembayaran.kode_kunjungan}</td>
                    <td>${listPembayaran.tarif_dokter}</td>
                    <td>${listPembayaran.obat}</td>
                    <td>${listPembayaran.tindakan}</td>
                    <td>${listPembayaran.harga_tindakan}</td>
                    <td>${listPembayaran.total}</td>
                    <c:url var="deletePembayaran" value="/deletePembayaran.htm">
                        <c:param name="kode_pembayaran" value="${listPembayaran.kode_pembayaran}"/>
                    </c:url>
                    <c:url var="updatePembayaran" value="/getUpdatePembayaran.htm">
                        <c:param name="kode_pembayaran" value="${listPembayaran.kode_pembayaran}"/>
                    </c:url>
                    <td width="5%" class="hov"><a href="${deletePembayaran}"><img src="boostrap/icon/delete.png" width="100%" ></a></td>
                    <td width="5%" class="hov"><a href="${updatePembayaran}"><img src="boostrap/icon/edit.png" width="100%" ></a></td>
                </tr>
                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </table>       
    </center>
    </body>
</html>
