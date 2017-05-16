package id.ac.univ.regismaba.model;

import lombok.Data;
import java.util.Date;

@Data
public class JadwalRegisModel {
	int jadwal_registrasi_id;
	Date timestamp_awal;
	Date timestamp_akhir;
	String tanggal;
	String hari;
	String waktu_awal;
	String waktu_akhir;
	String fakultas;
	int kapasitas;
	String created_by;
	Date created_at;
	String updated_by;
	Date updated_at;
	int tahun_ajaran_id;
	int status_aktif;
}

