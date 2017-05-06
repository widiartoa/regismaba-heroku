package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.SkemaBiayaModel;
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
}
