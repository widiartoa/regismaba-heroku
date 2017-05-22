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

import id.ac.univ.regismaba.model.AssignJadwalModel;
import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.model.TahunAjaranModel;
import id.ac.univ.regismaba.model.UrutanAssignJadwalModel;
import id.ac.univ.regismaba.service.AssignJadwalService;
import id.ac.univ.regismaba.service.FakultasService;
import id.ac.univ.regismaba.service.JadwalService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;
import id.ac.univ.regismaba.service.TahunAjaranService;
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

	@Autowired
	TahunAjaranService tahunAjaranService;

	@Autowired
	AssignJadwalService assignJadwalService;

	@RequestMapping("/calon-mahasiswa/")
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

	@RequestMapping("/staf-registrasi/daftar-jadwal")
	public String getAllJadwal(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();

		List<JadwalRegisModel> jadwalRegisList = jadwalService.selectAllJadwalRegis();
		model.addAttribute("jadwalRegisList", jadwalRegisList);
		List<JadwalKesehatanModel> jadwalTesKesList = jadwalService.selectAllJadwalTesKes();
		model.addAttribute("jadwalTesKesList", jadwalTesKesList);
		List<JadwalEptModel> jadwalEptList = jadwalService.selectAllJadwalEpt();
		model.addAttribute("jadwalEptList", jadwalEptList);

		// assign jadwal
		List<FakultasModel> fakultasList = fakultasService.selectAllFakultas();
		model.addAttribute("fakultasList", fakultasList);

		return "staf_registrasi-daftar_jadwal";
	}

	@PostMapping("/staf-registrasi/membuat-jadwal/submit")
	public String insertJadwal(@RequestParam(value = "hari", required = false) String hari,
			@RequestParam(value = "waktu_awal", required = false) String waktu_awal,
			@RequestParam(value = "waktu_akhir", required = false) String waktu_akhir,
			@RequestParam(value = "kapasitas", required = false) int kapasitas) throws ParseException {
		jadwalService.insertJadwalRegis(hari, waktu_awal, waktu_akhir, kapasitas);

		return "redirect:/staf-registrasi/daftar-jadwal";
	}

	@RequestMapping("/staf-registrasi/daftar-jadwal/{jadwal_registrasi_id}/hapus")
	public String reqDeleteJadwalRegis(Model model,
			@PathVariable(value = "jadwal_registrasi_id") int jadwal_registrasi_id) {
		JadwalRegisModel jadwalRegis = jadwalService.selectJadwalRegis(jadwal_registrasi_id);
		model.addAttribute("jadwalRegis", jadwalRegis);
		return "staf_registrasi-konfirmasi_hapus_jadwal";
	}

	@RequestMapping("/staf-registrasi/daftar-jadwal/{jadwal_registrasi_id}/hapus-konfirmasi")
	public String deleteJadwalRegis(Model model,
			@PathVariable(value = "jadwal_registrasi_id") int jadwal_registrasi_id) {
		jadwalService.deleteJadwalRegis(jadwal_registrasi_id);
		return "redirect:/staf-registrasi/daftar-jadwal";
	}

	@PostMapping("/staf-registrasi/assign-jadwal")
	public String assignJadwal(Model model, @RequestParam(value = "myArray[]", required = false) Integer[] myArray) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();

		TahunAjaranModel tahunAjaranSaatIni = tahunAjaranService.selectTahunAjaranSaatIni();
		jadwalService.resetAssignJadwal(tahunAjaranSaatIni.getTahun_ajaran_id());

		// TODO: insert into urutan_assign_jadwal
		for (int i = 0; i < myArray.length; i++) {
			int fakultas_id = myArray[i];
			UrutanAssignJadwalModel uaj = new UrutanAssignJadwalModel();
			uaj.setFakultas_id(fakultas_id);
			uaj.setCreated_by(user);
			uaj.setUpdated_by(user);
			uaj.setTahun_ajaran_id(tahunAjaranSaatIni.getTahun_ajaran_id());

			log.info("get fakultas id {} insert urutan assign", fakultas_id);

			jadwalService.insertUrutanAssign(uaj);
		}

		// TODO: get jadwal order by timestamp_awal ASC
		List<JadwalRegisModel> jadwalRegisList = jadwalService.selectAllJadwalRegisAsc();

		// TODO: Select * from mahasiswa as m inner join program_studi as p on
		// m.fakultas_id = p.fakultas_id
		// inner join urutan_assign_jadwal as u on m.fakultas_id = u.fakultas_id
		// order by fakultasorder_id insert mhs + jadwal to assign_jadwal
		List<MahasiswaModel> mahasiswaList = mahasiswaService
				.selectAllMahasiswaSortedUrutanAssignonTahunAjaran(tahunAjaranSaatIni.getTahun_ajaran_id());
		for (MahasiswaModel mahasiswa : mahasiswaList) {
			log.info("get one of mahasiswa with npm {} and fakultas {} on the list", mahasiswa.getNpm(),
					mahasiswa.getFakultas());
		}
		// TODO: assign jadwal
		jadwalService.assignJadwalReg(jadwalRegisList, 0, jadwalRegisList.get(0).getKapasitas(), mahasiswaList, 0,
				"redita.arifin");

		return "redirect:/staf-registrasi/daftar-assign-jadwal/";
	}

	@RequestMapping("/staf-registrasi/daftar-assign-jadwal")
	public String getAssignedJadwals(Model model) {
		List<AssignJadwalModel> assignedJadwals = assignJadwalService.selectAllAssignJadwal();

		model.addAttribute("assignedJadwals", assignedJadwals);

		for (AssignJadwalModel assign : assignedJadwals) {
			JadwalRegisModel jadwalRegis = null;
			if (assign.getJadwal_registrasi_id() != 0) {
				int jadwalRegisId = assign.getJadwal_registrasi_id();
				jadwalRegis = jadwalService.selectJadwalRegis(jadwalRegisId);
			}
			assign.setJadwalRegis(jadwalRegis);

			JadwalKesehatanModel jadwalTesKes = null;
			if (assign.getJadwal_tes_kesehatan_id() != 0) {
				int jadwalTesKesId = assign.getJadwal_tes_kesehatan_id();
				jadwalTesKes = jadwalService.selectJadwalKesehatan(jadwalTesKesId);
			}
			assign.setJadwalTesKes(jadwalTesKes);

			JadwalEptModel jadwalEpt = null;
			if (assign.getJadwal_ept_id() != 0) {
				int jadwalEptId = assign.getJadwal_ept_id();
				jadwalEpt = jadwalService.selectJadwalEpt(jadwalEptId);
			}
			assign.setJadwalEpt(jadwalEpt);
		}

		return "staf_registrasi-daftar_assign_jadwal";
	}

}
