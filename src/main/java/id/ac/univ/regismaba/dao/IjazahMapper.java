package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.model.IjazahModel;

@Mapper
public interface IjazahMapper
{
    @Select("select nama_institusi as nama_institusi, jenjang as jenjang, scan_ijazah as scan_ijazah, scan_pernyataan_ijazah as scan_pernyataan_ijazah from ijazah where nomor_ijazah = #{nomor_ijazah}")
    IjazahModel selectIjazah(@Param("nomor_ijazah") String nomor_ijazah);
    
    @Insert("INSERT into ijazah (nomor_ijazah, nama_institusi, jenjang, scan_ijazah, scan_pernyataan_ijazah) " +
            "VALUES (#{nomor_ijazah}, #{nama_institusi}, #{jenjang}, #{scan_ijazah}, #{scan_pernyataan_ijazah})")
    void addIjazah(IjazahModel ijazah);
    
    
	@Select("SELECT * FROM ijazah WHERE username=#{username}")
	@Results(value = {
		@Result(property="nomor_ijazah", column="nomor_ijazah"),
		@Result(property="institusi_id", column="institusi_id"),
		@Result(property="jenjang", column="jenjang"),
		@Result(property="scan_ijazah", column="scan_ijazah"),
		@Result(property="scan_pernyataan_ijazah", column="scan_pernyataan_ijazah"),
		@Result(property="created_by", column="created_by"),
		@Result(property="created_at", column="created_at"),
		@Result(property="updated_by", column="updated_by"),
		@Result(property="updated_at", column="updated_at"),
	})
	IjazahModel selectIjazahByUsername(String username);
	
}