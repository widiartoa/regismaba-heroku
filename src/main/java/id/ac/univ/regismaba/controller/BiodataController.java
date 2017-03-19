package id.ac.univ.regismaba.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.service.BiodataService;
import id.ac.univ.regismaba.service.MahasiswaService;

@Controller
public class BiodataController {
	@Autowired
	BiodataService biodataDAO;
	MahasiswaService mahasiswaDAO;
	
	@RequestMapping("/biodata/fill")
	public String insert()
	{
		return "calon_mahasiswa-mengisi_idm";
	}
	
	@RequestMapping("/biodata/fill/submit")
	public String insertBiodata (
			@RequestParam(value = "nomor_ijazah", required = false) String nomor_ijazah,
			@RequestParam(value = "nomor_asuransi", required = false) String nomor_asuransi,
			@RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
			@RequestParam(value = "jenis_kelamin", required = false) String jenis_kelamin,
			@RequestParam(value = "nomor_telepon", required = false) String nomor_telepon,
			@RequestParam(value = "kewarganegaraan", required = false) String kewarganegaraan,
			@RequestParam(value = "nomor_ktp", required = false) String nomor_ktp,
			@RequestParam(value = "sidik_jari", required = false) String sidik_jari,
			@RequestParam(value = "scan_ktp", required = false) String scan_ktp,
			@RequestParam(value = "scan_kk", required = false) String scan_kk,
			@RequestParam(value = "scan_surat_pernyataan_mahasiswa", required = false) String scan_surat_pernyataan_mahasiswa,
			@RequestParam(value = "status_verifikasi", required = false) String status_verifikasi,
			@RequestParam(value = "flag_aktif", required = false) String flag_aktif) throws ParseException	
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date tanggalLahir = format.parse(tanggal_lahir);
		System.out.println(tanggalLahir);
		BiodataModel biodata = new BiodataModel(0, 0, nomor_ijazah, nomor_asuransi, 0, tanggalLahir, jenis_kelamin, nomor_telepon, kewarganegaraan, nomor_ktp, sidik_jari, scan_ktp, scan_kk, scan_surat_pernyataan_mahasiswa, "Unverified", "1");
		biodataDAO.insertBiodata(biodata);
		return "success-biodata-insert";
		
	}
	
	@RequestMapping("/biodata/view/{npm}")
	public String view(Model model, @PathVariable(value="npm") String npm)
	{
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
		BiodataModel biodata = biodataDAO.selectBiodata(mahasiswa.getBiodata_id());
		if(biodata!=null){
			model.addAttribute("biodata", biodata);
			return "biodata-view";
		}
		return "not-found";
	} 
	
}

/**
@Param("data_kesehatan_id") int data_kesehatan_id,
							@Param("nomor_ijazah") String nomor_ijazah,
							@Param("nomor_asuransi") String nomor_asuransi,
							@Param("jalan_id") int jalan_id,
							@Param("tanggal_lahir") Date tanggal_lahir,
							@Param("jenis_kelamin") String jenis_kelamin,
							@Param("nomor_telepon") String nomor_telepon,
							@Param("kewarganegaraan") String kewarganegaraan,
							@Param("nomor_ktp") String nomor_ktp,
							@Param("sidik_jari") String sidik_jari,
							@Param("scan_ktp") String scan_ktp,
							@Param("scan_kk") String scan_kk,
							@Param("scan_surat_pernyataan_mahasiswa") String scan_surat_pernyataan_mahasiswa,
							@Param("status_verifikasi") String status_verifikasi,
							@Param("flag_aktif") String flag_aktif
**/