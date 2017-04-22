package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import id.ac.univ.regismaba.model.InstitusiModel;
import id.ac.univ.regismaba.model.KotaKabupatenModel;
import id.ac.univ.regismaba.model.ProvinsiModel;
import id.ac.univ.regismaba.service.AgamaService;
import id.ac.univ.regismaba.service.AlamatService;
import id.ac.univ.regismaba.service.BiodataService;
import id.ac.univ.regismaba.service.DataKesehatanService;
import id.ac.univ.regismaba.service.IjazahService;
import id.ac.univ.regismaba.service.InstitusiService;
import id.ac.univ.regismaba.service.KotaKabupatenService;
//import id.ac.univ.regismaba.service.IjazahService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.ProvinsiService;
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

	@Autowired
	IjazahService ijazahDAO;
	
	@Autowired
	DataKesehatanService dataKesehatanDAO;

	@Autowired
	AlamatService alamatDAO;
	
	@Autowired
	KotaKabupatenService kotaKabupatenDAO;

	@Autowired
	ProvinsiService provinsiDAO;
	
	@Autowired
	InstitusiService institusiDAO;
	
	@Autowired
	AgamaService agamaDAO;
	

	@RequestMapping("calon-mahasiswa/idm")
	public String idmMahasiswa()
	{		
		// todo : kalo belom isi idm ke fill idm, udah ke view idm
		return "calon_mahasiswa-mengisi_idm";
	}

	@RequestMapping("calon-mahasiswa/biodata/fill")
	public String insert(Model model) {
		 List<ProvinsiModel> provinsis = provinsiDAO.selectAllProvinsi();
		 model.addAttribute("provinsis", provinsis);
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
	        //@RequestParam("agama_id") int agama_id)
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
        Path data1 = storageService.load(scan_ijazah.getOriginalFilename());
        String pdb1 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data1.getFileName().toString())
                .build().toString();
        
        ijazah.setScan_ijazah (pdb1);
        
        //SCAN PERNYATAAN IJAZAH UPLOAD//
        Path data2 = storageService.load(scan_ijazah.getOriginalFilename());
        String pdb2 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data2.getFileName().toString())
                .build().toString();
        
        ijazah.setScan_pernyataan_ijazah (pdb2);
        
        //=================================BIODATA======================================
        BiodataModel bio = new BiodataModel();
        
        //SCAN SIDIK JARI UPLOAD//        
        Path data3 = storageService.load(sidik_jari.getOriginalFilename());
        String pdb3 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data3.getFileName().toString())
                .build().toString();
        
        bio.setSidik_jari(pdb3);

        
        //SCAN SCAN KTP UPLOAD//
        Path data4 = storageService.load(scan_ktp.getOriginalFilename());
        String pdb4 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data4.getFileName().toString())
                .build().toString();
        
        bio.setScan_ktp(pdb4);
        
        
        //SCAN SCAN KK UPLOAD//
        Path data5 = storageService.load(scan_kk.getOriginalFilename());
        String pdb5 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data5.getFileName().toString())
                .build().toString();
        
        bio.setScan_kk(pdb5);
        
        
        //SCAN SCAN SURAT PERNYATAAN MAHASISWA UPLOAD//
        Path data6 = storageService.load(scan_surat_pernyataan_mahasiswa.getOriginalFilename());
        String pdb6 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data6.getFileName().toString())
                .build().toString();
        
        bio.setScan_surat_pernyataan_mahasiswa(pdb6);
        
        
//        //SCAN FORM SURVEY KESEHATAN UPLOAD//
//        Path data7 = storageService.load(form_survey_kesehatan.getOriginalFilename());
//        String pdb7 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data7.getFileName().toString())
//                .build().toString();
//        
//        bio.setScan_surat_pernyataan_mahasiswa(pdb7);
//        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //get logged in username
        
        bio.setUsername(name);
        bio.setBiodata_id(0);
        bio.setFlag_aktif("1");
        bio.setJenis_kelamin(jenis_kelamin);
        bio.setKewarganegaraan(kewarganegaraan);
        bio.setNomor_ktp(nomor_ktp);
        bio.setNomor_telepon(nomor_telepon);
        bio.setStatus_verifikasi("Not verified yet");
        bio.setTanggal_lahir(tanggalLahir);
        bio.setUkuran_jaket(ukuran_jaket);
        bio.setCreated_by(name);
        bio.setUpdated_at(null);
        bio.setUpdated_by(name);
        bio.setAgama_id(1);
        
        //===================================

        AlamatModel alamat = new AlamatModel(0, kota_kabupaten_id, jalan, kecamatan, kelurahan, kode_pos, null, null, null);
        alamat.setCreated_by(name);
		alamat.setUpdated_by(name);
		alamat.setUpdated_at(null);
        int idAlamat = alamatDAO.selectJalanId(alamat);
		if (idAlamat == 0) {
			alamatDAO.insertAlamat(alamat);
		}
		alamat.setJalan_id(alamatDAO.selectJalanId(alamat));
		bio.setJalan_id(alamatDAO.selectJalanId(alamat));
		

		biodataDAO.insertBiodata(bio);

		return "success-biodata-insert";
           
        
		//==============================
//		DataKesehatanModel dataKesehatan = new DataKesehatanModel(0, form_survey_kesehatan, hasil_tes_kesehatan);
//		dataKesehatanDAO.insertDataKesehatan(dataKesehatan);
//		dataKesehatan.setData_kesehatan_id(dataKesehatanDAO.selectDataKesehatanId(dataKesehatan));

		
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

//	@RequestMapping("/biodata/view/{username}")
//	public String view(Model model, @PathVariable(value = "username") String username) {
//		BiodataModel biodata = biodataDAO.selectBiodata(username);
//		if (biodata != null) {
//			model.addAttribute("biodata", biodata);
//			return "biodata-view";
//		}
//		return "not-found";
//	}
    
	
	@RequestMapping("/biodata/view/")
	public String view(Model model, @RequestParam(value = "username", required = false) String username) {
		BiodataModel biodata = biodataDAO.selectBiodata(username);
		if (biodata != null) {
			model.addAttribute("biodata", biodata);
			//ALAMAT
			int jalan_id = biodata.getJalan_id();
			AlamatModel alamat = alamatDAO.selectAlamat(jalan_id);
			if (alamat != null) {
				model.addAttribute("alamat, alamat");
				//KOTA KABUPATEN
				int kota_kabupaten_id = alamat.getKota_kabupaten_id();
				KotaKabupatenModel kotaKabupaten = kotaKabupatenDAO.selectKotaKabupaten(kota_kabupaten_id);
				if (kotaKabupaten != null) {
					model.addAttribute(kotaKabupaten);
					//PROVINSI
					int provinsi_id = kotaKabupaten.getProvinsi_id();
					ProvinsiModel provinsi = provinsiDAO.selectProvinsi(provinsi_id);
					if (provinsi != null) {
						model.addAttribute(provinsi);
						DataKesehatanModel dataKesehatan = dataKesehatanDAO.selectDataKesehatanByUsername(username);
						if (dataKesehatan != null) {
							model.addAttribute(dataKesehatan);
							IjazahModel ijazah = ijazahDAO.selectIjazahByUsername(username);
							if (ijazah != null){
								model.addAttribute(ijazah);
								int institusi_id = ijazah.getInstitusi_id();
								InstitusiModel institusi = institusiDAO.selectInstitusi(institusi_id);
								model.addAttribute(institusi);
								return "calon_mahasiswa_melihat_idm";
							} else {
								return "not-found";
							}
						} else {
							return "not-found";
						}
					}
				}
			}
		}
		return "not-found";
	}

	
//	@RequestMapping("/kelas/update/{idKelas}")
//	public String update(Model model, @PathVariable(value = "idKelas") String idKelas) {
//		KelasModel kelas = kelasDAO.selectKelas(idKelas);
//		if (kelas != null) {
//			model.addAttribute("kelas", kelas);
//			model.addAttribute("univs", univDAO.selectAllUniv());
//			model.addAttribute("fakultass", fakultasDAO.selectAllFakultas());
//			model.addAttribute("kurikulums", kurikulumDAO.selectAllKurikulum());
//			model.addAttribute("prodis", prodiDAO.selectAllProdi());
//			model.addAttribute("matkuls", matkulDAO.selectAllMatkul());
//			return "enrollment/form-kelas-update";
//		} else {
//			model.addAttribute("idKelas", idKelas);
//			return "enrollment/kelas-not-found";
//		}
//	}
	
	
	
//	@RequestMapping("/kelas/view/")
//	public String view(Model model, @RequestParam(value = "idKelas", required = false) String idKelas) {
//		KelasModel kelas = kelasDAO.selectKelas(idKelas);
//
//		if (kelas != null) {
//			model.addAttribute("kelas", kelas);
//			return "/enrollment/view-kelas";
//		} else {
//			model.addAttribute("idKelas", idKelas);
//			return "enrollment/kelas-not-found";
//		}
//	}
    
}