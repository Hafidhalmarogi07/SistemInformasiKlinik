/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.KaryawanDto;
import projeck.hafidh.klinik.model.KaryawanModel;

/**
 *
 * @author Acer
 */
public interface KaryawanService {
    public void saveDataKaryawan(KaryawanDto dokterDto) throws Exception;
    public List <KaryawanDto> getListKaryawan()throws Exception;
    public KaryawanModel getKaryawanById(String id);
    public void deleteDataKaryawan(String kdKaryawan) throws Exception;
    public KaryawanDto getUpdateDataKaryawan(String kdKaryawan) throws Exception;
    public void doUpdateDataKaryawan(KaryawanDto karyawanDto) throws Exception;
    public KaryawanDto getDataId() throws Exception;
     public KaryawanDto getDataLogin(KaryawanDto fromDto)throws Exception;
    
}
