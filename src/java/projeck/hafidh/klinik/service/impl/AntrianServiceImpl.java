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
import projeck.hafidh.klinik.dao.AntrianDao;
import projeck.hafidh.klinik.dao.KunjunganDao;
import projeck.hafidh.klinik.dao.PasienDao;
import projeck.hafidh.klinik.dto.AntrianDto;
import projeck.hafidh.klinik.model.AntrianModel;
import projeck.hafidh.klinik.model.KunjunganModel;
import projeck.hafidh.klinik.model.PasienModel;
import projeck.hafidh.klinik.service.AntrianService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class AntrianServiceImpl implements AntrianService {
    
    @Autowired
    AntrianDao antrianDao;


    @Override
    public List<AntrianDto> getListAntrian() throws Exception {
        List <AntrianDto> listDataDto = new ArrayList<>();
        List <AntrianModel> listData = antrianDao.getListDataAntrian();
        AntrianDto antrianDto = null;
        try {
            if(listData != null){
                for(AntrianModel model : listData){
                    antrianDto = new AntrianDto();
                    if(model.getKode_kunjungan()!= null){
                        antrianDto.setKode_kunjungan(model.getKode_kunjungan());
                    }
                    if(model.getNo_antrian()!= null){
                        antrianDto.setNo_antrian(model.getNo_antrian());
                    }
                    if(model.getKode_poli()!= null){
                        antrianDto.setKode_poli(model.getKode_poli());
                    }
                    if(model.getKode_dokter()!=null){
                        antrianDto.setKode_dokter(model.getKode_dokter());
                    }
                    listDataDto.add(antrianDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<AntrianDto> getListAntrianByPoli(String kd) throws Exception {
        List <AntrianDto> listDataDto = new ArrayList<>();
        List <AntrianModel> listData = antrianDao.getListDataAntrianByPoli(kd);
        AntrianDto antrianDto = null;
        try {
            if(listData != null){
                for(AntrianModel model : listData){
                    antrianDto = new AntrianDto();
                    if(model.getKode_kunjungan()!= null){
                        antrianDto.setKode_kunjungan(model.getKode_kunjungan());
                    }
                    if(model.getNo_antrian()!= null){
                        antrianDto.setNo_antrian(model.getNo_antrian());
                    }
                    if(model.getNama_pasien()!= null){
                        antrianDto.setNama_pasien(model.getNama_pasien());
                    }
                    if(model.getKode_poli()!= null){
                        antrianDto.setKode_poli(model.getKode_poli());
                    } 
                    if(model.getKode_dokter()!=null){
                        antrianDto.setKode_dokter(model.getKode_dokter());
                    }
                    listDataDto.add(antrianDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public void deleteDataAntrian(String kdkunjungan) throws Exception {
       try {
            antrianDao.deleteAntrian(kdkunjungan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDataAntrian(String kod_kun, String nama, String ko_pol,String kod_dok) throws Exception {
        int noantrian=1;
        List <AntrianModel> listData = antrianDao.getListDataAntrianByPoli(ko_pol);
        try {
            if(listData != null){
                for(AntrianModel model : listData){
                   noantrian+=1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        AntrianModel antrianModel = new AntrianModel();
        try {
            antrianModel.setKode_kunjungan(kod_kun);
            antrianModel.setNo_antrian(String.valueOf(noantrian));
            antrianModel.setNama_pasien(nama);
            antrianModel.setKode_poli(ko_pol);
            antrianModel.setKode_dokter(kod_dok);
            
            antrianDao.saveDataAntrian(antrianModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AntrianModel getAntrianById(String id) {
         AntrianModel antrianModel = null;
        try {
            antrianModel= antrianDao.getAntrianById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return antrianModel;
    }
    
}
