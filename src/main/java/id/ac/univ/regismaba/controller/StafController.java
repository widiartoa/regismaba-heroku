package id.ac.univ.regismaba.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.net.URL;
import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.boot.json.GsonJsonParser;

import id.ac.univ.regismaba.model.AlamatModel;
import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.model.IjazahModel;
import id.ac.univ.regismaba.model.InstitusiModel;
import id.ac.univ.regismaba.model.KotaKabupatenModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.model.ProvinsiModel;
import id.ac.univ.regismaba.model.RumpunModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.model.UserModel;
import id.ac.univ.regismaba.service.AlamatService;
import id.ac.univ.regismaba.service.EmailService;
import id.ac.univ.regismaba.service.MahasiswaService;
import id.ac.univ.regismaba.service.PengajuanSkemaBiayaService;
import id.ac.univ.regismaba.service.RumpunService;
import id.ac.univ.regismaba.service.SkemaBiayaService;
import id.ac.univ.regismaba.service.UserService;
import id.ac.univ.regismaba.service.VerifikasiIDMService;

@Controller
public class StafController
{

    @Autowired
    MahasiswaService mahasiswaDAO;

    @Autowired
    PengajuanSkemaBiayaService pengajuanSkemaBiayaDAO;

    @Autowired
    SkemaBiayaService sbs;

    @Autowired
    RumpunService rm;

    @Autowired
    VerifikasiIDMService verifikasiIdmDAO;

    @Autowired
    AlamatService alamatDAO;

    @Autowired
    UserService userDAO;

    @Autowired
    EmailService emailDAO;


    // TODO: Tambahkan @RequestMapping("/") setelah bisa ambil session
    // untuk Verifikator redirect:/staf_verifikasi/daftar_mhs
    // untuk Staf Registrasi redirect:/staf_registrasi/daftar_mhs
    // untuk Staf Kesehatan redirect:/staf_kesehatan/daftar_mhs
    // untuk Staf Kesejahteraan redirect:/staf_kesejahteraan/daftar_mhs

	@RequestMapping("/staf/login")
	public String loginStaf(Model model,
		@RequestParam(value = "username", required = true) String username,
		@RequestParam(value = "password", required = true) String password)
	{
		try {		
			HttpURLConnection con = (HttpURLConnection) new URL("https://sso.ui.ac.id/oauth/lockdin/token").openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			String param = "grant_type=password&client_id=dev-propensi-cs&client_secret=od5ifie3ueSeeshai9ohyoo9cha2ZuhueMoo0equ&username="+username+"&password="+password;
			con.getOutputStream().write(param.getBytes("UTF-8"));
			
			GsonJsonParser jsonParser = new GsonJsonParser();
			Scanner s = new Scanner(con.getInputStream()).useDelimiter("\\A");
			String resultTokenJSON = s.hasNext() ? s.next() : "";
			System.out.println(resultTokenJSON);
			Map<String, Object> resultTokenMap = jsonParser.parseMap(resultTokenJSON);
			String resultSessionId = resultTokenMap.get("access_token").toString();
			System.out.println(resultSessionId);

			HttpURLConnection conResource = (HttpURLConnection) new URL("https://sso.ui.ac.id/oauth/lockdin/resource?access_token="+resultSessionId).openConnection();
			conResource.setDoOutput(true);
			
			Scanner s2 = new Scanner(conResource.getInputStream()).useDelimiter("\\A");
			String resultResourceJSON = s2.hasNext() ? s2.next() : "";
			System.out.println(resultResourceJSON);
			Map<String, Object> resultResourceMap = jsonParser.parseMap(resultResourceJSON);
			String resultUserId = resultResourceMap.get("user_id").toString();
			System.out.println(resultUserId);
		}
		catch(Exception e){
			System.out.println("error "+e);
		}
		
		return "redirect:/";
	}
	
    @RequestMapping("/staf-verifikasi/daftar-mhs")
    public String daftarMhsVerifikator (Model model)
    {
        String usernameStaf = "anin.lia";
        String nipStaf = "0123456798";

        UserModel staf = userDAO.selectUserStafbyNIP (nipStaf);

        // select mhs by fakultas
        List<MahasiswaModel> mahasiswas;

        if (staf.getTingkat_role ().getTingkat_role_id () == 1) {
            mahasiswas = mahasiswaDAO.selectAllMahasiswa ();
        } else {
            mahasiswas = mahasiswaDAO
                    .selectAllMahasiswabyFakultasatTahunAjaran (
                            staf.getRole ().getFakultas_id ());
        }
        model.addAttribute ("mahasiswas", mahasiswas);
        List<BiodataModel> biodatas = verifikasiIdmDAO.selectAllBiodata ();
        model.addAttribute ("biodatas", biodatas);
        List<AlamatModel> alamats = verifikasiIdmDAO.selectAllAlamat ();
        model.addAttribute ("alamats", alamats);
        List<KotaKabupatenModel> kotakabs = verifikasiIdmDAO
                .selectAllKotaKab ();
        model.addAttribute ("kotakabs", kotakabs);
        List<ProvinsiModel> provinsis = verifikasiIdmDAO.selectAllProvinsi ();
        model.addAttribute ("provinsis", provinsis);
        List<IjazahModel> ijazahs = verifikasiIdmDAO.selectAllIjazah ();
        model.addAttribute ("ijazahs", ijazahs);
        List<InstitusiModel> institusis = verifikasiIdmDAO
                .selectAllInstitusi ();
        model.addAttribute ("institusis", institusis);
        List<DataKesehatanModel> dataKess = verifikasiIdmDAO
                .selectAllDataKesehatan ();
        model.addAttribute ("dataKess", dataKess);
        return "staf_verifikasi-daftar_mhs";
    }


    @RequestMapping("/staf-registrasi/daftar-mhs")
    public String daftarMhsRegistrasi (Model model)
    {
        List<MahasiswaModel> mahasiswas = mahasiswaDAO.selectAllMahasiswa ();
        model.addAttribute ("mahasiswas", mahasiswas);
        return "staf_registrasi-daftar_mhs";
    }


    @RequestMapping("/staf-kesehatan/daftar-mhs")
    public String daftarMhsKesehatan (Model model)
    {
        String usernameStaf = "wilson.mokoginta";
        String nipStaf = "0132456789";

        UserModel staf = userDAO.selectUserStafbyNIP (nipStaf);

        // select mhs by fakultas
        List<MahasiswaModel> mahasiswas;

        if (staf.getTingkat_role ().getTingkat_role_id () == 1) {
            mahasiswas = mahasiswaDAO.selectAllMahasiswa ();
        } else {
            mahasiswas = mahasiswaDAO
                    .selectAllMahasiswabyFakultasatTahunAjaran (
                            staf.getRole ().getFakultas_id ());
        }
        model.addAttribute ("mahasiswas", mahasiswas);
        List<DataKesehatanModel> dataKess = verifikasiIdmDAO
                .selectAllDataKesehatan ();
        model.addAttribute ("dataKess", dataKess);
        return "staf_kesehatan-daftar_mhs";
    }


    @RequestMapping("/staf-kesejahteraan/daftar-mhs")
    public String daftarMhsKesejahteraan (Model model)
    {
        String usernameStaf = "irsyadillah.nuralifa";
        String nipStaf = "0123546789";

        UserModel staf = userDAO.selectUserStafbyNIP (nipStaf);

        // select mhs by fakultas
        List<MahasiswaModel> mahasiswas;

        if (staf.getTingkat_role ().getTingkat_role_id () == 1) {
            mahasiswas = mahasiswaDAO.selectAllMahasiswa ();
        } else {
            mahasiswas = mahasiswaDAO
                    .selectAllMahasiswabyFakultasatTahunAjaran (
                            staf.getRole ().getFakultas_id ());
        }
        model.addAttribute ("mahasiswas", mahasiswas);
        List<PengajuanSkemaBiayaModel> pengajuans = pengajuanSkemaBiayaDAO
                .selectAllPSBM ();
        model.addAttribute ("pengajuans", pengajuans);
        if (mahasiswas.size () > 0) {
            RumpunModel[] rumpuns = new RumpunModel[pengajuans.size ()];
            for (int i = 0; i < rumpuns.length; i++) {
                rumpuns[i] = rm.getRumpun (pengajuans.get (i).getUsername ());
            }
            model.addAttribute ("rumpuns", rumpuns);
        }
        if (pengajuans.size () > 0) {
            SkemaBiayaModel[] skemas = new SkemaBiayaModel[pengajuans.size ()];
            for (int i = 0; i < skemas.length; i++) {
                skemas[i] = sbs
                        .selectSBM (pengajuans.get (i).getGolongan_id ());
            }
            model.addAttribute ("skemas", skemas);
        }

        List<SkemaBiayaModel> skemaList = sbs.selectAllSBM ();
        model.addAttribute ("skemaList", skemaList);

        return "staf_kesejahteraan-daftar_mhs";
    }


	@PostMapping("/staf-kesejahteraan/daftar-mhs/{npm}")
	public String daftarMhsKesejahteraanSubmitVerifikasiPembayaran(Model model, @PathVariable(value = "npm") String npm,
			@RequestParam(value = "status-pengajuan", required = true) String status_pengajuan,
			@RequestParam(value = "ubah-golongan", required = true) int golongan_id,
			@RequestParam(value = "ubah-uang", required = true) int uang,
			@RequestParam(value = "komentar", required = true) String komentar) {
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
		PengajuanSkemaBiayaModel psbm = pengajuanSkemaBiayaDAO.selectPSBMFromUsername(mahasiswa.getUsername());
		if (psbm != null) {
			psbm.setGolongan_id(golongan_id);
			psbm.setStatus_pengajuan(status_pengajuan);
			psbm.setUang_pangkal(uang);
			psbm.setKomentar(komentar);
			psbm.setUpdated_by(mahasiswa.getUsername()); // ntar update ke staff
			pengajuanSkemaBiayaDAO.updatePengajuan(psbm);
			return "redirect:/staf-kesejahteraan/daftar-mhs";
		} else {
			return "error";
		}
	}


    @RequestMapping("/staf-verifikasi/daftar-mhs/verified/{npm}")
    public String VerifyIDMModal (Model model,
            @PathVariable(value = "npm") String npm)
    {
        // status = "Verified";
        MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa (npm);
        verifikasiIdmDAO.updateStatusVerify (mahasiswa.getUsername ());
        model.addAttribute ("mahasiswa", mahasiswa);
        String emailUser = verifikasiIdmDAO
                .selectUserEmail (mahasiswa.getUsername ());
        model.addAttribute ("emailUser", emailUser);
        String contentEmail = "Dear " + mahasiswa.getNama_lengkap () + ",\n"
                + "\nSelamat telah menjadi mahasiswa baru Universitas Indonesia. Berikut ini akun SSO Anda selama menjadi mahasiswa Universitas Indonesia\n"
                + "Username: " + mahasiswa.getUsername () + "\nPassword: "
                + mahasiswa.getUsername () + "34567875\n"
                + "Setelah melakukan login, Anda dapat mengganti password tersebut.\n\n"
                + "Best regards,\n" + "C6 Developer Team\n" + "Universitas Indonesia";
        emailDAO.sendSimpleMessage (emailUser, "Akun SSO Universitas Indonesia", contentEmail);
        return "redirect:/staf-verifikasi/daftar-mhs";
    }


    @PostMapping("/staf-verifikasi/daftar-mhs/unverified/{npm}")
    public String unverifyDetailIDM (Model model,
            @PathVariable(value = "npm") String npm,
            @RequestParam(value = "komentar", required = true) String komentar)
    {
        MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa (npm);
        verifikasiIdmDAO.updateComment (mahasiswa.getUsername (), komentar);
        verifikasiIdmDAO.updateStatusUnverify (mahasiswa.getUsername ());
        String komentarAdded = verifikasiIdmDAO
                .selectKomentar (mahasiswa.getUsername ());
        model.addAttribute ("mahasiswa", mahasiswa);
        model.addAttribute ("komentarAdded", komentarAdded);
        return "redirect:/staf-verifikasi/daftar-mhs";
    }
}
