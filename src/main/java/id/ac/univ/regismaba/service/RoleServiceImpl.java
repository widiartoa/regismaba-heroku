package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.RoleMapper;
import id.ac.univ.regismaba.model.RoleModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleMapper rm;
	
	@Override
	public RoleModel selectRole(int role_id) {
		// TODO Auto-generated method stub
		log.info ("select peran with id {}", role_id);
		return rm.selectRole(role_id);
	}

	@Override
	public List<RoleModel> selectAllRoles() {
		// TODO Auto-generated method stub
		log.info ("select peran");
		return rm.selectAllRoles();
	}
}
