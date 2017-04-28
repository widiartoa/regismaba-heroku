package id.ac.univ.regismaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JenjangModel;
import id.ac.univ.regismaba.model.ProgramModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;
import id.ac.univ.regismaba.model.StatistikManagerModel;
import id.ac.univ.regismaba.service.StatistikManagerService;

@Controller
public class StatistikManagerController {

	@Autowired
	StatistikManagerService sms;
	
	@RequestMapping("/manager-pendidikan/statistik-manager")
	public String statistikManager(Model model)
	{
		List<FakultasModel> f = sms.getFaculties();
		List<ProgramStudiModel> m = sms.getMajors();
		List<JenjangModel> l = sms.getLevels();
		List<ProgramModel> p = sms.getPrograms();
		
		ArrayList<StatistikManagerModel> faculties = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerModel> majors = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerModel> levels = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerModel> programs = new ArrayList<StatistikManagerModel>();
		
		for(int i=0; i < f.size(); i++)
		{
			StatistikManagerModel faculty = sms.selectPemilihFakultas(f.get(i).getFakultas_id());
			faculties.add(faculty);
		}
		
		for(int i=0; i < m.size(); i++)
		{
			StatistikManagerModel major = sms.selectPemilihProdi(m.get(i).getProgram_studi_id());
			majors.add(major);
		}
		
		for(int i=0; i < l.size(); i++)
		{
			StatistikManagerModel level = sms.selectJenjang(l.get(i).getJenjang_id());
			levels.add(level);
		}
		
		for(int i=0; i < p.size(); i++)
		{
			StatistikManagerModel program= sms.selectProgram(p.get(i).getProgram_id());
			programs.add(program);
		}
		
		model.addAttribute("faculties", faculties);
		model.addAttribute("majors", majors);
		model.addAttribute("levels", levels);
		model.addAttribute("programs", programs);
		
		return "manager_pendidikan-statistik_manager";
	}
	
}
