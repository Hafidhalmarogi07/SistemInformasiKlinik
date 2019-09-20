/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.dto.KaryawanDto;
import projeck.hafidh.klinik.model.KaryawanModel;

/**
 *
 * @author Acer
 */
public interface KaryawanDao {
    public void saveDataKaryawan(KaryawanModel karyawanModel)throws Exception;
    public List<KaryawanModel> getListDataKaryawan()throws Exception;
    public KaryawanModel getKaryawanById(String id) throws Exception;
    public void deleteKaryawan(String id);
    public void updateKaryawan(KaryawanModel karyawanModel);
    public List<KaryawanModel> getListKaryawanUpdate(String kdKaryawan);
    public List<KaryawanModel> getlistlogin(KaryawanDto loginDto) throws Exception;
}
