package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.TahunAjaranModel;

@Mapper
public interface TahunAjaranMapper {

	@Select("select * from tahun_ajaran where timestamp_awal <= current_timestamp and timestamp_akhir >= current_timestamp")
	TahunAjaranModel selectTahunAjaranSaatIni();
	
	@Select("select * from tahun_ajaran where tahun_ajaran_id = #{tahun_ajaran_id}")
	TahunAjaranModel selectTahunAjaran(@Param("tahun_ajaran_id") int tahun_ajaran_id);
	
	@Select("select * from tahun_ajaran")
	List<TahunAjaranModel> selectAllTahunAjaran();
}
