<%-- 
    Document   : UpdateLayanan
    Created on : Jul 7, 2019, 4:08:52 PM
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
        <title>Update Data Poli</title>
         <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body>
         <div id="divform" >
           <form:form id="poliUpdate" action="updatePoli.htm" modelAttribute="poliDto" method="POST">
                <center><label style="font-size: 20px">Udate Data Poli </label></center>

                <label style="font-size: 20px">Kode Poli</label>
                <label style="font-size: 20px">:</label>
                <label id="idps" style="font-size: 20px">${poliDto.kode_poli}</label>
                 <form:hidden path="kode_poli" value="${poliDto.kode_poli}" />
                <br>

              
                <label > Nama Poli</label>
              <form:input path="nama_poli" id="nm" value="${poliDto.nama_poli}" class="validate validate[required, maxSize[100]]"/>
               
                <label >Keterangan</label>
               <form:input path="keterangan" id="ket" value="${poliDto.keterangan}" class="validate validate[required, maxSize[100]]"/>
              
                <form:button type="submit" class="submit" id="save">Save</form:button>

            </form:form>
        </div>
        
        
        
           
    </body>
</html>
