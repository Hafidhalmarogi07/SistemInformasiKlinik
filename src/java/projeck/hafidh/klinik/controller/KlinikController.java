/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;
import projeck.hafidh.klinik.dto.AntrianDto;
import projeck.hafidh.klinik.dto.AntrianRekamDto;
import projeck.hafidh.klinik.dto.DataPembayaranDto;
import projeck.hafidh.klinik.dto.DokterDto;
import projeck.hafidh.klinik.dto.KaryawanDto;
import projeck.hafidh.klinik.dto.KunjunganDto;
import projeck.hafidh.klinik.dto.LaporanDto;
import projeck.hafidh.klinik.dto.LaporanPembayaranDokterDto;
import projeck.hafidh.klinik.dto.LaporanPendapatanDto;
import projeck.hafidh.klinik.dto.LoginDto;
import projeck.hafidh.klinik.dto.PasienDto;
import projeck.hafidh.klinik.dto.PoliDto;
import projeck.hafidh.klinik.dto.RekamMedisDto;
import projeck.hafidh.klinik.model.AntrianModel;
import projeck.hafidh.klinik.model.AntrianRekamModel;
import projeck.hafidh.klinik.model.KaryawanModel;
import projeck.hafidh.klinik.model.LoginModel;
import projeck.hafidh.klinik.service.AntrianRekamService;
import projeck.hafidh.klinik.service.AntrianService;
import projeck.hafidh.klinik.service.DataPembayaranService;
import projeck.hafidh.klinik.service.DokterService;
import projeck.hafidh.klinik.service.KaryawanService;
import projeck.hafidh.klinik.service.KunjunganService;
import projeck.hafidh.klinik.service.LaporanService;
import projeck.hafidh.klinik.service.PoliService;
import projeck.hafidh.klinik.service.LoginService;
import projeck.hafidh.klinik.service.PasienService;
import projeck.hafidh.klinik.service.RekamMedisService;

/**
 *
 * @author Acer
 */
@Controller
public class KlinikController {

    @Autowired
    LoginService loginService;

    @Autowired
    DokterService dokterService;

    @Autowired
    PoliService poliService;

    @Autowired
    PasienService pasienService;

    @Autowired
    KaryawanService karyawanService;

    @Autowired
    KunjunganService kunjunganService;

    @Autowired
    RekamMedisService rekamService;

    @Autowired
    AntrianService antrianService;

    @Autowired
    AntrianRekamService antrianRekamService;

    @Autowired
    DataPembayaranService pembayaranService;

    @Autowired
    LaporanService laporanService;

    LoginModel logModel = new LoginModel();
    LoginDto dto = new LoginDto();
    HttpSession session;
    KaryawanModel karModel = new KaryawanModel();
    KaryawanDto kardto = new KaryawanDto();
    AntrianDto artdto = new AntrianDto();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String viewIndex() {
        return "index";
    }

    @RequestMapping(value = "/cobalogin", method = RequestMethod.GET)
    public String viewCobalogin() {
        return "cobalogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin() {
        return "login";
    }

    @RequestMapping(value = "/HalamanUtama", method = RequestMethod.GET)
    public String viewHalamanUtama() {
        return "HalamanUtama";
    }

    @RequestMapping(value = "/MenuAdmin", method = RequestMethod.GET)
    public String viewMenuAdmin() {
        return "MenuAdmin";
    }

    @RequestMapping(value = "/TambahDokter", method = RequestMethod.GET)
    public String viewTambahDokter() {
        return "tambahdokter";
    }

    @RequestMapping(value = "/saveDokter", method = RequestMethod.POST)
    public String saveData(DokterDto dokterDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        dokterService.saveDataDokter(dokterDto);
        return "redirect:Datadokter.htm";
    }

    @RequestMapping(value = "/savePoli", method = RequestMethod.POST)
    public String saveDataLayanan(PoliDto poliDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        poliService.saveDataPoli(poliDto);
        return "redirect:DataPoli.htm";
    }

    @RequestMapping(value = "/savePasien", method = RequestMethod.POST)
    public String saveDataPasien(PasienDto pasienDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        pasienService.saveDataPasien(pasienDto);
        return "redirect:DataPasien.htm";
    }

    @RequestMapping(value = "/saveKaryawan", method = RequestMethod.POST)
    public String saveDataKaryawan(KaryawanDto karyawanDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        karyawanService.saveDataKaryawan(karyawanDto);
        return "redirect:DataKaryawan.htm";
    }

    @RequestMapping(value = "/saveKunjungan", method = RequestMethod.POST)
    public String saveDataKunjungan(KunjunganDto kunjunganDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        //  antrianRekamService.saveDataAntrianRekam("KJ030",kunjunganDto.getKode_pasien(),kunjunganDto.getKode_poli());
        kunjunganService.saveDataKunjungan(kunjunganDto);

        return "redirect:doTambahDataKunjungan.htm";
    }

    @RequestMapping(value = "/saveKunjunganAdmin", method = RequestMethod.POST)
    public String saveDataKunjunganAdmin(KunjunganDto kunjunganDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        //  antrianRekamService.saveDataAntrianRekam("KJ030",kunjunganDto.getKode_pasien(),kunjunganDto.getKode_poli());
        kunjunganService.saveDataKunjungan(kunjunganDto);

        return "redirect:DataKunjungan.htm";
    }

    @RequestMapping(value = "/saveRekamMedis", method = RequestMethod.POST)
    public String saveDataRekamMedis(RekamMedisDto rekamDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        rekamService.saveDataRekamMedis(rekamDto);
        antrianService.deleteDataAntrian(rekamDto.getKode_kunjungan());
        return "redirect:doTambahDataRekamMedis.htm";
    }

    @RequestMapping(value = "/saveRekamMedisAdmin", method = RequestMethod.POST)
    public String saveDataRekamMedisAdmin(RekamMedisDto rekamDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        rekamService.saveDataRekamMedis(rekamDto);
        antrianService.deleteDataAntrian(rekamDto.getKode_kunjungan());
        return "redirect:DataRekamMedis.htm";
    }

    @RequestMapping(value = "/savePembayaran", method = RequestMethod.POST)
    public String saveDataPembayaran(DataPembayaranDto pembayaranDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        pembayaranService.saveDataDokter(pembayaranDto);
        return "redirect:doTambahDataPembayaran.htm";
    }

    @RequestMapping(value = "/savePembayaranAdmin", method = RequestMethod.POST)
    public String saveDataPembayaranAdmin(DataPembayaranDto pembayaranDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        pembayaranService.saveDataDokter(pembayaranDto);
        antrianRekamService.deleteDataAntrianRekam(pembayaranDto.getKode_kunjungan());
        return "redirect:DataPembayaran.htm";
    }

    @RequestMapping(value = "/Datadokter", method = RequestMethod.GET)
    public String viewDataDokter(ModelMap model) {
        try {
            List<DokterDto> listDokterDto = dokterService.getListDokter();
            model.addAttribute("listDokterDto", listDokterDto);
        } catch (Exception e) {
        }
        return "Datadokter";
    }

    @RequestMapping(value = "/DataPoli", method = RequestMethod.GET)
    public String viewDataPoli(ModelMap model) {
        try {
            List<PoliDto> listPoliDto = poliService.getListPoli();
            model.addAttribute("listPoliDto", listPoliDto);
        } catch (Exception e) {
        }
        return "DataPoli";
    }

    @RequestMapping(value = "/DataPasien", method = RequestMethod.GET)
    public String viewDataPasien(ModelMap model) {
        try {
            List<PasienDto> listPasienDto = pasienService.getListPasien();
            model.addAttribute("listPasienDto", listPasienDto);
        } catch (Exception e) {
        }
        return "DataPasien";
    }

    @RequestMapping(value = "/DataKaryawan", method = RequestMethod.GET)
    public String viewDataKaryawan(ModelMap model) {
        try {
            List<KaryawanDto> listkaryawanDto = karyawanService.getListKaryawan();
            model.addAttribute("listKaryawanDto", listkaryawanDto);
        } catch (Exception e) {
        }
        return "DataKaryawan";
    }

    @RequestMapping(value = "/DataKunjungan", method = RequestMethod.GET)
    public String viewDataKunjungan(ModelMap model) {
        try {
            List<LaporanDto> listLaporanKunjungan = laporanService.getDataLaporanKunjungan();
            model.addAttribute("listKunjunganDto", listLaporanKunjungan);
        } catch (Exception e) {
        }
        return "DataKunjungan";
    }

    @RequestMapping(value = "/DataRekamMedis", method = RequestMethod.GET)
    public String viewDataRekamMedis(ModelMap model) {
        try {
            List<RekamMedisDto> listrekamDto = rekamService.getListRekamMedis();
            model.addAttribute("listRekamMedisDto", listrekamDto);
        } catch (Exception e) {
        }
        return "DataRekamMedis";
    }

    @RequestMapping(value = "/DataPembayaran", method = RequestMethod.GET)
    public String viewDataPembayaran(ModelMap model) {
        try {
            List<DataPembayaranDto> listpembayaranDto = pembayaranService.getListPembayaran();
            model.addAttribute("listPembayaranDto", listpembayaranDto);
        } catch (Exception e) {
        }
        return "DataPembayaran";
    }

    @RequestMapping(value = "/doTambahDataDokter", method = RequestMethod.GET)
    public String doTambahDataDokter(ModelMap model) {
        DokterDto dto1 = new DokterDto();
        model.addAttribute("dokterDto", dto1);
        try {
            List<DokterDto> listDokterDto = dokterService.getListDokter();
            model.addAttribute("listDokterDto", listDokterDto);
        } catch (Exception e) {
        }
        return "tambahdokter";
    }

    @RequestMapping(value = "/doTambahDataPoli", method = RequestMethod.GET)
    public String doTambahDataPoli(ModelMap model) {
        PoliDto dto1 = new PoliDto();
        model.addAttribute("poliDto", dto1);
        try {
            List<PoliDto> listPoliDto = poliService.getListPoli();
            model.addAttribute("listPoliDto", listPoliDto);
        } catch (Exception e) {
        }
        return "TambahPoli";
    }

    @RequestMapping(value = "/doTambahDataPasien", method = RequestMethod.GET)
    public String doTambahDataPasien(ModelMap model) {
        PasienDto dto1 = new PasienDto();
        model.addAttribute("pasienDto", dto1);
        try {
            List<PasienDto> listPasienDto = pasienService.getListPasien();
            model.addAttribute("listPasienDto", listPasienDto);
        } catch (Exception e) {
        }
        return "TambahPasien";
    }

    @RequestMapping(value = "/doTambahDataKaryawan", method = RequestMethod.GET)
    public String doTambahDataKarawan(ModelMap model) throws Exception {
        KaryawanDto dto1 = karyawanService.getDataId();
        model.addAttribute("karyawanDto", dto1);
//        try {
//            KaryawanDto listKaryawanDto = karyawanService.getDataId();
//            model.addAttribute("karyawanDto", listKaryawanDto);
//        } catch (Exception e) {
//        } 
        return "TambahKaryawan";
    }

    @RequestMapping(value = "/doTambahDataKunjungan", method = RequestMethod.GET)
    public String doTambahDataKunjungan(ModelMap model) {
        KunjunganDto dto1 = new KunjunganDto();
        model.addAttribute("kunjunganDto", dto1);
        List<PoliDto> listPoli = null;
        List<DokterDto> listDokter = null;

        try {
            List<KunjunganDto> listKunjunganDto = kunjunganService.getListKunjungan();
            model.addAttribute("listKunjunganDto", listKunjunganDto);

            listPoli = poliService.getListPoli();
            model.addAttribute("listPoli", listPoli);

            listDokter = dokterService.getListDokter();
            model.addAttribute("listDokter", listDokter);
        } catch (Exception e) {
        }
        return "TambahKunjungan";
    }

    @RequestMapping(value = "/TambahKunjungan", method = RequestMethod.GET)
    public String doTambahDataKunjunganAdmin(ModelMap model) {
        KunjunganDto dto1 = new KunjunganDto();
        model.addAttribute("kunjunganDto", dto1);
        List<PoliDto> listPoli = null;
        List<DokterDto> listDokter = null;

        try {
            List<KunjunganDto> listKunjunganDto = kunjunganService.getListKunjungan();
            model.addAttribute("listKunjunganDto", listKunjunganDto);

            listPoli = poliService.getListPoli();
            model.addAttribute("listPoli", listPoli);

            listDokter = dokterService.getListDokter();
            model.addAttribute("listDokter", listDokter);
        } catch (Exception e) {
        }
        return "TambahKunjunganAdmin";
    }

    @RequestMapping(value = "/doTambahDataRekamMedis", method = RequestMethod.GET)
    public String doTambahDataRekamMedis(ModelMap model) throws Exception {
        RekamMedisDto dto1 = new RekamMedisDto();
        List<AntrianDto> listantrianDto = antrianService.getListAntrianByPoli(artdto.getKode_poli());
        model.addAttribute("listKunjungan", listantrianDto);
        model.addAttribute("rekamDto", dto1);
        try {
            List<RekamMedisDto> listRekamMedisDto = rekamService.getListRekamMedis();
            model.addAttribute("listRekamMedisDto", listRekamMedisDto);
        } catch (Exception e) {
        }
        return "TambahRekamMedis";
    }

    @RequestMapping(value = "/TambahRekamMedisAdmin", method = RequestMethod.GET)
    public String doTambahDataRekamMedisAdmin(ModelMap model) throws Exception {
        RekamMedisDto dto1 = new RekamMedisDto();
        List<AntrianDto> listantrianDto = antrianService.getListAntrian();
        model.addAttribute("listKunjungan", listantrianDto);
        model.addAttribute("rekamDto", dto1);
        try {
            List<RekamMedisDto> listRekamMedisDto = rekamService.getListRekamMedis();
            model.addAttribute("listRekamMedisDto", listRekamMedisDto);
        } catch (Exception e) {
        }
        return "TambahRekamMedisAdmin";
    }

    @RequestMapping(value = "/doTambahDataPembayaran", method = RequestMethod.GET)
    public String doTambahDataPembayaran(ModelMap model) throws Exception {
        DataPembayaranDto dto1 = new DataPembayaranDto();
        model.addAttribute("pembayaranDto", dto1);
        List<AntrianRekamDto> listantrianDto = antrianRekamService.getAntrianRekam();
        model.addAttribute("listantrian", listantrianDto);
//        try {
//            List<DataPembayaranDto> listPembayaranDto = pembayaranService.getListPembayaran();
//            model.addAttribute("listPembayaranDto", listPembayaranDto);
//        } catch (Exception e) {
//        } 
        return "TambahPembayaran";
    }

    @RequestMapping(value = "/TambahPembayaranAdmin", method = RequestMethod.GET)
    public String doTambahDataPembayaranAdmin(ModelMap model) throws Exception {
        DataPembayaranDto dto1 = new DataPembayaranDto();
        model.addAttribute("pembayaranDto", dto1);
        List<AntrianRekamDto> listantrianDto = antrianRekamService.getAntrianRekam();
        model.addAttribute("listantrian", listantrianDto);
//        try {
//            List<DataPembayaranDto> listPembayaranDto = pembayaranService.getListPembayaran();
//            model.addAttribute("listPembayaranDto", listPembayaranDto);
//        } catch (Exception e) {
//        } 
        return "TambahPembayaranAdmin";
    }

    @RequestMapping(value = "/deleteDataDokter", method = RequestMethod.GET)
    public String hapusData(String kode_dokter, ModelMap model) throws Exception {
        dokterService.deleteDataDokter(kode_dokter);
        return "redirect:Datadokter.htm";
    }

    @RequestMapping(value = "/deleteDataPoli", method = RequestMethod.GET)
    public String hapusDataPoli(String kode_poli, ModelMap model) throws Exception {
        poliService.deleteDataPoli(kode_poli);
        return "redirect:DataPoli.htm";
    }

    @RequestMapping(value = "/deleteDataPasien", method = RequestMethod.GET)
    public String hapusDataPasien(String kode_pasien, ModelMap model) throws Exception {
        pasienService.deleteDataPasien(kode_pasien);
        return "redirect:DataPasien.htm";
    }

    @RequestMapping(value = "/deleteDataKaryawan", method = RequestMethod.GET)
    public String hapusDataKaryawan(String id_Karyawan, ModelMap model) throws Exception {
        karyawanService.deleteDataKaryawan(id_Karyawan);
        return "redirect:DataKaryawan.htm";
    }

    @RequestMapping(value = "/deleteDataKunjungan", method = RequestMethod.GET)
    public String hapusDataKunjungan(String kode_kunjungan, ModelMap model) throws Exception {
        kunjunganService.deleteDataKunjungan(kode_kunjungan);
        return "redirect:DataKunjungan.htm";
    }

    @RequestMapping(value = "/deleteDataRekamMedis", method = RequestMethod.GET)
    public String hapusDataRekamMedis(String kode_rekam, ModelMap model) throws Exception {
        rekamService.deleteDataRekamMedis(kode_rekam);
        return "redirect:DataRekamMedis.htm";
    }

    @RequestMapping(value = "/deletePembayaran", method = RequestMethod.GET)
    public String hapusDataPembayaran(String kode_pembayaran, ModelMap model) throws Exception {
        pembayaranService.deleteDataPembayaran(kode_pembayaran);
        return "redirect:DataPembayaran.htm";
    }

    @RequestMapping(value = "/getDataUpdateDokter", method = RequestMethod.GET)
    public String getUpdateDataDokter(String kode_dokter, ModelMap model) throws Exception {
        DokterDto dokterDto = dokterService.getUpdateDataDokter(kode_dokter);
        model.addAttribute("dokterDto", dokterDto);
        return "UpdateDokter";
    }

    @RequestMapping(value = "/getDataUpdatePoli", method = RequestMethod.GET)
    public String getUpdateDataPoli(String kode_poli, ModelMap model) throws Exception {
        PoliDto poliDto = poliService.getUpdateDataPoli(kode_poli);
        model.addAttribute("poliDto", poliDto);
        return "UpdatePoli";
    }

    @RequestMapping(value = "/getDataUpdatePasien", method = RequestMethod.GET)
    public String getUpdateDataPasien(String kode_pasien, ModelMap model) throws Exception {
        PasienDto pasienDto = pasienService.getUpdateDataPasien(kode_pasien);
        model.addAttribute("pasienDto", pasienDto);
        return "UpdatePasien";
    }

    @RequestMapping(value = "/getDataUpdateKaryawan", method = RequestMethod.GET)
    public String getUpdateDataKaryawan(String id_Karyawan, ModelMap model) throws Exception {
        KaryawanDto karyawanDto = karyawanService.getUpdateDataKaryawan(id_Karyawan);
        model.addAttribute("karyawanDto", karyawanDto);
        List<PoliDto> listpoli = poliService.getListPoli();
        model.addAttribute("listpoli", listpoli);
        return "UpdateKaryawan";
    }

    @RequestMapping(value = "/getDataUpdateKunjungan", method = RequestMethod.GET)
    public String getUpdateDataKunjungan(String kode_kunjungan, ModelMap model) throws Exception {
        KunjunganDto kunjunganDto = kunjunganService.getUpdateDataKunjungan(kode_kunjungan);
        model.addAttribute("kunjunganDto", kunjunganDto);
        List<PoliDto> listPoli = null;
        List<DokterDto> listDokter = null;
        List<PasienDto> listPasien = null;

        try {

            listPoli = poliService.getListPoli();
            model.addAttribute("listPoli", listPoli);

            listDokter = dokterService.getListDokter();
            model.addAttribute("listDokter", listDokter);
            listPasien = pasienService.getListPasien();
            model.addAttribute("listPasien", listPasien);

        } catch (Exception e) {
        }
        return "UpdateKunjungan";
    }

    @RequestMapping(value = "/getDataUpdateRekamMedis", method = RequestMethod.GET)
    public String getUpdateDataRekamMedis(String kode_rekam, ModelMap model) throws Exception {
        RekamMedisDto rekamDto = rekamService.getUpdateDataRekamMedis(kode_rekam);
        model.addAttribute("rekamMedisDto", rekamDto);
        return "UpdateRekamMedis";
    }

    @RequestMapping(value = "getUpdatePembayaran", method = RequestMethod.GET)
    public String getUpdatePembayaran(String kode_pembayaran, ModelMap model) throws Exception {
        DataPembayaranDto pembayaranDto = pembayaranService.getUpdateDataPembayaran(kode_pembayaran);
        model.addAttribute("pembayaranDto", pembayaranDto);
        return "UpdatePembayaran";
    }

    @RequestMapping(value = "/updateDokter", method = RequestMethod.POST)
    public String editData(DokterDto dokterDto) throws Exception {
        dokterService.doUpdateDataDokter(dokterDto);
        return "redirect:Datadokter.htm";
    }

    @RequestMapping(value = "/updatePoli", method = RequestMethod.POST)
    public String editDataPoli(PoliDto poliDto) throws Exception {
        poliService.doUpdateDataPoli(poliDto);
        return "redirect:DataPoli.htm";
    }

    @RequestMapping(value = "/updatePasien", method = RequestMethod.POST)
    public String editDataPasien(PasienDto pasienDto) throws Exception {
        pasienService.doUpdateDataPasien(pasienDto);
        return "redirect:DataPasien.htm";
    }

    @RequestMapping(value = "/updateKaryawan", method = RequestMethod.POST)
    public String editDataKaryawan(KaryawanDto karyawanDto) throws Exception {
        karyawanService.doUpdateDataKaryawan(karyawanDto);
        return "redirect:DataKaryawan.htm";
    }

    @RequestMapping(value = "/updateKunjungan", method = RequestMethod.POST)
    public String editDataKunjungan(KunjunganDto kunjunganDto) throws Exception {
        kunjunganService.doUpdateDataKunjungan(kunjunganDto);
        return "redirect:DataKunjungan.htm";
    }

    @RequestMapping(value = "/updateRekamMedis", method = RequestMethod.POST)
    public String editDataRekamMedis(RekamMedisDto rekamMedisDto) throws Exception {
        rekamService.doUpdateDataRekamMedis(rekamMedisDto);
        return "redirect:DataRekamMedis.htm";
    }

    @RequestMapping(value = "/updatePembayaran", method = RequestMethod.POST)
    public String editPembayaran(DataPembayaranDto pembayaranDto) throws Exception {
        pembayaranService.doUpdateDataPembayaran(pembayaranDto);
        return "redirect:DataPembayaran.htm";
    }

    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public void doLogin(LoginDto formDto, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        String u = "login.htm";
        dto = loginService.getListDataUserLogin(formDto);
        if (dto.getListDataUser().isEmpty()) {
            u = "login.htm";
        } else {
            logModel = dto.getListDataUser().get(0);
            if (logModel.getUsername().equals(formDto.getUsername())) {
                if (logModel.getStatus().equalsIgnoreCase("admin")) {
                    u = "MenuAdmin.htm";
                } else if (logModel.getStatus().equalsIgnoreCase("user")) {
                    u = "cobalogin.htm";
                } else {
                    u = "login.htm";
                }
            }
            session = request.getSession(true);
            session.setAttribute("username", formDto.getUsername());
            session.setAttribute("status", dto.getStatus());
            session.setAttribute("pswd", dto.getPassword());
            model.addAttribute("userDto", dto);
        }
        response.sendRedirect(u);
    }

    @RequestMapping(value = "exit", method = RequestMethod.GET)
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logModel = null;
        session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.htm");
    }

    @RequestMapping(value = "/getautopoli", method = RequestMethod.GET)
    @ResponseBody
    public String getAutoPoli() throws Exception {
        List<PoliDto> listAutoPoli = poliService.getListPoli();
        return new Gson().toJson(listAutoPoli);

    }

    @RequestMapping(value = "/getautopasien", method = RequestMethod.GET)
    @ResponseBody
    public String getAutoPasien() throws Exception {
        List<PasienDto> listAutoPasien = pasienService.getListPasien();
        return new Gson().toJson(listAutoPasien);

    }

    @RequestMapping(value = "/getautodokter", method = RequestMethod.GET)
    @ResponseBody
    public String getAutoDokter() throws Exception {
        List<DokterDto> listAutoDokter = dokterService.getListDokter();
        return new Gson().toJson(listAutoDokter);

    }

    @RequestMapping(value = "/getDataMajorByKunjungan", method = RequestMethod.GET)
    @ResponseBody
    public String getDataMajorByPoli(String kdkunjungan) {
        AntrianModel kunjunganMajor = antrianService.getAntrianById(kdkunjungan);
        return new Gson().toJson(kunjunganMajor);
    }

    @RequestMapping(value = "/getDataMajorDokter", method = RequestMethod.GET)
    @ResponseBody
    public String getDataMajor(String kdkunjungan) throws Exception {
        List<AntrianRekamDto> kunjunganMajor = antrianRekamService.getAntrianById(kdkunjungan);
        return new Gson().toJson(kunjunganMajor);
    }

    @RequestMapping(value = "/LaporanKunjungan", method = RequestMethod.GET)
    public String viewLaporanKunjungan(ModelMap model) {
        try {
            List<LaporanDto> listLaporanKunjungan = laporanService.getDataLaporanKunjungan();
            model.addAttribute("listLaporanKunjungan", listLaporanKunjungan);
        } catch (Exception e) {
        }
        return "LaporanKunjungan";
    }

    @RequestMapping(value = "/getLaporanKunjungan", method = RequestMethod.GET)
    @ResponseBody
    public String getDataLaporanKunjungan() throws Exception {
        List<LaporanDto> listLaporanKunjungan = laporanService.getDataLaporanKunjungan();
        return new Gson().toJson(listLaporanKunjungan);
    }

    @RequestMapping(value = "/LaporanPendapatan", method = RequestMethod.GET)
    public String viewLaporanPendapatan(ModelMap model) {
        try {
            List<LaporanPendapatanDto> listLaporanPendapatan = laporanService.getDataLaporanPedapatan();
            model.addAttribute("listLaporanPendapatan", listLaporanPendapatan);
        } catch (Exception e) {
        }
        return "LaporanPendapatan";
    }

    @RequestMapping(value = "/getLaporanPendapatan", method = RequestMethod.GET)
    @ResponseBody
    public String getDataLaporanPendapatan() throws Exception {
        List<LaporanPendapatanDto> listLaporanPendapatan = laporanService.getDataLaporanPedapatan();
        return new Gson().toJson(listLaporanPendapatan);
    }

    @RequestMapping(value = "/LaporanPembayaranDokter", method = RequestMethod.GET)
    public String viewLaporanPembayaranDokter(ModelMap model) {
        try {
            List<LaporanPembayaranDokterDto> listLaporanPembayaranDokter = laporanService.getDataLaporanPembayaranDokter();
            model.addAttribute("listLaporanPembayaranDokter", listLaporanPembayaranDokter);
            List<DokterDto> listDokter = dokterService.getListDokter();
            model.addAttribute("listDokter", listDokter);
        } catch (Exception e) {
        }
        return "LaporanPembayaranDokter";
    }

    @RequestMapping(value = "/getLaporanPembayaranDokter", method = RequestMethod.GET)
    @ResponseBody
    public String getDataLaporanPembayaranDokter() throws Exception {
        List<LaporanPembayaranDokterDto> listLaporanPembayaranDokter = laporanService.getDataLaporanPembayaranDokter();
        return new Gson().toJson(listLaporanPembayaranDokter);
    }

    @RequestMapping(value = "LoginKaryawan", method = RequestMethod.POST)
    public void LoginKaryawan(KaryawanDto formDto, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        String u = "index.htm";
        kardto = karyawanService.getDataLogin(formDto);
        if (kardto.getListDataUser().isEmpty()) {
            u = "index.htm";
        } else {
            karModel = kardto.getListDataUser().get(0);
            if (karModel.getId_karyawan().equals(formDto.getId_karyawan())) {
                if (karModel.getStatus_bagian().equalsIgnoreCase("Admin")) {
                    u = "MenuAdmin.htm";
                } else if (karModel.getStatus_bagian().equalsIgnoreCase("Owner")) {
                    u = "HalamanUtama.htm";
                } else if (karModel.getStatus_bagian().equalsIgnoreCase("Pembayaran")) {
                    u = "doTambahDataPembayaran.htm";
                } else if (karModel.getStatus_bagian().equalsIgnoreCase("front_office")) {
                    u = "doTambahDataKunjungan.htm";
                } else if (karModel.getStatus_bagian().equalsIgnoreCase("Poli")) {
                    artdto.setKode_poli(karModel.getKode_poli());
                    u = "doTambahDataRekamMedis.htm";
                } else {
                    u = "index.htm";
                }
            }
            session = request.getSession(true);
            session.setAttribute("username", formDto.getId_karyawan());
            session.setAttribute("status", kardto.getBagian());
            session.setAttribute("pswd", kardto.getPassword());
            session.setAttribute("poli", kardto.getKode_poli());
            model.addAttribute("userDto", kardto);
        }
        response.sendRedirect(u);
    }
}
