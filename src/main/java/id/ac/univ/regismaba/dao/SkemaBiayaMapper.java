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
	
	@Insert("insert into skema_pembayaran (jumlah_biaya, uang_pangkal) values "
			+ "(#{jumlah_biaya}, #{uang_pangkal})")
	void insertSBM(SkemaBiayaModel sbm);
	
	@Update("update skema_pembayaran set jumlah_biaya=#{jumlah_biaya}, uang_pangkal=#{uang_pangkal} "
			+ "where golongan_id=#{golongan_id}")
	void updateSBM(SkemaBiayaModel sbm);
	
}
