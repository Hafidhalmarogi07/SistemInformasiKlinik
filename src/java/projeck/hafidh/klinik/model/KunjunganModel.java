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
public class KunjunganModel {
    String kode_kunjungan,tanggal_kunjungan,kode_poli,Kode_pasien,kode_dokter,metode_pembayran;

    public String getKode_kunjungan() {
        return kode_kunjungan;
    }

    public void setKode_kunjungan(String kode_kunjungan) {
        this.kode_kunjungan = kode_kunjungan;
    }

    public String getTanggal_kunjungan() {
        return tanggal_kunjungan;
    }

    public void setTanggal_kunjungan(String tanggal_kunjungan) {
        this.tanggal_kunjungan = tanggal_kunjungan;
    }

    public String getKode_poli() {
        return kode_poli;
    }

    public void setKode_poli(String kode_poli) {
        this.kode_poli = kode_poli;
    }

    public String getKode_pasien() {
        return Kode_pasien;
    }

    public void setKode_pasien(String Kode_pasien) {
        this.Kode_pasien = Kode_pasien;
    }

    public String getKode_dokter() {
        return kode_dokter;
    }

    public void setKode_dokter(String kode_dokter) {
        this.kode_dokter = kode_dokter;
    }

    public String getMetode_pembayran() {
        return metode_pembayran;
    }

    public void setMetode_pembayran(String metode_pembayran) {
        this.metode_pembayran = metode_pembayran;
    }
    
}
