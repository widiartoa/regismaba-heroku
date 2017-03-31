package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;
import id.ac.univ.regismaba.service.SkemaBiayaService;
import id.ac.univ.regismaba.storage.StorageFileNotFoundException;
import id.ac.univ.regismaba.storage.StorageService;

@Controller
public class DataKesehatanController {
	private final StorageService storageService;
	
	@Autowired
	public DataKesehatanController(StorageService storageService){
		this.storageService = storageService;
	}
	
    @Autowired
    MahasiswaService mahasiswaDAO;
	
    //@Autowired
    //DataKesehatanService dataKesehatanDAO;
	
	@RequestMapping("/calon-mahasiswa/riwayat-kesehatan")
	public String surveyKesehatan(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		// todo : jangan di hardcode plz
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa("1234567890");
		//DataKesehatanModel dataKesehatan = dataKesehatanDAO.selectDataKesehatan("1");
		DataKesehatanModel dataKesehatan = null;
		
		if(dataKesehatan != null) {
			model.addAttribute("form_survey_kesehatan_error", dataKesehatan.form_survey_kesehatan == null);
			model.addAttribute("hasil_tes_kesehatan_error", dataKesehatan.hasil_tes_kesehatan == null);	
			model.addAttribute("form_survey_kesehatan", dataKesehatan.form_survey_kesehatan);
			model.addAttribute("hasil_tes_kesehatan", dataKesehatan.hasil_tes_kesehatan);
		} else {
			model.addAttribute("form_survey_kesehatan_error", true);
			model.addAttribute("hasil_tes_kesehatan_error", true);	
		}
		
		return "calon_mahasiswa-survey_kesehatan";	
	}
	
	@RequestMapping("/calon-mahasiswa/survey-kesehatan/submit")
	public String submitSurveyKesehatan(Model model, 
		@RequestParam(value = "form_survey_kesehatan", required = false) MultipartFile form_survey_kesehatan
	)	{
		
		// todo : jangan di hardcode plz
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa("1234567890");
		
		//storageService.store(form_survey_kesehatan, mahasiswa.npm);
		
		return "calon_mahasiswa-survey_kesehatan";
	}
}
