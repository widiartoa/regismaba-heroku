package id.ac.univ.regismaba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.service.RekapitulasiJaketService;

@Controller
public class RekapitulasiJaketController {

	@Autowired
	RekapitulasiJaketService rjs;
	
	@RequestMapping("/staf-registrasi/rekapitulasi-jaket")
	public String rekapJaket(Model model)
	{
		List<String> sizes = rjs.getSizes();
		List<String> faculties = rjs.getFaculties();
		
		//List<RekapitulasiJaketModel> jacketAnalytics = rjs.selectRekap("");
		return "staf_registrasi-rekapitulasi_jaket";
	}
	
}
