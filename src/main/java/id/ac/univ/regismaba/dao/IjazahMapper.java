package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.IjazahModel;

@Mapper
public interface IjazahMapper
{
//    @Select("select nama_institusi as nama_institusi, jenjang as jenjang, scan_ijazah as scan_ijazah, scan_pernyataan_ijazah as scan_pernyataan_ijazah from ijazah where nomor_ijazah = #{nomor_ijazah}")
//    IjazahModel selectIjazah(@Param("nomor_ijazah") String nomor_ijazah);
    
    @Insert("INSERT into ijazah (nomor_ijazah, username, institusi_id, jenjang, scan_ijazah, scan_pernyataan_ijazah,"
    		+ "created_by, updated_by, updated_at) " +
            "VALUES (#{nomor_ijazah}, #{username}, #{institusi_id}, #{jenjang}, #{scan_ijazah}, #{scan_pernyataan_ijazah},"
            + "#{created_by}, #{updated_by}, #{updated_at})")
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
	
    @Update("UPDATE ijazah SET nomor_ijazah=#{nomor_ijazah}, username=#{username}, institusi_id=#{institusi_id}, jenjang=#{jenjang},"
    		+ "scan_ijazah=#{scan_ijazah}, scan_pernyataan_ijazah=#{scan_pernyataan_ijazah}, updated_by=#{updated_by},"
    		+ "updated_at=#{updated_at} WHERE username=#{username}")
    void updateIjazah(IjazahModel ijazah);
	
}