/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.KunjunganDto;
import projeck.hafidh.klinik.model.KunjunganModel;

/**
 *
 * @author Acer
 */
public interface KunjunganService {
    public void saveDataKunjungan(KunjunganDto kunjunganDto) throws Exception;
    public List <KunjunganDto> getListKunjungan()throws Exception;
    public KunjunganModel getKunjunganById(String id);
    public void deleteDataKunjungan(String kdKunjungan) throws Exception;
    public KunjunganDto getUpdateDataKunjungan(String kdKunjungan) throws Exception;
    public void doUpdateDataKunjungan(KunjunganDto kunjunganDto) throws Exception;
    
}
