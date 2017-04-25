package id.ac.univ.regismaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.service.BiodataService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.VerifikasiIDMService;

@Controller
public class VerifikasiIDMController
{
    private BiodataModel biodata = new BiodataModel ();
    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    BiodataService biodataService;

    @Autowired
    VerifikasiIDMService verifikasiIdmService;


    @RequestMapping("/staf-verifikasi/detailIDM/{npm}")
    public String detailIDM (Model model,
            @PathVariable(value = "npm") String npm)
    {
        MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswa (npm);

        if (mahasiswa != null) {
            String status_verifikasi = verifikasiIdmService.selectStatusVerifikasi (mahasiswa.getUsername ());
            model.addAttribute ("mahasiswa", mahasiswa);
            if (status_verifikasi.equals ("Unverified")) {
                String komentarAdded = verifikasiIdmService.selectKomentar (mahasiswa.getUsername ());
                model.addAttribute ("komentarAdded", komentarAdded);
                return "staf_verifikasi-detail_idm_mhs_unverified";
            } else if (status_verifikasi.equals ("Verified")) {
                return "staf_verifikasi-detail_idm_mhs_verified";
            } else {
                return "staf_verifikasi-detail_idm_mhs";
            }
        } else {
            return "error";
        }
    }


    @RequestMapping("/staf-verifikasi/detailIDM/verified/{npm}")
    public String VerifiedDetailIDM (Model model,
            @PathVariable(value = "npm") String npm)
    {
        // status = "Verified";
        MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswa (npm);
        verifikasiIdmService.updateStatusVerify (mahasiswa.getUsername ());
        if (mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
            return "staf_verifikasi-detail_idm_mhs_verified";
        } else {
            return "not-registered";
        }
    }


    @RequestMapping("/staf-verifikasi/detailIDM/unverified/{npm}")
    public String unverifyDetailIDM (Model model,
            @PathVariable(value = "npm") String npm,
            @RequestParam("komentar") String komentar)
    {
        MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswa (npm);
        verifikasiIdmService.updateComment (mahasiswa.getUsername (), komentar);
        verifikasiIdmService.updateStatusUnverify (mahasiswa.getUsername ());
        String komentarAdded = verifikasiIdmService.selectKomentar (mahasiswa.getUsername ());
        if (mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
            model.addAttribute ("komentarAdded", komentarAdded);
            return "staf_verifikasi-detail_idm_mhs_unverified";
        } else {
            return "not-registered";
        }
    }

    // @RequestMapping("/staf_verifikasi/detailIDM/{username}")
    // public String detailIDM(Model model,
    // @PathVariable(value = "username") String username) {
    // MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername
    // (username);
    // BiodataModel biodata = biodataService.selectBiodata (mahasiswa.getBiodata
    // ().getBiodata_id ());
    //
    // if(mahasiswa != null) {
    // model.addAttribute ("mahasiswa", mahasiswa);
    // model.addAttribute ("biodata", biodata);
    // return "staf_verifikasi-detail_idm_mhs";
    // } else {
    // return "not-registered";
    // }
    // }
}