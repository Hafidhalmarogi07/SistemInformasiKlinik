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
public class DataPembayaranModel {
    String kode_pembayaran,kode_kunjungan,tindakan;
    int tarif_dokter,obat,harga_tindakan,total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    

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

    public int getObat() {
        return obat;
    }

    public void setObat(int obat) {
        this.obat = obat;
    }

    public int getHarga_tindakan() {
        return harga_tindakan;
    }

    public void setHarga_tindakan(int harga_tindakan) {
        this.harga_tindakan = harga_tindakan;
    }
    
    
}
