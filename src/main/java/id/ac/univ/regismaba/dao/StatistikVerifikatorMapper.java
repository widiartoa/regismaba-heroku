package id.ac.univ.regismaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.univ.regismaba.model.StatistikManagerModel;

@Mapper
public class StatistikVerifikatorMapper
{
    @Select("select j.nama_jalur as jenis_rekap, count(*) as jumlah from jalur j, "
            + "mahasiswa m, biodata b where "
            + "m.username=b.username and j.jalur_id=m.jalur_id and b.status_verifikasi = 'Verified'"
            + "j.nama_jalur='SNMPTN' group by j.nama_jalur")
    StatistikVerifikatorModel selectVerifiedSNMPTN();
}
