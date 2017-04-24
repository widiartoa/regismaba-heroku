package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.AsuransiKesehatanModel;

@Mapper
public interface AsuransiKesehatanMapper {
//    @Select("select nama_institusi as nama_institusi, jenjang as jenjang, scan_ijazah as scan_ijazah, scan_pernyataan_ijazah as scan_pernyataan_ijazah from ijazah where nomor_ijazah = #{nomor_ijazah}")
//    IjazahModel selectIjazah(@Param("nomor_ijazah") String nomor_ijazah);
    
    @Insert("INSERT into asuransi_kesehatan (nomor_asuransi, username, nomor_penerbit_asuransi, expired_date, scan_kartu,"
    		+ "created_by, created_at, updated_by, updated_at) " +
            "VALUES (#{nomor_asuransi}, #{username}, #{nomor_penerbit_asuransi}, #{expired_date}, #{scan_kartu}, #{created_by},"
            + " #{created_at}, #{updated_by}, #{updated_at})")
    void insertAsuransiKesehatan(AsuransiKesehatanModel asuransiKesehatan);
    
    
	@Select("SELECT * FROM asuransi_kesehatan WHERE username=#{username}")
	@Results(value = {
		@Result(property="nomor_asuransi", column="nomor_asuransi"),
		@Result(property="nomor_penerbit_asuransi", column="nomor_penerbit_asuransi"),
		@Result(property="expired_date", column="expired_date"),
		@Result(property="scan_kartu", column="scan_kartu"),
		@Result(property="created_by", column="created_by"),
		@Result(property="created_at", column="created_at"),
		@Result(property="updated_by", column="updated_by"),
		@Result(property="updated_at", column="updated_at"),
	})
	AsuransiKesehatanModel selectAsuransiKesehatanByUsername(String username);
}
