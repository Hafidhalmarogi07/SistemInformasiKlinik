/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.PasienDto;
import projeck.hafidh.klinik.model.PasienModel;

/**
 *
 * @author Acer
 */
public interface PasienService {
    public void saveDataPasien(PasienDto pasienDto) throws Exception;
    public List <PasienDto> getListPasien()throws Exception;
    public PasienModel getPasienById(String id);
    public void deleteDataPasien(String kdPasien) throws Exception;
    public PasienDto getUpdateDataPasien(String kdPasien) throws Exception;
    public void doUpdateDataPasien(PasienDto pasienDto) throws Exception;
    
}
