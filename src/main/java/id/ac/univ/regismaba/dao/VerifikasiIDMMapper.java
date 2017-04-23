package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.BiodataModel;

@Mapper
public interface VerifikasiIDMMapper
{
    @Select("select status_verifikasi from biodata where username = #{username}")
    @Results(value = {
            @Result(property = "status_verifikasi", column = "status_verifikasi")
    })
    String selectStatusVerifikasi (@Param("username") String username);

    @Select("select komentar from biodata where username = #{username}")
    @Results(value = {
            @Result(property = "komentar", column = "komentar")
    })
    String selectKomentar (@Param("username") String username);
    
    @Select("select * from biodata")
    List<BiodataModel> selectAllBiodata ();

    @Update("update biodata set status_verifikasi = 'Verified' where username = #{username}")
    void updateStatusVerify (@Param("username") String username);


    @Update("update biodata set status_verifikasi = 'Unverified' where username = #{username}")
    void updateStatusUnverify (@Param("username") String username);


    @Update("update biodata set komentar = #{komentar} where username = #{username}")
    void updateComment (@Param("username") String username,
            @Param("komentar") String komentar);
}