package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.BiodataModel;

@Mapper
public interface BiodataMapper {
	//INSERT BIODATA
		@Insert("insert into biodata (nomor_ijazah, nomor_asuransi, "
				+ "tanggal_lahir, jenis_kelamin, nomor_telepon, kewarganegaraan, nomor_ktp, sidik_jari, scan_ktp,"
				+ "scan_kk, scan_surat_pernyataan_mahasiswa) values (#{nomor_ijazah}, #{nomor_asuransi},"
				+ "#{tanggal_lahir}, #{jenis_kelamin}, #{nomor_telepon}, #{kewarganegaraan}, #{nomor_ktp}, #{sidik_jari}, #{scan_ktp},"
				+ "#{scan_kk}, #{scan_surat_pernyataan_mahasiswa})")
		void insertBiodata(BiodataModel biodata);

		@Select("SELECT * FROM BIODATA WHERE biodata_id=#{biodata_id}")
		BiodataModel selectBiodata(int biodata_id);
}





//@Insert("insert into biodata (biodata_id, data_kesehatan_id, nomor_ijazah, nomor_asuransi, jalan_id, "
//		+ "tanggal_lahir, jenis_kelamin, nomor_telepon, kewarganegaraan, nomor_ktp, sidik_jari, scan_ktp"
//		+ "scan_kk, scan_surat_pernyataan_mahasiswa, status_verifikasi, flag_aktif) values (#{biodata_id}, #{data_kesehatan_id}, #{nomor_ijazah}, #{nomor_asuransi}, #{jalan_id},"
//		+ "#{tanggal_lahir}, #{jenis_kelamin}, #{nomor_telepon}, #{kewarganegaraan}, #{nomor_ktp}, #{sidik_jari}, #{scan_ktp},"
//		+ "#{scan_kk}, #{scan_surat_pernyataan_mahasiswa}, #{status_verifikasi}, #{flag_aktif})")
//void insertBiodata(BiodataModel biodata);