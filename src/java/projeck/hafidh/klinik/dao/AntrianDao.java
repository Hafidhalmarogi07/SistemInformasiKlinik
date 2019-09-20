/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.model.AntrianModel;

/**
 *
 * @author Acer
 */
public interface AntrianDao {
    public void saveDataAntrian(AntrianModel antrianModel)throws Exception;
    public List<AntrianModel> getListDataAntrian()throws Exception;
    public List<AntrianModel> getListDataAntrianByPoli(String id_poli)throws Exception;
    public void deleteAntrian(String id);
    public AntrianModel getAntrianById(String id) throws Exception;
    public List<Object[]> getDataAntrian()throws Exception;
    public List<Object[]> getDataAntrianByPoli(String poli)throws Exception;
    public void updateAntrian(AntrianModel antrianModel);
}
