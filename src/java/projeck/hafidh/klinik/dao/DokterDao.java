/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.model.DokterModel;

/**
 *
 * @author Acer
 */
public interface DokterDao {
    public void saveDataDokter(DokterModel dokterModel)throws Exception;
    public List<DokterModel> getListDataDokter()throws Exception;
    public DokterModel getDokterById(String id) throws Exception;
    public void deleteDokter(String id);
    public void updateDokter(DokterModel dokterModel);
    public List<DokterModel> getListDokterUpdate(String kdDokter);
    
}
