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
import projeck.hafidh.klinik.dto.AntrianRekamDto;
import projeck.hafidh.klinik.model.AntrianRekamModel;
import projeck.hafidh.klinik.service.AntrianRekamService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class AntrianRekamServiceImpl implements AntrianRekamService{
    
    @Autowired 
    AntrianRekamDao antrianRekamDao;

    @Override
    public void saveDataAntrianRekam(String kod_kun, String nama, String kod_pol,int tarif) throws Exception {
//       List <AntrianRekamModel> listData = antrianRekamDao.getListDataAntrianRekamByPoli(kod_pol);
//       int ind=0;
//        for(AntrianRekamModel model : listData){
//            String tamp=model.getNo_antrian();
//            ind=Integer.parseInt(tamp);
//        }
//
//        ind=ind+1;
//        AntrianRekamModel antrianRekamModel = new AntrianRekamModel();
//        try {
//            antrianRekamModel.setKode_kunjungan(kod_kun);
//            antrianRekamModel.setNo_antrian(String.valueOf(ind));
//            antrianRekamModel.setNama_pasien(nama);
//            antrianRekamModel.setKode_poli(kod_pol);
//            antrianRekamModel.setTarif_dokter(tarif);
//           
//            
//            antrianRekamDao.saveDataAntrianRekam(antrianRekamModel);
//                       
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public List<AntrianRekamDto> getListAntrianRekam() throws Exception {
        List <AntrianRekamDto> listDataDto = new ArrayList<>();
        List <AntrianRekamModel> listData = antrianRekamDao.getListDataAntrianRekam();
        AntrianRekamDto antrianDto = null;
        try {
            if(listData != null){
                for(AntrianRekamModel model : listData){
                    antrianDto = new AntrianRekamDto();
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
                        antrianDto.setTarif_dokter(1);
                    }
                   listDataDto.add(antrianDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto; }

    @Override
    public AntrianRekamModel getListAntrianRekamById(String kd) throws Exception {
        AntrianRekamModel antrianModel = null;
        try {
            antrianModel= antrianRekamDao.getListDataAntrianRekamById(kd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return antrianModel;
    }

    @Override
    public void deleteDataAntrianRekam(String kdkunjungan) throws Exception {
         try {
            antrianRekamDao.deleteAntrianRekam(kdkunjungan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AntrianRekamDto> getAntrianRekam() throws Exception {
        List <AntrianRekamDto> listDataDto = new ArrayList<>();
        List <Object[]> listData = antrianRekamDao.getDataAtrian();
        AntrianRekamDto antrianDto = null;
        try {
            if(listData != null){
                for(Object[] model : listData){
                    antrianDto = new AntrianRekamDto();
                        antrianDto.setKode_kunjungan(model[0].toString());
                        antrianDto.setNo_antrian(model[1].toString());
                        antrianDto.setKode_pasien(model[2].toString());
                        antrianDto.setNama_pasien(model[3].toString());
                        antrianDto.setKode_poli(model[4].toString());
                        antrianDto.setNama_poli(model[5].toString());
                        antrianDto.setKode_dokter(model[6].toString());
                        antrianDto.setTarif_dokter(Integer.parseInt(model[7].toString()));
                    listDataDto.add(antrianDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<AntrianRekamDto> getAntrianById(String id) throws Exception {
        List <AntrianRekamDto> listDataDto = new ArrayList<>();
        List <Object[]> listData = antrianRekamDao.getAntrianById(id);
        AntrianRekamDto antrianDto = null;
       try {
            if(listData != null){
                for(Object[] model : listData){
                    antrianDto = new AntrianRekamDto();
                        antrianDto.setKode_kunjungan(model[0].toString());
                        antrianDto.setKode_dokter(model[1].toString());
                        antrianDto.setTarif_dokter(Integer.parseInt(model[2].toString()));
                    listDataDto.add(antrianDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
    
}
