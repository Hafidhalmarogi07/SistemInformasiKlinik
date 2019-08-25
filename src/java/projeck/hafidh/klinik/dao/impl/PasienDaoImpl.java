/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.PasienDao;
import projeck.hafidh.klinik.model.PasienModel;

/**
 *
 * @author Acer
 */
public class PasienDaoImpl extends HibernateUtil implements PasienDao{

    @Override
    public void saveDataPasien(PasienModel pasienModel) throws Exception {
         try {
            getSession().save(pasienModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PasienModel> getListDataPasien() throws Exception {
         List<PasienModel> listData = null;
        try {
            String sql = "select model from PasienModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public PasienModel getPasienById(String id) throws Exception {
        PasienModel pasien = new PasienModel();
        Query query = null;
        try {
            String sql = "select model from PasienModel model where kode_pasien=:kdpasien";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PasienModel) query.uniqueResult();
    }

    @Override
    public void deletePasien(String id) {
        PasienModel pasien = new PasienModel();
        pasien.setKode_pasien(id);
        getSession().delete(pasien);
    }

    @Override
    public void updatePasien(PasienModel pasienModel) {
        getSession().saveOrUpdate(pasienModel);
    }

    @Override
    public List<PasienModel> getListPasienUpdate(String kdPasien) {
         List<PasienModel> dataList = null;
        String sql = "select model from PasienModel model where kode_pasien=:id";
        Query query = createQuery(sql).setParameter("id", kdPasien);
        dataList = query.list();
        return dataList;
    }
    
}
