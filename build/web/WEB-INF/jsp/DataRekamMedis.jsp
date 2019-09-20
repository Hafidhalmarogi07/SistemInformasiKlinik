<%-- 
    Document   : DataRekamMedis
    Created on : Sep 3, 2019, 8:13:49 AM
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
       <title>Data Rekam Medis</title>
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
                width:200px;
            }
        </style>
    </head>
    <body>
        <br/>
        <br/>
        <c:url var="tambahRekamMedis" value="/TambahRekamMedisAdmin.htm">        
        </c:url>
        <a href="${tambahRekamMedis}" style="padding-left: 40px"><button id="sbm">Tambah Rekam Medis</button></a>
    <center>
        <table id="customers">
            <tr>
                <th>No</th> 
                <th>Kode Rekam</th> 
                <th>Kode Kunjungan</th>
                <th>Keluhan</th>            
                <th>Diangnosa</th>
                <th>Tindakan</th>            
                <th>Resep</th>
                <th>Delete</th>
                <th>Update</th>
            </tr> 
            <c:set var="index" value="1"/>
            <c:forEach var="listRekam" items="${listRekamMedisDto}">
                <tr style="height: 10px">  
                    <td >${index}</td>
                    <td>${listRekam.kode_rekam}</td>
                    <td>${listRekam.kode_kunjungan}</td>
                    <td>${listRekam.keluhan}</td> 
                    <td>${listRekam.diagnosa}</td>
                    <td>${listRekam.tindakan}</td>
                    <td>${listRekam.resep}</td> 
                    <c:url var="deleteRekam" value="/deleteDataRekamMedis.htm">
                        <c:param name="kode_rekam" value="${listRekam.kode_rekam}"/>
                    </c:url>
                    <c:url var="updateRekam" value="/getDataUpdateRekamMedis.htm">
                        <c:param name="kode_rekam" value="${listRekam.kode_rekam}"/>
                    </c:url>
                    <td width="3%" class="hov"><a href="${deleteRekam}"><img src="boostrap/icon/delete.png" width="100%" ></a></td>
                    <td width="3%" class="hov"><a href="${updateRekam}"><img src="boostrap/icon/edit.png" width="100%"></a></td>
                </tr>            
                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </table>
        <br> <br>
    </center>
    </body>
</html>
