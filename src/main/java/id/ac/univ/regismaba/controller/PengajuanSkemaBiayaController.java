package id.ac.univ.regismaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;

@Controller
public class PengajuanSkemaBiayaController {

	@Autowired
	PengajuanSkemaBiayaService psbs;
	
	@Autowired
	MahasiswaService mahasiswaService;
	
	@RequestMapping("/calon-mahasiswa/skema-pembayaran")
	public String skemaMahasiswa(Model model)
	{
		//hardcode first psbm
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswa("1234567890");
		
		int pengajuanId = mahasiswa.getPengajuan_id();
		
		PengajuanSkemaBiayaModel psbm = psbs.selectPSBM(pengajuanId);
		
		model.addAttribute("mahasiswa", mahasiswa);
		
		model.addAttribute("psbm", psbm);
		
		return "calon_mahasiswa-melihat_skema_pembayaran";
	}
	
	@RequestMapping("/calon-mahasiswa/pengajuan-skema")
	public String pengajuanSkemaMahasiswa()
	{
		return "calon_mahasiswa-pengajuan_skema_pembayaran";
	}
	
	@RequestMapping("/calon-mahasiswa/pengajuan-skema/submit")
	public String pengajuanSkemaMahasiswaSubmit(Model model, @ModelAttribute PengajuanSkemaBiayaModel skema)
	{
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswa("1234567890");
		
		if(mahasiswa.getPengajuan_id() == 0)
		{
			//insert new pengajuan
			psbs.insertPSBM(skema);
		}
		else
		{
			//update existing pengajuan
			psbs.updatePSBM(skema);
		}
		
		mahasiswa = mahasiswaService.selectMahasiswa("1234567890");
		
		int pengajuanId = mahasiswa.getPengajuan_id();
		
		PengajuanSkemaBiayaModel psbm = psbs.selectPSBM(pengajuanId);
		
		model.addAttribute("mahasiswa", mahasiswa);
		
		model.addAttribute("psbm", psbm);
		
		return "calon_mahasiswa-melihat_skema_pembayaran";
	}
}