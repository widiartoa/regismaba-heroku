package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VerifikasiIDMMapper
{
    @Select("select status_verifikasi from biodata where username = #{username}")
    @Results (value = {
                        @Result(property="status_verifikasi", column="status_verifikasi")
    })
    String selectStatusVerifikasi(@Param("username") String username);
    
    @Update("update biodata set status_verifikasi = 'Verified' where username = #{username}")
    void updateStatus(@Param("username") String username);
}