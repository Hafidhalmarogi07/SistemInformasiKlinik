/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.LaporanDao;

/**
 *
 * @author Acer
 */
public class LaporanDaoImpl extends HibernateUtil implements LaporanDao {

    @Override
    public List<Object[]> getDataLaporanKunjungan() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT a.kode_kunjungan,a.tanggal_kunjungan,b.nama_poli,c.nama_pasien,d.nama_dokter,a.metode_pembayran FROM kunjungan_tbl a JOIN poli_tbl b ON a.kode_poli=b.kode_poli JOIN pasien_tbl c ON a.Kode_pasien=c.kode_pasien JOIN dokter_tbl d ON a.kode_dokter=d.kode_dokter;";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;

    }

    @Override
    public List<Object[]> getDataLaporanPendapatan() throws Exception {
        List<Object[]> listDatalap=null;
        String sql="select a.kode_pembayaran, b.tanggal_kunjungan,a.tarif_dokter,a.obat,a.harga_tindakan,b.metode_pembayran from datapembayaran_tbl a join kunjungan_tbl b on a.kode_kunjungan=b.kode_kunjungan;";
        Query query = createNativeQuery(sql);
        listDatalap=query.list();
        return listDatalap;
         
    }

    @Override
    public List<Object[]> getDataLaporanPembayaranDokter() throws Exception {
        List<Object[]> listDatalap=null;
        String sql="SELECT a.tanggal_kunjungan,b.kode_dokter,b.nama_dokter,c.nama_pasien,b.tarif,d.tindakan,d.harga_tindakan from kunjungan_tbl a join dokter_tbl b on a.kode_dokter=b.kode_dokter join pasien_tbl c on a.kode_Pasien=c.kode_pasien join datapembayaran_tbl d on a.kode_kunjungan=d.kode_kunjungan;";
        Query query = createNativeQuery(sql);
        listDatalap=query.list();
        return listDatalap;
    }

}
