<%-- 
    Document   : UpdatePembayaran
    Created on : Sep 7, 2019, 9:43:20 AM
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
        <title>Update Pembayaran</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
    </head>
    <body>
        <div id="divform" >
            <form:form id="rekam" action="updatePembayaran.htm" modelAttribute="pembayaranDto" method="POST">
                <center><label style="font-size: 20px">Update Pembayaran </label></center>
                <br>
                <form:hidden path="kode_pembayaran" /> 
                <label > Kode Rekam Medis</label>
                <label>:</label>
                <label>${pembayaranDto.kode_pembayaran}</label>
                <br>
                <label > Kode Kunjungan</label>
                <label>&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <label>${pembayaranDto.kode_kunjungan}</label>
                <br>
                <form:hidden path="kode_kunjungan" />
                <label >Kode Tarif Dokter</label>
                <label >&nbsp;&nbsp;&nbsp;:</label>
                <label id="idinp">${pembayaranDto.tarif_dokter}</label>
                <form:hidden path="tarif_dokter" id="hardok" />
                <br> 
                <label > Tarif Obat</label>
                <form:input path="obat" id="obt" onkeyup="tambahtotal()" class="validate validate[required, maxSize[100]]"/>
                <label >Nama Tindakan</label>
                <form:input path="tindakan" />
                <label>Tarif Tindakan</label>
                <form:input path="harga_tindakan" id="tarif_tindakan" onkeyup="tambahtotal()" />
                <br>
                <label >Total</label>
                <label style="font-size: 20px">:</label>
                <label id="total" style="font-size: 20px">${pembayaranDto.total}</label>
                <form:input path="total" id="totalinp" type="hidden" />
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>
    </body>
</html>
<script>
    function tambahtotal(a){
        var t1=document.getElementById("hardok").value;
        var t2=document.getElementById("tarif_tindakan").value;
        var t3=document.getElementById("obt").value;
       if(t3=="")t3="0";
       if(t2=="")t2="0";
            
            var hasil=parseInt(t1)+parseInt(t2)+parseInt(t3);
            document.getElementById("total").innerHTML=hasil;
            document.getElementById("totalinp").value=hasil;
                
    }
    function tambahtindakan(){
        document.getElementById("namatindakan").innerHTML="Nama Tindakan";
        document.getElementById("tariftindakan").innerHTML="Tarif Tindakan";
        var xxx=document.getElementById("tindakan");
        var xxxx=document.getElementById("tarif_tindakan");
        xxx.type="text";
        xxxx.type="text";
    }
        
    function isiKdDok()
    {
        var kdkunjungan = document.getElementById("pillkun").value;
        alert(kdkunjungan);
        $.ajax({
            url: 'getDataMajorDokter.htm',
            data: "kdkunjungan="+ kdkunjungan,
            type: 'GET',
            success: function (response) {
                var data = JSON.parse(response);
                var len = data.length;
                for (var i = 0; i < len; i++) {
                    document.getElementById("idinp").innerHTML = data[i].tarif_dokter;
                    document.getElementById("tdok").value=data[i].tarif_dokter;
                    document.getElementById("total").innerHTML = data[i].tarif_dokter;
                    document.getElementById("totalinp").value=data[i].tarif_dokter;
                }
               
            }

        });
    }
</script>