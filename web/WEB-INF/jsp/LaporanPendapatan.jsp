<%-- 
    Document   : LaporanPendapatan
    Created on : Aug 24, 2019, 9:32:27 AM
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
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="//resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
    <body>
       <div>
            <label> filter data </label>
            <label>berdasarkan metode pembayaran</label>
            <select id="metodepemabayaran">
                 <option value="0">- -> SEMUA < - -</option>
                 <option value="Umum"> UMUM</option>
                 <option value="BPJS"> BPJS</option>
            </select>
            <button onclick="isilaporan()">Filter Laporan</button>
            <br>
            <input id="mulai" placeholder="Start" type="date" >
            <input id="selesai" placeholder="END" type="date" >
            <button onclick="isilapdate()">Filter Laporan</button>
            
        </div>
        <table id="customers">
            <tr>
                <th>NO</th> 
                <th>Kode Pembayaran</th> 
                <th>Tanggal Kunjugan</th>            
                <th>Tarif Dokter</th>            
                <th>Tarif Obata</th>         
                <th >Tarif Tidakan</th>
                <th>Metode Pembayaran</th>
            </tr>        
            <c:set var="index" value="1"/>
            <c:forEach var="listLaporan" items="${listLaporanPendapatan}">
                <tr style="height: 10px">  
                    <td >${index}</td>
                    <td>${listLaporan.kode_pembayaran}</td>
                    <td>${listLaporan.tanggal_kunjungan}</td>
                    <td>${listLaporan.tarif_dokter}</td>
                    <td>${listLaporan.obat}</td>
                    <td>${listLaporan.harga_tindakan}</td>
                    <td>${listLaporan.metode_pembayaran}</td>
                </tr>


                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </table>
    </body>
</html>
<script>
    function isilaporan()
    {
        var met = document.getElementById("metodepemabayaran").value;
        var content;            
            $.ajax({
                url: 'getLaporanPendapatan.htm',
                type: 'GET',
                success: function (response) {
                    var data = JSON.parse(response);
                    var len = data.length;
                    content = '<tr><th>NO</th><th>Kode Pembayaran</th><th>Tanggal Kunjugan</th><th>Tarif Dokter</th><th>Tarif Obat</th><th >Tarif Tindakan</th><th>Metode Pembayaran</th></tr> ';
                    for (var i = 0; i < len; i++) {
                         if(met==data[i].metode_pembayaran){
                        content += '<tr> <td>'+ i+1 + '</td><td>' + data[i].kode_pembayaran + '</td><td>'+ data[i].tanggal_kunjungan + '</td><td>'+ data[i].tarif_dokter + '</td><td>'+ data[i].obat + '</td><td>'+ data[i].harga_tindakan + '</td><td>'+ data[i].metode_pembayaran + '</td><tr>';
                    }else if(met==0){
                        content += '<tr> <td>'+ i+1 + '</td><td>' + data[i].kode_pembayaran + '</td><td>'+ data[i].tanggal_kunjungan + '</td><td>'+ data[i].tarif_dokter + '</td><td>'+ data[i].obat + '</td><td>'+ data[i].harga_tindakan + '</td><td>'+ data[i].metode_pembayaran + '</td><tr>';


                        
                    }
                }
                    $('#customers').html(content);
                }
            });

    }
    
    function isilapdate(){
        var mulai = document.getElementById("mulai").value;
        var selesai = document.getElementById("selesai").value;
        var content;            
            $.ajax({
                url: 'getLaporanPendapatan.htm',
                type: 'GET',
                success: function (response) {
                    var data = JSON.parse(response);
                    var len = data.length;                   
                    content = '<tr><th>NO</th><th>Kode Pembayaran</th><th>Tanggal Kunjugan</th><th>Tarif Dokter</th><th>Tarif Obat</th><th >Tarif Tindakan</th><th>Metode Pembayaran</th></tr> ';
                    for (var i = 0; i < len; i++) {
                         if(data[i].tanggal_kunjungan>=mulai && data[i].tanggal_kunjungan<=selesai){
                        content += '<tr> <td>'+ i+1 + '</td><td>' + data[i].kode_pembayaran + '</td><td>'+ data[i].tanggal_kunjungan + '</td><td>'+ data[i].tarif_dokter + '</td><td>'+ data[i].obat + '</td><td>'+ data[i].harga_tindakan + '</td><td>'+ data[i].metode_pembayaran + '</td><tr>';
                    }
                }
                    $('#customers').html(content);
                }
            });
        
    }

</script>
