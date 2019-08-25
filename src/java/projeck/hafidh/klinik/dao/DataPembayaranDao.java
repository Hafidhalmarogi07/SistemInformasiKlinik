/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.model.DataPembayaranModel;

/**
 *
 * @author Acer
 */
public interface DataPembayaranDao {
    public void saveDataDataPembayaran(DataPembayaranModel dataPembayaranModel)throws Exception;
    public List<DataPembayaranModel> getListDataDataPembayaran()throws Exception;
    public DataPembayaranModel getDataPembayaranById(String id) throws Exception;
    public void deleteDataPembayaran(String id);
    public void updateDataPembayaran(DataPembayaranModel dataPembayaranModel);
    public List<DataPembayaranModel> getListDataPembayaranUpdate(String kdPembayaran);
    
}
