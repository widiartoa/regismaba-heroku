package id.ac.univ.regismaba.model;

import lombok.Data;

@Data

public class MahasiswaModel {

	String username;
	String npm;
	String uid_sso;
	int jenjang_id;
	String no_seleksi;
	int jadwal_registrasi_id;
	int jadwal_tes_kesehatan_id;
	int jadwal_ept_id;
	
}
