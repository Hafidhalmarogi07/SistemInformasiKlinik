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
import projeck.hafidh.klinik.dto.KunjunganDto;
import projeck.hafidh.klinik.model.AntrianModel;
import projeck.hafidh.klinik.model.KunjunganModel;
import projeck.hafidh.klinik.service.KunjunganService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class KunjunganServiceImpl implements KunjunganService{

    @Autowired
    KunjunganDao kunjunganDao;
    @Autowired
    AntrianDao antrianDao;
    
    @Override
    public void saveDataKunjungan(KunjunganDto kunjunganDto) throws Exception {
        List <KunjunganModel> listData = kunjunganDao.getListDataKunjungan();
       int ind=0;
        for(KunjunganModel model : listData){
            String tamp=model.getKode_kunjungan();
            String tamp1=tamp.substring(2);
            if(ind<Integer.parseInt(tamp1)){
                ind=Integer.parseInt(tamp1);
           }
        }
        ind+=1;
        String untukId="KJ0"+ind+"";
        KunjunganModel kunjunganModel = new KunjunganModel();
        try {
            kunjunganModel.setKode_kunjungan(untukId);
            kunjunganModel.setTanggal_kunjungan(kunjunganDto.getTanggal_kunjungan());
            kunjunganModel.setKode_poli(kunjunganDto.getKode_poli());
            kunjunganModel.setKode_pasien(kunjunganDto.getKode_pasien());
            kunjunganModel.setKode_dokter(kunjunganDto.getKode_dokter());
            kunjunganModel.setMetode_pembayran(kunjunganDto.getMetode_pembayran());
            
            kunjunganDao.saveDataKunjungan(kunjunganModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
        List <AntrianModel> listData1 = antrianDao.getListDataAntrianByPoli(kunjunganDto.getKode_poli());
        int ind1=0;
        for(AntrianModel model1 : listData1){
            String tamp=model1.getNo_antrian();
            ind1=Integer.parseInt(tamp);
        }

        ind1=ind1+1;
        
        
        AntrianModel antrianModel = new AntrianModel();
        
        try {
            antrianModel.setKode_kunjungan(untukId);
            antrianModel.setNo_antrian(String.valueOf(ind1));
            antrianModel.setNama_pasien(kunjunganDto.getKode_pasien());
            antrianModel.setKode_poli(kunjunganDto.getKode_poli());
            antrianModel.setKode_dokter(kunjunganDto.getKode_dokter());    
            antrianDao.saveDataAntrian(antrianModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    @Override
    public List<KunjunganDto> getListKunjungan() throws Exception {
        List <KunjunganDto> listDataDto = new ArrayList<>();
        List <KunjunganModel> listData = kunjunganDao.getListDataKunjungan();
        KunjunganDto kunjunganDto = null;
        try {
            if(listData != null){
                for(KunjunganModel model : listData){
                    kunjunganDto = new KunjunganDto();
                    if(model.getKode_kunjungan()!= null){
                        kunjunganDto.setKode_kunjungan(model.getKode_kunjungan());
                    }
                    if(model.getTanggal_kunjungan()!= null){
                        kunjunganDto.setTanggal_kunjungan(model.getTanggal_kunjungan());
                    }
                    if(model.getKode_poli()!= null){
                        kunjunganDto.setKode_poli(model.getKode_poli());
                    }
                    if(model.getKode_pasien()!= null){
                        kunjunganDto.setKode_pasien(model.getKode_pasien());
                    }
                    if(model.getKode_dokter()!= null){
                        kunjunganDto.setKode_dokter(model.getKode_dokter());
                    }
                    if(model.getMetode_pembayran()!= null){
                        kunjunganDto.setMetode_pembayran(model.getMetode_pembayran());
                    }
                            
                    listDataDto.add(kunjunganDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public KunjunganModel getKunjunganById(String id) {
        KunjunganModel kunjunganModel = null;
        try {
            kunjunganModel= kunjunganDao.getKunjunganById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kunjunganModel;
    }

    @Override
    public void deleteDataKunjungan(String kdKunjungan) throws Exception {
        try {
            kunjunganDao.deleteKunjungan(kdKunjungan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public KunjunganDto getUpdateDataKunjungan(String kdKunjungan) throws Exception {
        List<KunjunganModel> dataList = kunjunganDao.getListKunjunganUpdate(kdKunjungan);
        KunjunganDto dto = new KunjunganDto();
        if(dataList != null){
            for (KunjunganModel ddm : dataList) {       
                if(ddm.getKode_kunjungan() != null){
                    dto.setKode_kunjungan(ddm.getKode_kunjungan());
                }
                if(ddm.getTanggal_kunjungan() != null){
                    dto.setTanggal_kunjungan(ddm.getTanggal_kunjungan());
                }
                if(ddm.getKode_poli() != null){
                    dto.setKode_poli(ddm.getKode_poli());
                }
                if(ddm.getKode_pasien() != null){
                    dto.setKode_pasien(ddm.getKode_pasien());
                }
                if(ddm.getKode_dokter() != null){
                    dto.setKode_dokter(ddm.getKode_dokter());
                }
                if(ddm.getMetode_pembayran() != null){
                    dto.setMetode_pembayran(ddm.getMetode_pembayran());
                }
                
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataKunjungan(KunjunganDto kunjunganDto) throws Exception {
        KunjunganModel ddm = new KunjunganModel();
        try {
            ddm.setKode_kunjungan(kunjunganDto.getKode_kunjungan());
            ddm.setTanggal_kunjungan(kunjunganDto.getTanggal_kunjungan());
            ddm.setKode_poli(kunjunganDto.getKode_poli());
            ddm.setKode_pasien(kunjunganDto.getKode_pasien());
            ddm.setKode_dokter(kunjunganDto.getKode_dokter());
            ddm.setMetode_pembayran(kunjunganDto.getMetode_pembayran());
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        kunjunganDao.updateKunjungan(ddm);
    }
    
}
