package id.ac.univ.regismaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MahasiswaController {

	@RequestMapping("/")
	public String loginMahasiswa()
	{
		return "index";
	}
}
