package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.AgamaModel;

@Mapper
public interface AgamaMapper {
	@Select("SELECT * FROM agama WHERE agama_id=#{agama_id}")
	@Results(value = {
		@Result(property="nama_agama", column="nama_agama"),
	})
	AgamaModel selectAgama(int agama_id);
	
}
