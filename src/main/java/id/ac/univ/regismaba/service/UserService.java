package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.UserModel;

public interface UserService {
	UserModel selectUser(String username);
}
