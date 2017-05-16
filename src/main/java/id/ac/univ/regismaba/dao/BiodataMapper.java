package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.BiodataModel;

@Mapper
public interface BiodataMapper {
	//INSERT BIODATA
		@Insert("insert into biodata (biodata_id, username, flag_aktif, status_verifikasi, jalan_id, "
				+ "tanggal_lahir, jenis_kelamin, nomor_telepon, kewarganegaraan, nomor_ktp, sidik_jari, scan_ktp,"
				+ "scan_kk, scan_surat_pernyataan_mahasiswa, ukuran_jaket, created_by, updated_by, updated_at, agama_id) values (#{biodata_id}, #{username}, #{flag_aktif}, #{status_verifikasi}, #{jalan_id},"
				+ "#{tanggal_lahir}, #{jenis_kelamin}, #{nomor_telepon}, #{kewarganegaraan}, #{nomor_ktp}, #{sidik_jari}, #{scan_ktp},"
				+ "#{scan_kk}, #{scan_surat_pernyataan_mahasiswa}, #{ukuran_jaket}, #{created_by}, #{updated_by}, #{updated_at}, #{agama_id})")
		void insertBiodata(BiodataModel biodata);

		@Select("SELECT * FROM BIODATA WHERE biodata_id=#{biodata_id}")
		BiodataModel selectBiodata(int biodata_id);
		
		@Select("SELECT * FROM BIODATA WHERE username=#{username}")
		@Results(value = {
			@Result(property="jalan_id", column="jalan_id"),    
			@Result(property="tanggal_lahir", column="tanggal_lahir"),
			@Result(property="jenis_kelamin", column="jenis_kelamin"),
			@Result(property="nomor_telepon", column="nomor_telepon"),
			@Result(property="kewarganegaraan", column="kewarganegaraan"),
			@Result(property="nomor_ktp", column="nomor_ktp"),
			@Result(property="sidik_jari", column="sidik_jari"),    
			@Result(property="scan_ktp", column="scan_ktp"),
			@Result(property="scan_kk", column="scan_kk"),
			@Result(property="scan_surat_pernyataan_mahasiswa", column="scan_surat_pernyataan_mahasiswa"),
			@Result(property="status_verifikasi", column="status_verifikasi"),
			@Result(property="flag_aktif", column="flag_aktif"),
			@Result(property="ukuran_jaket", column="ukuran_jaket"),
			@Result(property="created_by", column="created_by"),
			@Result(property="created_at", column="created_at"),
			@Result(property="updated_by", column="updated_by"),
			@Result(property="updated_at", column="updated_at"),
			@Result(property="agama_id", column="agama_id"),			
		})
		BiodataModel selectBiodataByUsername(String username);
		
		@Update("UPDATE biodata SET flag_aktif=#{flag_aktif}, status_verifikasi=#{status_verifikasi},"
				+ "tanggal_lahir=#{tanggal_lahir}, jenis_kelamin=#{jenis_kelamin}, nomor_telepon=#{nomor_telepon}, kewarganegaraan=#{kewarganegaraan},"
				+ "nomor_ktp=#{nomor_ktp}, sidik_jari=#{sidik_jari}, scan_ktp=#{scan_ktp}, scan_kk=#{scan_kk}, scan_surat_pernyataan_mahasiswa=#{scan_surat_pernyataan_mahasiswa},"
				+ "ukuran_jaket=#{ukuran_jaket}, created_by=#{created_by}, updated_by=#{updated_by}, updated_at=#{updated_at}, agama_id=#{agama_id} "
				+ "WHERE username=#{username}")
		void updateBiodataByUsername(BiodataModel biodata);

//		@Update("UPDATE absensi_dosen SET idStatus=#{idStatus} WHERE idKelas=#{idKelas} AND tanggal=#{tanggal} AND jamMulai=#{jamMulai} AND jamSelesai=#{jamSelesai} AND nip=#{nip}")
//	    void updateAbsensiDosen (AbsensiDosenModel absensiDosen);
		
		
}