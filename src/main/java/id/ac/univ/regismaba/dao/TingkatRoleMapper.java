package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.TingkatRoleModel;

@Mapper
public interface TingkatRoleMapper {

	@Select("select * from tingkat_role where tingkat_role_id=#{tingkat_role_id}")
	TingkatRoleModel selectTRM(@Param("tingkat_role_id") int tingkat_role_id);

	@Select("select * from tingkat_role")
	List<TingkatRoleModel> selectAllTRM();
}
