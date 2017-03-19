package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.AlamatModel;

@Mapper
public interface AlamatMapper {
	
	@Insert("insert into alamat(kota_kabupaten_id, jalan, kecamatan, kelurahan, kode_pos) values (#{kota_kabupaten_id}, #{jalan}, #{kecamatan}, #{kelurahan}, #{kode_pos})")
	void insertAlamat(AlamatModel alamat);

	@Select("select jalan_id from alamat where kota_kabupaten_id = #{kota_kabupaten_id} and jalan = #{jalan} and kecamatan = #{kecamatan} and kelurahan = #{kelurahan} and kode_pos = #{kode_pos}")
	@Results (value = {
				@Result(property="jalan_id", column="jalan_id")
	})
	Integer selectJalanId(AlamatModel alamat);	
}
