/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.AntrianRekamDto;
import projeck.hafidh.klinik.model.AntrianRekamModel;

/**
 *
 * @author Acer
 */
public interface AntrianRekamService {
    public void saveDataAntrianRekam(String kod_kun,String nama,String kod_pol,int tarif) throws Exception;
    public List <AntrianRekamDto> getListAntrianRekam()throws Exception;
    public AntrianRekamModel getListAntrianRekamById(String kd)throws Exception;
    public void deleteDataAntrianRekam(String kdkunjungan) throws Exception;
    
}
