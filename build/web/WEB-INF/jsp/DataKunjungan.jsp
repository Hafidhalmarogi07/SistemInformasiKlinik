<%-- 
    Document   : DataKunjungan
    Created on : Sep 2, 2019, 10:03:56 PM
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
        <title>Data Kunjungan</title>
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
        <c:url var="tambahDataKunjungan" value="/TambahKunjungan.htm">        
        </c:url>       
        <a href="${tambahDataKunjungan}" style="padding-left: 40px"><button id="sbm">Tambah Kunjungan</button></a>
    <center>          
        <table id="customers">
            <tr>
                <th>NO</th> 
                <th>Kode Kunjungan</th> 
                <th>Tanggal Kunjugan</th>            
                <th>Nama Poli</th>            
                <th>Nama Pasien</th>         
                <th >Nama Dokter</th>
                <th>Metode Pembayaran</th>
                <th >Delete</th>
                <th>Update</th>
            </tr>        
            <c:set var="index" value="1"/>
            <c:forEach var="listKunjungan" items="${listKunjunganDto}">
                <tr style="height: 10px">  
                    <td >${index}</td>
                    <td>${listKunjungan.kode_kunjungan}</td>
                    <td>${listKunjungan.tanggal_kunjungan}</td>
                    <td>${listKunjungan.nama_poli}</td>
                    <td>${listKunjungan.nama_pasien}</td>
                    <td>${listKunjungan.nama_dokter}</td>
                    <td>${listKunjungan.metode_pembayaran}</td>
                    <c:url var="deletekunjungan" value="/deleteDataKunjungan.htm">
                        <c:param name="kode_kunjungan" value="${listKunjungan.kode_kunjungan}"/>
                    </c:url>
                    <c:url var="updateKunjungan" value="/getDataUpdateKunjungan.htm">
                        <c:param name="kode_kunjungan" value="${listKunjungan.kode_kunjungan}"/>
                    </c:url>
                    <td width="5%" class="hov"><a href="${deletekunjungan}"><img src="boostrap/icon/delete.png" width="100%" ></a></td>
                    <td width="5%" class="hov"><a href="${updateKunjungan}"><img src="boostrap/icon/edit.png" width="100%" ></a></td>

                </tr>


                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </table>       
    </center>
    </body>
</html>
