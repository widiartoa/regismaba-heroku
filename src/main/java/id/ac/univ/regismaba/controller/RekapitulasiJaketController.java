package id.ac.univ.regismaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
//		List<RekapitulasiJaketModel> sizeAnalytics = new ArrayList<RekapitulasiJaketModel>();
//		List<RekapitulasiJaketModel> facultyAnalytics = new ArrayList<RekapitulasiJaketModel>();
		ArrayList<ArrayList<RekapitulasiJaketModel>> crossAnalytics = new ArrayList<ArrayList<RekapitulasiJaketModel>>();
		
		List<String> modelSizeTypes = new ArrayList<String>();
		List<Integer> modelSizeTotal = new ArrayList<Integer>();
		
		List<String> modelJacketTypes = new ArrayList<String>();
		List<Integer> modelJacketTotal = new ArrayList<Integer>();
		
		for(int i = 0; i < sizes.size(); i++)
		{
			RekapitulasiJaketModel size = rjs.selectRekapUkuran(sizes.get(i));
//			sizeAnalytics.add(size);
			modelSizeTypes.add(size.getJenis_rekap());
			modelSizeTotal.add(size.getJumlah());
		}
		
		for(int i = 0; i < faculties.size(); i++)
		{
			RekapitulasiJaketModel faculty = rjs.selectRekapFakultas(faculties.get(i).getFakultas_id());
			ArrayList<RekapitulasiJaketModel> faculti = rjs.selectUkuranOfFakultas(faculties.get(i).getFakultas_id());
//			facultyAnalytics.add(faculty);
			
			modelJacketTypes.add(faculty.getJenis_rekap());
			modelJacketTotal.add(faculty.getJumlah());
			crossAnalytics.add(faculti);
		}
		
//		model.addAttribute("sizeAnalytics", sizeAnalytics);
//		model.addAttribute("facultyAnalytics", facultyAnalytics);
		model.addAttribute("crossAnalytics", crossAnalytics);
		
		model.addAttribute("mstypes", modelSizeTypes);
		model.addAttribute("mstotal", modelSizeTotal);
		model.addAttribute("mjtypes", modelJacketTypes);
		model.addAttribute("mjtotal", modelJacketTotal);
		
		return "staf_registrasi-rekapitulasi_jaket";
	}
}
