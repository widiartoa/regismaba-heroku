package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.AlamatModel;

@Mapper
public interface AlamatMapper {
	
	@Insert("insert into alamat(kota_kabupaten_id, jalan, kecamatan, kelurahan, kode_pos, created_by, updated_by, updated_at)"
			+ "values (#{kota_kabupaten_id}, #{jalan}, #{kecamatan}, #{kelurahan}, #{kode_pos}, #{created_by}, #{updated_by}, #{updated_at})")
	void insertAlamat(AlamatModel alamat);

	@Select("select jalan_id from alamat where kota_kabupaten_id = #{kota_kabupaten_id} and jalan = #{jalan} and kecamatan = #{kecamatan} and kelurahan = #{kelurahan} and kode_pos = #{kode_pos}")
	@Results (value = {
				@Result(property="jalan_id", column="jalan_id")
	})
	Integer selectJalanId(AlamatModel alamat);	
	
	@Select("SELECT * FROM ALAMAT WHERE jalan_id=#{jalan_id}")
	@Results(value = {
		@Result(property="kota_kabupaten_id", column="kota_kabupaten_id"),    
		@Result(property="jalan", column="jalan"),
		@Result(property="kecamatan", column="kecamatan"),
		@Result(property="kelurahan", column="kelurahan"),
		@Result(property="kode_pos", column="kode_pos"),
		@Result(property="created_by", column="created_by"),
		@Result(property="created_at", column="created_at"),
		@Result(property="updated_by", column="updated_by"),
		@Result(property="updated_at", column="updated_at"),
		@Result(property="agama_id", column="agama_id"),			
	})
	AlamatModel selectAlamat(int jalan_id);
}
