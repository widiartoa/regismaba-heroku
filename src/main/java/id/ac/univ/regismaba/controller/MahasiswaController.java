package id.ac.univ.regismaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MahasiswaController {

	@RequestMapping("/")
	public String loginMahasiswa()
	{
		return "index";
	}
	
	@RequestMapping("/idm/fill")
	public String idmMahasiswa()
	{
		return "calon_mahasiswa-mengisi_idm";
	}
	
	@RequestMapping("/calon-mahasiswa/skema-pembayaran")
	public String skemaMahasiswa()
	{
		return "calon_mahasiswa-melihat_skema_pembayaran";
	}
}
