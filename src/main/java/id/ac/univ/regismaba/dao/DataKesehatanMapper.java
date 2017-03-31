package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.DataKesehatanModel;

@Mapper
public interface DataKesehatanMapper {
	
	@Select("select data_kesehatan_id from data_kesehatan where form_survey_kesehatan = #{form_survey_kesehatan} and hasil_tes_kesehatan = #{hasil_tes_kesehatan}")
	@Results (value = {
				@Result(property="data_kesehatan_id", column="data_kesehatan_id")
	})
	int selectDataKesehatanId(DataKesehatanModel dataKesehatan);
	
	@Insert("insert into data_kesehatan(form_survey_kesehatan, hasil_tes_kesehatan) values (#{form_survey_kesehatan}, #{hasil_tes_kesehatan})")
	void insertDataKesehatan(DataKesehatanModel dataKesehatan);
	
}
