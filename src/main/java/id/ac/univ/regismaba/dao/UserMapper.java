package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.UserModel;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE username=#{username}")
	@Results(value = {
		@Result(property="id_role", column="id_role"),
		@Result(property="nama_lengkap", column="nama_lengkap"),
		@Result(property="email", column="email"),
	})
	UserModel selectUser(String username);
	
	@Select("SELECT * FROM staf S LEFT JOIN user U ON S.username=U.username WHERE nip=#{nip}")
	UserModel selectUserStafbyNIP(String nip);
}
