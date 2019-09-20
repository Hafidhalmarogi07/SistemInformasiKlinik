/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dto;

/**
 *
 * @author Acer
 */
public class RekamMedisDto {
    String kode_rekam,kode_kunjungan,keluhan,diagnosa,tindakan,resep,id_dokter,nama_pasien,kode_poli;

    public String getKode_poli() {
        return kode_poli;
    }

    public void setKode_poli(String kode_poli) {
        this.kode_poli = kode_poli;
    }
    
    public String getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }
    
   

    public String getKode_rekam() {
        return kode_rekam;
    }

    public void setKode_rekam(String kode_rekam) {
        this.kode_rekam = kode_rekam;
    }

    public String getKode_kunjungan() {
        return kode_kunjungan;
    }

    public void setKode_kunjungan(String kode_kunjungan) {
        this.kode_kunjungan = kode_kunjungan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }

    public String getResep() {
        return resep;
    }

    public void setResep(String resep) {
        this.resep = resep;
    }
    
    
}
