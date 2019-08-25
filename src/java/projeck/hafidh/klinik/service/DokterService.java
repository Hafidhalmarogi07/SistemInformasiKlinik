/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.DokterDto;
import projeck.hafidh.klinik.model.DokterModel;

/**
 *
 * @author Acer
 */
public interface DokterService {
    public void saveDataDokter(DokterDto dokterDto) throws Exception;
    public List <DokterDto> getListDokter()throws Exception;
    public DokterModel getDokterById(String id);
    public void deleteDataDokter(String kddokter) throws Exception;
    public DokterDto getUpdateDataDokter(String kddokter) throws Exception;
    public void doUpdateDataDokter(DokterDto dokterDto) throws Exception;
}
