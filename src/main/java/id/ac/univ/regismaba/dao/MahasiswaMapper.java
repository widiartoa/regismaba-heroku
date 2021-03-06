package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;

@Mapper
public interface MahasiswaMapper {

	@Select("SELECT username FROM user WHERE username = #{username} AND password = MD5(#{password}) AND id_role = '1'")
	@Results(value = { @Result(property = "username", column = "username") })
	MahasiswaModel loginMahasiswa(@Param("username") String username, @Param("password") String password);

	@Select("select * from mahasiswa where npm = #{npm}")
	@Results(value = { @Result(property = "username", column = "username"), @Result(property = "npm", column = "npm"),
			@Result(property = "uid_sso", column = "uid_sso"), @Result(property = "biodata_id", column = "biodata_id"),
			@Result(property = "jenjang_id", column = "jenjang_id"),
			@Result(property = "pengajuan_id", column = "pengajuan_id"),
			@Result(property = "no_seleksi", column = "no_seleksi"),
			@Result(property = "jadwal_registrasi_id", column = "jadwal_registrasi_id"),
			@Result(property = "jadwal_tes_kesehatan_id", column = "jadwal_tes_kesehatan_id"),
			@Result(property = "jadwal_ept_id", column = "jadwal_ept_id") })
	MahasiswaModel selectMahasiswa(@Param("npm") String npm);

	@Select("select * from mahasiswa where username = #{username}")
	@Results(value = { @Result(property = "username", column = "username"), @Result(property = "npm", column = "npm"),
			@Result(property = "uid_sso", column = "uid_sso"), @Result(property = "biodata_id", column = "biodata_id"),
			@Result(property = "jenjang_id", column = "jenjang_id"),
			@Result(property = "pengajuan_id", column = "pengajuan_id"),
			@Result(property = "no_seleksi", column = "no_seleksi"),
			@Result(property = "jadwal_registrasi_id", column = "jadwal_registrasi_id"),
			@Result(property = "jadwal_tes_kesehatan_id", column = "jadwal_tes_kesehatan_id"),
			@Result(property = "jadwal_ept_id", column = "jadwal_ept_id") })
	MahasiswaModel selectMahasiswaByUsername(@Param("username") String username);

	@Select("select * from mahasiswa")
	@Results(value = { @Result(property = "username", column = "username"), @Result(property = "npm", column = "npm"),
			@Result(property = "uid_sso", column = "uid_sso"), @Result(property = "biodata_id", column = "biodata_id"),
			@Result(property = "jenjang_id", column = "jenjang_id"),
			@Result(property = "pengajuan_id", column = "pengajuan_id"),
			@Result(property = "no_seleksi", column = "no_seleksi"),
			@Result(property = "jadwal_registrasi_id", column = "jadwal_registrasi_id"),
			@Result(property = "jadwal_tes_kesehatan_id", column = "jadwal_tes_kesehatan_id"),
			@Result(property = "jadwal_ept_id", column = "jadwal_ept_id") })
	List<MahasiswaModel> selectAllMahasiswa();

	@Select("Select * from mahasiswa as m inner join program_studi as p on m.program_studi_id = p.program_studi_id "
			+ "inner join urutan_assign_jadwal as u on p.fakultas_id = u.fakultas_id where m.tahun_ajaran_id=#{tahun_ajaran_id} order by urutan_assign_jadwal_id")
	List<MahasiswaModel> selectAllMahasiswaSortedUrutanAssignonTahunAjaran(@Param("tahun_ajaran_id") int tahun_ajaran_id);

	@Select("select * from mahasiswa where tahun_ajaran_id = #{tahun_ajaran_id}")
	List<MahasiswaModel> selectAllMahasiswabyTahunAjaran(@Param("tahun_ajaran_id") int tahun_ajaran_id);

	@Select("select * from mahasiswa where fakultas_id = #{fakultas_id}")
	List<MahasiswaModel> selectAllMahasiswabyFakultas(@Param("fakultas_id") int fakultas_id);

	@Select("select * from program_studi P LEFT JOIN mahasiswa M ON P.program_studi_id=M.program_studi_id where fakultas_id = #{fakultas_id} and tahun_ajaran_id = #{tahun_ajaran_id}")
	List<MahasiswaModel> selectAllMahasiswabyFakultasatTahunAjaran(@Param("fakultas_id") int fakultas_id,
			@Param("tahun_ajaran_id") int tahun_ajaran_id);

	@Select("select nama_lengkap from user where username=#{username}")
	String selectNamaLengkap(@Param("username") String username);

	@Select("select * from biodata where username=#{username}")
	BiodataModel selectBiodataMahasiswa(@Param("username") String username);

	@Select("select * from program_studi where program_studi_id=#{program_studi_id}")
	ProgramStudiModel selectProgramStudiMahasiswa(@Param("program_studi_id") int program_studi_id);

	@Select("select nama_program from program where program_id=#{program_id}")
	String selectProgramMahasiswa(@Param("program_id") int program_id);

	@Select("select nama_fakultas from fakultas where fakultas_id=#{fakultas_id}")
	String selectFakultasMahasiswa(@Param("fakultas_id") int fakultas_id);

	@Select("select nama_jenjang from jenjang where jenjang_id=#{jenjang_id}")
	String selectJenjangMahasiswa(@Param("jenjang_id") int jenjang_id);

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