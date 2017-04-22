package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;

@Mapper
public interface JadwalMapper {

	@Select("select * from jadwal_ept where jadwal_ept_id = #{jadwal_ept_id}")
	JadwalEptModel selectJadwalEpt(@Param("jadwal_ept_id") int jadwal_ept_id);
	
	@Select("select * from jadwal_tes_kesehatan where jadwal_tes_kesehatan_id = #{jadwal_tes_kesehatan_id}")
	JadwalKesehatanModel selectJadwalKesehatan(@Param("jadwal_tes_kesehatan_id") int jadwal_tes_kesehatan_id);
	
	@Select("select * from jadwal_registrasi where jadwal_registrasi_id = #{jadwal_registrasi_id}")
	JadwalRegisModel selectJadwalRegis(@Param("jadwal_registrasi_id") int jadwal_registrasi_id);
	
	@Select("select * from jadwal_registrasi")
	List<JadwalRegisModel> selectAllJadwalRegis();
}
