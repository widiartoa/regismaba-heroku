package id.ac.univ.regismaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.AlamatModel;
import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.model.IjazahModel;
import id.ac.univ.regismaba.model.InstitusiModel;
import id.ac.univ.regismaba.model.KotaKabupatenModel;
import id.ac.univ.regismaba.model.ProvinsiModel;

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
    
    @Select("select * from alamat")
    List<AlamatModel> selectAllAlamat ();

    @Select("select * from kota_kabupaten")
    List<KotaKabupatenModel> selectAllKotaKab ();
    
    @Select("select * from provinsi")
    List<ProvinsiModel> selectAllProvinsi ();
    
    @Select("select * from ijazah")
    List<IjazahModel> selectAllIjazah ();
    
    @Select("select * from institusi")
    List<InstitusiModel> selectAllInstitusi ();
    
    @Select("select * from data_kesehatan")
    List<DataKesehatanModel> selectAllDataKesehatan ();
    
    @Update("update biodata set status_verifikasi = 'Verified' where username = #{username}")
    void updateStatusVerify (@Param("username") String username);


    @Update("update biodata set status_verifikasi = 'Unverified' where username = #{username}")
    void updateStatusUnverify (@Param("username") String username);


    @Update("update biodata set komentar = #{komentar} where username = #{username}")
    void updateComment (@Param("username") String username,
            @Param("komentar") String komentar);
    
    @Select("select u.email as email from user u, mahasiswa m where u.username = m.username and m.username = #{username}")
    String selectUserEmail(@Param("username") String username);
}