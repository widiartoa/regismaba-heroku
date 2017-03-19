package id.ac.univ.regismaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.univ.regismaba.model.IjazahModel;
import id.ac.univ.regismaba.service.BiodataService;
import id.ac.univ.regismaba.service.IjazahService;

@Controller
public class BiodataController
{
    @Autowired
    IjazahService ijazahDAO;
    
    @Autowired
    BiodataService biodataDAO;
    
    @RequestMapping("/biodata/fill")
    public String insert()
    {
            return "calon_mahasiswa-mengisi_idm";
    }
    
    @RequestMapping("/biodata/fill/submit")
    public String insertBiodata(
            @RequestParam(value = "nomor_ijazah", required = false) String nomor_ijazah,
            @RequestParam(value = "nama_institusi", required = false) String nama_institusi,
            @RequestParam(value = "jenjang", required = false) String jenjang,
            @RequestParam(value = "scan_ijazah", required = false) String scan_ijazah,
            @RequestParam(value = "scan_pernyataan_ijazah", required = false) String scan_pernyataan_ijazah)
    {
        IjazahModel ijazah = new IjazahModel(nomor_ijazah, nama_institusi, jenjang, scan_ijazah, scan_pernyataan_ijazah);
        ijazahDAO.addIjazah (ijazah);
        return "calon_mahasiswa-mengisi_idm";
    }

//    @RequestMapping("/biodata/{biodata_id}")
//    public String viewBiodata (Model model,
//            @PathVariable(value = "biodata_id") int biodata_id)
//    {
//        IjazahModel ijazah = ijazahDAO.selectIjazah (nomor_ijazah);
//        return "calon_mahasiswa-melihat_idm";
//    }
//    
//    @RequestMapping("/univ/{kode_univ}")
//    public String viewUnivPath (Model model,
//            @PathVariable(value = "kode_univ") String kode_univ)
//    {
//        UniversityModel university = pageDAO.selectDetailUniversity (kode_univ);
//
//        if (university != null) {
//            model.addAttribute ("university", university);
//            model.addAttribute ("prodis", university.getProdis ());
//            return "viewUniversity";
//        } else {
//            model.addAttribute ("kode_univ", kode_univ);
//            return "not-found-university";
//        }
//    }
}
