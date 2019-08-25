/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.DataPembayaranDao;
import projeck.hafidh.klinik.model.DataPembayaranModel;

/**
 *
 * @author Acer
 */
public class DataPembayaranDaoImpl extends HibernateUtil implements DataPembayaranDao{

    @Override
    public void saveDataDataPembayaran(DataPembayaranModel dataPembayaranModel) throws Exception {
         try {
            getSession().save(dataPembayaranModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DataPembayaranModel> getListDataDataPembayaran() throws Exception {
        List<DataPembayaranModel> listData = null;
        try {
            String sql = "select model from DataPembayaranModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public DataPembayaranModel getDataPembayaranById(String id) throws Exception {
        DataPembayaranModel pembayaran = new DataPembayaranModel();
        Query query = null;
        try {
            String sql = "select model from DataPembayaranModel model where kode_pembayaran=:kdpembayaran";
            query = createQuery(sql).setParameter("kdpembayaran", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (DataPembayaranModel) query.uniqueResult();
    }

    @Override
    public void deleteDataPembayaran(String id) {
        DataPembayaranModel pembayaran = new DataPembayaranModel();
        pembayaran.setKode_pembayaran(id);
        getSession().delete(pembayaran);
    }

    @Override
    public void updateDataPembayaran(DataPembayaranModel dataPembayaranModel) {
         getSession().saveOrUpdate(dataPembayaranModel);
    }

    @Override
    public List<DataPembayaranModel> getListDataPembayaranUpdate(String kdPembayaran) {
        List<DataPembayaranModel> dataList = null;
        String sql = "select model from DataPembayaranModel model where kode_pembayaran=:id";
        Query query = createQuery(sql).setParameter("id", kdPembayaran);
        dataList = query.list();
        return dataList;
    }    
}
