package id.ac.univ.regismaba.dao;

import java.util.List;

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

	@Select("select * from pengajuan_skema_pembayaran")
	List<PengajuanSkemaBiayaModel> selectAllPSBM ();
	
	@Insert("insert into pengajuan_skema_pembayaran (golongan_id, surat_keterangan_rtrw, "
			+ "foto_rumah, slip_gaji_pribadi, slip_gaji_wali1, slip_gaji_wali2, tagihan_air, "
			+ "tagihan_listrik, tagihan_telepon) values (#{golongan_id}, #{surat_keterangan_rtrw}, "
			+ "#{foto_rumah}, #{slip_gaji_pribadi}, #{slip_gaji_wali1}, #{slip_gaji_wali2}, "
			+ "#{tagihan_air}, #{tagihan_listrik}, #{tagihan_telepon})")
	void insertPSBM(PengajuanSkemaBiayaModel psbm);
	
	@Update("update pengajuan_skema_pembayaran set golongan_id=#{golongan_id}, "
			+ "surat_keterangan_rtrw=#{surat_keterangan_rtrw}, foto_rumah=#{foto_rumah}, "
			+ "slip_gaji_pribadi=#{slip_gaji_pribadi}, slip_gaji_wali1=#{slip_gaji_wali1}, "
			+ "slip_gaji_wali2=#{slip_gaji_wali2}, tagihan_air=#{tagihan_air}, "
			+ "tagihan_listrik=#{tagihan_listrik}, tagihan_telepon=#{tagihan_telepon} "
			+ "where pengajuan_id=1")
	void updatePSBM(PengajuanSkemaBiayaModel psbm);
	
}
