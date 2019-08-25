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
public class PembayaranModel {
    String kode_pembayaran,kode_kunjungan,nama_tindakan;
    int tarif_dokter,tarif_obat,tarif_tindakan,total_tarif;

    public String getKode_pembayaran() {
        return kode_pembayaran;
    }

    public void setKode_pembayaran(String kode_pembayaran) {
        this.kode_pembayaran = kode_pembayaran;
    }

    public String getKode_kunjungan() {
        return kode_kunjungan;
    }

    public void setKode_kunjungan(String kode_kunjungan) {
        this.kode_kunjungan = kode_kunjungan;
    }

    public String getNama_tindakan() {
        return nama_tindakan;
    }

    public void setNama_tindakan(String nama_tindakan) {
        this.nama_tindakan = nama_tindakan;
    }

    public int getTarif_dokter() {
        return tarif_dokter;
    }

    public void setTarif_dokter(int tarif_dokter) {
        this.tarif_dokter = tarif_dokter;
    }

    public int getTarif_obat() {
        return tarif_obat;
    }

    public void setTarif_obat(int tarif_obat) {
        this.tarif_obat = tarif_obat;
    }

    public int getTarif_tindakan() {
        return tarif_tindakan;
    }

    public void setTarif_tindakan(int tarif_tindakan) {
        this.tarif_tindakan = tarif_tindakan;
    }

    public int getTotal_tarif() {
        return total_tarif;
    }

    public void setTotal_tarif(int total_tarif) {
        this.total_tarif = total_tarif;
    }
    
    
    
    
}
