package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.RoleModel;

public interface RoleService {

	RoleModel selectRole(int role_id);
	
	List<RoleModel> selectAllRoles();
}
