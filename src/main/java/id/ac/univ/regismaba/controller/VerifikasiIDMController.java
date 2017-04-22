package id.ac.univ.regismaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.service.BiodataService;
import id.ac.univ.regismaba.service.MahasiswaService;

@Controller
public class VerifikasiIDMController
{   
    @Autowired
    MahasiswaService mahasiswaService;
    
    @RequestMapping("/staf_verifikasi/detailIDM/{username}")
    public String detailIDM(Model model,
            @PathVariable(value = "username") String username) {
        MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername (username);
     
        if(mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
            model.addAttribute ("biodata", mahasiswa.getBiodata ());
            return "staf_verifikasi-detail_idm_mhs";
        } else {
            return "not-registered";
        }
    }
}