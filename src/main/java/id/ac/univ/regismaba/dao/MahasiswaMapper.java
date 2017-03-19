package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.MahasiswaModel;

@Mapper
public interface MahasiswaMapper {

	@Select("select * from mahasiswa where npm = #{npm}")
	@Results (value = {
				@Result(property="username", column="username"),
				@Result(property="npm", column="npm"),
				@Result(property="uid_sso", column="uid_sso"),
				@Result(property="biodata_id", column="biodata_id"),
				@Result(property="jenjang_id", column="jenjang_id"),
				@Result(property="pengajuan_id", column="pengajuan_id"),
				@Result(property="no_seleksi", column="no_seleksi"),
				@Result(property="jadwal_registrasi_id", column="jadwal_registrasi_id"),
				@Result(property="jadwal_tes_kesehatan_id", column="jadwal_tes_kesehatan_id"),
				@Result(property="jadwal_ept_id", column="jadwal_ept_id")
	})
	MahasiswaModel selectMahasiswa(@Param("npm") String npm);
	
	@Select("select * from mahasiswa")
	@Results (value = {
				@Result(property="username", column="username"),
				@Result(property="npm", column="npm"),
				@Result(property="uid_sso", column="uid_sso"),
				@Result(property="biodata_id", column="biodata_id"),
				@Result(property="jenjang_id", column="jenjang_id"),
				@Result(property="pengajuan_id", column="pengajuan_id"),
				@Result(property="no_seleksi", column="no_seleksi"),
				@Result(property="jadwal_registrasi_id", column="jadwal_registrasi_id"),
				@Result(property="jadwal_tes_kesehatan_id", column="jadwal_tes_kesehatan_id"),
				@Result(property="jadwal_ept_id", column="jadwal_ept_id")
	})
	List<MahasiswaModel> selectAllMahasiswa();
	
	@Insert("insert into mahasiswa (biodata_id) values (#{biodata_id}) where npm = #{npm}")
	void insertBiodataMahasiswa(@Param("npm") String npm, @Param("biodata_id") String biodata_id);
	
	@Insert("insert into mahasiswa (jenjang_id) values (#{jenjang_id}) where npm = #{npm}")
	void insertJenjangMahasiswa(@Param("npm") String npm, @Param("jenjang_id") String jenjang_id);
	
	@Insert("insert into mahasiswa (pengajuan_id) values (#{pengajuan_id}) where npm = #{npm}")
	void insertPengajuanMahasiswa(@Param("npm") String npm, @Param("pengajuan_id") String pengajuan_id);
	
	@Update("update mahasiswa set biodata_id = #{biodata_id} where npm = #{npm}")
	void updateBiodataMahasiswa(@Param("npm") String npm, @Param("biodata_id") String biodata_id);
	
	@Update("update mahasiswa set jenjang_id = #{jenjang_id} where npm = #{npm}")
	void updateJenjangMahasiswa(@Param("npm") String npm, @Param("jenjang_id") String jenjang_id);
	
	@Update("update mahasiswa set pengajuan_id = #{pengajuan_id} where npm = #{npm}")
	void updatePengajuanMahasiswa(@Param("npm") String npm, @Param("pengajuan_id") String pengajuan_id);	
	
}

