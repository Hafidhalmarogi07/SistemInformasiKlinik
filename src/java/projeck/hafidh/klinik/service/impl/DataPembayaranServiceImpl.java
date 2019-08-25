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
import projeck.hafidh.klinik.dao.DataPembayaranDao;
import projeck.hafidh.klinik.dto.DataPembayaranDto;
import projeck.hafidh.klinik.model.DataPembayaranModel;
import projeck.hafidh.klinik.service.DataPembayaranService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class DataPembayaranServiceImpl implements DataPembayaranService{

    @Autowired
    DataPembayaranDao pembayaranDao;
    
    @Override
    public void saveDataDokter(DataPembayaranDto pembayaranDto) throws Exception {
        List <DataPembayaranModel> listData = pembayaranDao.getListDataDataPembayaran();
       int ind=1;
        for(DataPembayaranModel model : listData){
            String tamp=model.getKode_pembayaran();
            String tamp1=tamp.substring(2);
            if(ind<Integer.parseInt(tamp1)){
                ind=Integer.parseInt(tamp1);
           }
        }
        ind+=1;
        String untukId="DP0"+ind+"";
        DataPembayaranModel pembayaranModel = new DataPembayaranModel();
        try {
            pembayaranModel.setKode_pembayaran(untukId);
            pembayaranModel.setKode_kunjungan(pembayaranDto.getKode_kunjungan());
            pembayaranModel.setTarif_dokter(pembayaranDto.getTarif_dokter());
            pembayaranModel.setObat(pembayaranDto.getObat());
            pembayaranModel.setTindakan(pembayaranDto.getTindakan());
             pembayaranModel.setHarga_tindakan(pembayaranDto.getHarga_tindakan());
            pembayaranModel.setTotal(pembayaranDto.getTotal());
            pembayaranDao.saveDataDataPembayaran(pembayaranModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DataPembayaranDto> getListPembayaran() throws Exception {
        List <DataPembayaranDto> listDataDto = new ArrayList<>();
        List <DataPembayaranModel> listData = pembayaranDao.getListDataDataPembayaran();
        DataPembayaranDto pembayaranDto = null;
        try {
            if(listData != null){
                for(DataPembayaranModel model : listData){
                    pembayaranDto = new DataPembayaranDto();
                    if(model.getKode_pembayaran()!= null){
                        pembayaranDto.setKode_pembayaran(model.getKode_pembayaran());
                    }
                     if(model.getKode_kunjungan()!= null){
                        pembayaranDto.setKode_kunjungan(model.getKode_kunjungan());
                    }
                     pembayaranDto.setTarif_dokter(model.getTarif_dokter());
                     pembayaranDto.setObat(model.getObat());
                    if(model.getTindakan()!= null){
                        pembayaranDto.setTindakan(model.getTindakan());
                    }
                   pembayaranDto.setHarga_tindakan(model.getHarga_tindakan());
                   pembayaranDto.setTotal(model.getTotal());
                    
                    listDataDto.add(pembayaranDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public DataPembayaranModel getpembayaranById(String id) {
        DataPembayaranModel pembayaranModel = null;
        try {
            pembayaranModel= pembayaranDao.getDataPembayaranById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pembayaranModel;
    }

    @Override
    public void deleteDataPembayaran(String kdpembayaran) throws Exception {
        try {
            pembayaranDao.deleteDataPembayaran(kdpembayaran);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DataPembayaranDto getUpdateDataPembayaran(String kdpemabayaran) throws Exception {
        List<DataPembayaranModel> dataList = pembayaranDao.getListDataPembayaranUpdate(kdpemabayaran);
        DataPembayaranDto dto = new DataPembayaranDto();
        if(dataList != null){
            for (DataPembayaranModel ddm : dataList) {       
                if(ddm.getKode_pembayaran() != null){
                    dto.setKode_pembayaran(ddm.getKode_pembayaran());
                }
                if(ddm.getKode_kunjungan() != null){
                    dto.setKode_kunjungan(ddm.getKode_kunjungan());
                }
                dto.setTarif_dokter(ddm.getTarif_dokter());
                dto.setObat(ddm.getObat());
                if(ddm.getTindakan()!=null){
                    dto.setTindakan(ddm.getTindakan());
                    
                }
                dto.setHarga_tindakan(ddm.getHarga_tindakan());
                dto.setTotal(ddm.getTotal());
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataPembayaran(DataPembayaranDto pembayaranDto) throws Exception {
        DataPembayaranModel ddm = new DataPembayaranModel();
        try {
            ddm.setKode_pembayaran(pembayaranDto.getKode_pembayaran());
            ddm.setKode_kunjungan(pembayaranDto.getKode_kunjungan());
            ddm.setTarif_dokter(pembayaranDto.getTarif_dokter());
            ddm.setObat(pembayaranDto.getObat());
            ddm.setTindakan(pembayaranDto.getTindakan());
            ddm.setHarga_tindakan(pembayaranDto.getHarga_tindakan());
            ddm.setTotal(pembayaranDto.getTotal());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        pembayaranDao.updateDataPembayaran(ddm);
    }
    
}
