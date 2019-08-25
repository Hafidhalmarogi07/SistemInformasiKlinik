/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.PoliDao;
import projeck.hafidh.klinik.model.PoliModel;

/**
 *
 * @author Acer
 */
public class PoliDaoImpl extends HibernateUtil implements PoliDao {
    @Override
    public void saveDataPoli(PoliModel poliModel) throws Exception {
        try {
            getSession().save(poliModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PoliModel> getListDataPoli() throws Exception {
        List<PoliModel> listData = null;
        try {
            String sql = "select model from PoliModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public PoliModel getPoliById(String id) throws Exception {
       //PoliModel poli = new PoliModel();
        Query query = null;
        try {
            String sql = "select model from PoliModel model where kode_poli=:kdpoli";
            query = createQuery(sql).setParameter("kdpoli", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PoliModel) query.uniqueResult();
    }

    @Override
    public void deletePoli(String id) {
        PoliModel poli = new PoliModel();
        poli.setKode_poli(id);
        getSession().delete(poli);
    }

    @Override
    public void updatePoli(PoliModel poliModel) {
        getSession().saveOrUpdate(poliModel);
    }

    @Override
    public List<PoliModel> getListPoliUpdate(String kdPoli) {
        List<PoliModel> dataList = null;
        String sql = "select model from PoliModel model where kode_poli=:id";
        Query query = createQuery(sql).setParameter("id", kdPoli);
        dataList = query.list();
        return dataList;
    }
    
}
