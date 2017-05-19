package id.ac.univ.regismaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JalurModel;
import id.ac.univ.regismaba.model.JenjangModel;
import id.ac.univ.regismaba.model.ProgramModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;
import id.ac.univ.regismaba.model.StatistikManagerModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;
import id.ac.univ.regismaba.service.StatistikManagerService;

@Controller
public class StatistikManagerController {

	@Autowired
	StatistikManagerService sms;
	
	@RequestMapping("/manager-pendidikan/statistik-manager/fakultas")
	public String statistikManagerFakultas(Model model)
	{
		List<FakultasModel> f = sms.getFaculties();
		ArrayList<StatistikManagerModel> faculties = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerModel> regFaculties = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerSummaryModel> sumFaculties = new ArrayList<StatistikManagerSummaryModel>();
		
		for(int i=0; i < f.size(); i++)
		{
			StatistikManagerModel faculty = sms.selectPemilihFakultas(f.get(i).getFakultas_id());
			if(faculty != null) { faculties.add(faculty); }
			
			StatistikManagerModel faculty2 = sms.selectRegistranFakultas(f.get(i).getFakultas_id());
			if(faculty2 != null) { regFaculties.add(faculty2); }
			
			StatistikManagerSummaryModel faculty3 = sms.summaryFaculty(f.get(i).getFakultas_id());
			if(faculty3 != null) { sumFaculties.add(faculty3); }
		}
		
		model.addAttribute("faculties", faculties);
		model.addAttribute("regFaculties", regFaculties);
		model.addAttribute("sumFaculties", sumFaculties);
		
		return "manager_pendidikan-statistik_manager";
	}
	
	@RequestMapping("/manager-pendidikan/statistik-manager/prodi")
	public String statistikManagerProdi(Model model)
	{
		List<ProgramStudiModel> m = sms.getMajors();
		ArrayList<StatistikManagerModel> majors = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerModel> regMajors = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerSummaryModel> sumMajors = new ArrayList<StatistikManagerSummaryModel>();
		
		for(int i=0; i < m.size(); i++)
		{
			StatistikManagerModel major = sms.selectPemilihProdi(m.get(i).getProgram_studi_id());
			if(major != null) { majors.add(major); }
			
			StatistikManagerModel major2 = sms.selectRegistranProdi(m.get(i).getProgram_studi_id());
			if(major2 != null) { regMajors.add(major2); }
			
			StatistikManagerSummaryModel major3 = sms.summaryMajor(m.get(i).getProgram_studi_id());
			if(major3 != null) { sumMajors.add(major3); }
		}
		
		model.addAttribute("majors", majors);
		model.addAttribute("regMajors", regMajors);
		model.addAttribute("sumMajors", sumMajors);
		
		return "manager_pendidikan-statistik_manager_prodi";
	}
	
	@RequestMapping("/manager-pendidikan/statistik-manager/jenjang")
	public String statistikManagerJenjang(Model model)
	{

		List<JenjangModel> l = sms.getLevels();
		ArrayList<StatistikManagerModel> levels = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerModel> regLevels = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerSummaryModel> sumLevels = new ArrayList<StatistikManagerSummaryModel>();
		
		for(int i=0; i < l.size(); i++)
		{
			StatistikManagerModel level = sms.selectJenjang(l.get(i).getJenjang_id());
			if(level != null) { levels.add(level); }
			
			StatistikManagerModel level2 = sms.selectRegistranJenjang(l.get(i).getJenjang_id());
			if(level2 != null) { regLevels.add(level2); }
			
			StatistikManagerSummaryModel level3 = sms.summaryLevel(l.get(i).getJenjang_id());
			if(level3 != null) { sumLevels.add(level3); }
		}

		model.addAttribute("levels", levels);
		model.addAttribute("regLevels", regLevels);
		model.addAttribute("sumLevels", sumLevels);
		
		return "manager_pendidikan-statistik_manager_jenjang";
	}
	
	@RequestMapping("/manager-pendidikan/statistik-manager/program")
	public String statistikManagerProgram(Model model)
	{
		List<ProgramModel> p = sms.getPrograms();
		ArrayList<StatistikManagerModel> programs = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerModel> regPrograms = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerSummaryModel> sumPrograms = new ArrayList<StatistikManagerSummaryModel>();

		for(int i=0; i < p.size(); i++)
		{
			StatistikManagerModel program = sms.selectProgram(p.get(i).getProgram_id());
			if(program != null) { programs.add(program); }
			
			StatistikManagerModel program2 = sms.selectRegistranProgram(p.get(i).getProgram_id());
			if(program2 != null) { regPrograms.add(program2); }
			
			StatistikManagerSummaryModel program3 = sms.summaryProgram(p.get(i).getProgram_id());
			if(program3 != null) { sumPrograms.add(program3); }
		}

		model.addAttribute("programs", programs);
		model.addAttribute("regPrograms", regPrograms);
		model.addAttribute("sumPrograms", sumPrograms);
		
		return "manager_pendidikan-statistik_manager_program";
	}
	
	@RequestMapping("/manager-pendidikan/statistik-manager/jalur")
	public String statistikManagerJalur(Model model)
	{
		List<JalurModel> j = sms.getPaths();
		ArrayList<StatistikManagerModel> paths = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerModel> regPaths = new ArrayList<StatistikManagerModel>();
		ArrayList<StatistikManagerSummaryModel> sumPaths = new ArrayList<StatistikManagerSummaryModel>();
		
		for(int i=0; i < j.size(); i++)
		{
			StatistikManagerModel jalur = sms.selectJalur(j.get(i).getJalur_id());
			if(jalur != null) { paths.add(jalur); }
			
			StatistikManagerModel jalur2 = sms.selectRegistranJalur(j.get(i).getJalur_id());
			if(jalur2 != null) { regPaths.add(jalur2); }
			
			StatistikManagerSummaryModel jalur3 = sms.summaryPath(j.get(i).getJalur_id());
			if(jalur3 != null) { sumPaths.add(jalur3); }
		}
		
		model.addAttribute("paths", paths);
		model.addAttribute("regPaths", regPaths);
		model.addAttribute("sumPaths", sumPaths);
		
		return "manager_pendidikan-statistik_manager_jalur";
	}
}
