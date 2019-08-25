/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.model.AntrianRekamModel;

/**
 *
 * @author Acer
 */
public interface AntrianRekamDao {
    public void saveDataAntrianRekam(AntrianRekamModel antrianModel)throws Exception;
    public List<AntrianRekamModel> getListDataAntrianRekam()throws Exception;
    public AntrianRekamModel getListDataAntrianRekamById(String id)throws Exception;
    public void deleteAntrianRekam(String id);
    
}
