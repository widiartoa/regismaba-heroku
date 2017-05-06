package id.ac.univ.regismaba.model;

import lombok.Data;

@Data
public class RoleModel {
	int id_role;
	String nama_role;
	int flag_aktif;
	int tingkat_role_id;
	int fakultas_id;
}
