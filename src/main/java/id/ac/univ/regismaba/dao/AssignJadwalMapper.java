package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.AssignJadwalModel;

@Mapper
public interface AssignJadwalMapper {

	@Select("select * from assign_jadwal where npm = #{npm}")
	AssignJadwalModel selectAssignJadwal(@Param("npm") String npm);
	
}
