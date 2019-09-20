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
        List<KaryawanModel> listData = karyawanDao.getListDataKaryawan();
        int ind = 1;
        for (KaryawanModel model : listData) {
            String tamp = model.getId_karyawan();
            String tamp1 = tamp.substring(1);
            if (ind < Integer.parseInt(tamp1)) {
                ind = Integer.parseInt(tamp1);
            }
        }
        ind += 1;
        String untukId = "K0" + ind + "";

        KaryawanModel karyawanModel = new KaryawanModel();
        try {
            karyawanModel.setId_karyawan(untukId);
            karyawanModel.setNama_karyawan(karyawanDto.getNama_karyawan());
            karyawanModel.setJenis_kelamin(karyawanDto.getJenis_kelamin());
            karyawanModel.setPassword(karyawanDto.getPassword());
            karyawanModel.setAlamat(karyawanDto.getAlamat());
            karyawanModel.setStatus_bagian(karyawanDto.getBagian());
            karyawanModel.setTelp(karyawanDto.getTelp());
            karyawanModel.setKode_poli(karyawanDto.getKode_poli());

            karyawanDao.saveDataKaryawan(karyawanModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KaryawanDto> getListKaryawan() throws Exception {
        List<KaryawanDto> listDataDto = new ArrayList<>();
        List<KaryawanModel> listData = karyawanDao.getListDataKaryawan();
        KaryawanDto karyawanDto = null;
        try {
            if (listData != null) {
                for (KaryawanModel model : listData) {
                    karyawanDto = new KaryawanDto();
                    if (model.getId_karyawan() != null) {
                        karyawanDto.setId_karyawan(model.getId_karyawan());
                    }
                    if (model.getNama_karyawan() != null) {
                        karyawanDto.setNama_karyawan(model.getNama_karyawan());
                    }
                    if(model.getJenis_kelamin() !=null){
                        karyawanDto.setJenis_kelamin(model.getJenis_kelamin());
                    }
                    if (model.getPassword() != null) {
                        karyawanDto.setPassword(model.getPassword());
                    }
                    if (model.getStatus_bagian() != null) {
                        karyawanDto.setBagian(model.getStatus_bagian());
                    }
                    if (model.getAlamat() != null) {
                        karyawanDto.setAlamat(model.getAlamat());
                    }
                    if (model.getTelp() != null) {
                        karyawanDto.setTelp(model.getTelp());
                    }
                    if (model.getKode_poli() != null) {
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
            karyawanModel = karyawanDao.getKaryawanById(id);
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
        if (dataList != null) {
            for (KaryawanModel ddm : dataList) {
                if (ddm.getId_karyawan() != null) {
                    dto.setId_karyawan(ddm.getId_karyawan());
                }
                if (ddm.getNama_karyawan() != null) {
                    dto.setNama_karyawan(ddm.getNama_karyawan());
                }
                if (ddm.getJenis_kelamin() != null) {
                    dto.setJenis_kelamin(ddm.getJenis_kelamin());
                }
                if (ddm.getPassword() != null) {
                    dto.setPassword(ddm.getPassword());
                }
                if (ddm.getStatus_bagian() != null) {
                    dto.setBagian(ddm.getStatus_bagian());
                }
                if (ddm.getAlamat() != null) {
                    dto.setAlamat(ddm.getAlamat());
                }
                if (ddm.getTelp() != null) {
                    dto.setTelp(ddm.getTelp());
                }
                if (ddm.getKode_poli() != null) {
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
            ddm.setJenis_kelamin(karyawanDto.getJenis_kelamin());
            ddm.setPassword(karyawanDto.getPassword());
            ddm.setStatus_bagian(karyawanDto.getBagian());
            ddm.setAlamat(karyawanDto.getAlamat());
            ddm.setTelp(karyawanDto.getTelp());
            ddm.setKode_poli(karyawanDto.getKode_poli());
        } catch (Exception e) {
            e.printStackTrace();
        }
        karyawanDao.updateKaryawan(ddm);
    }

    @Override
    public KaryawanDto getDataId() throws Exception {
        KaryawanDto karDto = new KaryawanDto();
        List<KaryawanModel> listData = karyawanDao.getListDataKaryawan();
        int ind = 1;
        for (KaryawanModel model : listData) {
            String tamp = model.getId_karyawan();
            String tamp1 = tamp.substring(1);
            if (ind < Integer.parseInt(tamp1)) {
                ind = Integer.parseInt(tamp1);
            }
        }
        ind += 1;
        String untukId = "K0" + ind + "";

        karDto.setId_karyawan(untukId);
        return karDto;
    }

    @Override
    public KaryawanDto getDataLogin(KaryawanDto fromDto) throws Exception {
        List<KaryawanModel> datalist=karyawanDao.getlistlogin(fromDto);
        KaryawanDto usrDto = new KaryawanDto();
        
        try {
            usrDto.setListDataUser(karyawanDao.getlistlogin(fromDto));
            if(datalist != null){
            for (KaryawanModel ddm : datalist) {       
                if(ddm.getId_karyawan()!= null){
                    usrDto.setId_karyawan(ddm.getId_karyawan());
                }
                if(ddm.getNama_karyawan()!= null){
                    usrDto.setNama_karyawan(ddm.getNama_karyawan());
                }
                if(ddm.getJenis_kelamin() != null){
                    usrDto.setJenis_kelamin(ddm.getJenis_kelamin());
                }
                if(ddm.getAlamat() != null){
                    usrDto.setAlamat(ddm.getAlamat());
                }
                if(ddm.getTelp() != null){
                    usrDto.setTelp(ddm.getTelp());
                }
                if(ddm.getStatus_bagian() != null){
                    usrDto.setBagian(ddm.getStatus_bagian());
                }
                if(ddm.getKode_poli() != null){
                    usrDto.setKode_poli(ddm.getKode_poli());
                }
                if(ddm.getPassword() != null){
                    usrDto.setPassword(ddm.getPassword());
                }
                
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usrDto;
    }

}
