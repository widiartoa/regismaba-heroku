package id.ac.univ.regismaba.model;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class MahasiswaModel {

	String username;
	String npm;
	String nama_lengkap;
	String uid_sso;
	int program_studi_id;
	String no_seleksi;
	int jadwal_registrasi_id;
	int jadwal_tes_kesehatan_id;
	int jadwal_ept_id;
	BiodataModel biodata;
	ProgramStudiModel program_studi;
	String program;
	String fakultas;
	String jenjang;
	Timestamp created_at;
    Timestamp updated_at;
    String created_by;
    String updated_by;
	
}
