package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import id.ac.univ.regismaba.model.RumpunModel;

@Mapper
public interface PengajuanSkemaBiayaMapper {
	
	@Select("select * from pengajuan_skema_pembayaran where pengajuan_id = #{pengajuan_id}")
	PengajuanSkemaBiayaModel selectPSBM (@Param("pengajuan_id") int pengajuan_id);

	@Select("select * from pengajuan_skema_pembayaran where username = #{username}")
	PengajuanSkemaBiayaModel selectPSBMFromUsername (@Param("username") String username);
	
	@Select("select * from pengajuan_skema_pembayaran")
	List<PengajuanSkemaBiayaModel> selectAllPSBM ();
	
	@Insert("insert into pengajuan_skema_pembayaran (golongan_id, surat_keterangan_rtrw, "
			+ "foto_rumah, slip_gaji_pribadi, slip_gaji_wali1, slip_gaji_wali2, tagihan_air, "
			+ "tagihan_listrik, tagihan_telepon, gaji_pribadi, gaji_wali1, gaji_wali2, "
			+ "nilai_tagihan_air, nilai_tagihan_listrik, nilai_tagihan_telepon, username, "
			+ "status_pengajuan, created_at, created_by, updated_at, updated_by) "
			+ "values (#{golongan_id}, #{surat_keterangan_rtrw}, "
			+ "#{foto_rumah}, #{slip_gaji_pribadi}, #{slip_gaji_wali1}, #{slip_gaji_wali2}, "
			+ "#{tagihan_air}, #{tagihan_listrik}, #{tagihan_telepon}, #{gaji_pribadi}, #{gaji_wali1}, "
			+ "#{gaji_wali2}, #{nilai_tagihan_air}, #{nilai_tagihan_listrik}, #{nilai_tagihan_telepon}, "
			+ "#{username}, 'Unverified', current_timestamp, #{username}, current_timestamp, #{username})")
	void insertPSBM(PengajuanSkemaBiayaModel psbm);
	
//	@Update("update pengajuan_skema_pembayaran set golongan_id=#{golongan_id}, "
//			+ "surat_keterangan_rtrw=#{surat_keterangan_rtrw}, foto_rumah=#{foto_rumah}, "
//			+ "slip_gaji_pribadi=#{slip_gaji_pribadi}, slip_gaji_wali1=#{slip_gaji_wali1}, "
//			+ "slip_gaji_wali2=#{slip_gaji_wali2}, tagihan_air=#{tagihan_air}, "
//			+ "tagihan_listrik=#{tagihan_listrik}, tagihan_telepon=#{tagihan_telepon}, "
//			+ "gaji_pribadi=#{gaji_pribadi}, gaji_wali1=#{gaji_wali1}, gaji_wali2=#{gaji_wali2}, "
//			+ "nilai_tagihan_air=#{nilai_tagihan_air}, nilai_tagihan_listrik=#{nilai_tagihan_listrik}, "
//			+ "nilai_tagihan_telepon=#{nilai_tagihan_telepon}, updated_at=current_timestamp, "
//			+ "updated_by=#{username} where username=#{username}")
//	void updatePSBM(PengajuanSkemaBiayaModel psbm);
	
	@Update("update pengajuan_skema_pembayaran set "
			+ "surat_keterangan_rtrw=#{surat_keterangan_rtrw}, foto_rumah=#{foto_rumah}, "
			+ "slip_gaji_pribadi=#{slip_gaji_pribadi}, slip_gaji_wali1=#{slip_gaji_wali1}, "
			+ "slip_gaji_wali2=#{slip_gaji_wali2}, tagihan_air=#{tagihan_air}, "
			+ "tagihan_listrik=#{tagihan_listrik}, tagihan_telepon=#{tagihan_telepon}, "
			+ "gaji_pribadi=#{gaji_pribadi}, gaji_wali1=#{gaji_wali1}, gaji_wali2=#{gaji_wali2}, "
			+ "nilai_tagihan_air=#{nilai_tagihan_air}, nilai_tagihan_listrik=#{nilai_tagihan_listrik}, "
			+ "nilai_tagihan_telepon=#{nilai_tagihan_telepon}, updated_at=current_timestamp, "
			+ "updated_by=#{username} where username=#{username}")
	void updatePSBM(PengajuanSkemaBiayaModel psbm);
	
//	@Insert("insert into pengajuan_skema_pembayaran (golongan_id, surat_keterangan_rtrw, "
//			+ "foto_rumah, slip_gaji_pribadi, slip_gaji_wali1, slip_gaji_wali2, tagihan_air, "
//			+ "tagihan_listrik, tagihan_telepon, gaji_pribadi, gaji_wali1, gaji_wali2, "
//			+ "nilai_tagihan_air, nilai_tagihan_listrik, nilai_tagihan_telepon, username, "
//			+ "status_pengajuan, created_at, created_by, updated_at, updated_by) "
//			+ "values (#{golongan_id}, '-', "
//			+ "'-', '-', '-', '-', "
//			+ "'-', '-', '-', '0', '0', "
//			+ "'0', '0', '0', '0', "
//			+ "#{username}, 'Unverified', current_timestamp, #{username}, current_timestamp, #{username})")
//	void insertGolongan(PengajuanSkemaBiayaModel psbm);
	
	@Insert("insert into pengajuan_skema_pembayaran (golongan_id, foto_rumah, status_pengajuan, "
			+ "created_at, created_by, updated_at, updated_by, username) values (#{golongan_id}, '-', "
			+ "'Unverified', current_timestamp, #{username}, current_timestamp, #{username}, "
			+ "#{username})")
	void insertGolongan(PengajuanSkemaBiayaModel psbm);
	
	@Update("update pengajuan_skema_pembayaran set golongan_id=#{golongan_id}, updated_at=current_timestamp, "
			+ "updated_by=#{updated_by}, gaji_pribadi=null, gaji_wali1=null, gaji_wali2=null, "
			+ "nilai_tagihan_air=null, nilai_tagihan_listrik=null, nilai_tagihan_telepon=null, "
			+ "surat_keterangan_rtrw=null, foto_rumah='-', slip_gaji_pribadi=null, slip_gaji_wali1=null, "
			+ "slip_gaji_wali2=null, tagihan_air=null, tagihan_listrik=null, tagihan_telepon=null, "
			+ "status_pengajuan='Unverified', komentar=null where username=#{username}")
	void updateGolongan(PengajuanSkemaBiayaModel psbm);
}
