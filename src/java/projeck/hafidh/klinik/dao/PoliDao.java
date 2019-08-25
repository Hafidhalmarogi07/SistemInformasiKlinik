/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.model.PoliModel;


/**
 *
 * @author Acer
 */
public interface PoliDao {
    public void saveDataPoli(PoliModel poliModel)throws Exception;
    public List<PoliModel> getListDataPoli()throws Exception;
    public PoliModel getPoliById(String id) throws Exception;
    public void deletePoli(String id);
    public void updatePoli(PoliModel poliModel);
    public List<PoliModel> getListPoliUpdate(String kdPoli);
    
}
