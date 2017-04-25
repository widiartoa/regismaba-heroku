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

import id.ac.univ.regismaba.model.AgamaModel;
import id.ac.univ.regismaba.model.AlamatModel;
import id.ac.univ.regismaba.model.AsuransiKesehatanModel;
import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.model.IjazahModel;
import id.ac.univ.regismaba.model.InstitusiModel;
import id.ac.univ.regismaba.model.JenjangModel;
import id.ac.univ.regismaba.model.KotaKabupatenModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.ProvinsiModel;
import id.ac.univ.regismaba.model.TingkatPendidikanModel;
import id.ac.univ.regismaba.service.AgamaService;
import id.ac.univ.regismaba.service.AlamatService;
import id.ac.univ.regismaba.service.AsuransiKesehatanService;
import id.ac.univ.regismaba.service.BiodataService;
import id.ac.univ.regismaba.service.DataKesehatanService;
import id.ac.univ.regismaba.service.IjazahService;
import id.ac.univ.regismaba.service.InstitusiService;
import id.ac.univ.regismaba.service.JenjangService;
import id.ac.univ.regismaba.service.KotaKabupatenService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.ProvinsiService;
import id.ac.univ.regismaba.service.TingkatPendidikanService;
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
	
	@Autowired
	AsuransiKesehatanService asuransiKesehatanDAO;
	
	@Autowired
	JenjangService jenjangDAO;
	
	@Autowired
	TingkatPendidikanService tingkatPendidikanDAO;
	

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
		List<AgamaModel> agamas = agamaDAO.selectAllAgama();
		model.addAttribute("agamas", agamas);
		List<JenjangModel> jenjangs = jenjangDAO.selectAllJenjang();
		model.addAttribute("jenjangs", jenjangs);
		List<TingkatPendidikanModel> tingkatPendidikans = tingkatPendidikanDAO.selectAllTingkatPendidikan();
		model.addAttribute("tingkatPendidikans", tingkatPendidikans);
		
		return "calon_mahasiswa-mengisi_idm";
	}

	@PostMapping("calon-mahasiswa/biodata/fill/submit")
	public String insertBiodata(Model model, @RequestParam(value = "nomor_asuransi", required = false) String nomor_asuransi,
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
			@RequestParam(value = "scan_kartu", required = false) MultipartFile scan_kartu,
			//@RequestParam(value = "hasil_tes_kesehatan", required = false) String hasil_tes_kesehatan,
			@RequestParam(value = "jalan", required = false) String jalan,
			@RequestParam(value = "kota_kabupaten_id", required = false) int kota_kabupaten_id,
			@RequestParam(value = "kecamatan", required = false) String kecamatan,
			@RequestParam(value = "kelurahan", required = false) String kelurahan,
			@RequestParam(value = "provinsi_id", required = false) String provinsi_id,			
			@RequestParam(value = "kode_pos", required = false) String kode_pos,
			@RequestParam(value = "ukuran_jaket", required = false) String ukuran_jaket,
			@RequestParam(value = "nomor_ijazah", required = false) String nomor_ijazah,
			@RequestParam(value = "institusi_id", required = false) String institusi_id,
			@RequestParam(value = "tingkat_pendidikan_id", required = false) String tingkat_pendidikan_id,
//			@RequestParam(value = "nama_institusi", required = false) String nama_institusi,
	        @RequestParam(value = "jenjang", required = false) String jenjang,
	        @RequestParam("scan_ijazah") MultipartFile scan_ijazah,
	        @RequestParam("scan_pernyataan_ijazah") MultipartFile scan_pernyataan_ijazah,
	        //@RequestParam("agama_id") int agama_id)
			@RequestParam(value = "nomor_penerbit_asuransi", required = false) String nomor_penerbit_asuransi,
			@RequestParam(value = "expired_date", required = false) String expired_date,
			@RequestParam(value = "agama_id", required = false) String agama_id)
			throws ParseException {
		
		List<AgamaModel> agamas = agamaDAO.selectAllAgama();
		model.addAttribute("agamas", agamas);
		List<JenjangModel> jenjangs = jenjangDAO.selectAllJenjang();
		model.addAttribute("jenjangs", jenjangs);
		List<TingkatPendidikanModel> tingkatPendidikans = tingkatPendidikanDAO.selectAllTingkatPendidikan();
		model.addAttribute("tingkatPendidikans", tingkatPendidikans);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tanggalLahir = format.parse(tanggal_lahir);
		System.out.println(tanggalLahir);
		
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date expiredDate = format2.parse(expired_date);
		
		System.out.println(agama_id);
		int agamaId = 0;
		System.out.println(agamaId);
		if (agama_id != null) {
			agamaId = Integer.parseInt(agama_id);
			System.out.println(agamaId);
		} else {
			agamaId = 1;
			System.out.println(agamaId);
		}

		
		//========================
        IjazahModel ijazah = new IjazahModel();
        ijazah.setNomor_ijazah (nomor_ijazah);
        
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
        /*Path data3 = storageService.load(sidik_jari.getOriginalFilename());
        String pdb3 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data3.getFileName().toString())
                .build().toString();
        
        bio.setSidik_jari(pdb3);*/

        
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
        
        
        //SCAN FORM SURVEY KESEHATAN UPLOAD//
        DataKesehatanModel dataKesehatan = new DataKesehatanModel();
        
        Path data7 = storageService.load(form_survey_kesehatan.getOriginalFilename());
        String pdb7 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data7.getFileName().toString())
                .build().toString();
        
        dataKesehatan.setForm_survey_kesehatan(pdb7);
              
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //get logged in username
        
        bio.setUsername(name);	
        bio.setBiodata_id(0);
        bio.setFlag_aktif("1");
        bio.setSidik_jari("Belum scan sidik jari");
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
        bio.setAgama_id(agamaId);
        
        ijazah.setUsername(name);
        ijazah.setInstitusi_id(Integer.parseInt(institusi_id));
        ijazah.setJenjang(jenjang);
        ijazah.setCreated_by(name);
		ijazah.setUpdated_by(name);
		ijazah.setUpdated_at(null);
        
		dataKesehatan.setData_kesehatan_id(0);
        dataKesehatan.setHasil_tes_kesehatan("Belum cek kesehatan");
        dataKesehatan.setUsername(name);
        dataKesehatan.setCreated_by(name);
		dataKesehatan.setUpdated_by(name);
		dataKesehatan.setUpdated_at(null);
        
        //===================================

        AlamatModel alamat = new AlamatModel(0, kota_kabupaten_id, jalan, kecamatan, kelurahan, kode_pos, null, null, null, null);
        alamat.setCreated_by(name);
		alamat.setUpdated_by(name);
		alamat.setUpdated_at(null);
        int idAlamat = alamatDAO.selectJalanId(alamat);
		if (idAlamat == 0) {
			alamatDAO.insertAlamat(alamat);
		}
		alamat.setJalan_id(alamatDAO.selectJalanId(alamat));
		bio.setJalan_id(alamatDAO.selectJalanId(alamat));

		
		AsuransiKesehatanModel asuransiKesehatan = new AsuransiKesehatanModel();
		
		//SCAN KARTU ASURANSI
        Path data8 = storageService.load(scan_kartu.getOriginalFilename());
        String pdb8 = MvcUriComponentsBuilder
                .fromMethodName(BiodataController.class, "serveFile", data8.getFileName().toString())
                .build().toString();
        
        asuransiKesehatan.setScan_kartu(pdb8);
		
		asuransiKesehatan.setNomor_asuransi(nomor_asuransi);
		asuransiKesehatan.setUsername(name);
		asuransiKesehatan.setNomor_penerbit_asuransi(nomor_penerbit_asuransi);
		asuransiKesehatan.setExpired_date(expiredDate);
		asuransiKesehatan.setCreated_by(name);
		asuransiKesehatan.setUpdated_by(name);
		asuransiKesehatan.setUpdated_at(null);
		
		biodataDAO.insertBiodata(bio);
		ijazahDAO.addIjazah(ijazah);
		dataKesehatanDAO.insertDataKesehatan(dataKesehatan);
		asuransiKesehatanDAO.insertAsuransiKesehatan(asuransiKesehatan);
		
		return "success-biodata-insert";
           
        
		//==============================

		
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
    
	
	@RequestMapping("/biodata/view/{npm}")
	public String view(Model model, @PathVariable(value = "npm") String npm) {
		System.out.println(npm);
		System.out.println("masuk atas");
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
		String username = mahasiswa.getUsername();
		BiodataModel biodata = biodataDAO.selectBiodataByUsername(username);
		System.out.println("biodata ke select");
		System.out.println(biodata);
		if (biodata != null) {
			System.out.println("biodata gak null");
			model.addAttribute("biodata", biodata);
			System.out.println("biodata ke add ke model");
			//ALAMAT
			int jalan_id = biodata.getJalan_id();
			System.out.println("jalan id = " + jalan_id);
			AlamatModel alamat = alamatDAO.selectAlamat(jalan_id);
			System.out.println(alamat);
			if (alamat != null) {
				model.addAttribute("alamat, alamat");
					System.out.println("alamat ke add ke model");
				//KOTA KABUPATEN
				int kota_kabupaten_id = alamat.getKota_kabupaten_id();
					System.out.println("kota kabupaten id " + kota_kabupaten_id);
				KotaKabupatenModel kotaKabupaten = kotaKabupatenDAO.selectKotaKabupaten(kota_kabupaten_id);
					System.out.println(kotaKabupaten);
				if (kotaKabupaten != null) {
					model.addAttribute("kotaKabupaten", kotaKabupaten);
						System.out.println("kota kabupaten ke add ke model");
					//PROVINSI
					int provinsi_id = kotaKabupaten.getProvinsi_id();
					System.out.println("provinsi id " + provinsi_id);
					ProvinsiModel provinsi = provinsiDAO.selectProvinsi(provinsi_id);
					System.out.println(provinsi);
					if (provinsi != null) {
						model.addAttribute("provinsi", provinsi);
							System.out.println("provinsi ke add ke model");
							
						int agama_id = biodata.getAgama_id();
						AgamaModel agama = agamaDAO.selectAgama(agama_id);
						if (agama != null) {
							model.addAttribute("agama", agama);
							System.out.println(agama.getNama_agama());
						} else {
							return "error";
						}
						
						DataKesehatanModel dataKesehatan = dataKesehatanDAO.selectDataKesehatanByUsername(username);
						System.out.println(provinsi);
						if (dataKesehatan != null) {
							model.addAttribute("dataKesehatan", dataKesehatan);
								System.out.println("data kesehatan ke add ke model");
							IjazahModel ijazah = ijazahDAO.selectIjazahByUsername(username);
							System.out.println(ijazah);
							if (ijazah != null){
								model.addAttribute("ijazah", ijazah);
									System.out.println("ijazah ke add ke model");
								int institusi_id = ijazah.getInstitusi_id();
								InstitusiModel institusi = institusiDAO.selectInstitusi(institusi_id);
								System.out.println(provinsi);
								model.addAttribute("institusi", institusi);
									System.out.println("institusi ke add ke model");
								return "calon_mahasiswa-melihat_idm";
							} else {
								return "error";
							}
						} else {
							return "error";
						}
					}
				}
			}
		}
		System.out.println("keluuarrrr");
		return "error";
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