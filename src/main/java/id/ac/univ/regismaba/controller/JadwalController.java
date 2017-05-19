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

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.service.FakultasService;
import id.ac.univ.regismaba.service.JadwalService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;
import id.ac.univ.regismaba.service.VerifikasiIDMService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@Autowired
	FakultasService fakultasService;

	@RequestMapping("/c6/calon-mahasiswa/")
	public String getJadwal(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername(user);

		model.addAttribute("mahasiswa", mahasiswa);

		JadwalRegisModel jadwalRegis = null;
		if (mahasiswa.getJadwal_registrasi_id() != 0) {
			int jadwalRegisId = mahasiswa.getJadwal_registrasi_id();
			jadwalRegis = jadwalService.selectJadwalRegis(jadwalRegisId);
		}
		model.addAttribute("jadwalRegis", jadwalRegis);

		JadwalKesehatanModel jadwalTesKes = null;
		if (mahasiswa.getJadwal_tes_kesehatan_id() != 0) {
			int jadwalTesKesId = mahasiswa.getJadwal_tes_kesehatan_id();
			jadwalTesKes = jadwalService.selectJadwalKesehatan(jadwalTesKesId);
		}
		model.addAttribute("jadwalTesKes", jadwalTesKes);

		JadwalEptModel jadwalEpt = null;
		if (mahasiswa.getJadwal_ept_id() != 0) {
			int jadwalEptId = mahasiswa.getJadwal_ept_id();
			jadwalEpt = jadwalService.selectJadwalEpt(jadwalEptId);
		}
		model.addAttribute("jadwalEpt", jadwalEpt);

		PengajuanSkemaBiayaModel psbm = psbmService.selectPSBMFromUsername(mahasiswa.getUsername());
		model.addAttribute("psbm", psbm);

		return "calon_mahasiswa-melihat_jadwal";
	}

	@RequestMapping("/c6/staf-registrasi/daftar-jadwal")
	public String getAllJadwal(Model model) {
		List<JadwalRegisModel> jadwalRegisList = jadwalService.selectAllJadwalRegis();
		model.addAttribute("jadwalRegisList", jadwalRegisList);
		List<JadwalKesehatanModel> jadwalTesKesList = jadwalService.selectAllJadwalTesKes();
		model.addAttribute("jadwalTesKesList", jadwalTesKesList);
		List<JadwalEptModel> jadwalEptList = jadwalService.selectAllJadwalEpt();
		model.addAttribute("jadwalEptList", jadwalEptList);
		
		//assign jadwal
		List<FakultasModel> fakultasList = fakultasService.selectAllFakultas();
		model.addAttribute("fakultasList", fakultasList);
		
		return "staf_registrasi-daftar_jadwal";
	}

	@PostMapping("/c6/staf-registrasi/membuat-jadwal/submit")
	public String insertJadwal(@RequestParam(value = "hari", required = false) String hari,
			@RequestParam(value = "waktu_awal", required = false) String waktu_awal,
			@RequestParam(value = "waktu_akhir", required = false) String waktu_akhir,
			@RequestParam(value = "kapasitas", required = false) int kapasitas) throws ParseException {
		jadwalService.insertJadwalRegis(hari, waktu_awal, waktu_akhir, kapasitas);

		return "redirect:/staf-registrasi/daftar-jadwal";
	}

	@RequestMapping("/c6/staf-registrasi/daftar-jadwal/{jadwal_registrasi_id}/hapus")
	public String reqDeleteJadwalRegis(Model model,
			@PathVariable(value = "jadwal_registrasi_id") int jadwal_registrasi_id) {
		JadwalRegisModel jadwalRegis = jadwalService.selectJadwalRegis(jadwal_registrasi_id);
		model.addAttribute("jadwalRegis", jadwalRegis);
		return "staf_registrasi-konfirmasi_hapus_jadwal";
	}

	@RequestMapping("/c6/staf-registrasi/daftar-jadwal/{jadwal_registrasi_id}/hapus-konfirmasi")
	public String deleteJadwalRegis(Model model,
			@PathVariable(value = "jadwal_registrasi_id") int jadwal_registrasi_id) {
		jadwalService.deleteJadwalRegis(jadwal_registrasi_id);
		return "redirect:/staf-registrasi/daftar-jadwal";
	}
	
	@PostMapping("/c6/staf-registrasi/assign-jadwal")
	public String assignJadwal(Model model, @RequestParam(value = "myArray[]", required = false) String[] myArray){
		log.info("get array filled with {}", myArray[0]);
		//TODO: insert fakultas order
		//TODO: get jadwal order by timestamp_awal ASC
		//TODO: get mhs left join fakultasorder order by fakultasorder_id
		//TODO: insert mhs + jadwal to assign_jadwal
		
		//TODO: buat halaman sukses assign jadwal + view assigned jadwal
		return "index";
	}
	
}
