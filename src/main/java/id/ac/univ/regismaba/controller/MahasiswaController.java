package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Collection;

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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
public class MahasiswaController {
	private final StorageService storageService;
	
	@Autowired
	public MahasiswaController(StorageService storageService){
		this.storageService = storageService;
	}
	
    @Autowired
    MahasiswaService mahasiswaDAO;
	
	@RequestMapping("/")
	public String index()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		if (authorities.contains(new SimpleGrantedAuthority("1"))){
			return "calon_mahasiswa-mengisi_idm";
		} else {
			return "index";
		}
	}
	
	@RequestMapping("/calon-mahasiswa/login/submit")
	public String loginMahasiswa(Model model)	
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		//MahasiswaModel mahasiswa = mahasiswaDAO.loginMahasiswa (username, password);

        if (authorities.contains(new SimpleGrantedAuthority("1"))) {
            //model.addAttribute ("mahasiswa", mahasiswa);
			// todo : cek mahasiswa udah ngisi idm apa belom, kalo belom ke mengisi idm kalo udah view idm
			return "calon_mahasiswa-mengisi_idm";
        } else {
			model.addAttribute ("error", true);
            return "index";
        }
	}
	
	@RequestMapping("/calon-mahasiswa/idm")
	public String idmMahasiswa()
	{		
		// todo : kalo belom isi idm ke fill idm, udah ke view idm
		return "calon_mahasiswa-mengisi_idm";
	}
}
