package id.ac.univ.regismaba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.service.MahasiswaService;

@Controller
public class StafController {

	@Autowired
	MahasiswaService mahasiswaDAO;

	// TODO: Tambahkan @RequestMapping("/") setelah bisa ambil session
	// untuk Verifikator redirect:/staf_verifikasi/daftar_mhs
	// untuk Staf Registrasi redirect:/staf_registrasi/daftar_mhs
	// untuk Staf Kesehatan redirect:/staf_kesehatan/daftar_mhs
	// untuk Staf Kesejahteraan redirect:/staf_kesejahteraan/daftar_mhs

	@RequestMapping("/staf_verifikasi/daftar_mhs")
	public String daftarMhsVerifikator(Model model) {
		List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa();
		model.addAttribute("mahasiswas", mahasiswas);
		// TODO: BiodataModel harus memiliki atribut username
		return "staf_verifikasi-daftar_mhs";
	}

	@RequestMapping("/staf_registrasi/daftar_mhs")
	public String daftarMhsRegistrasi(Model model) {
		List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa();
		model.addAttribute("mahasiswas", mahasiswas);
		return "staf_registrasi-daftar_mhs";
	}

	@RequestMapping("/staf_kesehatan/daftar_mhs")
	public String daftarMhsKesehatan(Model model) {
		List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa();
		model.addAttribute("mahasiswas", mahasiswas);
		return "staf_kesehatan-daftar_mhs";
	}

	@RequestMapping("/staf_kesejahteraan/daftar_mhs")
	public String daftarMhsKesejahteraan(Model model) {
		List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa();
		model.addAttribute("mahasiswas", mahasiswas);
		return "staf_kesejahteraan-daftar_mhs";
	}
}
