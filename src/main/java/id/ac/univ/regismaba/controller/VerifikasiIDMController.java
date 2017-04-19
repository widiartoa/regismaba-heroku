package id.ac.univ.regismaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private BiodataModel biodata = new BiodataModel();
    @Autowired
    MahasiswaService mahasiswaService;
    
    @Autowired
    BiodataService biodataService;
    
    @Autowired
    VerifikasiIDMService verifikasiIdmService;
    
    @RequestMapping("/staf_verifikasi/detailIDM/")
    public String detailIDM(Model model) {
        MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername ("benathavia.saladdin");
//        BiodataModel biodata = biodataService.selectBiodata (mahasiswa.getBiodata ().getBiodata_id ());
       
        if(mahasiswa != null) {
// if(biodata.get status verif == not yet) masuk sini
//            String status_verifikasi = verifikasiIdmService
            model.addAttribute ("mahasiswa", mahasiswa);
//            model.addAttribute ("biodata", biodata);
            return "staf_verifikasi-detail_idm_mhs";
// else if(biodata.get status verif == unverified) masuk ke halaman yg merah2
// else ya masuk ke halaman yg ijo
        } else {
            return "not-registered";
        }
    }
    
    @RequestMapping("/staf_verifikasi/detailIDM/verified")
    public String VerifiedDetailIDM(Model model) {
//        status = "Verified";
        MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername ("benathavia.saladdin");
        verifikasiIdmService.updateStatus (mahasiswa.getUsername ());
        if(mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
            return "staf_verifikasi-detail_idm_mhs_verified";
        } else {
            return "not-registered";
        }
    }
    
//    @RequestMapping("/staf_verifikasi/detailIDM/{username}")
//    public String detailIDM(Model model,
//            @PathVariable(value = "username") String username) {
//        MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername (username);
//        BiodataModel biodata = biodataService.selectBiodata (mahasiswa.getBiodata ().getBiodata_id ());
//       
//        if(mahasiswa != null) {
//            model.addAttribute ("mahasiswa", mahasiswa);
//            model.addAttribute ("biodata", biodata);
//            return "staf_verifikasi-detail_idm_mhs";
//        } else {
//            return "not-registered";
//        }
//    }
}