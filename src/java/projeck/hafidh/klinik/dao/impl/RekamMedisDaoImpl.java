/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.RekamMedisDao;
import projeck.hafidh.klinik.model.RekamMedisModel;

/**
 *
 * @author Acer
 */
public class RekamMedisDaoImpl extends HibernateUtil implements RekamMedisDao{

    @Override
    public void saveDataRekamMedis(RekamMedisModel rekamMedisModel) throws Exception {
        try {
            getSession().save(rekamMedisModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RekamMedisModel> getListDataRekamMedis() throws Exception {
        List<RekamMedisModel> listData = null;
        try {
            String sql = "select model from RekamMedisModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public RekamMedisModel getRekamMedisById(String id) throws Exception {
        Query query = null;
        try {
            String sql = "select model from RekamMedisModel model where kode_rekam=:kdrek";
            query = createQuery(sql).setParameter("kdrek", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (RekamMedisModel) query.uniqueResult();
    }

    @Override
    public void deleteRekamMedis(String id) {
        RekamMedisModel rekam = new RekamMedisModel();
        rekam.setKode_rekam(id);
        getSession().delete(rekam);
    }

    @Override
    public void updateRekamMedis(RekamMedisModel rekamMedisModel) {
        getSession().saveOrUpdate(rekamMedisModel);
    }

    @Override
    public List<RekamMedisModel> getListRekamMedisUpdate(String kdRekamMedis) {
        List<RekamMedisModel> dataList = null;
        String sql = "select model from RekamMedisModel model where kode_rekam=:id";
        Query query = createQuery(sql).setParameter("id", kdRekamMedis);
        dataList = query.list();
        return dataList;
    }
    
    
}
