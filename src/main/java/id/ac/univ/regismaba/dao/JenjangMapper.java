package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.JenjangModel;

@Mapper
public interface JenjangMapper {
	@Select("select jenjang_id, nama_jenjang from jenjang")
	List<JenjangModel> selectAllJenjang();
	
	@Select("SELECT * FROM jenjang WHERE jenjang_id=#{jenjang_id}")
	@Results(value = {
		@Result(property="nama_jenjang", column="nama_jenjang"),
	})
	JenjangModel selectJenjang(int jenjang_id);
}
