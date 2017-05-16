package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.DataKesehatanModel;

@Mapper
public interface DataKesehatanMapper {
	
	@Select("select data_kesehatan_id from data_kesehatan where form_survey_kesehatan = #{form_survey_kesehatan} and hasil_tes_kesehatan = #{hasil_tes_kesehatan}")
	@Results (value = {
				@Result(property="data_kesehatan_id", column="data_kesehatan_id")
	})
	int selectDataKesehatanId(DataKesehatanModel dataKesehatan);
	
	@Insert("insert into data_kesehatan(data_kesehatan_id, username, form_survey_kesehatan, hasil_tes_kesehatan,"
			+ "created_by, updated_by, updated_at) values (#{data_kesehatan_id}, #{username}, #{form_survey_kesehatan},"
			+ "#{hasil_tes_kesehatan}, #{created_by}, #{updated_by}, #{updated_at})")
	void insertDataKesehatan(DataKesehatanModel dataKesehatan);
	
	
	@Select("SELECT * FROM data_kesehatan WHERE username=#{username}")
	@Results(value = {
		@Result(property="data_kesehatan_id", column="data_kesehatan_id"),
		@Result(property="form_survey_kesehatan", column="form_survey_kesehatan"),
		@Result(property="hasil_tes_kesehatan", column="hasil_tes_kesehatan"),
		@Result(property="created_by", column="created_by"),
		@Result(property="created_at", column="created_at"),
		@Result(property="updated_by", column="updated_by"),
		@Result(property="updated_at", column="updated_at"),
	})
	DataKesehatanModel selectDataKesehatanByUsername(String username);
	
	
	@Update("UPDATE data_kesehatan SET data_kesehatan_id=#{data_kesehatan_id}, username=#{username},"
			+ "form_survey_kesehatan=#{form_survey_kesehatan}, hasil_tes_kesehatan=#{hasil_tes_kesehatan},"
			+ "updated_by=#{updated_by}, updated_at=#{updated_at} WHERE username=#{username}")
	void updateDataKesehatan(DataKesehatanModel dataKesehatan);
	
}

