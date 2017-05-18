package id.ac.univ.regismaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.RoleModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;
import id.ac.univ.regismaba.model.TingkatRoleModel;
import id.ac.univ.regismaba.model.UserModel;
import id.ac.univ.regismaba.service.RoleService;
import id.ac.univ.regismaba.service.SkemaBiayaService;
import id.ac.univ.regismaba.service.TingkatRoleService;
import id.ac.univ.regismaba.service.UserService;

@Controller
public class SkemaBiayaController {

	@Autowired
	SkemaBiayaService sbs;
	
	@Autowired
	TingkatRoleService trs;
	
	@Autowired
	UserService us;
	
	@Autowired
	RoleService rs;
	
	@RequestMapping("/staf-kesejahteraan/skema-pembayaran/daftar")
	public String viewAllRincianSkemaPembayaran(Model model)
	{
		String username = "irsyadillah.nuralifa";
		UserModel user =  us.selectUser(username);
		RoleModel role = rs.selectRole(user.getId_role());
		
		if(role.getTingkat_role_id() == 1){
			List<SkemaBiayaModel> schemas = sbs.selectAllSBM();
			
			model.addAttribute("schemas", schemas);
		}
		else{
			List<SkemaBiayaModel> schemas = sbs.selectAllSBMByFacultyLevel();
			
			model.addAttribute("schemas", schemas);
		}
		
		return "staf_kesejahteraan-daftar_rincian_skema";
	}
	
	@RequestMapping("/staf-kesejahteraan/skema-pembayaran/insert")
	public String insertRincianSkemaPembayaran(Model model)
	{
		List<TingkatRoleModel> roles = trs.selectAllTRM();
		
		model.addAttribute("roles", roles);
		
		return "staf_kesejahteraan-insert_rincian_skema";
	}
	
	@RequestMapping("/staf-kesejahteraan/skema-pembayaran/insert-submit")
	public String submitNewRincianSkemaPembayaran(Model model, @ModelAttribute SkemaBiayaModel sbm)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		sbm.setCreated_by(user);
		
		sbs.insertSBM(sbm);
		
		List<SkemaBiayaModel> schemas = sbs.selectAllSBM();
		
		model.addAttribute("schemas", schemas);
		
		return "staf_kesejahteraan-daftar_rincian_skema";
	}
	
	@RequestMapping("/staf-kesejahteraan/skema-pembayaran/update/{id}")
	public String updateRincianSkemaPembayaran(Model model, @PathVariable(value = "id") int golongan_id)
	{	
		SkemaBiayaModel schema = sbs.selectSBM(golongan_id);
		
		model.addAttribute("schema", schema);
		
		return "staf_kesejahteraan-update_rincian_skema";
	}
	
	@RequestMapping("/staf-kesejahteraan/skema-pembayaran/update-submit")
	public String submitUpdateRincianSkemaPembayaran(@ModelAttribute SkemaBiayaModel sbm)
	{
		sbs.updateSBM(sbm);
		
		return "staf_kesejahteraan-daftar_rincian_skema";
	}
	
	@RequestMapping("/staf-kesejahteraan/skema-pembayaran/dashboard")
	public String SkemaPembayaranDashboard(Model model)
	{
		List<SkemaBiayaModel> s = sbs.selectAllSBM();
		ArrayList<StatistikManagerSummaryModel> schemas = new ArrayList<StatistikManagerSummaryModel>();
		
		for(int index=0; index < s.size(); index++)
		{
			StatistikManagerSummaryModel schema = sbs.summarySchema(s.get(index).getGolongan_id());
			if(schema != null) { schemas.add(schema); }
		}
		
		model.addAttribute("schemas", schemas);
		
		return "staf_kesejahteraan-dashboard";
	}
}