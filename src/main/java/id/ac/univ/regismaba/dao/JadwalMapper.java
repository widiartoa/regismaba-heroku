package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;

@Mapper
public interface JadwalMapper {

	@Select("select * from jadwal_ept where jadwal_ept_id = #{jadwal_ept_id}")
	@Results (value = {
				@Result(property="jadwal_ept_id", column="jadwal_ept_id"),
				@Result(property="timestamp_awal", column="timestamp_awal"),
				@Result(property="timestamp_akhir", column="timestamp_akhir")
	})
	JadwalEptModel selectJadwalEpt(@Param("jadwal_ept_id") int jadwal_ept_id);
	
	@Select("select * from jadwal_tes_kesehatan where jadwal_tes_kesehatan_id = #{jadwal_tes_kesehatan_id}")
	@Results (value = {
				@Result(property="jadwal_tes_kesehatan_id", column="jadwal_tes_kesehatan_id"),
				@Result(property="timestamp_awal", column="timestamp_awal"),
				@Result(property="timestamp_akhir", column="timestamp_akhir")
	})
	JadwalKesehatanModel selectJadwalKesehatan(@Param("jadwal_tes_kesehatan_id") int jadwal_tes_kesehatan_id);
	
	@Select("select * from jadwal_registrasi where jadwal_registrasi_id = #{jadwal_registrasi_id}")
	@Results (value = {
				@Result(property="jadwal_registrasi_id", column="jadwal_registrasi_id"),
				@Result(property="timestamp_awal", column="timestamp_awal"),
				@Result(property="timestamp_akhir", column="timestamp_akhir")
	})
	JadwalRegisModel selectJadwalRegis(@Param("jadwal_registrasi_id") int jadwal_registrasi_id);
}
