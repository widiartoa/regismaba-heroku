package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.MahasiswaModel;

public interface MahasiswaService {

	MahasiswaModel selectMahasiswa(String npm);
	
	MahasiswaModel selectMahasiswaByUsername(String username);
	
	MahasiswaModel loginMahasiswa (String username, String password);
	
	List<MahasiswaModel> selectAllMahasiswa();
		
	void insertBiodataMahasiswa(String npm, String biodata_id);
	
	void insertJenjangMahasiswa(String npm, String jenjang_id);
	
	void insertPengajuanMahasiswa(String npm, String pengajuan_id);
	
	void updateBiodataMahasiswa(String npm, String biodata_id);
	
	void updateJenjangMahasiswa(String npm, String jenjang_id);
	
	void updatePengajuanMahasiswa(String npm, String pengajuan_id);
}
