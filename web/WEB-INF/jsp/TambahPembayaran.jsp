<%-- 
    Document   : TambahPembayaran
    Created on : Jul 26, 2019, 12:44:13 AM
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
         <link rel="stylesheet" href="boostrap/css/cssinput.css">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="//resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </head>
    <body>
        <div>
            <table border='1'>
                <tr>
                    <th>No antrian</th>
                    <th>Nama Pasien</th>
                    <th>Kode Kunjungan</th>
                </tr>

                <c:forEach var="listPasien" items="${listantrian}">
                    <tr>              
                        <td>${listPasien.no_antrian}</td>
                        <td>${listPasien.nama_pasien}</td>
                        <td>${listPasien.kode_kunjungan}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
        <div id="divform" style="width: 500px; margin-left: 450px" >
            <form:form id="rekam" action="savePembayaran.htm" modelAttribute="pembayaranDto" method="POST">
                <center><label style="font-size: 20px">Tambah Pembayaran </label></center>
                <br>
                <label style="font-size: 20px">Kode Kunjungan</label>
                <form:select path="kode_kunjungan" class="validate validate[required]" id="pillkun" onchange="isiKdDok()">
                    <form:option value="" selected="true" disabled="true" >Pilih Kode Kunjungan</form:option>
                    <c:forEach var="IdKunjungan" items="${listantrian}">
                        <form:option value="${IdKunjungan.kode_kunjungan}">${IdKunjungan.kode_kunjungan}</form:option>
                    </c:forEach>
                </form:select>
                <label >Kode Tarif Dokter</label>
                <label style="font-size: 20px">:</label>
                <label id="idinp" style="font-size: 20px"></label>
                <form:input path="tarif_dokter" id="tdok" type="hidden" />
                <br> 
                <label > Tarif Obat</label>
                <form:input path="obat" id="obt" onkeyup="tambahtotal()" class="validate validate[required, maxSize[100]]"/>
                <label onclick="tambahtindakan()">Tambah Tindakan</label>
                <label id="namatindakan"></label>
                <form:input path="tindakan" id="tindakan" type="hidden" />
                <label id="tariftindakan"></label>
                <form:input path="harga_tindakan" id="tarif_tindakan" onkeyup="tambahtotal()" type="hidden" />
                <br>
                <label >Total</label>
                <label style="font-size: 20px">:</label>
                <label id="total" style="font-size: 20px"></label>
                <form:input path="total" id="totalinp" type="hidden" />
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>
    </body>
</html>
<script>
    function tambahtotal(a){
        var t1=document.getElementById("totalinp").value;
        var t2=document.getElementById("tarif_tindakan").value;
        var t3=document.getElementById("obt").value;
       if(t3=="")t3="0";
       if(t2=="")t2="0";
            
            var hasil=parseInt(t1)+parseInt(t2)+parseInt(t3);
            document.getElementById("total").innerHTML=hasil;
        
        
        
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
            data: "kdkunjungan=" + kdkunjungan,
            type: 'GET',
            success: function (response) {
                var data = JSON.parse(response);
                var len = data.length;
                var tmp = '';
                for (var i = 0; i < len; i++) {
                    tmp = data[i].kode_dokter;
                }
                alert(data.tarif_dokter);
                document.getElementById("idinp").innerHTML = data.tarif_dokter;
                document.getElementById("tdok").value=data.tarif_dokter;
                document.getElementById("total").innerHTML = data.tarif_dokter;
                document.getElementById("totalinp").value=data.tarif_dokter;
            }

        });
    }
</script>
