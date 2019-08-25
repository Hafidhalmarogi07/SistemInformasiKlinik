/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.KaryawanDao;
import projeck.hafidh.klinik.model.KaryawanModel;

/**
 *
 * @author Acer
 */
public class KaryawanDaoImpl extends HibernateUtil implements KaryawanDao{

    @Override
    public void saveDataKaryawan(KaryawanModel karyawanModel) throws Exception {
        try {
            getSession().save(karyawanModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KaryawanModel> getListDataKaryawan() throws Exception {
        List<KaryawanModel> listData = null;
        try {
            String sql = "select model from KaryawanModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public KaryawanModel getKaryawanById(String id) throws Exception {
       KaryawanModel dokter = new KaryawanModel();
        Query query = null;
        try {
            String sql = "select model from KaryawanModel model where id_karyawan=:idkar";
            query = createQuery(sql).setParameter("idkar", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (KaryawanModel) query.uniqueResult();
    }

    @Override
    public void deleteKaryawan(String id) {
        KaryawanModel karyawan = new KaryawanModel();
        karyawan.setId_karyawan(id);
        getSession().delete(karyawan);
    }

    @Override
    public void updateKaryawan(KaryawanModel karyawanModel) {
        getSession().saveOrUpdate(karyawanModel);
    }
    

    @Override
    public List<KaryawanModel> getListKaryawanUpdate(String kdKaryawan) {
        List<KaryawanModel> dataList = null;
        String sql = "select model from KaryawanModel model where id_karyawan=:id";
        Query query = createQuery(sql).setParameter("id", kdKaryawan);
        dataList = query.list();
        return dataList;
    }
    
}
