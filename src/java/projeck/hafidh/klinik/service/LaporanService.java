/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import java.util.List;
import projeck.hafidh.klinik.dto.LaporanDto;
import projeck.hafidh.klinik.dto.LaporanPembayaranDokterDto;
import projeck.hafidh.klinik.dto.LaporanPendapatanDto;

/**
 *
 * @author Acer
 */
public interface LaporanService {
     public List <LaporanDto> getDataLaporanKunjungan()throws Exception;
     public List<LaporanPendapatanDto> getDataLaporanPedapatan()throws Exception;
     public List<LaporanPembayaranDokterDto> getDataLaporanPembayaranDokter()throws Exception;
    
    
}
