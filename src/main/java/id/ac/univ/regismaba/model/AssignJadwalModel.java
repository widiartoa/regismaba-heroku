package id.ac.univ.regismaba.model;

import java.util.Date;

import lombok.Data;

@Data
public class AssignJadwalModel {
	int fakultas_id;
	String npm;
	int jadwal_registrasi_id;
	int jadwal_tes_kesehatan_id;
	int jadwal_ept_id;
	Date created_at;
    Date updated_at;
    String created_by;
    String updated_by;
}
