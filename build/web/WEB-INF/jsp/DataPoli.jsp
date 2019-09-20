<%-- 
    Document   : DataLayanan
    Created on : Jul 6, 2019, 10:58:34 AM
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
        <title>JSP Page</title>
        <style>
            #customers {
                font-family: "Times New Roman", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 80%;

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
                font-style: initial;
                font-size: 20px;
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
    <body style="background-color: #f2f2f2;">
        <br/>
        <br/>
        <c:url var="tambahDataPoli" value="/doTambahDataPoli.htm">        
        </c:url>
        <a href="${tambahDataPoli}" style="padding-left: 140px"><button id="sbm">Tambah Poli</button></a>
    <center>
        <table id="customers">
            <tr>
                <th>No</th> 
                <th>Kode Poli</th>            
                <th>Nama Poli</th>            
                <th>Keterangan</th>         
                <th >Delete</th>
                <th>Update</th>
            </tr>        
            <c:set var="index" value="1"/>
            <c:forEach var="listPoli" items="${listPoliDto}">
                <tr style="height: 10px">  
                    <td >${index}</td>
                    <td>${listPoli.kode_poli}</td>
                    <td>${listPoli.nama_poli}</td>
                    <td>${listPoli.keterangan}</td> 
                    <c:url var="deletePoli" value="/deleteDataPoli.htm">
                        <c:param name="kode_poli" value="${listPoli.kode_poli}"/>
                    </c:url>
                    <c:url var="updatePoli" value="/getDataUpdatePoli.htm">
                        <c:param name="kode_poli" value="${listPoli.kode_poli}"/>
                    </c:url>
                    <td width="3%" class="hov"><a href="${deletePoli}"><img src="boostrap/icon/delete.png" width="100%" ></a></td>
                    <td width="3%" class="hov"><a href="${updatePoli}"><img src="boostrap/icon/edit.png" width="100%"></a></td>
                </tr>            
                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </table>
        <br> <br>
    </center>
</body>
</html>
