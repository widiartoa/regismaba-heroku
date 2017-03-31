package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

@Controller
public class MahasiswaController {
	
    @Autowired
    MahasiswaService mahasiswaDAO;
	
	@RequestMapping("/")
	public String index(Model model,
		@RequestParam(value = "error", required = false) String error) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		if (authorities.contains(new SimpleGrantedAuthority("1"))){
			return "redirect:/calon-mahasiswa/idm";
		} else {
			model.addAttribute("error", error != null);
			return "index";
		}
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}
}
