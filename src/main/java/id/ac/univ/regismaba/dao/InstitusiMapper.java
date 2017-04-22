package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.InstitusiModel;

@Mapper
public interface InstitusiMapper {
	@Select("SELECT * FROM institusi WHERE institusi_id=#{institusi_id}")
	@Results(value = {
		@Result(property="nama_institusi", column="nama_institusi"),
		@Result(property="tingkat_pendidikan_id", column="tingkat_pendidikan_id"),
	})
	InstitusiModel selectInstitusi(int institusi_id);
}
