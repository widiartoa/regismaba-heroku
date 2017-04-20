package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.model.RumpunModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;
import id.ac.univ.regismaba.service.RumpunService;
import id.ac.univ.regismaba.service.SkemaBiayaService;
import id.ac.univ.regismaba.storage.StorageFileNotFoundException;
import id.ac.univ.regismaba.storage.StorageService;

@Controller
public class PengajuanSkemaBiayaController {

	private final StorageService storageService;
	private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg");
	private boolean fileError = false;
	private PengajuanSkemaBiayaModel skema = new PengajuanSkemaBiayaModel();
	
	@Autowired
	public PengajuanSkemaBiayaController(StorageService storageService){
		this.storageService = storageService;
	}
	
	@Autowired
	PengajuanSkemaBiayaService psbs;
	
	@Autowired
	SkemaBiayaService sbs;
	
	@Autowired
	MahasiswaService mahasiswaService;
	
	@Autowired
	RumpunService rm;
	
	@RequestMapping("/calon-mahasiswa/skema-pembayaran")
	public String skemaMahasiswa(Model model)
	{	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername(user);
		
		PengajuanSkemaBiayaModel psbm = psbs.selectPSBMFromUsername(mahasiswa.getUsername());
		model.addAttribute("mahasiswa", mahasiswa);
		
		if(psbm != null)
		{	
			RumpunModel rumpun = rm.getRumpun(mahasiswa.getUsername());
			SkemaBiayaModel sbm = sbs.selectSBM(psbm.getGolongan_id());
				
			model.addAttribute("psbm", psbm);
			model.addAttribute("sbm", sbm);
			model.addAttribute("rumpun", rumpun);
			return "calon_mahasiswa-melihat_skema_pembayaran";
		}
		else
		{
			return "calon_mahasiswa-melihat_skema_pembayaran_null";
		}
	}
	
	@RequestMapping("/calon-mahasiswa/skema-pembayaran/pengajuan")
	public String pengajuanSkemaMahasiswa(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername(user);
		
		List<SkemaBiayaModel> schemas = sbs.selectAllSBM();
		model.addAttribute("schemas", schemas);
		
		RumpunModel rumpun = rm.getRumpun(mahasiswa.getUsername());
		model.addAttribute("rumpun", rumpun);
		
		if(psbs.selectPSBMFromUsername(mahasiswa.getUsername()) != null)
		{
			System.out.println("Send update pengajuan page");
			PengajuanSkemaBiayaModel psbm = psbs.selectPSBMFromUsername(mahasiswa.getUsername());
			model.addAttribute("psbm", psbm);
			return "calon_mahasiswa-pengajuan_skema_pembayaran";
		}
		else
		{
			System.out.println("Send new pengajuan page");
			return "calon_mahasiswa-pengajuan_skema_pembayaran_add";
		}
		
	}
	
	@PostMapping("/calon-mahasiswa/skema-pembayaran/submit")
	public String pengajuanSkemaMahasiswaSubmit(Model model, 
												@RequestParam("golongan_id") int golongan_id,
												@RequestParam("surat_keterangan_rtrw") MultipartFile surat_keterangan_rtrw,
												@RequestParam("foto_rumah") MultipartFile foto_rumah,
												@RequestParam("slip_gaji_pribadi") MultipartFile slip_gaji_pribadi,
												@RequestParam("slip_gaji_wali1") MultipartFile slip_gaji_wali1,
												@RequestParam("slip_gaji_wali2") MultipartFile slip_gaji_wali2,
												@RequestParam("tagihan_air") MultipartFile tagihan_air,
												@RequestParam("tagihan_listrik") MultipartFile tagihan_listrik,
												@RequestParam("tagihan_telepon") MultipartFile tagihan_telepon,
												@RequestParam("gaji_pribadi") String gaji_pribadi,
												@RequestParam("gaji_wali1") String gaji_wali1,
												@RequestParam("gaji_wali2") String gaji_wali2,
												@RequestParam("nilai_tagihan_air") String nilai_tagihan_air,
												@RequestParam("nilai_tagihan_listrik") String nilai_tagihan_listrik,
												@RequestParam("nilai_tagihan_telepon") String nilai_tagihan_telepon)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername(user);
		
		skema.setGolongan_id(golongan_id);
		skema.setUsername(mahasiswa.getUsername());
		if(gaji_pribadi.equals("") == false){
			skema.setGaji_pribadi(Integer.parseInt(gaji_pribadi));
		}
		else{
			skema.setGaji_pribadi(0);
		}
		
		if(gaji_wali1.equals("") == false){
			skema.setGaji_wali1(Integer.parseInt(gaji_wali1));
		}
		else{
			skema.setGaji_wali1(0);
		}
		
		if(gaji_wali2.equals("") == false){
			skema.setGaji_wali2(Integer.parseInt(gaji_wali2));
		}
		else{
			skema.setGaji_wali2(0);
		}
		
		if(nilai_tagihan_air.equals("") == false){
			skema.setNilai_tagihan_air(Integer.parseInt(nilai_tagihan_air));
		}
		else{
			skema.setNilai_tagihan_air(0);
		}
		
		if(nilai_tagihan_listrik.equals("") == false){
			skema.setNilai_tagihan_listrik(Integer.parseInt(nilai_tagihan_listrik));
		}
		else{
			skema.setNilai_tagihan_listrik(0);
		}
		
		if(nilai_tagihan_telepon.equals("") == false){
			skema.setNilai_tagihan_telepon(Integer.parseInt(nilai_tagihan_telepon));
		}
		else{
			skema.setNilai_tagihan_telepon(0);
		}
		
		storeFile(surat_keterangan_rtrw, 1);
		storeFile(foto_rumah, 2);
		storeFile(slip_gaji_pribadi, 3);
		storeFile(slip_gaji_wali1, 4);
		storeFile(slip_gaji_wali2, 5);
		storeFile(tagihan_air, 6);
		storeFile(tagihan_listrik, 7);
		storeFile(tagihan_telepon, 8);
		
		
//		Random rand = new Random();
//		int num = rand.nextInt(1000000) + 1;
//		
//		if(surat_keterangan_rtrw.isEmpty() == false){	
//		    String fileContentType = surat_keterangan_rtrw.getContentType();
//		    if(contentTypes.contains(fileContentType)) {
//				storageService.store(surat_keterangan_rtrw, num + "-1");
//				
//				//SURAT KETERANGAN RT RW UPLOAD //
//		        String pathDB1 = storageService.load(surat_keterangan_rtrw.getOriginalFilename()).toString();
//		        
//		        Path data1 = storageService.load(surat_keterangan_rtrw.getOriginalFilename());
//		        String pdb1 = MvcUriComponentsBuilder
//		                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-1-" + data1.getFileName().toString())
//		                .build().toString();
//		        
//		        skema.setSurat_keterangan_rtrw(pdb1);
//		    } else {
//		    	return "calon_mahasiswa-salah_file_pengajuan";
//		    }
//		}
//		else{
//			if(psbs.selectPSBMFromUsername(mahasiswa.getUsername()) != null){
//				skema.setSurat_keterangan_rtrw(psbs.selectPSBMFromUsername(mahasiswa.getUsername()).getSurat_keterangan_rtrw());
//			}
//			else{
//				return "calon_mahasiswa-salah_file_pengajuan";
//			}
//		}
//		
//		if(foto_rumah.isEmpty() == false){
//		    String fileContentType = foto_rumah.getContentType();
//		    if(contentTypes.contains(fileContentType)) {
//				storageService.store(foto_rumah, num + "-2");
//				
//		        //FOTO RUMAH//
//		        String pathDB2 = storageService.load(foto_rumah.getOriginalFilename()).toString();
//		        
//		        Path data2 = storageService.load(foto_rumah.getOriginalFilename());
//		        String pdb2 = MvcUriComponentsBuilder
//		                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-2-" + data2.getFileName().toString())
//		                .build().toString();
//		        
//		        skema.setFoto_rumah(pdb2);
//		    } else {
//		    	return "calon_mahasiswa-salah_file_pengajuan";
//		    }
//		}
//		else {
//			skema.setFoto_rumah("no_data");
//		}
//		
//		if(slip_gaji_pribadi.isEmpty() == false){
//			storageService.store(slip_gaji_pribadi, num + "-3");
//			
//	        //SLIP GAJI PRIBADI//
//	        String pathDB3 = storageService.load(slip_gaji_pribadi.getOriginalFilename()).toString();
//	        
//	        Path data3 = storageService.load(slip_gaji_pribadi.getOriginalFilename());
//	        String pdb3 = MvcUriComponentsBuilder
//	                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-3-" + data3.getFileName().toString())
//	                .build().toString();
//	        
//	        skema.setSlip_gaji_pribadi(pdb3);
//		}
//		else{
//			skema.setSlip_gaji_pribadi("no_data");
//		}
//		
//		if(slip_gaji_wali1.isEmpty() == false)
//		{
//			storageService.store(slip_gaji_wali1, num + "-4");
//			
//	        //SLIP GAJI WALI 1//
//	        String pathDB4 = storageService.load(slip_gaji_wali1.getOriginalFilename()).toString();
//	        
//	        Path data4 = storageService.load(slip_gaji_wali1.getOriginalFilename());
//	        String pdb4 = MvcUriComponentsBuilder
//	                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-4-" + data4.getFileName().toString())
//	                .build().toString();
//	        
//	        skema.setSlip_gaji_wali1(pdb4);
//		}
//		else{
//			skema.setSlip_gaji_wali1("no_data");
//		}
//		
//		if(slip_gaji_wali2.isEmpty() == false)
//		{
//			storageService.store(slip_gaji_wali2, num + "-5");
//			
//	        //SLIP GAJI WALI 2//
//	        String pathDB5 = storageService.load(slip_gaji_wali2.getOriginalFilename()).toString();
//	        
//	        Path data5 = storageService.load(slip_gaji_wali2.getOriginalFilename());
//	        String pdb5 = MvcUriComponentsBuilder
//	                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-5-" + data5.getFileName().toString())
//	                .build().toString();
//	        
//	        skema.setSlip_gaji_wali2(pdb5);
//		}
//		else{
//			skema.setSlip_gaji_wali2("no_data");
//		}
//			
//		
//		if(tagihan_air.isEmpty() == false)
//		{
//			storageService.store(tagihan_air, num + "-6");
//			
//	        //TAGIHAN AIR//
//	        String pathDB6 = storageService.load(tagihan_air.getOriginalFilename()).toString();
//	        
//	        Path data6 = storageService.load(tagihan_air.getOriginalFilename());
//	        String pdb6 = MvcUriComponentsBuilder
//	                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-6-" + data6.getFileName().toString())
//	                .build().toString();
//	        
//	        skema.setTagihan_air(pdb6);
//		}
//		else{
//			skema.setTagihan_air("no_data");
//		}
//		
//		if(tagihan_listrik.isEmpty() == false)
//		{
//			storageService.store(tagihan_listrik, num + "-7");
//			
//	        //TAGIHAN LISTRIK//
//	        String pathDB7 = storageService.load(tagihan_listrik.getOriginalFilename()).toString();
//	        
//	        Path data7 = storageService.load(tagihan_listrik.getOriginalFilename());
//	        String pdb7 = MvcUriComponentsBuilder
//	                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-7-" + data7.getFileName().toString())
//	                .build().toString();
//	        
//	        skema.setTagihan_listrik(pdb7);
//		}
//		else{
//			skema.setTagihan_listrik("no_data");
//		}
//		
//		if(tagihan_telepon.isEmpty() == false)
//		{
//			storageService.store(tagihan_telepon, num + "-8");
//			
//	        //TAGIHAN TELEPON//
//	        String pathDB8 = storageService.load(tagihan_telepon.getOriginalFilename()).toString();
//	        
//	        Path data8 = storageService.load(tagihan_telepon.getOriginalFilename());
//	        String pdb8 = MvcUriComponentsBuilder
//	                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-8-" + data8.getFileName().toString())
//	                .build().toString();
//	        
//	        skema.setTagihan_telepon(pdb8);
//		}
//		else{
//			skema.setTagihan_telepon("no_data");
//		}
        
		
		if(fileError == true)
		{
			return "calon_mahasiswa-salah_file_pengajuan";
		}
		
		//INSERT OR UPDATE//
		if(psbs.selectPSBMFromUsername(mahasiswa.getUsername()) == null)
		{
			//insert new pengajuan
			psbs.insertPSBM(skema);
		}
		else
		{
			//update existing pengajuan
			psbs.updatePSBM(skema);
		}
		
		PengajuanSkemaBiayaModel psbm = psbs.selectPSBMFromUsername(mahasiswa.getUsername());
		RumpunModel rumpun = rm.getRumpun(mahasiswa.getUsername());
		SkemaBiayaModel sbm = sbs.selectSBM(psbm.getGolongan_id());
		model.addAttribute("mahasiswa", mahasiswa);	
		model.addAttribute("psbm", psbm);
		model.addAttribute("sbm", sbm);
		model.addAttribute("rumpun", rumpun);
		return "calon_mahasiswa-melihat_skema_pembayaran";
	}
	
	@RequestMapping("/skema-pembayaran/no_data")
	public String noData(){
		return "error";
	}
	
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
	
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
    
    public void storeFile(MultipartFile file, int type)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByUsername(user);
    	Random rand = new Random();
		int num = rand.nextInt(1000000) + 1;
		
    	if(file.isEmpty() == false){	
    		String fileContentType = file.getContentType();
    		
    		if(contentTypes.contains(fileContentType)) {
    			storageService.store(file, num + "-1");
    			
    			String path = storageService.load(file.getOriginalFilename()).toString();
    			
    			Path data = storageService.load(file.getOriginalFilename());
    			String dbURL = MvcUriComponentsBuilder
    					.fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", num + "-" + type + "-" + data.getFileName().toString())
    					.build().toString();
    			
    			if(type == 1) {skema.setSurat_keterangan_rtrw(dbURL);}
    			if(type == 2) {skema.setFoto_rumah(dbURL);}
    			if(type == 3) {skema.setSlip_gaji_pribadi(dbURL);}
    			if(type == 4) {skema.setSlip_gaji_wali1(dbURL);}
    			if(type == 5) {skema.setSlip_gaji_wali2(dbURL);}
    			if(type == 6) {skema.setTagihan_air(dbURL);}
    			if(type == 7) {skema.setTagihan_listrik(dbURL);}
    			if(type == 8) {skema.setTagihan_telepon(dbURL);}
    			
    		} else {
    			//triggering return "calon_mahasiswa-salah_file_pengajuan";
    			fileError = true;
    		}
    	}
    	else{
    		//for update
    		if(psbs.selectPSBMFromUsername(mahasiswa.getUsername()) != null){
    			PengajuanSkemaBiayaModel tmp = psbs.selectPSBMFromUsername(mahasiswa.getUsername());
//    			if(type == 1) {skema.setSurat_keterangan_rtrw(tmp.getSurat_keterangan_rtrw());}
//    			if(type == 2) {skema.setFoto_rumah(tmp.getFoto_rumah());}
//    			if(type == 3) {skema.setSlip_gaji_pribadi(tmp.getSlip_gaji_pribadi());}
//    			if(type == 4) {skema.setSlip_gaji_wali1(tmp.getSlip_gaji_wali1());}
//    			if(type == 5) {skema.setSlip_gaji_wali2(tmp.getSlip_gaji_wali2());}
//    			if(type == 6) {skema.setTagihan_air(tmp.getTagihan_air());}
//    			if(type == 7) {skema.setTagihan_listrik(tmp.getTagihan_listrik());}
//    			if(type == 8) {skema.setTagihan_telepon(tmp.getTagihan_telepon());}
    			
    			if(type == 1) {skema.setSurat_keterangan_rtrw("no_data");}
    			if(type == 2) {skema.setFoto_rumah("no_data");}
    			if(type == 3) {skema.setSlip_gaji_pribadi("no_data");}
    			if(type == 4) {skema.setSlip_gaji_wali1("no_data");}
    			if(type == 5) {skema.setSlip_gaji_wali2("no_data");}
    			if(type == 6) {skema.setTagihan_air("no_data");}
    			if(type == 7) {skema.setTagihan_listrik("no_data");}
    			if(type == 8) {skema.setTagihan_telepon("no_data");}
    		}
    		//for insert
    		else{
    			//triggering return "calon_mahasiswa-salah_file_pengajuan";
    			if( type == 1 ||
    				type == 2 ||
    				type == 6 ||
    				type == 7 ||
    				type == 8)
    			{
        			fileError = true;
    			}
    			else
    			{
    				if(type == 3) {skema.setSlip_gaji_pribadi("no_data");}
        			if(type == 4) {skema.setSlip_gaji_wali1("no_data");}
        			if(type == 5) {skema.setSlip_gaji_wali2("no_data");}
    			}
    		}
    	}
    }		
}