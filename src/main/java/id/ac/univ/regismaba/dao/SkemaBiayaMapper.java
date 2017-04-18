package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.SkemaBiayaModel;

@Mapper
public interface SkemaBiayaMapper {

	@Select("select * from skema_pembayaran where golongan_id = #{golongan_id}")
	SkemaBiayaModel selectSBM(@Param("golongan_id") int golongan_id);
	
	@Select("select * from skema_pembayaran")
	List<SkemaBiayaModel> selectAllSBM();
	
	@Insert("insert into skema_pembayaran (jumlah_biaya_ipa, uang_pangkal_ipa, jumlah_biaya_ips, uang_pangkal_ips, "
			+ "jumlah_biaya_ik, uang_pangkal_ik, created_by, created_at) values (#{jumlah_biaya_ipa}, #{uang_pangkal_ipa}, #{jumlah_biaya_ips}, "
			+ "#{uang_pangkal_ips}, #{jumlah_biaya_ik}, #{uang_pangkal_ik}, #{created_by}, current_timestamp)")
	void insertSBM(SkemaBiayaModel sbm);
	
	@Update("update skema_pembayaran set jumlah_biaya_ipa=#{jumlah_biaya_ipa}, uang_pangkal_ipa=#{uang_pangkal_ipa}, "
			+ "jumlah_biaya_ips=#{jumlah_biaya_ips}, uang_pangkal_ips=#{uang_pangkal_ips}, "
			+ "jumlah_biaya_ik=#{jumlah_biaya_ik}, uang_pangkal_ik=#{uang_pangkal_ik} "
			+ "where golongan_id=#{golongan_id}")
	void updateSBM(SkemaBiayaModel sbm);
	
}
