package id.ac.univ.regismaba.controller;

import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;
import id.ac.univ.regismaba.service.SkemaBiayaService;
import id.ac.univ.regismaba.storage.StorageFileNotFoundException;
import id.ac.univ.regismaba.storage.StorageService;

@Controller
public class PengajuanSkemaBiayaController {

	private final StorageService storageService;
	
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
	
	@RequestMapping("/calon-mahasiswa/skema-pembayaran")
	public String skemaMahasiswa(Model model)
	{
		//hardcode first psbm
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswa("1234567890");
		
		int pengajuanId = mahasiswa.getPengajuan_id();
		
		PengajuanSkemaBiayaModel psbm = psbs.selectPSBM(pengajuanId);
		
		model.addAttribute("mahasiswa", mahasiswa);
		
		model.addAttribute("psbm", psbm);
		
		return "calon_mahasiswa-melihat_skema_pembayaran";
	}
	
	@RequestMapping("/calon-mahasiswa/pengajuan-skema")
	public String pengajuanSkemaMahasiswa(Model model)
	{
		List<SkemaBiayaModel> schemas = sbs.selectAllSBM();
		
		for(int i = 0; i < schemas.size(); i++)
		{
			System.out.println(schemas.get(i).getGolongan_id());
		}
		
		model.addAttribute("schemas", schemas);
		
		return "calon_mahasiswa-pengajuan_skema_pembayaran";
	}
	
	@PostMapping("/calon-mahasiswa/pengajuan-skema/submit")
	public String pengajuanSkemaMahasiswaSubmit(Model model, 
												@RequestParam("golongan_id") int golongan_id,
												@RequestParam("surat_keterangan_rtrw") MultipartFile surat_keterangan_rtrw,
												@RequestParam("foto_rumah") MultipartFile foto_rumah,
												@RequestParam("slip_gaji_pribadi") MultipartFile slip_gaji_pribadi,
												@RequestParam("slip_gaji_wali1") MultipartFile slip_gaji_wali1,
												@RequestParam("slip_gaji_wali2") MultipartFile slip_gaji_wali2,
												@RequestParam("tagihan_air") MultipartFile tagihan_air,
												@RequestParam("tagihan_listrik") MultipartFile tagihan_listrik,
												@RequestParam("tagihan_telepon") MultipartFile tagihan_telepon)
	{
		MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswa("1234567890");
		PengajuanSkemaBiayaModel skema = new PengajuanSkemaBiayaModel();
		
		skema.setGolongan_id(golongan_id);
		
		storageService.store(surat_keterangan_rtrw);
		storageService.store(foto_rumah);
		storageService.store(slip_gaji_pribadi);
		storageService.store(slip_gaji_wali1);
		storageService.store(slip_gaji_wali2);
		storageService.store(tagihan_air);
		storageService.store(tagihan_listrik);
		storageService.store(tagihan_telepon);
		
		//SURAT KETERANGAN RT RW UPLOAD//
        String pathDB1 = storageService.load(surat_keterangan_rtrw.getOriginalFilename()).toString();
        
        Path data1 = storageService.load(surat_keterangan_rtrw.getOriginalFilename());
        String pdb1 = MvcUriComponentsBuilder
                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", data1.getFileName().toString())
                .build().toString();
        
        skema.setSurat_keterangan_rtrw(pdb1);
        
        //FOTO RUMAH//
        String pathDB2 = storageService.load(foto_rumah.getOriginalFilename()).toString();
        
        Path data2 = storageService.load(foto_rumah.getOriginalFilename());
        String pdb2 = MvcUriComponentsBuilder
                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", data2.getFileName().toString())
                .build().toString();
        
        skema.setFoto_rumah(pdb2);
        
        //SLIP GAJI PRIBADI//
        String pathDB3 = storageService.load(slip_gaji_pribadi.getOriginalFilename()).toString();
        
        Path data3 = storageService.load(slip_gaji_pribadi.getOriginalFilename());
        String pdb3 = MvcUriComponentsBuilder
                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", data3.getFileName().toString())
                .build().toString();
        
        skema.setSlip_gaji_pribadi(pdb3);
        
        //SLIP GAJI WALI 1//
        String pathDB4 = storageService.load(slip_gaji_wali1.getOriginalFilename()).toString();
        
        Path data4 = storageService.load(slip_gaji_wali1.getOriginalFilename());
        String pdb4 = MvcUriComponentsBuilder
                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", data4.getFileName().toString())
                .build().toString();
        
        skema.setSlip_gaji_wali1(pdb4);
        
        //SLIP GAJI WALI 2//
        String pathDB5 = storageService.load(slip_gaji_wali2.getOriginalFilename()).toString();
        
        Path data5 = storageService.load(slip_gaji_wali2.getOriginalFilename());
        String pdb5 = MvcUriComponentsBuilder
                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", data5.getFileName().toString())
                .build().toString();
        
        skema.setSlip_gaji_wali2(pdb5);
        
        //TAGIHAN AIR//
        String pathDB6 = storageService.load(tagihan_air.getOriginalFilename()).toString();
        
        Path data6 = storageService.load(tagihan_air.getOriginalFilename());
        String pdb6 = MvcUriComponentsBuilder
                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", data6.getFileName().toString())
                .build().toString();
        
        skema.setTagihan_air(pdb6);
        
        //TAGIHAN LISTRIK//
        String pathDB7 = storageService.load(tagihan_listrik.getOriginalFilename()).toString();
        
        Path data7 = storageService.load(tagihan_listrik.getOriginalFilename());
        String pdb7 = MvcUriComponentsBuilder
                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", data7.getFileName().toString())
                .build().toString();
        
        skema.setTagihan_listrik(pdb7);
        
        //TAGIHAN TELEPON//
        String pathDB8 = storageService.load(tagihan_telepon.getOriginalFilename()).toString();
        
        Path data8 = storageService.load(tagihan_telepon.getOriginalFilename());
        String pdb8 = MvcUriComponentsBuilder
                .fromMethodName(PengajuanSkemaBiayaController.class, "serveFile", data8.getFileName().toString())
                .build().toString();
        
        skema.setTagihan_telepon(pdb8);
        
		//INSERT OR UPDATE//
		if(mahasiswa.getPengajuan_id() == 0)
		{
			//insert new pengajuan
			psbs.insertPSBM(skema);
		}
		else
		{
			//update existing pengajuan
			psbs.updatePSBM(skema);
		}
		
		mahasiswa = mahasiswaService.selectMahasiswa("1234567890");
		
		int pengajuanId = mahasiswa.getPengajuan_id();
		
		PengajuanSkemaBiayaModel psbm = psbs.selectPSBM(pengajuanId);
		
		model.addAttribute("mahasiswa", mahasiswa);
		
		model.addAttribute("psbm", psbm);
		
		return "calon_mahasiswa-melihat_skema_pembayaran";
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
}