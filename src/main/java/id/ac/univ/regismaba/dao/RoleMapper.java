package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.RoleModel;

@Mapper
public interface RoleMapper {

	@Select("select * from role where id_role=#{id_role}")
	RoleModel selectRole(@Param("id_role") int id_role);
	
	@Select("select * from role")
	List<RoleModel> selectAllRoles();
}
