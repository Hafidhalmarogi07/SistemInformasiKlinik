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
import projeck.hafidh.klinik.dao.AntrianRekamDao;
import projeck.hafidh.klinik.dao.DokterDao;
import projeck.hafidh.klinik.dao.RekamMedisDao;
import projeck.hafidh.klinik.dto.DokterDto;
import projeck.hafidh.klinik.dto.RekamMedisDto;
import projeck.hafidh.klinik.model.AntrianRekamModel;
import projeck.hafidh.klinik.model.DokterModel;
import projeck.hafidh.klinik.model.RekamMedisModel;
import projeck.hafidh.klinik.service.RekamMedisService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class RekamMedisServiceImpl implements RekamMedisService{

    @Autowired
    RekamMedisDao rekamMedisDao;
    
    @Autowired
    AntrianRekamDao antrianRekamDao;
    
    @Autowired
    DokterDao datadok;
    
    @Override
    public void saveDataRekamMedis(RekamMedisDto rekamMedisDto) throws Exception {
        List <RekamMedisModel> listData = rekamMedisDao.getListDataRekamMedis();
        int ind=0;
        for(RekamMedisModel model : listData){
            String tamp=model.getKode_rekam();
            String tamp1=tamp.substring(2);
            if(ind<Integer.parseInt(tamp1)){
                ind=Integer.parseInt(tamp1);
           }
        }
        ind+=1;
        String untukId="RM0"+ind+"";
         RekamMedisModel rekamMedisModel = new RekamMedisModel();
        try {
            rekamMedisModel.setKode_rekam(untukId);
            rekamMedisModel.setKode_kunjungan(rekamMedisDto.getKode_kunjungan());
            rekamMedisModel.setKeluhan(rekamMedisDto.getKeluhan());
            rekamMedisModel.setDiagnosa(rekamMedisDto.getDiagnosa());
            rekamMedisModel.setTindakan(rekamMedisDto.getTindakan());
            rekamMedisModel.setResep(rekamMedisDto.getResep());
           
            rekamMedisDao.saveDataRekamMedis(rekamMedisModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
        AntrianRekamModel antrianRekamModel = new AntrianRekamModel();
        try {
            antrianRekamModel.setKode_kunjungan(rekamMedisDto.getKode_kunjungan());
            antrianRekamModel.setNo_antrian("1");
            antrianRekamModel.setKode_pasien(rekamMedisDto.getNama_pasien());
            antrianRekamModel.setKode_poli(rekamMedisDto.getKode_poli());
            antrianRekamModel.setKode_dokter(rekamMedisDto.getId_dokter());
            antrianRekamDao.saveDataAntrianRekam(antrianRekamModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public List<RekamMedisDto> getListRekamMedis() throws Exception {
       List<RekamMedisDto> listDataDto = new ArrayList<>();
        List<RekamMedisModel> listData = rekamMedisDao.getListDataRekamMedis();
        RekamMedisDto rekamDto = null;
        try {
            if (listData != null) {
                for (RekamMedisModel model : listData) {
                    rekamDto = new RekamMedisDto();
                    if (model.getKode_rekam() != null) {
                        rekamDto.setKode_rekam(model.getKode_rekam());
                    }
                    if (model.getKode_kunjungan() != null) {
                        rekamDto.setKode_kunjungan(model.getKode_kunjungan());
                    }
                    if (model.getKeluhan() != null) {
                        rekamDto.setKeluhan(model.getKeluhan());
                    }
                    if (model.getDiagnosa() != null) {
                        rekamDto.setDiagnosa(model.getDiagnosa());
                    }
                    if (model.getTindakan() != null) {
                        rekamDto.setTindakan(model.getTindakan());
                    }
                    if (model.getResep() != null) {
                        rekamDto.setResep(model.getResep());
                    }
                   
                    listDataDto.add(rekamDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public RekamMedisModel getRekamMedisById(String id) {
        RekamMedisModel rekamMedisModel = null;
        try {
            rekamMedisModel = rekamMedisDao.getRekamMedisById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rekamMedisModel;
    }

    @Override
    public void deleteDataRekamMedis(String kdRekamMedis) throws Exception {
         try {
            rekamMedisDao.deleteRekamMedis(kdRekamMedis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public RekamMedisDto getUpdateDataRekamMedis(String kdRekamMedis) throws Exception {
        List<RekamMedisModel> dataList = rekamMedisDao.getListRekamMedisUpdate(kdRekamMedis);
        RekamMedisDto dto = new RekamMedisDto();
        if (dataList != null) {
            for (RekamMedisModel ddm : dataList) {
                if (ddm.getKode_rekam() != null) {
                    dto.setKode_rekam(ddm.getKode_rekam());
                }
                if (ddm.getKode_kunjungan() != null) {
                    dto.setKode_kunjungan(ddm.getKode_kunjungan());
                }
                if (ddm.getKeluhan() != null) {
                    dto.setKeluhan(ddm.getKeluhan());
                }
                if (ddm.getDiagnosa() != null) {
                    dto.setDiagnosa(ddm.getDiagnosa());
                }
                if (ddm.getTindakan() != null) {
                    dto.setTindakan(ddm.getTindakan());
                }
                if (ddm.getResep()!= null) {
                    dto.setResep(ddm.getResep());
                }
                
               
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataRekamMedis(RekamMedisDto rekamMedisDto) throws Exception {
        RekamMedisModel rek=new RekamMedisModel();
        try {
            rek.setKode_rekam(rekamMedisDto.getKode_rekam());
            rek.setKode_kunjungan(rekamMedisDto.getKode_kunjungan());
            rek.setKeluhan(rekamMedisDto.getKeluhan());
            rek.setDiagnosa(rekamMedisDto.getDiagnosa());
            rek.setResep(rekamMedisDto.getResep());
            rek.setTindakan(rekamMedisDto.getTindakan());
        } catch (Exception e) {
        }
        rekamMedisDao.updateRekamMedis(rek);   
    }    
}
