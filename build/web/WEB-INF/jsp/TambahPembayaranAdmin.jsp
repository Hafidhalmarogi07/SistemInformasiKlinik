<%-- 
    Document   : TambahPembayaranAdmin
    Created on : Sep 5, 2019, 4:37:14 PM
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
        <title>Tambah Pembayaran</title>
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
                <table border='1' id="customers">
                    <tr>
                        <th>No antrian</th>
                        <th>Nama Pasien</th>
                        <th>Poli</th>
                        <th>Kode Kunjungan</th>
                    </tr>

                    <c:forEach var="listPasien" items="${listantrian}">
                        <tr align='center'>              
                            <td>${listPasien.no_antrian}</td>
                            <td>${listPasien.nama_pasien}</td>
                            <td>${listPasien.nama_poli}</td>
                            <td>${listPasien.kode_kunjungan}</td> 
                        </tr>
                    </c:forEach>
                </table>

            </div>
            <div style=" float:left;height:500px; width: 60%;padding:20px;">
                <div style="background-color: #ddd; padding: 5%">
                   <form:form id="rekam" action="savePembayaranAdmin.htm" modelAttribute="pembayaranDto" method="POST">
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
                <label onclick="tambahtindakan()" style="background-color: #00FF00; width: 150px; height: 30px; border-radius: 25px; padding: 5px; padding-left: 10px">Tambah Tindakan</label>
                <br>
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
            </div>
        </div>
    </body>
</html>
<script>
    function tambahtotal(a){
        var t1=document.getElementById("tdok").value;
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