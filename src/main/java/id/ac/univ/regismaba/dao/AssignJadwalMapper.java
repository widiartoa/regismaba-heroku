package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.AssignJadwalModel;

@Mapper
public interface AssignJadwalMapper {

	@Select("select * from assign_jadwal where npm = #{npm}")
	AssignJadwalModel selectAssignJadwal(@Param("npm") String npm);
	
	@Select("select * from assign_jadwal where tahun_ajaran_id = #{tahun_ajaran_id}")
	List<AssignJadwalModel> selectAllAssignJadwal(@Param("tahun_ajaran_id") int tahun_ajaran_id);
	
}
