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
    
    
}
