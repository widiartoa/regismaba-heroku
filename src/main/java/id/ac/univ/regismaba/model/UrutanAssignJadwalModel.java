package id.ac.univ.regismaba.model;

import java.util.Date;

import lombok.Data;

@Data
public class UrutanAssignJadwalModel {
	int urutan_assign_jadwal_id;
	int fakultas_id;
	int tahun_ajaran_id;
	Date created_at;
    Date updated_at;
    String created_by;
    String updated_by;
}
