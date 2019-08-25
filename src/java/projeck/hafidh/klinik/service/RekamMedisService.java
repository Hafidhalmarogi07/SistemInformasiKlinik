/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.RekamMedisDto;
import projeck.hafidh.klinik.model.RekamMedisModel;

/**
 *
 * @author Acer
 */
public interface RekamMedisService {
    public void saveDataRekamMedis(RekamMedisDto rekamMedisDto) throws Exception;
    public List <RekamMedisDto> getListRekamMedis()throws Exception;
    public RekamMedisModel getRekamMedisById(String id);
    public void deleteDataRekamMedis(String kdRekamMedis) throws Exception;
    public RekamMedisDto getUpdateDataRekamMedis(String kdRekamMedis) throws Exception;
    public void doUpdateDataRekamMedis(RekamMedisDto rekamMedisDto) throws Exception;
    
}
