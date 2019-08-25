/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.model.RekamMedisModel;

/**
 *
 * @author Acer
 */
public interface RekamMedisDao {
    public void saveDataRekamMedis(RekamMedisModel rekamMedisModel)throws Exception;
    public List<RekamMedisModel> getListDataRekamMedis()throws Exception;
    public RekamMedisModel getRekamMedisById(String id) throws Exception;
    public void deleteRekamMedis(String id);
    public void updateRekamMedis(RekamMedisModel rekamMedisModel);
    public List<RekamMedisModel> getListRekamMedisUpdate(String kdRekamMedis);
    
}
