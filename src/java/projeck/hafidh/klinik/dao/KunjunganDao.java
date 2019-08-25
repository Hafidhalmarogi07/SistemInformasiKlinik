/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.model.KunjunganModel;

/**
 *
 * @author Acer
 */
public interface KunjunganDao {
    public void saveDataKunjungan(KunjunganModel kunjunganModel)throws Exception;
    public List<KunjunganModel> getListDataKunjungan()throws Exception;
    public KunjunganModel getKunjunganById(String id) throws Exception;
    public void deleteKunjungan(String id);
    public void updateKunjungan(KunjunganModel kunjunganModel);
    public List<KunjunganModel> getListKunjunganUpdate(String kdKunjungan);
    
}
