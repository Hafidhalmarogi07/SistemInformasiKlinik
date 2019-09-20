<%-- 
    Document   : UpdateKunjungan
    Created on : Sep 3, 2019, 7:45:15 AM
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
        <title>Update Data Kunjungan</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </head>
    <body>
        <div id="divform" >
            <form:form id="kunjungan" action="updateKunjungan.htm" modelAttribute="kunjunganDto" method="POST">
                <center><label style="font-size: 20px">Tambah Kunjungan </label></center>
                <br>
                <label > Kode Kunjungan</label>
                <label>&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <label>${kunjunganDto.kode_kunjungan}</label>
                <form:hidden path="kode_kunjungan"/>
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
                 <c:set var="nampas" value="${kunjunganDto.kode_pasien}"></c:set>
                    <c:forEach var="nmpasien" items="${listPasien}">
                        <c:if test="${nampas == nmpasien.kode_pasien}">
                            <c:set var="nampas" value="${nampas} - ${nmpasien.nama_pasien}"></c:set>
                        </c:if>
                    </c:forEach>
                <form:input path="kode_pasien" id="nmpasien" value="${nampas}" />
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
