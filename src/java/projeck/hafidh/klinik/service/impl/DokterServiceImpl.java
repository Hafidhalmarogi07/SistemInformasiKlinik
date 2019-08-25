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
import projeck.hafidh.klinik.dao.DokterDao;
import projeck.hafidh.klinik.dto.DokterDto;
import projeck.hafidh.klinik.model.DokterModel;
import projeck.hafidh.klinik.service.DokterService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class DokterServiceImpl implements DokterService{
    @Autowired
    DokterDao dokterDao;

    @Override
    public void saveDataDokter(DokterDto dokterDto) throws Exception {
        
       List <DokterModel> listData = dokterDao.getListDataDokter();
       int ind=1;
        for(DokterModel model : listData){
            String tamp=model.getKode_dokter();
            String tamp1=tamp.substring(1);
            if(ind<Integer.parseInt(tamp1)){
                ind=Integer.parseInt(tamp1);
           }
        }
        ind+=1;
        String untukId="D0"+ind+"";

        
        DokterModel dokterModel = new DokterModel();
        try {
            dokterModel.setKode_dokter(untukId);
            dokterModel.setNama_dokter(dokterDto.getNama_dokter());
            dokterModel.setSpesialis(dokterDto.getSpesialis());
            dokterModel.setTarif(dokterDto.getTarif());
            
            dokterDao.saveDataDokter(dokterModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<DokterDto> getListDokter() throws Exception {
        List <DokterDto> listDataDto = new ArrayList<>();
        List <DokterModel> listData = dokterDao.getListDataDokter();
        DokterDto dokterDto = null;
        try {
            if(listData != null){
                for(DokterModel model : listData){
                    dokterDto = new DokterDto();
                    if(model.getKode_dokter()!= null){
                        dokterDto.setKode_dokter(model.getKode_dokter());
                    }
                    if(model.getNama_dokter()!= null){
                        dokterDto.setNama_dokter(model.getNama_dokter());
                    }
                    if(model.getSpesialis()!= null){
                        dokterDto.setSpesialis(model.getSpesialis());
                    } 
                    dokterDto.setTarif(model.getTarif());
                    
                    listDataDto.add(dokterDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public DokterModel getDokterById(String id) {
        DokterModel dokterModel = null;
        try {
            dokterModel= dokterDao.getDokterById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dokterModel;
    }

    @Override
    public void deleteDataDokter(String kddokter) throws Exception {
       try {
            dokterDao.deleteDokter(kddokter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DokterDto getUpdateDataDokter(String kddokter) throws Exception {
        List<DokterModel> dataList = dokterDao.getListDokterUpdate(kddokter);
        DokterDto dto = new DokterDto();
        if(dataList != null){
            for (DokterModel ddm : dataList) {       
                if(ddm.getKode_dokter() != null){
                    dto.setKode_dokter(ddm.getKode_dokter());
                }
                if(ddm.getNama_dokter() != null){
                    dto.setNama_dokter(ddm.getNama_dokter());
                }
                if(ddm.getSpesialis() != null){
                    dto.setSpesialis(ddm.getSpesialis());
                }
                dto.setTarif(ddm.getTarif());
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataDokter(DokterDto dokterDto) throws Exception {
        DokterModel ddm = new DokterModel();
        try {
            ddm.setKode_dokter(dokterDto.getKode_dokter());
            ddm.setNama_dokter(dokterDto.getNama_dokter());
            ddm.setSpesialis(dokterDto.getSpesialis());
            ddm.setTarif(dokterDto.getTarif());
        } catch (Exception e) {
            e.printStackTrace();
        }
        dokterDao.updateDokter(ddm);
    }
    
}
