package id.ac.univ.regismaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;

@Controller
public class PengajuanSkemaBiayaController {

	@Autowired
	PengajuanSkemaBiayaService psbs;
	
	@RequestMapping("/calon-mahasiswa/skema-pembayaran")
	public String skemaMahasiswa(Model model)
	{
		//hardcode first psbm
		PengajuanSkemaBiayaModel psbm = psbs.selectPSBM(1);
		
		model.addAttribute("psbm", psbm);
		
		return "calon_mahasiswa-melihat_skema_pembayaran";
	}
	
	@RequestMapping("/calon-mahasiswa/pengajuan-skema")
	public String pengajuanSkemaMahasiswa()
	{
		return "calon_mahasiswa-pengajuan_skema_pembayaran";
	}
}
