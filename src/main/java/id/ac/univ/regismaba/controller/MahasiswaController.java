package id.ac.univ.regismaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.service.MahasiswaService;

@Controller
public class MahasiswaController {

    @Autowired
    MahasiswaService mahasiswaDAO;
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/calon-mahasiswa/login-submit")
	public String loginMahasiswa(Model model, 
		@RequestParam(value = "username", required = true) String username,
		@RequestParam(value = "password", required = true) String password
	)	{
		MahasiswaModel mahasiswa = mahasiswaDAO.loginMahasiswa (username, password);

        if (mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
			return "calon_mahasiswa-mengisi_idm";
        } else {
			model.addAttribute ("error", true);
            return "index";
        }
	}
	
	@RequestMapping("/idm/fill")
	public String idmMahasiswa()
	{
		return "calon_mahasiswa-mengisi_idm";
	}
	
	@RequestMapping("/calon-mahasiswa/skema-pembayaran")
	public String skemaMahasiswa()
	{
		return "calon_mahasiswa-melihat_skema_pembayaran";
	}
	
	@RequestMapping("/calon-mahasiswa/pengajuan-skema")
	public String pengajuanSkemaMahasiswa()
	{
		return "calon_mahasiswa-pengajuan_skema_pembayaran";
	}
	
	@RequestMapping("/calon-mahasiswa/survey-kesehatan")
	public String surveyKesehatan()
	{
		
		return "calon_mahasiswa-survey_kesehatan";
	}
	
	/*@RequestMapping("/calon-mahasiswa/survey-kesehatan/submit")
	public String submitSurveyKesehatan(Model model, 
		@RequestParam(value = "form_survey_kesehatan", required = false) String username
	)	{
		
		return "calon_mahasiswa-survey_kesehatan";
	}*/
}
