package id.ac.univ.regismaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.CrossRekapJaketModel;
import id.ac.univ.regismaba.model.FakultasModel;
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
		List<FakultasModel> faculties = rjs.getFaculties();
		
		List<RekapitulasiJaketModel> sizeAnalytics = new ArrayList<RekapitulasiJaketModel>();
		List<RekapitulasiJaketModel> facultyAnalytics = new ArrayList<RekapitulasiJaketModel>();
		List<CrossRekapJaketModel> crossAnalytics = new ArrayList<CrossRekapJaketModel>();
		
		for(int i = 0; i < sizes.size(); i++)
		{
			RekapitulasiJaketModel size = rjs.selectRekapUkuran(sizes.get(i));
			if(size!=null) { sizeAnalytics.add(size); }
		}
		
		for(int i = 0; i < faculties.size(); i++)
		{
			RekapitulasiJaketModel faculty = rjs.selectRekapFakultas(faculties.get(i).getFakultas_id());
			
			if(faculty.getJumlah()!=0) { 
				facultyAnalytics.add(faculty);
				
//				ArrayList<RekapitulasiJaketModel> faculti = rjs.selectUkuranOfFakultas(faculties.get(i).getFakultas_id());
//				
//				CrossRekapJaketModel crjm = new CrossRekapJaketModel();
//				crjm.setFakultas_id(faculties.get(i).getFakultas_id());
//				crjm.setNama_fakultas(faculties.get(i).getNama_fakultas());
//				crjm.setRjm(faculti);
//				crossAnalytics.add(crjm);
				
				
			}
			
			CrossRekapJaketModel crjm = rjs.selectUkuranOfFakultas2(faculties.get(i).getFakultas_id());
			if( crjm.getUkuran_s() > 0 ||
				crjm.getUkuran_m() > 0 ||
				crjm.getUkuran_l() > 0 || 
				crjm.getUkuran_xl() > 0 ||
				crjm.getUkuran_xxl() > 0) { crossAnalytics.add(crjm); }
		}
		
		model.addAttribute("sizeAnalytics", sizeAnalytics);
		model.addAttribute("facultyAnalytics", facultyAnalytics);
		model.addAttribute("crossAnalytics", crossAnalytics);
		
		System.out.println(crossAnalytics);
		
		return "staf_registrasi-rekapitulasi_jaket";
	}
}