/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeck.hafidh.klinik.dao.LaporanDao;
import projeck.hafidh.klinik.dto.LaporanDto;
import projeck.hafidh.klinik.dto.LaporanPembayaranDokterDto;
import projeck.hafidh.klinik.dto.LaporanPendapatanDto;
import projeck.hafidh.klinik.service.LaporanService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class LaporanServiceImpl implements LaporanService{

    @Autowired
    LaporanDao laporanDao;
    
    @Override
    public List<LaporanDto> getDataLaporanKunjungan() throws Exception {
        List <LaporanDto> listDataDto = new ArrayList<>();
        List <Object[]> listData = laporanDao.getDataLaporanKunjungan();
        LaporanDto laporanDto = null;
        try {
           if(listData != null){
                for(Object[] model : listData){
                    laporanDto = new LaporanDto();
                    laporanDto.setKode_kunjungan(model[0].toString());
                    laporanDto.setTanggal_kunjungan(model[1].toString());
                    laporanDto.setNama_poli(model[2].toString());
                    laporanDto.setNama_pasien(model[3].toString());
                    laporanDto.setNama_dokter(model[4].toString());
                    laporanDto.setMetode_pembayaran(model[5].toString());
                    
                            
                    listDataDto.add(laporanDto);
                
                }
               
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<LaporanPendapatanDto> getDataLaporanPedapatan() throws Exception {
        List <LaporanPendapatanDto> listDataDto = new ArrayList<>();
        List <Object[]> listData = laporanDao.getDataLaporanPendapatan();
        LaporanPendapatanDto laporanDto = null;
        try {
           if(listData != null){
                for(Object[] model : listData){
                    laporanDto = new LaporanPendapatanDto();
                    laporanDto.setKode_pembayaran(model[0].toString());
                    laporanDto.setTanggal_kunjungan(model[1].toString());
                    laporanDto.setTarif_dokter(Integer.parseInt(model[2].toString()));
                    laporanDto.setObat(Integer.parseInt(model[3].toString()));
                    laporanDto.setHarga_tindakan(Integer.parseInt(model[4].toString()));
                    laporanDto.setMetode_pembayaran(model[5].toString());
                    
                            
                    listDataDto.add(laporanDto);
                
                }
               
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<LaporanPembayaranDokterDto> getDataLaporanPembayaranDokter() throws Exception {
        List<LaporanPembayaranDokterDto> listDataDto =new ArrayList<>();
        List<Object[]> listdata =laporanDao.getDataLaporanPembayaranDokter();
        LaporanPembayaranDokterDto laporanDto=null;
        try {
            if(listdata!=null){
                for(Object[] data :listdata){
                    laporanDto=new LaporanPembayaranDokterDto();
                    laporanDto.setTanggal(data[0].toString());
                    laporanDto.setKode_dekter(data[1].toString());
                    laporanDto.setNama_dokter(data[2].toString());
                    laporanDto.setNama_pasien(data[3].toString());
                    laporanDto.setTarif_dokter(Integer.parseInt(data[4].toString()));
                    laporanDto.setTindakan(data[5].toString());
                    laporanDto.setTarif_tindakan(Integer.parseInt(data[6].toString()));
                    
                    listDataDto.add(laporanDto);
                }
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }
    
}
