package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
import id.ac.univ.regismaba.model.UserModel;
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
import id.ac.univ.regismaba.service.UserService;
import id.ac.univ.regismaba.service.VerifikasiIDMService;
import id.ac.univ.regismaba.storage.StorageService;

@Controller
public class BiodataController {

    private final StorageService storageService;
    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "application/pdf");
	private boolean fileError = false;
	private BiodataModel biodata = new BiodataModel();
	private IjazahModel ijazah = new IjazahModel();
	private DataKesehatanModel dkm = new DataKesehatanModel();
	private AsuransiKesehatanModel akm = new AsuransiKesehatanModel();
	private InstitusiModel institusi = new InstitusiModel();
	private JenjangModel jenjang = new JenjangModel();
    
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
	
	@Autowired
	VerifikasiIDMService verifIDMDAO;
	
	@Autowired
	UserService userDAO;
	

	/*@RequestMapping("calon-mahasiswa/idm")
	public String idmMahasiswa()
	{		
		// todo : kalo belom isi idm ke fill idm, udah ke view idm
		
		
		return "calon_mahasiswa-mengisi_idm";
	}*/

	@RequestMapping("calon-mahasiswa/biodata/fill")
	public String insert(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String name = user.getUsername(); //get logged in username
		
		UserModel userNowLoggedIn = userDAO.selectUser(name);
		
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaByUsername(name);
		
		if (biodataDAO.selectBiodataByUsername(name) != null) {
			return "redirect:/calon-mahasiswa/biodata/update/";
		}
		
		List<ProvinsiModel> provinsis = provinsiDAO.selectAllProvinsi();
		model.addAttribute("provinsis", provinsis);
		List<AgamaModel> agamas = agamaDAO.selectAllAgama();
		model.addAttribute("agamas", agamas);
		List<JenjangModel> jenjangs = jenjangDAO.selectAllJenjang();
		model.addAttribute("jenjangs", jenjangs);
		List<TingkatPendidikanModel> tingkatPendidikans = tingkatPendidikanDAO.selectAllTingkatPendidikan();
		model.addAttribute("tingkatPendidikans", tingkatPendidikans);
		
		
		System.out.println(user);
		if (userNowLoggedIn != null) {
			model.addAttribute("user", userNowLoggedIn);
				System.out.println("user ke add ke model");
		} else {
			return "error";
		}
		
		
/*		if (mahasiswa != null){
			model.addAttribute("mahasiswa", mahasiswa);			
		} else {
			return "error";
		}*/
		
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
//        IjazahModel ijazah = new IjazahModel();
        ijazah.setNomor_ijazah (nomor_ijazah);
        
//        Random rand = new Random();
//        
//        int num = rand.nextInt(1000000) + 1;
        
//        storageService.store (scan_ijazah, num+"");
//        storageService.store (scan_pernyataan_ijazah, num+"");
//        storageService.store (scan_ktp, num+"");
//        storageService.store (scan_kk, num+"");
//        storageService.store (scan_surat_pernyataan_mahasiswa, num+"");
//        storageService.store (form_survey_kesehatan, num+"");
//        storageService.store (scan_kartu, num+"");
       
        
        
        storeFile(scan_kartu, 1);
    	storeFile(scan_ktp, 2);
    	storeFile(scan_kk, 3);
    	storeFile(scan_surat_pernyataan_mahasiswa, 4);
    	storeFile(form_survey_kesehatan, 5);
    	storeFile(scan_ijazah, 6);
    	storeFile(scan_pernyataan_ijazah, 7);
    	
    	if(fileError == true)
		{
			fileError = false;
			return "calon_mahasiswa-salah_file_upload";
		}
    	
//        //================================IJAZAH=====================================
//        Path data1 = storageService.load(scan_ijazah.getOriginalFilename());
//        String pdb1 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data1.getFileName().toString())
//                .build().toString();
//        
//        ijazah.setScan_ijazah (pdb1);
//        
//        //SCAN PERNYATAAN IJAZAH UPLOAD//
//        Path data2 = storageService.load(scan_ijazah.getOriginalFilename());
//        String pdb2 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data2.getFileName().toString())
//                .build().toString();
//        
//        ijazah.setScan_pernyataan_ijazah (pdb2);
//        
//        //=================================BIODATA======================================
//        BiodataModel bio = new BiodataModel();
//        
//        //SCAN SIDIK JARI UPLOAD//        
//        /*Path data3 = storageService.load(sidik_jari.getOriginalFilename());
//        String pdb3 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data3.getFileName().toString())
//                .build().toString();
//        
//        bio.setSidik_jari(pdb3);*/
//
//        
//        //SCAN SCAN KTP UPLOAD//
//        Path data4 = storageService.load(scan_ktp.getOriginalFilename());
//        String pdb4 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data4.getFileName().toString())
//                .build().toString();
//        
//        bio.setScan_ktp(pdb4);
//        
//        
//        //SCAN SCAN KK UPLOAD//
//        Path data5 = storageService.load(scan_kk.getOriginalFilename());
//        String pdb5 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data5.getFileName().toString())
//                .build().toString();
//        
//        bio.setScan_kk(pdb5);
//        
//        
//        //SCAN SCAN SURAT PERNYATAAN MAHASISWA UPLOAD//
//        Path data6 = storageService.load(scan_surat_pernyataan_mahasiswa.getOriginalFilename());
//        String pdb6 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data6.getFileName().toString())
//                .build().toString();
//        
//        bio.setScan_surat_pernyataan_mahasiswa(pdb6);
        
        
        //SCAN FORM SURVEY KESEHATAN UPLOAD//
//        DataKesehatanModel dkm = new DataKesehatanModel();
        
//        Path data7 = storageService.load(form_survey_kesehatan.getOriginalFilename());
//        String pdb7 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data7.getFileName().toString())
//                .build().toString();
//        
//        dkm.setForm_survey_kesehatan(pdb7);
              
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //get logged in username
        
        biodata.setUsername(name);	
        biodata.setBiodata_id(0);
        biodata.setFlag_aktif("1");
        biodata.setSidik_jari("Belum scan sidik jari");
        
        biodata.setJenis_kelamin(jenis_kelamin);
        biodata.setKewarganegaraan(kewarganegaraan);
        biodata.setNomor_ktp(nomor_ktp);
        biodata.setNomor_telepon(nomor_telepon);
        biodata.setStatus_verifikasi("Not verified yet");
        biodata.setTanggal_lahir(tanggalLahir);
        biodata.setUkuran_jaket(ukuran_jaket);
        biodata.setCreated_by(name);
        biodata.setUpdated_at(null);
        biodata.setUpdated_by(name);
        biodata.setAgama_id(agamaId);
        
        ijazah.setUsername(name);
        ijazah.setInstitusi_id(Integer.parseInt(institusi_id));
        ijazah.setJenjang(jenjang);
        ijazah.setCreated_by(name);
		ijazah.setUpdated_by(name);
		ijazah.setUpdated_at(null);
        
		institusi = institusiDAO.selectInstitusi(Integer.parseInt(institusi_id));
		model.addAttribute("institusi", institusi);
		
		
		//lalalala
		
		dkm.setData_kesehatan_id(0);
        dkm.setHasil_tes_kesehatan("Belum cek kesehatan");
        dkm.setUsername(name);
        dkm.setCreated_by(name);
		dkm.setUpdated_by(name);
		dkm.setUpdated_at(null);
        
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
		biodata.setJalan_id(alamatDAO.selectJalanId(alamat));

		
//		AsuransiKesehatanModel akm = new AsuransiKesehatanModel();
		
//		//SCAN KARTU ASURANSI
//        Path data8 = storageService.load(scan_kartu.getOriginalFilename());
//        String pdb8 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data8.getFileName().toString())
//                .build().toString();
//        
//        akm.setScan_kartu(pdb8);
		
		akm.setNomor_asuransi(nomor_asuransi);
		akm.setUsername(name);
		akm.setNomor_penerbit_asuransi(nomor_penerbit_asuransi);
		akm.setExpired_date(expiredDate);
		akm.setCreated_by(name);
		akm.setUpdated_by(name);
		akm.setUpdated_at(null);
		
		biodataDAO.insertBiodata(biodata);
		ijazahDAO.addIjazah(ijazah);
		dataKesehatanDAO.insertDataKesehatan(dkm);
		asuransiKesehatanDAO.insertAsuransiKesehatan(akm);
		
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaByUsername(name);
		if (mahasiswa != null){
			model.addAttribute("mahasiswa", mahasiswa);			
		} else {
			return "error";
		}
		
//		return "success-biodata-insert";
		return "redirect:/calon-mahasiswa/biodata/view/" + mahasiswa.getNpm();
           
        
		//==============================

		
	}
	
	public void storeFile(MultipartFile file, int type)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaByUsername(user);
    	Random rand = new Random();
		int num = rand.nextInt(1000000) + 1;
		
    	if(file.isEmpty() == false){	
    		String fileContentType = file.getContentType();
    		
    		if(contentTypes.contains(fileContentType)) {
    			storageService.store(file, num + "-" + type);
    			
    			String path = storageService.load(file.getOriginalFilename()).toString();
    			
    			Path data = storageService.load(file.getOriginalFilename());
    			String dbURL = MvcUriComponentsBuilder
    					.fromMethodName(BiodataController.class, "serveFile", num + "-" + type + "-" + data.getFileName().toString())
    					.build().toString();
				
				//sidik_jari
				if(type == 1) {akm.setScan_kartu(dbURL);}
				
				//scan_ktp
				if(type == 2) {biodata.setScan_ktp(dbURL);}
				
				//scan_kk
				if(type == 3) {biodata.setScan_kk(dbURL);}
				
				//scan_surat_pernyataan_mahasiswa
				if(type == 4) {biodata.setScan_surat_pernyataan_mahasiswa(dbURL);}
							
				//form_survey_kesehatan
				if(type == 5) {dkm.setForm_survey_kesehatan(dbURL);}
				
				//scan_ijazah
				if(type == 6) {ijazah.setScan_ijazah(dbURL);}
				
				//scan_pernyataan_ijazah
    			if(type == 7) {ijazah.setScan_pernyataan_ijazah(dbURL);}
				
    			
    		} else {
    			//triggering return "calon_mahasiswa-salah_file_pengajuan";
    			fileError = true;
    		}
    	}
    	else{
    		//for update
    		if(biodataDAO.selectBiodataByUsername(mahasiswa.getUsername()) != null){
    			//sidik_jari
				if(type == 1) {akm.setScan_kartu("-");}
				
				//scan_ktp
				if(type == 2) {biodata.setScan_ktp("-");}
				
				//scan_kk
				if(type == 3) {biodata.setScan_kk("-");}
				
				//scan_surat_pernyataan_mahasiswa
				if(type == 4) {biodata.setScan_surat_pernyataan_mahasiswa("-");}
							
				//form_survey_kesehatan
				if(type == 5) {dkm.setForm_survey_kesehatan("-");}
				
				//scan_ijazah
				if(type == 6) {ijazah.setScan_ijazah("-");}
				
				//scan_pernyataan_ijazah
    			if(type == 7) {ijazah.setScan_pernyataan_ijazah("-");}
    		}
    		//for insert
    		else{
    			fileError = true;
//    			return "calon_mahasiswa-salah_file_pengajuan";
    		}
    	}
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
    
	
	@RequestMapping("/calon-mahasiswa/biodata/view/{npm}")
	public String view(Model model, @PathVariable(value = "npm") String npm) {
		System.out.println(npm);
		System.out.println("masuk atas");
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
		String username = mahasiswa.getUsername();
		model.addAttribute("mahasiswa", mahasiswa);
		
		BiodataModel biodata = biodataDAO.selectBiodataByUsername(username);
		System.out.println("biodata ke select");
		System.out.println(biodata);
		if (biodata != null) {
			System.out.println("biodata gak null");
//			String tanggalLahir = verifIDMDAO.parseTanggalLahirBiodata(biodata);
			
			Date date = biodata.getTanggal_lahir ();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
            String tanggalLahir = dateFormat.format(date);
			biodata.setTanggal_lahirr(tanggalLahir);
			model.addAttribute("biodata", biodata);
			System.out.println("biodata ke add ke model");
			
			
			//ALAMAT
			int jalan_id = biodata.getJalan_id();
			System.out.println("jalan id = " + jalan_id);
			AlamatModel alamat = alamatDAO.selectAlamat(jalan_id);
			System.out.println(alamat);
			if (alamat != null) {
				model.addAttribute("alamat", alamat);
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
								System.out.println(institusi_id);
								model.addAttribute("institusi", institusi);
									System.out.println("institusi ke add ke model");
								
								jenjang = jenjangDAO.selectJenjang(Integer.parseInt(ijazah.getJenjang()));	
								model.addAttribute("jenjang", jenjang);	
								
								AsuransiKesehatanModel asuransiKesehatan = asuransiKesehatanDAO.selectAsuransiKesehatanByUsername(username);
									System.out.println(asuransiKesehatan);
								if(asuransiKesehatan != null) {
									
									Date expiredDate = asuransiKesehatan.getExpired_date();
						            DateFormat expiredDateFormat = new SimpleDateFormat("dd-MM-YYYY");
						            String expired_date = expiredDateFormat.format(expiredDate);
									asuransiKesehatan.setExpired_date_format(expired_date);
						            
									model.addAttribute("asuransiKesehatan", asuransiKesehatan);
									System.out.println("asuransi ke add ke model");
									int tingkat_pendidikan_id = institusi.getTingkat_pendidikan_id();
									TingkatPendidikanModel tingkatPendidikan = tingkatPendidikanDAO.selectTingkatPendidikan(tingkat_pendidikan_id);
									model.addAttribute("tingkatPendidikan", tingkatPendidikan);
									return "calon_mahasiswa-melihat_idm";
								}
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

	
	@RequestMapping("/calon-mahasiswa/biodata/update")
	public String updateView(Model model) {
		List<ProvinsiModel> provinsis = provinsiDAO.selectAllProvinsi();
		model.addAttribute("provinsis", provinsis);
		List<AgamaModel> agamas = agamaDAO.selectAllAgama();
		model.addAttribute("agamas", agamas);
		List<JenjangModel> jenjangs = jenjangDAO.selectAllJenjang();
		model.addAttribute("jenjangs", jenjangs);
		List<TingkatPendidikanModel> tingkatPendidikans = tingkatPendidikanDAO.selectAllTingkatPendidikan();
		model.addAttribute("tingkatPendidikans", tingkatPendidikans);
		
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username = user.getUsername(); //get logged in username
	    
		
		UserModel userNowLoggedIn = userDAO.selectUser(username);
		System.out.println(user);
		if (userNowLoggedIn != null) {
			model.addAttribute("user", userNowLoggedIn);
				System.out.println("user ke add ke model");
		} else {
			return "error";
		}
	    
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaByUsername(username);

		model.addAttribute("mahasiswa", mahasiswa);
		
		BiodataModel biodata = biodataDAO.selectBiodataByUsername(username);
		System.out.println("biodata ke select");
		System.out.println(biodata);
		if (biodata != null) {
			System.out.println("biodata gak null");
//			String tanggalLahir = verifIDMDAO.parseTanggalLahirBiodata(biodata);
			
			Date date = biodata.getTanggal_lahir ();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
            String tanggalLahir = dateFormat.format(date);
			biodata.setTanggal_lahirr(tanggalLahir);
			System.out.println(tanggalLahir);
			model.addAttribute("biodata", biodata);
			System.out.println("biodata ke add ke model");
			
			
			//ALAMAT
			int jalan_id = biodata.getJalan_id();
			System.out.println("jalan id = " + jalan_id);
			AlamatModel alamat = alamatDAO.selectAlamat(jalan_id);
			System.out.println(alamat);
			if (alamat != null) {
				model.addAttribute("alamat", alamat);
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
									
								jenjang = jenjangDAO.selectJenjang(Integer.parseInt(ijazah.getJenjang()));	
								model.addAttribute("jenjang", jenjang);	
									
								AsuransiKesehatanModel asuransiKesehatan = asuransiKesehatanDAO.selectAsuransiKesehatanByUsername(username);
									System.out.println(asuransiKesehatan);
								if(asuransiKesehatan != null) {
									
									Date expiredDate = asuransiKesehatan.getExpired_date();
						            DateFormat expiredDateFormat = new SimpleDateFormat("dd-MM-YYYY");
						            String expired_date = expiredDateFormat.format(expiredDate);
									asuransiKesehatan.setExpired_date_format(expired_date);
						            
									model.addAttribute("asuransiKesehatan", asuransiKesehatan);
									System.out.println("asuransi ke add ke model");
									int tingkat_pendidikan_id = institusi.getTingkat_pendidikan_id();
									TingkatPendidikanModel tingkatPendidikan = tingkatPendidikanDAO.selectTingkatPendidikan(tingkat_pendidikan_id);
									model.addAttribute("tingkatPendidikan", tingkatPendidikan);
									return "calon_mahasiswa-mengubah_idm";
								}
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
	
	
	@PostMapping("calon-mahasiswa/biodata/update/submit")
	public String updateBiodata(Model model, @RequestParam(value = "nomor_asuransi", required = false) String nomor_asuransi,
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
//        IjazahModel ijazah = new IjazahModel();
        ijazah.setNomor_ijazah (nomor_ijazah);
        
//        Random rand = new Random();
//        
//        int num = rand.nextInt(1000000) + 1;
        
//        storageService.store (scan_ijazah, num+"");
//        storageService.store (scan_pernyataan_ijazah, num+"");
//        storageService.store (scan_ktp, num+"");
//        storageService.store (scan_kk, num+"");
//        storageService.store (scan_surat_pernyataan_mahasiswa, num+"");
//        storageService.store (form_survey_kesehatan, num+"");
//        storageService.store (scan_kartu, num+"");
       
        
        
        storeFile(scan_kartu, 1);
    	storeFile(scan_ktp, 2);
    	storeFile(scan_kk, 3);
    	storeFile(scan_surat_pernyataan_mahasiswa, 4);
    	storeFile(form_survey_kesehatan, 5);
    	storeFile(scan_ijazah, 6);
    	storeFile(scan_pernyataan_ijazah, 7);
    	
    	if(fileError == true)
		{
			fileError = false;
			return "calon_mahasiswa-salah_file_upload";
		}
    	
//        //================================IJAZAH=====================================
//        Path data1 = storageService.load(scan_ijazah.getOriginalFilename());
//        String pdb1 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data1.getFileName().toString())
//                .build().toString();
//        
//        ijazah.setScan_ijazah (pdb1);
//        
//        //SCAN PERNYATAAN IJAZAH UPLOAD//
//        Path data2 = storageService.load(scan_ijazah.getOriginalFilename());
//        String pdb2 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data2.getFileName().toString())
//                .build().toString();
//        
//        ijazah.setScan_pernyataan_ijazah (pdb2);
//        
////        =================================BIODATA======================================
//        BiodataModel bio = new BiodataModel();
//        
//        //SCAN SIDIK JARI UPLOAD//        
//        /*Path data3 = storageService.load(sidik_jari.getOriginalFilename());
//        String pdb3 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data3.getFileName().toString())
//                .build().toString();
//        
//        bio.setSidik_jari(pdb3);*/
//
//        
//        //SCAN SCAN KTP UPLOAD//
//        Path data4 = storageService.load(scan_ktp.getOriginalFilename());
//        String pdb4 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data4.getFileName().toString())
//                .build().toString();
//        
//        bio.setScan_ktp(pdb4);
//        
//        
//        //SCAN SCAN KK UPLOAD//
//        Path data5 = storageService.load(scan_kk.getOriginalFilename());
//        String pdb5 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data5.getFileName().toString())
//                .build().toString();
//        
//        bio.setScan_kk(pdb5);
//        
//        
//        //SCAN SCAN SURAT PERNYATAAN MAHASISWA UPLOAD//
//        Path data6 = storageService.load(scan_surat_pernyataan_mahasiswa.getOriginalFilename());
//        String pdb6 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data6.getFileName().toString())
//                .build().toString();
//        
//        bio.setScan_surat_pernyataan_mahasiswa(pdb6);
        
        
        //SCAN FORM SURVEY KESEHATAN UPLOAD//
//        DataKesehatanModel dkm = new DataKesehatanModel();
//        
//        Path data7 = storageService.load(form_survey_kesehatan.getOriginalFilename());
//        String pdb7 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data7.getFileName().toString())
//                .build().toString();
//        
//        dkm.setForm_survey_kesehatan(pdb7);
//              
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //get logged in username
        
        biodata.setUsername(name);
        biodata.setFlag_aktif("1");
        biodata.setSidik_jari("Belum scan sidik jari");
        
        biodata.setJenis_kelamin(jenis_kelamin);
        biodata.setKewarganegaraan(kewarganegaraan);
        biodata.setNomor_ktp(nomor_ktp);
        biodata.setNomor_telepon(nomor_telepon);
        biodata.setStatus_verifikasi("Not verified yet");
        biodata.setTanggal_lahir(tanggalLahir);
        biodata.setUkuran_jaket(ukuran_jaket);
        biodata.setUpdated_at(null);
        biodata.setUpdated_by(name);
        biodata.setAgama_id(agamaId);
      
        
        ijazah.setUsername(name);
        ijazah.setInstitusi_id(Integer.parseInt(institusi_id));
        ijazah.setJenjang(jenjang);
		ijazah.setUpdated_by(name);
		ijazah.setUpdated_at(null);
        
		dkm.setData_kesehatan_id(0);
        dkm.setHasil_tes_kesehatan("Belum cek kesehatan");
        dkm.setUsername(name);
		dkm.setUpdated_by(name);
		dkm.setUpdated_at(null);
        
        //===================================

        AlamatModel alamat = new AlamatModel();
        
        //lalala

        int jalanID = alamatDAO.selectJalanIdByUsername(name);
        alamat.setJalan_id(jalanID);
        System.out.println("JALAN ID= " + biodata.getJalan_id());
        
        
        alamat.setKota_kabupaten_id(kota_kabupaten_id);
        alamat.setJalan(jalan);
        alamat.setKecamatan(kecamatan);
        alamat.setKelurahan(kelurahan);
        alamat.setKode_pos(kode_pos);
        alamat.setCreated_by(name);
		alamat.setUpdated_by(name);
		alamat.setUpdated_at(null);

		alamatDAO.updateAlamat(alamat);
		
		
//		AsuransiKesehatanModel akm = new AsuransiKesehatanModel();
//		
//		//SCAN KARTU ASURANSI
//        Path data8 = storageService.load(scan_kartu.getOriginalFilename());
//        String pdb8 = MvcUriComponentsBuilder
//                .fromMethodName(BiodataController.class, "serveFile", data8.getFileName().toString())
//                .build().toString();
//        
//        akm.setScan_kartu(pdb8);
		
		akm.setNomor_asuransi(nomor_asuransi);
		akm.setUsername(name);
		akm.setNomor_penerbit_asuransi(nomor_penerbit_asuransi);
		akm.setExpired_date(expiredDate);
		akm.setCreated_by(name);
		akm.setUpdated_by(name);
		akm.setUpdated_at(null);
		
		biodataDAO.updateBiodataByUsername(biodata);
		ijazahDAO.updateIjazah(ijazah);
		dataKesehatanDAO.updateDataKesehatan(dkm);

		asuransiKesehatanDAO.updateAsuransiKesehatan(akm);
		
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaByUsername(name);
		if (mahasiswa != null){
			model.addAttribute("mahasiswa", mahasiswa);			
		} else {
			return "error";
		}
		
//		return "success-biodata-insert";
		return "redirect:/calon-mahasiswa/biodata/view/" + mahasiswa.getNpm();
           
        
		//==============================

		
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
    
	
	@RequestMapping("/staf-registrasi/biodata/view/{npm}")
	public String viewByStafRegis(Model model, @PathVariable(value = "npm") String npm) {
		System.out.println(npm);
		System.out.println("masuk atas");
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
		String username = mahasiswa.getUsername();
		model.addAttribute("mahasiswa", mahasiswa);
		
		BiodataModel biodata = biodataDAO.selectBiodataByUsername(username);
		System.out.println("biodata ke select");
		System.out.println(biodata);
		if (biodata != null) {
			System.out.println("biodata gak null");
//			String tanggalLahir = verifIDMDAO.parseTanggalLahirBiodata(biodata);
			
			Date date = biodata.getTanggal_lahir ();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
            String tanggalLahir = dateFormat.format(date);
			biodata.setTanggal_lahirr(tanggalLahir);
			model.addAttribute("biodata", biodata);
			System.out.println("biodata ke add ke model");
			
			
			//ALAMAT
			int jalan_id = biodata.getJalan_id();
			System.out.println("jalan id = " + jalan_id);
			AlamatModel alamat = alamatDAO.selectAlamat(jalan_id);
			System.out.println(alamat);
			if (alamat != null) {
				model.addAttribute("alamat", alamat);
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
								AsuransiKesehatanModel asuransiKesehatan = asuransiKesehatanDAO.selectAsuransiKesehatanByUsername(username);
									System.out.println(asuransiKesehatan);
								if(asuransiKesehatan != null) {
									
									Date expiredDate = asuransiKesehatan.getExpired_date();
						            DateFormat expiredDateFormat = new SimpleDateFormat("dd-MM-YYYY");
						            String expired_date = expiredDateFormat.format(expiredDate);
									asuransiKesehatan.setExpired_date_format(expired_date);
						            
									model.addAttribute("asuransiKesehatan", asuransiKesehatan);
									System.out.println("asuransi ke add ke model");
									int tingkat_pendidikan_id = institusi.getTingkat_pendidikan_id();
									TingkatPendidikanModel tingkatPendidikan = tingkatPendidikanDAO.selectTingkatPendidikan(tingkat_pendidikan_id);
									model.addAttribute("tingkatPendidikan", tingkatPendidikan);
									return "staf_registrasi-melihat_idm";
								}
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
	
	
	
	
	
	
}