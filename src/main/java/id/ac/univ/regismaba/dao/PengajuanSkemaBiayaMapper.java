package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;

@Mapper
public interface PengajuanSkemaBiayaMapper {
	
	@Select("select * from pengajuan_skema_pembayaran where pengajuan_id = #{pengajuan_id}")
	PengajuanSkemaBiayaModel selectPSBM (@Param("pengajuan_id") int pengajuan_id);

	@Insert("insert into pengajuan_skema_pembayaran")
	void insertPSBM(PengajuanSkemaBiayaModel psbm);
	
	@Update("")
	void updatePSBM(PengajuanSkemaBiayaModel psbm);
	
}
