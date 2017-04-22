package id.ac.univ.regismaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.RekapitulasiJaketModel;
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
		
		List<RekapitulasiJaketModel> sizeAnalytics = new ArrayList<RekapitulasiJaketModel>();
		List<RekapitulasiJaketModel> facultyAnalytics = new ArrayList<RekapitulasiJaketModel>();
		
		for(int i = 0; i < sizes.size(); i++)
		{
			RekapitulasiJaketModel size = rjs.selectRekapUkuran(sizes.get(i));
			sizeAnalytics.add(size);
		}
		
		for(int i = 0; i < faculties.size(); i++)
		{
			RekapitulasiJaketModel faculty = rjs.selectRekapFakultas(sizes.get(i));
			facultyAnalytics.add(faculty);
		}
		
		model.addAttribute("sizeAnalytics", sizeAnalytics);
		model.addAttribute("facultyAnalytics", facultyAnalytics);
		
		return "staf_registrasi-rekapitulasi_jaket";
	}
	
}
