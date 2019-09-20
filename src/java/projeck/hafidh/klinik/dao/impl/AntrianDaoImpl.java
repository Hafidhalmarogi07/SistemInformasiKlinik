/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.AntrianDao;
import projeck.hafidh.klinik.model.AntrianModel;

/**
 *
 * @author Acer
 */
public class AntrianDaoImpl extends HibernateUtil implements AntrianDao{

    @Override
    public void saveDataAntrian(AntrianModel antrianModel) throws Exception {
         try {
            getSession().save(antrianModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AntrianModel> getListDataAntrian() throws Exception {
        List<AntrianModel> listData = null;
        try {
            String sql = "select model from AntrianModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public List<AntrianModel> getListDataAntrianByPoli(String id_poli) throws Exception {
        List<AntrianModel> listData = null;
        try {
            String sql = "select model from AntrianModel model WHERE kode_poli=:kode ORDER BY no_antrian";
            Query query = createQuery(sql).setParameter("kode", id_poli);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
        
    }

    @Override
    public void deleteAntrian(String id) {
        AntrianModel antrian = new AntrianModel();
        antrian.setKode_kunjungan(id);
        getSession().delete(antrian);
    }    

    @Override
    public AntrianModel getAntrianById(String id) throws Exception {
        AntrianModel antrian= new AntrianModel();
        Query query = null;
        try {
            String sql = "select model from AntrianModel model where kode_kunjungan=:kd";
            query = createQuery(sql).setParameter("kd", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (AntrianModel) query.uniqueResult();
   }

    @Override
    public List<Object[]> getDataAntrian() throws Exception {
        List <Object[]> listData = null;
        String sql="SELECT a.kode_kunjungan,a.no_antrian,b.kode_pasien,b.nama_pasien,c.kode_poli,c.nama_poli,a.kode_dokter FROM antrian_tbl a JOIN pasien_tbl b ON a.kode_pasien=b.kode_pasien JOIN poli_tbl c ON a.kode_poli=c.kode_poli ORDER BY kode_poli ASC;";
        Query query=createNativeQuery(sql);
        listData=query.list();
        return listData;
        
    }

    @Override
    public List<Object[]> getDataAntrianByPoli(String poli) throws Exception {
        List <Object[]> listData=null;
        String sql="SELECT a.kode_kunjungan,a.no_antrian,b.kode_pasien,b.nama_pasien,c.kode_poli,c.nama_poli,a.kode_dokter FROM antrian_tbl a JOIN pasien_tbl b ON a.kode_pasien=b.kode_pasien JOIN poli_tbl c ON a.kode_poli=c.kode_poli WHERE a.kode_poli=:PL;";
        Query query=createNativeQuery(sql).setParameter("PL", poli);
        listData=query.list();
        return listData;
    }

    @Override
    public void updateAntrian(AntrianModel antrianModel) {
         getSession().saveOrUpdate(antrianModel); 
    }
}
