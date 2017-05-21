package id.ac.univ.regismaba.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.univ.regismaba.service.MahasiswaService;

@Controller
public class MahasiswaController {
	
    @Autowired
    MahasiswaService mahasiswaDAO;
	
	/**
	*	1 : Mahasiswa
	*	2 : Verifikator
	*	3 : Staf Registrasi
	*	4 : Staf Kesejahteraan M
	*	5 : Staf Kesehatan Mahas
	*	6 : Manajer Pendidikan
	*
	*/
	@RequestMapping("/")
	public String index(Model model,
		@RequestParam(value = "error", required = false) String error) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		if (authorities.contains(new SimpleGrantedAuthority("1"))){
			return "redirect:/calon-mahasiswa/";
		} else if(authorities.contains(new SimpleGrantedAuthority("2"))) {
			return "redirect:/staf-verifikasi/";
		} else if(authorities.contains(new SimpleGrantedAuthority("3"))) {
			return "redirect:/staf-registrasi/";
		} else if(authorities.contains(new SimpleGrantedAuthority("4"))) {
			return "redirect:/staf-kesejahteraan/";
		} else if(authorities.contains(new SimpleGrantedAuthority("5"))) {
			return "redirect:/staf-kesehatan/";
		} else if(authorities.contains(new SimpleGrantedAuthority("6"))) {
			return "redirect:/manager-pendidikan/";
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
