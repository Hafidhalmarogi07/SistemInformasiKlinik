<%-- 
    Document   : TambahKaryawan
    Created on : Jul 27, 2019, 9:05:56 PM
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
        <title>Tambah Data Karyawan</title>
        <link rel="stylesheet" href="boostrap/css/cssinput.css">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </head>
    <body>
        
        <div id="divform" >
            <form:form id="karyawan" action="saveKaryawan.htm" modelAttribute="karyawanDto" method="POST">
                <center><label style="font-size: 20px">Tambah Karyawan </label></center>
                <br>
                    <label>Id Karyawan : ${karyawanDto.id_karyawan}</label>
                <br>
                <label> Nama Karyawan </label>
                <form:input path="nama_karyawan" id="nama_karyawan" />
                <label >Jenis Kelamin  :  </label>
                <input type="radio" path="jenis_kelamin" name="jenis_kelamin" value="Laki-laki" /><label >Laki-laki </label>
                <input type="radio" path="jenis_kelamin"  name="jenis_kelamin" value="perempuan" /><label >Perempuan</label>
                <br>
                <label>Alamat </label>
                <form:input path="alamat" id="alamat" class="validate validate[required]"/>
                <%--<label>Bagian </label>
                <form:input path="bagian" id="bagian" class="validate validate[required]"/>--%>
                <label>Telepon </label>
                <form:input path="telp" id="telp" class="validate validate[required]"/>
                 <label>Password </label>
                <form:input path="password" id="password" class="validate validate[required]"/>
                <%--<label>Kode Poli </label>
                <form:input path="kode_poli" id="kode_poli" class="validate validate[required]"/>--%>
                <label>Status :</label>
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="bagian" path="bagian" onclick="hapuspoli()" value="Admin"><label>Admin</label>
                <input type="radio" name="bagian" path="bagian" onclick="hapuspoli()" value="Owner"><label>Owner</label>
                <input type="radio" name="bagian" path="bagian" onclick="hapuspoli()" value="Pembayaran"><label>Pembayaran</label>
                <input type="radio" name="bagian" path="bagian" onclick="hapuspoli()" value="front_office"><label>front office</label>
                <input type="radio" name="bagian" path="bagian" onclick="isipoli()" value="Poli"><label>Poli</label>
                <label id="customers" ></label>
                <form:button type="submit" class="submit" id="save">Save</form:button>
            </form:form>
        </div>
    </body>
</html>
<script>
    function isipoli() {
        var content;
        $.ajax({
            url: 'getautopoli.htm',
            type: 'GET',
            success: function (response) {
                var data = JSON.parse(response);
                var len = data.length;
                content = '<br><label>Pilih Poli : </label><br>';
                for (var i = 0; i < len; i++) {
                    content+=' <input type="radio" name="kode_poli" path="kode_poli" value="'+data[i].kode_poli+'" /><label>'+data[i].nama_poli+'</label>';
                }
                $('#customers').html(content);
            }
        });

    }
    function hapuspoli(){
         $('#customers').html('');
    }

</script>
