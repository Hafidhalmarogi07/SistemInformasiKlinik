/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface LaporanDao{
    public List<Object[]> getDataLaporanKunjungan()throws Exception;
    public List<Object[]> getDataLaporanPendapatan()throws Exception;
    public List<Object[]> getDataLaporanPembayaranDokter()throws Exception;
    
}
