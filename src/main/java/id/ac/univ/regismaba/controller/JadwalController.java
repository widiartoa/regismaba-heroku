package id.ac.univ.regismaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.service.JadwalService;
import id.ac.univ.regismaba.service.MahasiswaService;

@Controller
public class JadwalController {

	@Autowired
	MahasiswaService mahasiswaService;

	@Autowired
	JadwalService jadwalService;

	@RequestMapping("/calon-mahasiswa/jadwal")
	public String getJadwal(Model model) {
		// hardcode
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswa("1234567890");

		model.addAttribute("mahasiswa", mahasiswa);

		int jadwalEptId = mahasiswa.getJadwal_ept_id();

		JadwalEptModel jadwalEpt = jadwalService.selectJadwalEpt(jadwalEptId);

		int jadwalKesehatanId = mahasiswa.getJadwal_tes_kesehatan_id();

		JadwalKesehatanModel jadwalKesehatan = jadwalService.selectJadwalKesehatan(jadwalKesehatanId);

		int jadwalRegisId = mahasiswa.getJadwal_registrasi_id();

		JadwalRegisModel jadwalRegis = jadwalService.selectJadwalRegis(jadwalRegisId);

		String hariRegis = jadwalService.parseHariRegis(jadwalRegis);

		String waktuRegis = jadwalService.parseWaktuRegis(jadwalRegis);

		String timestampAwalRegis = jadwalService.parseTimestampAwalRegis(jadwalRegis);

		String timestampAkhirRegis = jadwalService.parseTimestampAkhirRegis(jadwalRegis);

		model.addAttribute("hariRegis", hariRegis);
		model.addAttribute("waktuRegis", waktuRegis);
		model.addAttribute("timestampAwalRegis", timestampAwalRegis);
		model.addAttribute("timestampAkhirRegis", timestampAkhirRegis);

		return "calon_mahasiswa-melihat_jadwal";
	}
}
