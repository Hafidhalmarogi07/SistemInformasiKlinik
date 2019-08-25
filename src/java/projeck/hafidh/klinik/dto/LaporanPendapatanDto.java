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
public class LaporanPendapatanDto {
    String kode_pembayaran,tanggal_kunjungan,metode_pembayaran;
    int tarif_dokter,obat,harga_tindakan;

    public String getKode_pembayaran() {
        return kode_pembayaran;
    }

    public void setKode_pembayaran(String kode_pembayaran) {
        this.kode_pembayaran = kode_pembayaran;
    }

    public String getTanggal_kunjungan() {
        return tanggal_kunjungan;
    }

    public void setTanggal_kunjungan(String tanggal_kunjungan) {
        this.tanggal_kunjungan = tanggal_kunjungan;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
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
