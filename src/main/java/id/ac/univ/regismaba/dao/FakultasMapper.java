package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.FakultasModel;

@Mapper
public interface FakultasMapper {
	
	@Select("select * from fakultas")
	List<FakultasModel> selectAllFakultas();
	
}