package id.ac.univ.regismaba.model;

import java.util.Date;

import lombok.Data;

@Data
public class AssignJadwalModel {
	int fakultas_id;
	FakultasModel fakultas;
	String npm;
	int jadwal_registrasi_id;
	JadwalRegisModel jadwalRegis;
	int jadwal_tes_kesehatan_id;
	JadwalKesehatanModel jadwalTesKes;
	int jadwal_ept_id;
	JadwalEptModel jadwalEpt;
	Date created_at;
    Date updated_at;
    String created_by;
    String updated_by;
}
