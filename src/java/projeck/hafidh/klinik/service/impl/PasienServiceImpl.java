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
import projeck.hafidh.klinik.dao.PasienDao;
import projeck.hafidh.klinik.dto.PasienDto;
import projeck.hafidh.klinik.model.PasienModel;
import projeck.hafidh.klinik.service.PasienService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class PasienServiceImpl implements PasienService{
    @Autowired
    PasienDao pasienDao;

    @Override
    public void saveDataPasien(PasienDto pasienDto) throws Exception {
       List <PasienModel> listData = pasienDao.getListDataPasien();
       int ind=1;
        for(PasienModel model : listData){
            String tamp=model.getKode_pasien();
            String tamp1=tamp.substring(1);
            if(ind<Integer.parseInt(tamp1)){
                ind=Integer.parseInt(tamp1);
           }
        }
        ind+=1;
        String untukId="P0"+ind+"";
        PasienModel pasienModel = new PasienModel();
        try {
            pasienModel.setKode_pasien(untukId);
            pasienModel.setNama_pasien(pasienDto.getNama_pasien());
            pasienModel.setTanggal_lahir(pasienDto.getTanggal_lahir());
            pasienModel.setJenis_kelamin(pasienDto.getJenis_kelamin());
            pasienModel.setTelepon(pasienDto.getTelepon());
            pasienModel.setAlamat(pasienDto.getAlamat());
            pasienModel.setKeterangan(pasienDto.getKeterangan());
               
            pasienDao.saveDataPasien(pasienModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PasienDto> getListPasien() throws Exception {
        List <PasienDto> listDataDto = new ArrayList<>();
        List <PasienModel> listData = pasienDao.getListDataPasien();
        PasienDto pasienDto = null;
        try {
            if(listData != null){
                for(PasienModel model : listData){
                    pasienDto = new PasienDto();
                    if(model.getKode_pasien()!= null){
                        pasienDto.setKode_pasien(model.getKode_pasien());
                    }
                    if(model.getNama_pasien()!= null){
                        pasienDto.setNama_pasien(model.getNama_pasien());
                    }
                    if(model.getTanggal_lahir()!= null){
                        pasienDto.setTanggal_lahir(model.getTanggal_lahir());
                    }
                    if(model.getJenis_kelamin()!= null){
                        pasienDto.setJenis_kelamin(model.getJenis_kelamin());
                    }
                    if(model.getTelepon()!= null){
                        pasienDto.setTelepon(model.getTelepon());
                    }
                    if(model.getAlamat()!= null){
                        pasienDto.setAlamat(model.getAlamat());
                    }
                    if(model.getKeterangan()!= null){
                        pasienDto.setKeterangan(model.getKeterangan());
                    }
                    listDataDto.add(pasienDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public PasienModel getPasienById(String id) {
        PasienModel pasienModel = null;
        try {
            pasienModel= pasienDao.getPasienById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pasienModel;
    }

    @Override
    public void deleteDataPasien(String kdPasien) throws Exception {
        try {
            pasienDao.deletePasien(kdPasien);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PasienDto getUpdateDataPasien(String kdPasien) throws Exception {
        List<PasienModel> dataList = pasienDao.getListPasienUpdate(kdPasien);
        PasienDto dto = new PasienDto();
        if(dataList != null){
            for (PasienModel ddm : dataList) {       
                if(ddm.getKode_pasien() != null){
                    dto.setKode_pasien(ddm.getKode_pasien());
                }
                if(ddm.getNama_pasien() != null){
                    dto.setNama_pasien(ddm.getNama_pasien());
                }
                 if(ddm.getTanggal_lahir() != null){
                    dto.setTanggal_lahir(ddm.getTanggal_lahir());
                }
                  if(ddm.getJenis_kelamin() != null){
                    dto.setJenis_kelamin(ddm.getJenis_kelamin());
                }
                   if(ddm.getTelepon() != null){
                    dto.setTelepon(ddm.getTelepon());
                }
                   if(ddm.getAlamat() != null){
                    dto.setAlamat(ddm.getAlamat());
                }
                if(ddm.getKeterangan() != null){
                    dto.setKeterangan(ddm.getKeterangan());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataPasien(PasienDto pasienDto) throws Exception {
        PasienModel ddm = new PasienModel();
        try {
            ddm.setKode_pasien(pasienDto.getKode_pasien());
            ddm.setNama_pasien(pasienDto.getNama_pasien());
            ddm.setTanggal_lahir(pasienDto.getTanggal_lahir());
            ddm.setJenis_kelamin(pasienDto.getJenis_kelamin());
            ddm.setTelepon(pasienDto.getTelepon());
            ddm.setAlamat(pasienDto.getAlamat());
            ddm.setKeterangan(pasienDto.getKeterangan());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        pasienDao.updatePasien(ddm);
    }
    
}
