package id.ac.univ.regismaba.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.service.JadwalService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;
import id.ac.univ.regismaba.service.VerifikasiIDMService;

@Controller
public class JadwalController {

	@Autowired
	MahasiswaService mahasiswaService;

	@Autowired
	JadwalService jadwalService;
	
	@Autowired
	PengajuanSkemaBiayaService psbmService;
	
	@Autowired
	VerifikasiIDMService verifikasiIDMService;

	@RequestMapping("/calon-mahasiswa/")
	public String getJadwal(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername(user);

		model.addAttribute("mahasiswa", mahasiswa);

		int jadwalEptId = mahasiswa.getJadwal_ept_id();

		JadwalEptModel jadwalEpt = jadwalService.selectJadwalEpt(jadwalEptId);
		
		String hariEpt = jadwalService.parseHariEpt(jadwalEpt);
		String waktuEpt = jadwalService.parseWaktuEpt(jadwalEpt);
		String timestampAwalEpt = jadwalService.parseTimestampAwalEpt(jadwalEpt);
		String timestampAkhirEpt = jadwalService.parseTimestampAkhirEpt(jadwalEpt);
		
		model.addAttribute("hariEpt", hariEpt);
		model.addAttribute("waktuEpt", waktuEpt);
		model.addAttribute("timestampAwalEpt", timestampAwalEpt);
		model.addAttribute("timestampAkhirEpt", timestampAkhirEpt);

		int jadwalKesehatanId = mahasiswa.getJadwal_tes_kesehatan_id();

		JadwalKesehatanModel jadwalKesehatan = jadwalService.selectJadwalKesehatan(jadwalKesehatanId);

		String hariTesKes = jadwalService.parseHariTesKes(jadwalKesehatan);
		String waktuTesKes = jadwalService.parseWaktuTesKes(jadwalKesehatan);
		String timestampAwalTesKes = jadwalService.parseTimestampAwalTesKes(jadwalKesehatan);
		String timestampAkhirTesKes = jadwalService.parseTimestampAkhirTesKes(jadwalKesehatan);
		
		model.addAttribute("hariTesKes", hariTesKes);
		model.addAttribute("waktuTesKes", waktuTesKes);
		model.addAttribute("timestampAwalTesKes", timestampAwalTesKes);
		model.addAttribute("timestampAkhirTesKes", timestampAkhirTesKes);
		
		int jadwalRegisId = mahasiswa.getJadwal_registrasi_id();

		JadwalRegisModel jadwalRegis = jadwalService.selectJadwalRegis(jadwalRegisId);

		model.addAttribute("jadwalRegis", jadwalRegis);
		
		PengajuanSkemaBiayaModel psbm = psbmService.selectPSBMFromUsername(mahasiswa.getUsername());
		model.addAttribute("psbm", psbm);
		
		return "calon_mahasiswa-melihat_jadwal";
	}
	
	@RequestMapping("/staf-registrasi/daftar-jadwal")
	public String getAllJadwal(Model model) {
		List<JadwalRegisModel> jadwalRegisList = jadwalService.selectAllJadwalRegis();
		model.addAttribute("jadwalRegisList", jadwalRegisList);
		return "staf_registrasi-daftar_jadwal";
	}
	
	@PostMapping("/staf-registrasi/membuat-jadwal/submit")
	public String insertJadwal(
			@RequestParam(value = "hari", required = false) String hari,
			@RequestParam(value = "waktu_awal", required = false) String waktu_awal,
			@RequestParam(value = "waktu_akhir", required = false) String waktu_akhir,
			@RequestParam(value = "kapasitas", required = false) int kapasitas)
			throws ParseException {
		jadwalService.insertJadwalRegis(hari, waktu_awal, waktu_akhir, kapasitas);
		
		return "redirect:/staf-registrasi/daftar-jadwal";
	}
	
	@RequestMapping("/staf-registrasi/daftar-jadwal/{jadwal_id}/hapus")
    public String deleteJadwal (Model model,
            @PathVariable(value = "jadwal_id") int jadwal_id)
    {
		//TODO:hapus jadwal regis
		return "redirect:/staf-registrasi/daftar-jadwal";
	}
}
