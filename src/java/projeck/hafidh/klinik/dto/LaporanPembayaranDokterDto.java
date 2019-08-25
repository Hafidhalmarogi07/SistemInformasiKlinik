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
public class LaporanPembayaranDokterDto {
    String tanggal,kode_dekter,nama_dokter,nama_pasien,tindakan;
    int tarif_dokter,tarif_tindakan;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode_dekter() {
        return kode_dekter;
    }

    public void setKode_dekter(String kode_dekter) {
        this.kode_dekter = kode_dekter;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }

    public int getTarif_dokter() {
        return tarif_dokter;
    }

    public void setTarif_dokter(int tarif_dokter) {
        this.tarif_dokter = tarif_dokter;
    }

    public int getTarif_tindakan() {
        return tarif_tindakan;
    }

    public void setTarif_tindakan(int tarif_tindakan) {
        this.tarif_tindakan = tarif_tindakan;
    }
    
}
