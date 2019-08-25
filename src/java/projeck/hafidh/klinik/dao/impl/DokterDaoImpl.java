/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.DokterDao;
import projeck.hafidh.klinik.model.DokterModel;

/**
 *
 * @author Acer
 */
public class DokterDaoImpl extends HibernateUtil implements DokterDao{

    @Override
    public void saveDataDokter(DokterModel dokterModel) throws Exception {
        try {
            getSession().save(dokterModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DokterModel> getListDataDokter() throws Exception {
        List<DokterModel> listData = null;
        try {
            String sql = "select model from DokterModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public DokterModel getDokterById(String id) throws Exception {
        DokterModel dokter = new DokterModel();
        Query query = null;
        try {
            String sql = "select model from DokterModel model where kode_dokter=:kddokter";
            query = createQuery(sql).setParameter("kddokter", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (DokterModel) query.uniqueResult();
    }

    @Override
    public void deleteDokter(String id) {
        DokterModel dokter = new DokterModel();
        dokter.setKode_dokter(id);
        getSession().delete(dokter);
    }

    @Override
    public void updateDokter(DokterModel dokterModel) {
        getSession().saveOrUpdate(dokterModel);
    }

    @Override
    public List<DokterModel> getListDokterUpdate(String kdDokter) {
        List<DokterModel> dataList = null;
        String sql = "select model from DokterModel model where kode_dokter=:id";
        Query query = createQuery(sql).setParameter("id", kdDokter);
        dataList = query.list();
        return dataList;
    }
    
}
