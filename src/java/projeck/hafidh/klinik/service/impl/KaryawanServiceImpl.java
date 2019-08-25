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
import projeck.hafidh.klinik.dao.KaryawanDao;
import projeck.hafidh.klinik.dto.KaryawanDto;
import projeck.hafidh.klinik.model.KaryawanModel;
import projeck.hafidh.klinik.service.KaryawanService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class KaryawanServiceImpl implements KaryawanService {

    @Autowired
    KaryawanDao karyawanDao;
    
    @Override
    public void saveDataKaryawan(KaryawanDto karyawanDto) throws Exception {
        List <KaryawanModel> listData = karyawanDao.getListDataKaryawan();
       int ind=1;
        for(KaryawanModel model : listData){
            String tamp=model.getId_karyawan();
            String tamp1=tamp.substring(1);
            if(ind<Integer.parseInt(tamp1)){
                ind=Integer.parseInt(tamp1);
           }
        }
        ind+=1;
        String untukId="K0"+ind+"";
        
        KaryawanModel karyawanModel = new KaryawanModel();
        try {
            karyawanModel.setId_karyawan(untukId);
            karyawanModel.setNama_karyawan(karyawanDto.getNama_karyawan());
            karyawanModel.setPassword(karyawanDto.getPassword());
            karyawanModel.setAlamat(karyawanDto.getAlamat());
            karyawanModel.setBagian(karyawanDto.getBagian());
            karyawanModel.setTelp(karyawanDto.getTelp());
            karyawanModel.setKode_poli(karyawanDto.getKode_poli());
            
            karyawanDao.saveDataKaryawan(karyawanModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KaryawanDto> getListKaryawan() throws Exception {
        List <KaryawanDto> listDataDto = new ArrayList<>();
        List <KaryawanModel> listData = karyawanDao.getListDataKaryawan();
        KaryawanDto karyawanDto = null;
        try {
            if(listData != null){
                for(KaryawanModel model : listData){
                    karyawanDto = new KaryawanDto();
                    if(model.getId_karyawan()!= null){
                        karyawanDto.setId_karyawan(model.getId_karyawan());
                    }
                    if(model.getNama_karyawan()!= null){
                        karyawanDto.setNama_karyawan(model.getNama_karyawan());
                    }
                    if(model.getPassword()!= null){
                        karyawanDto.setPassword(model.getPassword());
                    } 
                    if(model.getBagian()!= null){
                        karyawanDto.setBagian(model.getBagian());
                    } 
                    if(model.getAlamat()!= null){
                        karyawanDto.setAlamat(model.getAlamat());
                    } 
                    if(model.getTelp()!= null){
                        karyawanDto.setTelp(model.getTelp());
                    } 
                     if(model.getKode_poli()!= null){
                        karyawanDto.setKode_poli(model.getKode_poli());
                    } 
                    
                    
                    listDataDto.add(karyawanDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public KaryawanModel getKaryawanById(String id) {
        KaryawanModel karyawanModel = null;
        try {
            karyawanModel= karyawanDao.getKaryawanById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return karyawanModel;
    }

    @Override
    public void deleteDataKaryawan(String kdKaryawan) throws Exception {
       try {
            karyawanDao.deleteKaryawan(kdKaryawan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public KaryawanDto getUpdateDataKaryawan(String kdKaryawan) throws Exception {
        List<KaryawanModel> dataList = karyawanDao.getListKaryawanUpdate(kdKaryawan);
        KaryawanDto dto = new KaryawanDto();
        if(dataList != null){
            for (KaryawanModel ddm : dataList) {       
                if(ddm.getId_karyawan() != null){
                    dto.setId_karyawan(ddm.getId_karyawan());
                }
                if(ddm.getNama_karyawan() != null){
                    dto.setNama_karyawan(ddm.getNama_karyawan());
                }
                if(ddm.getPassword() != null){
                    dto.setPassword(ddm.getPassword());
                }
                if(ddm.getBagian() != null){
                    dto.setBagian(ddm.getBagian());
                }
                if(ddm.getAlamat() != null){
                    dto.setAlamat(ddm.getAlamat());
                }
                if(ddm.getTelp() != null){
                    dto.setTelp(ddm.getTelp());
                }
                if(ddm.getKode_poli() != null){
                    dto.setKode_poli(ddm.getKode_poli());
                }
                
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataKaryawan(KaryawanDto karyawanDto) throws Exception {
       KaryawanModel ddm = new KaryawanModel();
        try {
            ddm.setId_karyawan(karyawanDto.getId_karyawan());
            ddm.setNama_karyawan(karyawanDto.getNama_karyawan());
            ddm.setPassword(karyawanDto.getPassword());
            ddm.setBagian(karyawanDto.getBagian());
            ddm.setAlamat(karyawanDto.getAlamat());
            ddm.setTelp(karyawanDto.getTelp());
            ddm.setKode_poli(karyawanDto.getKode_poli());
        } catch (Exception e) {
            e.printStackTrace();
        }
        karyawanDao.updateKaryawan(ddm);
    }
    
}
