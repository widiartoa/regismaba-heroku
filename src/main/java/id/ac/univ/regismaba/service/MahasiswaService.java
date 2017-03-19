package id.ac.univ.regismaba.service;

<<<<<<< HEAD
import id.ac.univ.regismaba.model.MahasiswaModel;

public interface MahasiswaService {
	MahasiswaModel loginMahasiswa (String username, String password);
=======
import java.util.List;

import id.ac.univ.regismaba.model.MahasiswaModel;

public interface MahasiswaService {

	MahasiswaModel selectMahasiswa(String npm);
	
	List<MahasiswaModel> selectAllMahasiswa();
	
	void insertBiodataMahasiswa(String npm, String biodata_id);
	
	void insertJenjangMahasiswa(String npm, String jenjang_id);
	
	void insertPengajuanMahasiswa(String npm, String pengajuan_id);
	
	void updateBiodataMahasiswa(String npm, String biodata_id);
	
	void updateJenjangMahasiswa(String npm, String jenjang_id);
	
	void updatePengajuanMahasiswa(String npm, String pengajuan_id);
	
>>>>>>> 7589d95d5efeb4ff08535a26000633719edd8d8b
}
