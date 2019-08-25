/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.KunjunganDao;
import projeck.hafidh.klinik.model.KunjunganModel;

/**
 *
 * @author Acer
 */
public class KunjunganDaoImpl extends HibernateUtil implements KunjunganDao{

    @Override
    public void saveDataKunjungan(KunjunganModel kunjunganModel) throws Exception {
         try {
            getSession().save(kunjunganModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KunjunganModel> getListDataKunjungan() throws Exception {
        List<KunjunganModel> listData = null;
        try {
            String sql = "select model from KunjunganModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public KunjunganModel getKunjunganById(String id) throws Exception {
        KunjunganModel kunjungan = new KunjunganModel();
        Query query = null;
        try {
            String sql = "select model from KunjunganModel model where kode_kunjungan=:idkun";
            query = createQuery(sql).setParameter("idkun", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (KunjunganModel) query.uniqueResult();
    }

    @Override
    public void deleteKunjungan(String id) {
        KunjunganModel kunjungan = new KunjunganModel();
        kunjungan.setKode_kunjungan(id);
        getSession().delete(kunjungan);
    }

    @Override
    public void updateKunjungan(KunjunganModel kunjunganModel) {
         getSession().saveOrUpdate(kunjunganModel);
    }

    @Override
    public List<KunjunganModel> getListKunjunganUpdate(String kdKunjungan) {
        List<KunjunganModel> dataList = null;
        String sql = "select model from KunjunganModel model where kode_kunjungan=:id";
        Query query = createQuery(sql).setParameter("id", kdKunjungan);
        dataList = query.list();
        return dataList;
    }
    
}
