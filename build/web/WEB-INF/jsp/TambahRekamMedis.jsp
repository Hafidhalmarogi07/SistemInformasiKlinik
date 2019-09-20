<%-- 
    Document   : TambahRekamMedis
    Created on : Jul 23, 2019, 7:42:31 AM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="HalamanUtama.jsp" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Rekam Medis</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="//resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
        <div>
            <div style=" float:left; height:500px; width: 30%;padding:20px;" >
                <c:set var="bb" value=" ${listpoll}"></c:set>
                <label>
                    ${userDto.kode_poli}
                </label>
                    <c:forEach var="aa" items="${listpoll}">
                        <label>${aa.kode_poli}</label>
                        <label>hafidh</label>
                    </c:forEach>
                        <label>hafidh</label>
                <table border='1' id="customers">
                    <tr>
                        <th>No antrian</th>
                        <th>Nama Pasien</th>
                        <th>Kode Kunjungan</th>
                    </tr>

                    <c:forEach var="listPasien" items="${listKunjungan}">
                        <tr align='center'>              
                            <td>${listPasien.no_antrian}</td>
                            <td>${listPasien.nama_pasien}</td>
                            <td>${listPasien.kode_kunjungan}</td> 
                        </tr>
                    </c:forEach>
                </table>

            </div>
            <div style=" float:left;height:500px; width: 60%;padding:20px;">
                <div style="background-color: #ddd; padding: 5%">
                    <form:form id="rekam" action="saveRekamMedis.htm" modelAttribute="rekamDto" method="POST">
                        <center><label style="font-size: 20px">Tambah Rekam Meids </label></center>
                        <br>

                        <form:input path="kode_rekam" id="idpas"  type="hidden" />  
                        <label > Kode Kunjungan</label>
                        <form:select path="kode_kunjungan" class="validate validate[required]" id="pillkun" onchange="isiKdDok()">
                            <form:option value="" selected="true" disabled="true" >Pilih Kode Kunjungan</form:option>
                            <c:forEach var="IdKunjungan" items="${listKunjungan}">
                                <form:option value="${IdKunjungan.kode_kunjungan}">${IdKunjungan.kode_kunjungan}</form:option>
                            </c:forEach>
                        </form:select>
                        <label >Keluhan</label>
                        <form:input path="keluhan" id="tl" />
                        <label> Diagnosa </label>
                        <form:input path="diagnosa" id="tlpn" />
                        <label>Tindakan</label>
                        <form:input path="tindakan" id="almt" />
                        <label>Resep </label>
                        <form:input path="resep" class="validate validate[required]"/>
                        <form:input  path="id_dokter" id="idinp" />
                        <form:input  path="nama_pasien" id="nmpasien" />
                        <form:button type="submit" class="submit" id="save">Save</form:button>
                    </form:form>
                </div>
            </div>
    </body>
</html>
<script>
    function isiKdDok()
    {
        var kdkunjungan = document.getElementById("pillkun").value;
        alert(kdkunjungan);
        $.ajax({
            url: 'getDataMajorByKunjungan.htm',
            data: "kdkunjungan=" + kdkunjungan,
            type: 'GET',
            success: function (response) {
                var data = JSON.parse(response);
                var len = data.length;
                var tmp = '';
                for (var i = 0; i < len; i++) {
                    tmp = data[i].kode_dokter;
                }
                document.getElementById("idinp").value = data.kode_dokter;
                document.getElementById("nmpasien").value = data.nama_pasien;
            }

        });
    }
</script>
