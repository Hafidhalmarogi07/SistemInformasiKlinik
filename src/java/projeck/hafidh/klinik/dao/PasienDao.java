/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.model.PasienModel;

/**
 *
 * @author Acer
 */
public interface PasienDao {
    public void saveDataPasien(PasienModel pasienModel)throws Exception;
    public List<PasienModel> getListDataPasien()throws Exception;
    public PasienModel getPasienById(String id) throws Exception;
    public void deletePasien(String id);
    public void updatePasien(PasienModel pasienModel);
    public List<PasienModel> getListPasienUpdate(String kdPasien);
    
}
