package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	@RequestMapping("calon-mahasiswa/calon-mahasiswa/idm")
	public String idmMahasiswa()
	{		
		// todo : kalo belom isi idm ke fill idm, udah ke view idm
		return "calon_mahasiswa-mengisi_idm";
	}

	@RequestMapping("calon-mahasiswa/biodata/fill")
	public String insert(Model model) {
		// List<ProvinsiModel> provinsis = provinsiDAO.selectAllProvinsi();
		// model.addAttribute("provinsis", provinsis);
		return "calon_mahasiswa-mengisi_idm";
	}

	@PostMapping("calon-mahasiswa/biodata/fill/submit")
	public String insertBiodata(@RequestParam(value = "nomor_asuransi", required = false) String nomor_asuransi,
			@RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
			@RequestParam(value = "jenis_kelamin", required = false) String jenis_kelamin,
			@RequestParam(value = "nomor_telepon", required = false) String nomor_telepon,
			@RequestParam(value = "kewarganegaraan", required = false) String kewarganegaraan,
			@RequestParam(value = "nomor_ktp", required = false) String nomor_ktp,
			@RequestParam(value = "sidik_jari", required = false) MultipartFile sidik_jari,
			@RequestParam(value = "scan_ktp", required = false) MultipartFile scan_ktp,
			@RequestParam(value = "scan_kk", required = false) MultipartFile scan_kk,
			@RequestParam(value = "scan_surat_pernyataan_mahasiswa", required = false) MultipartFile scan_surat_pernyataan_mahasiswa,
			@RequestParam(value = "form_survey_kesehatan", required = false) MultipartFile form_survey_kesehatan,
			@RequestParam(value = "hasil_tes_kesehatan", required = false) String hasil_tes_kesehatan,
			@RequestParam(value = "jalan", required = false) String jalan,
			@RequestParam(value = "kota_kabupaten_id", required = false) int kota_kabupaten_id,
			@RequestParam(value = "kecamatan", required = false) String kecamatan,
			@RequestParam(value = "kelurahan", required = false) String kelurahan,
			@RequestParam(value = "provinsi_id", required = false) String provinsi_id,			
			@RequestParam(value = "kode_pos", required = false) String kode_pos,
			@RequestParam(value = "ukuran_jaket", required = false) String ukuran_jaket,
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
        //ijazahDAO.addIjazah (ijazah);
        
        Random rand = new Random();
        
        int num = rand.nextInt(1000000) + 1;
        
        storageService.store (scan_ijazah, num+"");
        storageService.store (scan_pernyataan_ijazah, num+"");
        
        //================================IJAZAH=====================================
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
        
        //=================================BIODATA======================================
        BiodataModel bio = new BiodataModel();
        //SCAN SIDIK JARI UPLOAD//
        String pathDB3 = storageService.load(sidik_jari.getOriginalFilename()).toString();
        
        Path data3 = storageService.load(sidik_jari.getOriginalFilename());
        String pdb3 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data3.getFileName().toString())
                .build().toString();
        
        bio.setSidik_jari(pdb3);

        
        //SCAN SCAN KTP UPLOAD//
        //baris kayak yg dibawah ini harusnya gak dipake
        String pathDB4 = storageService.load(scan_ktp.getOriginalFilename()).toString();
        
        Path data4 = storageService.load(scan_ktp.getOriginalFilename());
        String pdb4 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data4.getFileName().toString())
                .build().toString();
        
        bio.setScan_ktp(pdb4);
        
        
        //SCAN SCAN KK UPLOAD//
        String pathDB5 = storageService.load(scan_kk.getOriginalFilename()).toString();
        
        Path data5 = storageService.load(scan_kk.getOriginalFilename());
        String pdb5 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data5.getFileName().toString())
                .build().toString();
        
        bio.setScan_kk(pdb5);
        
        
        //SCAN SCAN SURAT PERNYATAAN MAHASISWA UPLOAD//
        String pathDB6 = storageService.load(scan_surat_pernyataan_mahasiswa.getOriginalFilename()).toString();
        
        Path data6 = storageService.load(scan_surat_pernyataan_mahasiswa.getOriginalFilename());
        String pdb6 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data6.getFileName().toString())
                .build().toString();
        
        bio.setScan_surat_pernyataan_mahasiswa(pdb6);
        
        
//        //SCAN FORM SURVEY KESEHATAN UPLOAD//
//        String pathDB7 = storageService.load(form_survey_kesehatan.getOriginalFilename()).toString();
//        
//        Path data7 = storageService.load(form_survey_kesehatan.getOriginalFilename());
//        String pdb7 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data7.getFileName().toString())
//                .build().toString();
//        
//        bio.setScan_surat_pernyataan_mahasiswa(pdb7);
//        
//        bio.setBiodata_id(0);
//        bio.setFlag_aktif("1");
//        bio.setJenis_kelamin(jenis_kelamin);
//        bio.setKewarganegaraan(kewarganegaraan);
//        bio.setNomor_ktp(nomor_ktp);
//        bio.setNomor_telepon(nomor_telepon);
//        bio.setStatus_verifikasi("Unverified");
////        bio.setTanggal_lahir(tanggal_lahir.toString());
//        bio.setUkuran_jaket(ukuran_jaket);
        
        
        //===================================

        AlamatModel alamat = new AlamatModel(0, kota_kabupaten_id, jalan, kecamatan, kelurahan, kode_pos);
		int idAlamat = alamatDAO.selectJalanId(alamat);
		if (idAlamat == 0) {
			alamatDAO.insertAlamat(alamat);
		}
		alamat.setJalan_id(alamatDAO.selectJalanId(alamat));
     
		// ini kayaknya harus disesuaiin sama bio
//        BiodataModel biodata = new BiodataModel(0, "bena", nomor_ijazah, alamat.getJalan_id(), tanggalLahir,
//        		jenis_kelamin, nomor_telepon, kewarganegaraan, nomor_ktp,sidik_jari, scan_ktp,
//        		scan_kk, scan_surat_pernyataan_mahasiswa, "Unverified", "1", ukuran_jaket);
//		biodataDAO.insertBiodata(biodata);
		return "success-biodata-insert";
           
        
		//==============================
//		DataKesehatanModel dataKesehatan = new DataKesehatanModel(0, form_survey_kesehatan, hasil_tes_kesehatan);
//		dataKesehatanDAO.insertDataKesehatan(dataKesehatan);
//		dataKesehatan.setData_kesehatan_id(dataKesehatanDAO.selectDataKesehatanId(dataKesehatan));

		
		
//		System.out.println(kota_kabupaten_id);
//		int idKoKab = Integer.parseInt(kota_kabupaten_id);



//		BiodataModel biodata = new BiodataModel(0, dataKesehatan.getData_kesehatan_id(), nomor_ijazah, nomor_asuransi,
//				alamat.getJalan_id(), tanggalLahir, jenis_kelamin, nomor_telepon, kewarganegaraan, nomor_ktp,
//				sidik_jari, scan_ktp, scan_kk, scan_surat_pernyataan_mahasiswa, "Unverified", "1");
//		biodataDAO.insertBiodata(biodata);
//		return "success-biodata-insert";

	}
	
    @GetMapping("/files2/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

//	@RequestMapping("/biodata/view/{npm}")
//	public String view(Model model, @PathVariable(value = "npm") String npm) {
//		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
//		BiodataModel biodata = biodataDAO.selectBiodata(mahasiswa.getBiodata_id());
//		if (biodata != null) {
//			model.addAttribute("biodata", biodata);
//			return "biodata-view";
//		}
//		return "not-found";
//	}
}