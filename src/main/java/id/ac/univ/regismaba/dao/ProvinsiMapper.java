package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.ProvinsiModel;

@Mapper
public interface ProvinsiMapper {
	@Select("select provinsi_id, nama_provinsi from provinsi")
//	@Results (value = {
//				@Result(property="provinsi_id", column="provinsi_id"),
//				@Result(property="nama_provinsi", column="nama_provinsi")
//	})
	List<ProvinsiModel> selectAllProvinsi();
}
