package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.UserMapper;
import id.ac.univ.regismaba.model.UserModel;

@Service
public class UserServiceImplement implements UserService{

        @Autowired
	UserMapper userMapper;
	
	@Autowired
	RoleService roleDAO;
	
	@Autowired
	TingkatRoleService tingkatRoleDAO;
	
	@Override
	public UserModel selectUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(username);
	}

	@Override
	public UserModel selectUserStafbyNIP(String nip) {
		// TODO Auto-generated method stub
		UserModel staf = userMapper.selectUserStafbyNIP(nip);
		
		staf.setRole(roleDAO.selectRole(staf.getId_role()));
		staf.setTingkat_role(tingkatRoleDAO.selectTRM(staf.getRole().getTingkat_role_id()));
		
		return staf;
	}

}
