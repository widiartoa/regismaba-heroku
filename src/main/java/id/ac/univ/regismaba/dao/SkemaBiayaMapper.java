package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;
import id.ac.univ.regismaba.model.StatistikSkemaModel;
import id.ac.univ.regismaba.model.TingkatRoleModel;

@Mapper
public interface SkemaBiayaMapper {

	@Select("select * from skema_pembayaran where golongan_id = #{golongan_id}")
	@Results(@Result(property="tingkat_role", column="tingkat_role_id", javaType=TingkatRoleModel.class, one=@One(select="selectRole")))
	SkemaBiayaModel selectSBM(@Param("golongan_id") int golongan_id);
	
	@Select("select * from skema_pembayaran")
	@Results(@Result(property="tingkat_role", column="tingkat_role_id", javaType=TingkatRoleModel.class, one=@One(select="selectRole")))
	List<SkemaBiayaModel> selectAllSBM();
	
	@Insert("insert into skema_pembayaran (jumlah_biaya_ipa_min, jumlah_biaya_ipa_max, uang_pangkal_ipa_min, uang_pangkal_ipa_max, jumlah_biaya_ips_min, jumlah_biaya_ips_max, uang_pangkal_ips_min, uang_pangkal_ips_max, "
			+ "jumlah_biaya_ik_min, jumlah_biaya_ik_max, uang_pangkal_ik_min, uang_pangkal_ik_max, created_by, created_at, updated_by, updated_at, tingkat_role_id) values (#{jumlah_biaya_ipa_min}, #{jumlah_biaya_ipa_max}, #{uang_pangkal_ipa_min}, #{uang_pangkal_ipa_max}, #{jumlah_biaya_ips_min}, #{jumlah_biaya_ips_max}, "
			+ "#{uang_pangkal_ips_min}, #{uang_pangkal_ips_max}, #{jumlah_biaya_ik_min}, #{jumlah_biaya_ik_max}, #{uang_pangkal_ik_min}, #{uang_pangkal_ik_max}, #{created_by}, current_timestamp, #{created_by}, current_timestamp, #{tingkat_role.tingkat_role_id})")
	void insertSBM(SkemaBiayaModel sbm);
	
	@Update("update skema_pembayaran set jumlah_biaya_ipa=#{jumlah_biaya_ipa}, uang_pangkal_ipa=#{uang_pangkal_ipa}, "
			+ "jumlah_biaya_ips=#{jumlah_biaya_ips}, uang_pangkal_ips=#{uang_pangkal_ips}, "
			+ "jumlah_biaya_ik=#{jumlah_biaya_ik}, uang_pangkal_ik=#{uang_pangkal_ik} "
			+ "where golongan_id=#{golongan_id}")
	void updateSBM(SkemaBiayaModel sbm);
	
	@Select("select * from tingkat_role where tingkat_role_id=#{tingkat_role_id}")
	TingkatRoleModel selectRole(@Param("tingkat_role_id") int tingkat_role_id);
	
	@Select("select * from skema_pembayaran where tingkat_role_id=2")
	@Results(@Result(property="tingkat_role", column="tingkat_role_id", javaType=TingkatRoleModel.class, one=@One(select="selectRole")))
	List<SkemaBiayaModel> selectAllSBMByFacultyLevel();
	
	@Select("select golongan_id as nama, "
			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran p where m.username=p.username and p.golongan_id=#{golongan_id}) as total, "
			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran s where m.username=s.username and s.golongan_id=#{golongan_id} and s.status_pengajuan='Verified') as regis, "
			+ "((select count(*) from mahasiswa m, pengajuan_skema_pembayaran p where m.username=p.username and p.golongan_id=#{golongan_id}) - "
			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran s where m.username=s.username and s.golongan_id=#{golongan_id} and s.status_pengajuan='Verified')) as non_regis "
			+ "from skema_pembayaran where golongan_id=#{golongan_id}")
	StatistikManagerSummaryModel summarySchema(@Param("golongan_id") int golongan_id);
	
	@Select("select nama_fakultas as nama, "
			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran p, program_studi s, fakultas f where m.username=p.username and p.golongan_id=#{golongan_id} and m.program_studi_id=s.program_studi_id and s.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id}) as total, "
			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran p, program_studi s, fakultas f where m.username=p.username and p.golongan_id=#{golongan_id} and p.status_pengajuan='Verified' and m.program_studi_id=s.program_studi_id and s.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id}) as regis, "
			+ "((select count(*) from mahasiswa m, pengajuan_skema_pembayaran p, program_studi s, fakultas f where m.username=p.username and p.golongan_id=#{golongan_id} and m.program_studi_id=s.program_studi_id and s.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id}) - "
			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran p, program_studi s, fakultas f where m.username=p.username and p.golongan_id=#{golongan_id} and p.status_pengajuan='Verified' and m.program_studi_id=s.program_studi_id and s.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id})) as non_regis "
			+ "from fakultas where fakultas_id=#{fakultas_id}")
//	@Select("select golongan_id, "
//			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran p, program_studi s, fakultas f where m.username=p.username and p.golongan_id=#{golongan_id} and m.program_studi_id=s.program_studi_id and s.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id}) as total, "
//			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran s, program_studi s, fakultas f where m.username=s.username and s.golongan_id=#{golongan_id} and s.golongan_id='Verified' and m.program_studi_id=s.program_studi_id and s.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id}) as regis, "
//			+ "((select count(*) from mahasiswa m, pengajuan_skema_pembayaran p, program_studi s, fakultas f where m.username=p.username and p.golongan_id=#{golongan_id} and m.program_studi_id=s.program_studi_id and s.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id}) - "
//			+ "(select count(*) from mahasiswa m, pengajuan_skema_pembayaran s, program_studi s, fakultas f where m.username=s.username and s.golongan_id=#{golongan_id} and s.golongan_id='Verified' and m.program_studi_id=s.program_studi_id and s.fakultas_id=f.fakultas_id and f.fakultas_id=#{fakultas_id})) as non_regis "
//			+ "from skema_pembayaran where golongan_id=#{golongan_id}")
//	@Results(value = {
//				@Result(property="nama", column="golongan_id"), 
//				@Result(property="objects", column="fakultas_id", javaType=StatistikSkemaModel.class, many=@Many(select="selectFaculty"))
//			})
	StatistikManagerSummaryModel selectSchemaType(@Param("golongan_id") int golongan_id, @Param("fakultas_id") int fakultas_id);
	
	@Select("select distinct f.fakultas_id, f.nama_fakultas from fakultas f, program_studi p, mahasiswa m where "
			+ "f.fakultas_id=p.fakultas_id and p.program_studi_id=m.program_studi_id")
	List<FakultasModel> getFaculties();
	
	
}
