package id.ac.univ.regismaba.model;

import lombok.Data;

@Data
public class UserModel {

	String username;
	int id_role;
	String password;
	String nama_lengkap;
	String email;
	int flag_aktif;
	
}
