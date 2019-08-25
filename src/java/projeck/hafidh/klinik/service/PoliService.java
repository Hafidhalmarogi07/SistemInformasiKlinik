/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.PoliDto;
import projeck.hafidh.klinik.model.PoliModel;


/**
 *
 * @author Acer
 */
public interface PoliService {
    public void saveDataPoli(PoliDto poliDto) throws Exception;
    public List <PoliDto> getListPoli()throws Exception;
    public PoliModel getPoliById(String id);
    public void deleteDataPoli(String kdpoli) throws Exception;
    public PoliDto getUpdateDataPoli(String kdpoli) throws Exception;
    public void doUpdateDataPoli(PoliDto poliDto) throws Exception;
    
}
