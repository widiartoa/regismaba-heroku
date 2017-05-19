package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.JadwalEptModel;
import id.ac.univ.regismaba.model.JadwalKesehatanModel;
import id.ac.univ.regismaba.model.JadwalRegisModel;
import id.ac.univ.regismaba.model.UrutanAssignJadwalModel;

@Mapper
public interface JadwalMapper {

	@Select("select * from jadwal_ept where jadwal_ept_id = #{jadwal_ept_id}")
	JadwalEptModel selectJadwalEpt(@Param("jadwal_ept_id") int jadwal_ept_id);
	
	@Select("select * from jadwal_tes_kesehatan where jadwal_tes_kesehatan_id = #{jadwal_tes_kesehatan_id}")
	JadwalKesehatanModel selectJadwalKesehatan(@Param("jadwal_tes_kesehatan_id") int jadwal_tes_kesehatan_id);
	
	@Select("select * from jadwal_registrasi where jadwal_registrasi_id = #{jadwal_registrasi_id}")
	JadwalRegisModel selectJadwalRegis(@Param("jadwal_registrasi_id") int jadwal_registrasi_id);
	
	@Select("select jadwal_registrasi_id, timestamp_awal, timestamp_akhir, kapasitas, created_by, created_at, updated_by, updated_at from jadwal_registrasi WHERE status_aktif = 1 ORDER BY created_at DESC")
	List<JadwalRegisModel> selectAllJadwalRegis();
	
	@Select("select jadwal_registrasi_id, timestamp_awal, timestamp_akhir, kapasitas, created_by, created_at, updated_by, updated_at from jadwal_registrasi WHERE tahun_ajaran_id = #{tahun_ajaran_id} and status_aktif = 1 ORDER BY created_at DESC")
	List<JadwalRegisModel> selectAllJadwalRegisbyTahunAjaran(@Param("tahun_ajaran_id") int tahun_ajaran_id);
	
	@Select("select * from jadwal_registrasi WHERE tahun_ajaran_id = #{tahun_ajaran_id} and status_aktif = 1 ORDER BY timestamp_awal ASC")
	List<JadwalRegisModel> selectAllJadwalRegisbyTahunAjaranSortAsc(@Param("tahun_ajaran_id") int tahun_ajaran_id);
	
	@Insert("insert into jadwal_registrasi (timestamp_awal, timestamp_akhir, kapasitas, created_by, created_at, updated_by, updated_at, tahun_ajaran_id, status_aktif) "
			+ "values (#{timestamp_awal}, #{timestamp_akhir}, #{kapasitas}, #{created_by}, current_timestamp, #{updated_by}, current_timestamp, #{tahun_ajaran_id}, 1)")
	void insertJadwalRegis(JadwalRegisModel jadwalRegis);
	
	@Update("update jadwal_registrasi set status_aktif = 0 where jadwal_registrasi_id = #{jadwal_registrasi_id}")
    void deleteJadwalRegis (@Param("jadwal_registrasi_id") int jadwal_registrasi_id);

	@Select("select jadwal_tes_kesehatan_id, timestamp_awal, timestamp_akhir, kapasitas, created_by, created_at, updated_by, updated_at from jadwal_tes_kesehatan WHERE tahun_ajaran_id = #{tahun_ajaran_id} and status_aktif = 1 ORDER BY created_at DESC")
	List<JadwalKesehatanModel> selectAllJadwalTesKesbyTahunAjaran(int tahun_ajaran_id);

	@Select("select jadwal_ept_id, timestamp_awal, timestamp_akhir, kapasitas, created_by, created_at, updated_by, updated_at from jadwal_ept WHERE tahun_ajaran_id = #{tahun_ajaran_id} and status_aktif = 1 ORDER BY created_at DESC")
	List<JadwalEptModel> selectAllJadwalEptbyTahunAjaran(int tahun_ajaran_id);
	
	@Insert("insert into urutan_assign_jadwal (fakultas_id, tahun_ajaran_id, created_by, created_at, updated_by, updated_at) "
			+ "values (#{fakultas_id}, #{tahun_ajaran_id}, #{created_by}, current_timestamp, #{updated_by}, current_timestamp)")
	void insertUrutanAssign(UrutanAssignJadwalModel uaj);
	
	@Delete("DELETE FROM assign_jadwal WHERE tahun_ajaran_id=#{tahun_ajaran_id}")
	void resetAssignJadwal(int tahun_ajaran_id);
	
	@Delete("DELETE FROM urutan_assign_jadwal WHERE tahun_ajaran_id=#{tahun_ajaran_id}")
	void resetUrutanAssignJadwal(int tahun_ajaran_id);
}
