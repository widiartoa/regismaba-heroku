package id.ac.univ.regismaba.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.service.SkemaBiayaService;

@Controller
public class SkemaBiayaController {

	@Autowired
	SkemaBiayaService sbs;
	
	@RequestMapping("/staf-kesejahteraan/skema-pembayaran/daftar")
	public String viewAllRincianSkemaPembayaran(Model model)
	{
		List<SkemaBiayaModel> schemas = sbs.selectAllSBM();
		
		model.addAttribute("schemas", schemas);
		
		return "staf_kesejahteraan-daftar_rincian_skema";
	}
	
	@RequestMapping("/staf-kesejahteraan/skema-pembayaran/insert")
	public String insertRincianSkemaPembayaran()
	{
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
}