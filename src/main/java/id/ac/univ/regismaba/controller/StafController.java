package id.ac.univ.regismaba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.univ.regismaba.model.AlamatModel;
import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.model.IjazahModel;
import id.ac.univ.regismaba.model.InstitusiModel;
import id.ac.univ.regismaba.model.KotaKabupatenModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.model.ProvinsiModel;
import id.ac.univ.regismaba.model.RumpunModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.service.AlamatService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;
import id.ac.univ.regismaba.service.RumpunService;
import id.ac.univ.regismaba.service.SkemaBiayaService;
import id.ac.univ.regismaba.service.VerifikasiIDMService;

@Controller
public class StafController
{

    @Autowired
    MahasiswaService mahasiswaDAO;

    @Autowired
    PengajuanSkemaBiayaService pengajuanSkemaBiayaDAO;

    @Autowired
    SkemaBiayaService sbs;

    @Autowired
    RumpunService rm;

    @Autowired
    VerifikasiIDMService verifikasiIdmDAO;
    
    @Autowired
    AlamatService alamatDAO;


    // TODO: Tambahkan @RequestMapping("/") setelah bisa ambil session
    // untuk Verifikator redirect:/staf_verifikasi/daftar_mhs
    // untuk Staf Registrasi redirect:/staf_registrasi/daftar_mhs
    // untuk Staf Kesehatan redirect:/staf_kesehatan/daftar_mhs
    // untuk Staf Kesejahteraan redirect:/staf_kesejahteraan/daftar_mhs

    @RequestMapping("/staf-verifikasi/daftar-mhs")
    public String daftarMhsVerifikator (Model model)
    {
        List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa ();
        model.addAttribute ("mahasiswas", mahasiswas);
        List<BiodataModel> biodatas = verifikasiIdmDAO.selectAllBiodata ();
        model.addAttribute ("biodatas", biodatas);
        List<AlamatModel> alamats = verifikasiIdmDAO.selectAllAlamat ();
        model.addAttribute ("alamats", alamats);
        List<KotaKabupatenModel> kotakabs = verifikasiIdmDAO.selectAllKotaKab ();
        model.addAttribute ("kotakabs", kotakabs);
        List<ProvinsiModel> provinsis = verifikasiIdmDAO.selectAllProvinsi ();
        model.addAttribute ("provinsis", provinsis);
        List<IjazahModel> ijazahs = verifikasiIdmDAO.selectAllIjazah ();
        model.addAttribute ("ijazahs", ijazahs);
        List<InstitusiModel> institusis = verifikasiIdmDAO.selectAllInstitusi ();
        model.addAttribute ("institusis", institusis);
        List<DataKesehatanModel> dataKess = verifikasiIdmDAO.selectAllDataKesehatan ();
        model.addAttribute ("dataKess", dataKess);
        return "staf_verifikasi-daftar_mhs";
    }


    @RequestMapping("/staf-registrasi/daftar-mhs")
    public String daftarMhsRegistrasi (Model model)
    {
        List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa ();
        model.addAttribute ("mahasiswas", mahasiswas);
        return "staf_registrasi-daftar_mhs";
    }


    @RequestMapping("/staf-kesehatan/daftar-mhs")
    public String daftarMhsKesehatan (Model model)
    {
        List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa ();
        model.addAttribute ("mahasiswas", mahasiswas);
        return "staf_kesehatan-daftar_mhs";
    }


    @RequestMapping("/staf-kesejahteraan/daftar-mhs")
    public String daftarMhsKesejahteraan (Model model)
    {
        List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa ();
        model.addAttribute ("mahasiswas", mahasiswas);
        List<PengajuanSkemaBiayaModel> pengajuans = pengajuanSkemaBiayaDAO
                .selectAllPSBM ();
        model.addAttribute ("pengajuans", pengajuans);
        if (mahasiswas.size () > 0) {
            RumpunModel[] rumpuns = new RumpunModel[pengajuans.size ()];
            for (int i = 0; i < rumpuns.length; i++) {
                rumpuns[i] = rm.getRumpun (pengajuans.get (i).getUsername ());
            }
            model.addAttribute ("rumpuns", rumpuns);
        }
        if (pengajuans.size () > 0) {
            SkemaBiayaModel[] skemas = new SkemaBiayaModel[pengajuans.size ()];
            for (int i = 0; i < skemas.length; i++) {
                skemas[i] = sbs
                        .selectSBM (pengajuans.get (i).getGolongan_id ());
            }
            model.addAttribute ("skemas", skemas);
        }

        List<SkemaBiayaModel> skemaList = sbs.selectAllSBM ();
        model.addAttribute ("skemaList", skemaList);

        return "staf_kesejahteraan-daftar_mhs";
    }

    
    @PostMapping("/staf-kesejahteraan/daftar-mhs/{npm}")
    public String daftarMhsKesejahteraanSubmitVerifikasiPembayaran (Model model,
            @PathVariable(value = "npm") String npm,
            @RequestParam(value = "status-pengajuan", required = true) String status_pengajuan,
            @RequestParam(value = "ubah-golongan", required = true) int golongan_id,
            @RequestParam(value = "komentar", required = true) String komentar)
    {
        MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
 		PengajuanSkemaBiayaModel psbm = pengajuanSkemaBiayaDAO.selectPSBMFromUsername(mahasiswa.getUsername());
 		if(psbm != null) {			
 			psbm.setGolongan_id(golongan_id);
 			psbm.setStatus_pengajuan(status_pengajuan);
 			psbm.setKomentar(komentar);
 			psbm.setUpdated_by(mahasiswa.getUsername()); // ntar update ke staff
 			pengajuanSkemaBiayaDAO.updatePengajuan(psbm);	
 			return "redirect:/staf-kesejahteraan/daftar-mhs";
		} else {
 			return "error";
 		}
    }
    
    @RequestMapping("/staf-verifikasi/daftar-mhs/verified/{npm}")
    public String VerifyIDMModal (Model model,
            @PathVariable(value = "npm") String npm)
    {
        // status = "Verified";
        MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa (npm);
        verifikasiIdmDAO.updateStatusVerify (mahasiswa.getUsername ());
        model.addAttribute ("mahasiswa", mahasiswa);
        return "redirect:/staf-verifikasi/daftar-mhs";
    }
    
    @PostMapping("/staf-verifikasi/daftar-mhs/unverified/{npm}")
    public String unverifyDetailIDM (Model model,
            @PathVariable(value = "npm") String npm,
            @RequestParam(value = "komentar", required = true) String komentar)
    {
        MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa (npm);
        verifikasiIdmDAO.updateComment (mahasiswa.getUsername (), komentar);
        verifikasiIdmDAO.updateStatusUnverify (mahasiswa.getUsername ());
        String komentarAdded = verifikasiIdmDAO.selectKomentar (mahasiswa.getUsername ());
        model.addAttribute ("mahasiswa", mahasiswa);
        model.addAttribute ("komentarAdded", komentarAdded);
        return "redirect:/staf-verifikasi/daftar-mhs";
    }
}
