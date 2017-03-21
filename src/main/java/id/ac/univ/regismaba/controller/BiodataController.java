package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import id.ac.univ.regismaba.model.AlamatModel;
import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.model.IjazahModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.service.AlamatService;
import id.ac.univ.regismaba.service.BiodataService;
import id.ac.univ.regismaba.service.DataKesehatanService;
//import id.ac.univ.regismaba.service.IjazahService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.storage.StorageService;

@Controller
public class BiodataController {

    private final StorageService storageService;
    
    @Autowired
    public BiodataController(StorageService storageService) {
        this.storageService = storageService;
    }
    
	@Autowired
	BiodataService biodataDAO;

	@Autowired
	MahasiswaService mahasiswaDAO;

//	@Autowired
//	IjazahService ijazahDAO;
	
	@Autowired
	DataKesehatanService dataKesehatanDAO;

	@Autowired
	AlamatService alamatDAO;

	// @Autowired
	// ProvinsiService provinsiDAO;

	@RequestMapping("/biodata/fill")
	public String insert(Model model) {
		// List<ProvinsiModel> provinsis = provinsiDAO.selectAllProvinsi();
		// model.addAttribute("provinsis", provinsis);
		return "calon_mahasiswa-mengisi_idm";
	}

	@RequestMapping("/biodata/fill/submit")
	public String insertBiodata(@RequestParam(value = "nomor_asuransi", required = false) String nomor_asuransi,
			@RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
			@RequestParam(value = "jenis_kelamin", required = false) String jenis_kelamin,
			@RequestParam(value = "nomor_telepon", required = false) String nomor_telepon,
			@RequestParam(value = "kewarganegaraan", required = false) String kewarganegaraan,
			@RequestParam(value = "nomor_ktp", required = false) String nomor_ktp,
			@RequestParam(value = "sidik_jari", required = false) String sidik_jari,
			@RequestParam(value = "scan_ktp", required = false) String scan_ktp,
			@RequestParam(value = "scan_kk", required = false) String scan_kk,
			@RequestParam(value = "scan_surat_pernyataan_mahasiswa", required = false) String scan_surat_pernyataan_mahasiswa,
			@RequestParam(value = "form_survey_kesehatan", required = false) String form_survey_kesehatan,
			@RequestParam(value = "hasil_tes_kesehatan", required = false) String hasil_tes_kesehatan,
			@RequestParam(value = "jalan", required = false) String jalan,
			@RequestParam(value = "kota_kabupaten_id", required = false) String kota_kabupaten_id,
			@RequestParam(value = "kecamatan", required = false) String kecamatan,
			@RequestParam(value = "kelurahan", required = false) String kelurahan,
			@RequestParam(value = "kode_pos", required = false) String kode_pos,
			@RequestParam(value = "nomor_ijazah", required = false) String nomor_ijazah,
			@RequestParam(value = "nama_institusi", required = false) String nama_institusi,
	        @RequestParam(value = "jenjang", required = false) String jenjang,
	        @RequestParam("scan_ijazah") MultipartFile scan_ijazah,
	        @RequestParam("scan_pernyataan_ijazah") MultipartFile scan_pernyataan_ijazah)
			throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date tanggalLahir = format.parse(tanggal_lahir);
		System.out.println(tanggalLahir);
		
		//========================
        IjazahModel ijazah = new IjazahModel();
        ijazah.setNomor_ijazah (nomor_ijazah);
//        ijazahDAO.addIjazah (ijazah);
        
        Random rand = new Random();
        
        int num = rand.nextInt(1000000) + 1;
        
        storageService.store (scan_ijazah, num+"");
        storageService.store (scan_pernyataan_ijazah, num+"");
        
        //SCAN IJAZAH UPLOAD//
        String pathDB1 = storageService.load(scan_ijazah.getOriginalFilename()).toString();
        
        Path data1 = storageService.load(scan_ijazah.getOriginalFilename());
        String pdb1 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data1.getFileName().toString())
                .build().toString();
        
        ijazah.setScan_ijazah (pdb1);
        
        //SCAN PERNYATAAN IJAZAH UPLOAD//
        String pathDB2 = storageService.load(scan_ijazah.getOriginalFilename()).toString();
        
        Path data2 = storageService.load(scan_ijazah.getOriginalFilename());
        String pdb2 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data2.getFileName().toString())
                .build().toString();
        
        ijazah.setScan_pernyataan_ijazah (pdb2);
		
		//==============================
		DataKesehatanModel dataKesehatan = new DataKesehatanModel(0, form_survey_kesehatan, hasil_tes_kesehatan);
		dataKesehatanDAO.insertDataKesehatan(dataKesehatan);
		dataKesehatan.setData_kesehatan_id(dataKesehatanDAO.selectDataKesehatanId(dataKesehatan));

		System.out.println(kota_kabupaten_id);
		int idKoKab = Integer.parseInt(kota_kabupaten_id);

		AlamatModel alamat = new AlamatModel(0, idKoKab, jalan, kecamatan, kelurahan, kode_pos);
		int idAlamat = alamatDAO.selectJalanId(alamat);
		if (idAlamat == 0) {
			alamatDAO.insertAlamat(alamat);
		}
		alamat.setJalan_id(alamatDAO.selectJalanId(alamat));

		BiodataModel biodata = new BiodataModel(0, dataKesehatan.getData_kesehatan_id(), nomor_ijazah, nomor_asuransi,
				alamat.getJalan_id(), tanggalLahir, jenis_kelamin, nomor_telepon, kewarganegaraan, nomor_ktp,
				sidik_jari, scan_ktp, scan_kk, scan_surat_pernyataan_mahasiswa, "Unverified", "1");
		biodataDAO.insertBiodata(biodata);
		return "success-biodata-insert";

	}

	@RequestMapping("/biodata/view/{npm}")
	public String view(Model model, @PathVariable(value = "npm") String npm) {
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
		BiodataModel biodata = biodataDAO.selectBiodata(mahasiswa.getBiodata_id());
		if (biodata != null) {
			model.addAttribute("biodata", biodata);
			return "biodata-view";
		}
		return "not-found";
	}
}