package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.FakultasModel;

@Mapper
public interface FakultasMapper {
	
	@Select("select * from fakultas")
	List<FakultasModel> selectAllFakultas();
	
	@Select("select * from fakultas where fakultas_id = #{fakultas_id}")
	FakultasModel selectFakultas(@Param("fakultas_id") int fakultas_id);
	
}