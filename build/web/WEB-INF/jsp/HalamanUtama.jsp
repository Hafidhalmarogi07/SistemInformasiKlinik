<%-- 
    Document   : HalamanUtama
    Created on : Jun 30, 2019, 1:10:38 AM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistem Klinik</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="boostrap/css/css.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <style type="text/css">
            .hov:hover {
                background-color: #00FF00;
            }

        </style>
        <%
            if (session.getAttribute("username") == null) {
                response.sendRedirect("index.htm");
            }
        %>
    </head>
    <body bgcolor="#0000CD" background="#0000CD">

        <div class="w3-container " style="height:85px;padding:3px;background-color: #00FF00">
            <img src="boostrap/icon/logo2.png" style="width:35%" >
            <label style="float: right; font-size: 30px; padding: 25px 70px 0px 0px;">
                <label id="jam"></label>
                :
                <label id="menit"></label>
                :
                <label id="detik"></label>
            </label>
        </div>
        <div class="w3-container w3-red" style="height:25px;padding:1px 16px;">
            <label style="color: white;font-family:Times New Roman;font-size: 20px; float: right"> 
                Bandung,  
                <label id="hari"></label>
                , 
                <label id="tanggal"> </label>
                
                <label id="bulan"> </label>
                
                <label id="tahun"> </label>

            </label>
        </div>

        <div class="w3-container w3-dark-grey" style="height:105px;padding:5px 10px">
            <c:url var="dataPasienUrl" value="/DataPasien.htm"></c:url>
            <a href="${dataPasienUrl}" >
                <img src="boostrap/icon/register.png" style="width:7%" class="hov">
            </a>
             <c:url var="dataKaryawanUrl" value="/DataKaryawan.htm"></c:url>
             <a href="${dataKaryawanUrl}">
             <img src="boostrap/icon/laboratory.png" style="width:8%" class="hov">
             </a>
            <c:url var="dataPoliUrl" value="/DataPoli.htm"></c:url>
            <a href="${dataPoliUrl}" >
                <img src="boostrap/icon/admission.png" style="width:7%" class="hov">
            </a>
            <c:url var="tambahkunjunganUrl" value="doTambahDataKunjungan.htm" ></c:url>
            <a href="${tambahkunjunganUrl}" >
                <img src="boostrap/icon/rawat inap.png" style="width:7%" class="hov">
            </a>
            <img src="boostrap/icon/rawat berjalan.png" style="width:8%" class="hov">
            <c:url var="tambahRekamUrl" value="doTambahDataRekamMedis.htm" ></c:url>
            <a href="${tambahRekamUrl}" >

                <img src="boostrap/icon/rekam medis.png" style="width:7%" class="hov">
            </a>
            <img src="boostrap/icon/apotik.png" style="width:7%" class="hov">
             <c:url var="LaporanUrl" value="LaporanKunjungan.htm" ></c:url>
            <a href="${LaporanUrl}">
            <img src="boostrap/icon/administrasi.png" style="width:7%" class="hov">
            </a>
            <img src="boostrap/icon/jasa pelayanan.png" style="width:8%" class="hov">
            <c:url var="pembayaranUrl" value="doTambahDataPembayaran.htm" ></c:url>
            <a href="${pembayaranUrl}">
            <img src="boostrap/icon/pembayaran.png" style="width:7%" class="hov">
            </a>
             <c:url var="PendapatanUrl" value="LaporanPendapatan.htm" ></c:url>
            <a href="${PendapatanUrl}">
            <img src="boostrap/icon/keuangan.png" style="width:7%" class="hov">
            </a>
            <c:url var="LaporanDokterUrl" value="LaporanPembayaranDokter.htm" ></c:url>
            <a href="${LaporanDokterUrl}">
            <img src="boostrap/icon/logistik.png" style="width:7%" class="hov">
            </a>
            <c:url var="logoutUrl" value="/exit.htm"></c:url>
            <a href="${logoutUrl}"><img src="boostrap/icon/logout.png" style="width:7%" class="hov"></a>

        </div>

    </body>
</html>
<script>
    window.setTimeout("waktu()", 1000);

    function waktu() {
        var waktu = new Date();
        setTimeout("waktu()", 1000);
        var arrhari = ["hari", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu", "Minggu"];
        var bulan=["Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"];
        document.getElementById("hari").innerHTML = arrhari[waktu.getDay()];
        document.getElementById("tanggal").innerHTML = waktu.getDate();
        document.getElementById("bulan").innerHTML = bulan[waktu.getMonth()];
        document.getElementById("tahun").innerHTML = waktu.getFullYear();

        document.getElementById("jam").innerHTML = waktu.getHours();
        document.getElementById("menit").innerHTML = waktu.getMinutes();
        document.getElementById("detik").innerHTML = waktu.getSeconds();
    }
</script>