package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.UserMapper;
import id.ac.univ.regismaba.model.UserModel;

@Service
public class UserServiceImplement implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserModel selectUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(username);
	}

	@Override
	public UserModel selectUserStafbyNIP(String nip) {
		// TODO Auto-generated method stub
		return null;
	}

}
