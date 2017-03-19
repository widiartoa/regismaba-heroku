package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;

import id.ac.univ.regismaba.model.MahasiswaModel;

@Mapper
public interface MahasiswaMapper {
	@Select("SELECT username FROM user WHERE username = #{username} AND password = MD5(#{password}) AND id_role = '1'")
	@Results(value = {
		@Result(property="username", column="username")
	})
    MahasiswaModel loginMahasiswa (@Param("username") String username, @Param("password") String password);
}
