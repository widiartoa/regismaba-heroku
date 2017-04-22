<<<<<<< HEAD
package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.KotaKabupatenModel;

@Mapper
public interface KotaKabupatenMapper {
	@Select("select kota_kabupaten_id, nama_kota_kabupaten from kota_kabupaten")
	List<KotaKabupatenModel> selectAllKotaKabupaten();
	
	@Select("select kota_kabupaten_id, nama_kota_kabupaten from kota_kabupaten where provinsi_id=#{provinsi_id}")
	List<KotaKabupatenModel> selectKotaKabupatenByProvinsiId(int provinsi_id);

}
=======
package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.KotaKabupatenModel;

@Mapper
public interface KotaKabupatenMapper {
	@Select("select kota_kabupaten_id, nama_kota_kabupaten from kota_kabupaten")
	List<KotaKabupatenModel> selectAllKotaKabupaten();
	
	@Select("select kota_kabupaten_id, nama_kota_kabupaten from kota_kabupaten where provinsi_id=#{provinsi_id}")
	List<KotaKabupatenModel> selectKotaKabupatenByProvinsiId(int provinsi_id);

}
>>>>>>> e5a90e5cf757426172b3736d00e5f0ce36f4e017
