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
public class AntrianRekamModel {
    String kode_kunjungan,no_antrian,kode_pasien,kode_poli,kode_dokter;

    public String getKode_dokter() {
        return kode_dokter;
    }

    public void setKode_dokter(String kode_dokter) {
        this.kode_dokter = kode_dokter;
    }
    public String getKode_kunjungan() {
        return kode_kunjungan;
    }

    public void setKode_kunjungan(String kode_kunjungan) {
        this.kode_kunjungan = kode_kunjungan;
    }

    public String getNo_antrian() {
        return no_antrian;
    }

    public void setNo_antrian(String no_antrian) {
        this.no_antrian = no_antrian;
    }

    public String getKode_pasien() {
        return kode_pasien;
    }

    public void setKode_pasien(String kode_pasien) {
        this.kode_pasien = kode_pasien;
    }

    public String getKode_poli() {
        return kode_poli;
    }

    public void setKode_poli(String kode_poli) {
        this.kode_poli = kode_poli;
    }
    
}
