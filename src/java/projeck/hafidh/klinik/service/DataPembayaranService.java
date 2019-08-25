/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.DataPembayaranDto;
import projeck.hafidh.klinik.model.DataPembayaranModel;

/**
 *
 * @author Acer
 */
public interface DataPembayaranService {
    public void saveDataDokter(DataPembayaranDto pembayaranDto) throws Exception;
    public List <DataPembayaranDto> getListPembayaran()throws Exception;
    public DataPembayaranModel getpembayaranById(String id);
    public void deleteDataPembayaran(String kdpembayaran) throws Exception;
    public DataPembayaranDto getUpdateDataPembayaran(String kdpemabayaran) throws Exception;
    public void doUpdateDataPembayaran(DataPembayaranDto pembayaranDto) throws Exception;
    
}
