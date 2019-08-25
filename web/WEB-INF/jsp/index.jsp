<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html>
    <head>
        <title>Klinik</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="boostrap/css/css.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <%
            if (session.getAttribute("username") != null) {
                if (session.getAttribute("status").toString().equalsIgnoreCase("admin")) {
                    response.sendRedirect("HalamanUtama.htm");
                } else if (session.getAttribute("status").toString().equalsIgnoreCase("user")) {
                    response.sendRedirect("cobalogin.htm");
                }
            }
        %>
    </head>
    <body >
    
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
    <div class="w3-container w3-red" style="height:25px;padding:0px 26px">
        <label style="color: white;font-family:Times New Roman;font-size: 20px; float: right"> 
            Bandung,  
              <label id="hari"></label>
              , 
              <label id="tanggal"></label>
              /
              <label id="bulan"></label>
              /
              <label id="tahun"></label>
            
           
        </label>
    </div>
    <center>
        <div class="w3-panel w3-round-xlarge w3-teal w3-deep-purple" style="height:350px; width:300px;padding:10px 10px" >
            <label>Form Login Sistem</label>
            <br>
            <img src="boostrap/icon/user.png" style="width:50%" >
            <form action="doLogin.htm" modelAttribute="formDto" method="POST" class="form login" role="form">
                <fieldset>
                    <div class="form-group">
                        <input class="form-control" placeholder="UserName" name="username" type="text" autofocus="">
                    </div>
                    <div class="form-group">
                        <input class="form-control" placeholder="Password" name="password" type="password" value="">
                    </div>
                    <div class="checkbox">
                        <label>
                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                        </label>
                    </div>
                    <div class="form__field">
                        <input type="submit" value="Sign In" style="background: blue; font-size: 20px">
                    </div>
                </fieldset>
            </form>


        </div>
        <!--            <c:url var="indexUrl" value="/cobalogin.htm"></c:url>
                <a href="${indexUrl}" >Kembali</a>
                    
                </center>
        
                <div class="w3-container w3-green w3-bottom " style="height:40px;">
                    <p align="center">Hello W3.CSS Layout.</p>
        
                </div>-->
        
        <c:url var="datadokterUrl" value="/Datadokter.htm"></c:url>
        <a href="${datadokterUrl}" >Data Dokter</a>
         <c:url var="dataLayananUrl" value="/DataLayanan.htm"></c:url>
        <a href="${dataLayananUrl}" >Data Layanan</a>
        <c:url var="dataPasienUrl" value="/DataPasien.htm"></c:url>
        <a href="${dataPasienUrl}" >Data Pasien</a>

    </body>
</html>
<script>
    window.setTimeout("waktu()", 1000);

    function waktu() {
        var waktu = new Date();
        setTimeout("waktu()", 1000);
        var arrhari=["hari","Senin","Selasa","Rabu","Kamis","Jum'at","Sabtu","Minggu"];
        document.getElementById("hari").innerHTML = arrhari[waktu.getDay()];
        document.getElementById("tanggal").innerHTML = waktu.getDate();
        document.getElementById("bulan").innerHTML = waktu.getMonth();
        document.getElementById("tahun").innerHTML = waktu.getFullYear();
        
        document.getElementById("jam").innerHTML = waktu.getHours();
        document.getElementById("menit").innerHTML = waktu.getMinutes();
        document.getElementById("detik").innerHTML = waktu.getSeconds();
    }
</script>
