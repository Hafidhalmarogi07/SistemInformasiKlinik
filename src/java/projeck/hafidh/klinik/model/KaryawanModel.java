/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.model;

/**
 *
 * @author Acer
 */
public class KaryawanModel {
    String id_karyawan,nama_karyawan,jenis_kelamin,password,alamat,status_bagian,telp,kode_poli;

    public String getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getKode_poli() {
        return kode_poli;
    }

    public void setKode_poli(String kode_poli) {
        this.kode_poli = kode_poli;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getStatus_bagian() {
        return status_bagian;
    }

    public void setStatus_bagian(String status_bagian) {
        this.status_bagian = status_bagian;
    }
    
    
    
}
