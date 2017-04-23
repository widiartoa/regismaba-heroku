package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.KotaKabupatenModel;

@Mapper
public interface KotaKabupatenMapper {
	@Select("select kota_kabupaten_id, nama_kota_kabupaten from kota_kabupaten")
	List<KotaKabupatenModel> selectAllKotaKabupaten();
	
	@Select("select kota_kabupaten_id, nama_kota_kabupaten from kota_kabupaten where provinsi_id=#{provinsi_id}")
	List<KotaKabupatenModel> selectKotaKabupatenByProvinsiId(int provinsi_id);

	@Select("SELECT * FROM kota_kabupaten WHERE kota_kabupaten_id=#{kota_kabupaten_id}")
	@Results(value = {
		@Result(property="provinsi_id", column="provinsi_id"),
		@Result(property="nama_kota_kabupaten", column="nama_kota_kabupaten"),
	})
	KotaKabupatenModel selectKotaKabupaten(int kota_kabupaten_id);
	
}