package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.IjazahModel;

@Mapper
public interface IjazahMapper
{
    @Select("select nama_institusi as nama_institusi, jenjang as jenjang, scan_ijazah as scan_ijazah, scan_pernyataan_ijazah as scan_pernyataan_ijazah from ijazah where nomor_ijazah = #{nomor_ijazah}")
    IjazahModel selectIjazah(@Param("nomor_ijazah") String nomor_ijazah);
    
    @Insert("INSERT into ijazah (nomor_ijazah, nama_institusi, jenjang, scan_ijazah, scan_pernyataan_ijazah) " +
            "VALUES (#{nomor_ijazah}, #{nama_institusi}, #{jenjang}, #{scan_ijazah}, #{scan_pernyataan_ijazah})")
    void addIjazah(IjazahModel ijazah);
}