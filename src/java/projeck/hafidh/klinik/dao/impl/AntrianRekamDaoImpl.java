/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.AntrianRekamDao;
import projeck.hafidh.klinik.model.AntrianRekamModel;

/**
 *
 * @author Acer
 */
public class AntrianRekamDaoImpl extends HibernateUtil implements AntrianRekamDao{

    @Override
    public void saveDataAntrianRekam(AntrianRekamModel antrianModel) throws Exception {
         try {
            getSession().save(antrianModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AntrianRekamModel> getListDataAntrianRekam() throws Exception {
         List<AntrianRekamModel> listData = null;
        try {
            String sql = "select model from AntrianRekamModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public AntrianRekamModel getListDataAntrianRekamById(String id) throws Exception {
        AntrianRekamModel antrian = new AntrianRekamModel();
        Query query = null;
        try {
            String sql = "select model from AntrianRekamModel model where kode_kunjungan=:kdkun";
            query = createQuery(sql).setParameter("kdkun", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (AntrianRekamModel) query.uniqueResult();
    }

    @Override
    public void deleteAntrianRekam(String id) {
        AntrianRekamModel antrian = new AntrianRekamModel();
        antrian.setKode_kunjungan(id);
        getSession().delete(antrian);
    }

    @Override
    public List<Object[]> getDataAtrian() throws Exception {
        List<Object[]> data=null;
        String sql="SELECT a.kode_kunjungan,a.no_antrian,b.kode_pasien,b.nama_pasien,c.kode_poli,c.nama_poli,d.kode_dokter,d.tarif FROM antrianrekam_tbl a JOIN pasien_tbl b ON a.kode_pasien=b.kode_pasien JOIN poli_tbl c ON a.kode_poli=c.kode_poli JOIN dokter_tbl d ON a.kode_dokter=d.kode_dokter ORDER BY no_antrian;";
        Query query=createNativeQuery(sql);
        data=query.list();
        
        return data;
    }

    @Override
    public List<Object[]> getAntrianById(String id) throws Exception {
        List<Object[]> data=null;
        String sql="SELECT a.kode_kunjungan,b.kode_dokter,b.tarif FROM antrianrekam_tbl a JOIN dokter_tbl b ON a.kode_dokter=b.kode_dokter WHERE a.kode_kunjungan=:KJ";
        Query query=createNativeQuery(sql).setParameter("KJ", id);
        data=query.list();
        return data;
    }
    
    
}
