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
import projeck.hafidh.klinik.dao.PoliDao;
import projeck.hafidh.klinik.dto.PoliDto;
import projeck.hafidh.klinik.model.PoliModel;
import projeck.hafidh.klinik.service.PoliService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class PoliServiceImpl implements PoliService {

    @Autowired
    PoliDao poliDao;

    @Override
    public void saveDataPoli(PoliDto poliDto) throws Exception {
       List <PoliModel> listData = poliDao.getListDataPoli();
       int ind=1;
        for(PoliModel model : listData){
            String tamp=model.getKode_poli();
            String tamp1=tamp.substring(2);
            if(ind<Integer.parseInt(tamp1)){
                ind=Integer.parseInt(tamp1);
           }
        }
        ind+=1;
        String untukId="PL0"+ind+"";
        PoliModel poliModel = new PoliModel();
        try {
            poliModel.setKode_poli(untukId);
            poliModel.setNama_poli(poliDto.getNama_poli());
            poliModel.setKeterangan(poliDto.getKeterangan());

            poliDao.saveDataPoli(poliModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PoliDto> getListPoli() throws Exception {
        List<PoliDto> listDataDto = new ArrayList<>();
        List<PoliModel> listData = poliDao.getListDataPoli();
        PoliDto poliDto = null;
        try {
            if (listData != null) {
                for (PoliModel model : listData) {
                    poliDto = new PoliDto();
                    if (model.getKode_poli() != null) {
                        poliDto.setKode_poli(model.getKode_poli());
                    }
                    if (model.getNama_poli() != null) {
                        poliDto.setNama_poli(model.getNama_poli());
                    }
                    if (model.getKeterangan() != null) {
                        poliDto.setKeterangan(model.getKeterangan());
                    }

                    listDataDto.add(poliDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public PoliModel getPoliById(String id) {
        PoliModel poliModel = null;
        try {
            poliModel = poliDao.getPoliById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return poliModel;
    }

    @Override
    public void deleteDataPoli(String kdpoli) throws Exception {
        try {
            poliDao.deletePoli(kdpoli);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PoliDto getUpdateDataPoli(String kdpoli) throws Exception {
        List<PoliModel> dataList = poliDao.getListPoliUpdate(kdpoli);
        PoliDto dto = new PoliDto();
        if (dataList != null) {
            for (PoliModel ddm : dataList) {
                if (ddm.getKode_poli() != null) {
                    dto.setKode_poli(ddm.getKode_poli());
                }
                if (ddm.getNama_poli() != null) {
                    dto.setNama_poli(ddm.getNama_poli());
                }
                if (ddm.getKeterangan() != null) {
                    dto.setKeterangan(ddm.getKeterangan());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataPoli(PoliDto poliDto) throws Exception {
        PoliModel ddm = new PoliModel();
        try {
            ddm.setKode_poli(poliDto.getKode_poli());
            ddm.setNama_poli(poliDto.getNama_poli());
            ddm.setKeterangan(poliDto.getKeterangan());
        } catch (Exception e) {
            e.printStackTrace();
        }
        poliDao.updatePoli(ddm);
    }

}
