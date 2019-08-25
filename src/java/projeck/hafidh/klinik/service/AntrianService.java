/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.AntrianDto;
import projeck.hafidh.klinik.model.AntrianModel;

/**
 *
 * @author Acer
 */
public interface AntrianService {
    public void saveDataAntrian(String kod_kun,String nama,String ko_pol,String kod_dok) throws Exception;
    public List <AntrianDto> getListAntrian()throws Exception;
    public List <AntrianDto> getListAntrianByPoli(String kd)throws Exception;
    public void deleteDataAntrian(String kdkunjungan) throws Exception;
    public AntrianModel getAntrianById(String id);
}
