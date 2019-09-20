<%-- 
    Document   : TambahKunjunganAdmin
    Created on : Sep 2, 2019, 10:39:46 PM
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
        <title>Tambah Data Kunjungan</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        
    </head>
    <body>
        <div id="divform" >
            <form:form id="kunjungan" action="saveKunjunganAdmin.htm" modelAttribute="kunjunganDto" method="POST">
                <center><label style="font-size: 20px">Tambah Kunjungan </label></center>
                <br>
                <label >Tanggal Kunjungan</label>
                <form:input path="tanggal_kunjungan" id="tl"  type="date" style="width:30%"/>
                <br>
                <label > Poli</label>
                <form:select path="Kode_poli" class="validate validate[required]" id="poli">
                    <form:option value="" selected="true" disabled="true">Pilih Poli</form:option>
                    <c:forEach var="lpoli" items="${listPoli}">
                        <form:option value="${lpoli.kode_poli}">${lpoli.nama_poli}</form:option>
                    </c:forEach>
                </form:select>
                
                <label> Pasien </label>
                <form:input path="kode_pasien" id="nmpasien" />
                <label>Dokter</label>
                <form:select path="kode_dokter" class="validate validate[required]" id="dokter">
                    <form:option value="" selected="true" disabled="true">Pilih Dokter</form:option>
                    <c:forEach var="ldokter" items="${listDokter}">
                        <form:option value="${ldokter.kode_dokter}">${ldokter.nama_dokter}</form:option>
                    </c:forEach>
                </form:select>
                <label>Metode Pembayaran </label>
                <form:select path="metode_pembayran" class="validate validate[required]">
                     <form:option value="" selected="true" disabled="true">Pilih Metode Pembayaran</form:option>
                    <form:option value="Umum" >Umum</form:option>
                    <form:option value="BPJS" >BPJS</form:option>
                </form:select>
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>
    </body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        reloadAutocompletePasien();
        function reloadAutocompletePasien() {
            jAuto = jQuery.noConflict(true);
            $.ajax({
                url: 'getautopasien.htm',
                type: 'GET',
                success: function (response) {
                    var data1 = JSON.parse(response);
                    var len1 = data1.length;
                    var xxxx = [];
                    var untkid=[];
                    for (var i = 0; i < len1; i++) {
                        xxxx[i] = data1[i].kode_pasien+" - "+data1[i].nama_pasien;
                    }
                    jAuto('#nmpasien').autocomplete({
                        source: xxxx
                        
                    });
                    jAuto('#intkid').autocomplete({
                        source:untkid
                    });
                }
            });
        }
    });
</script>

