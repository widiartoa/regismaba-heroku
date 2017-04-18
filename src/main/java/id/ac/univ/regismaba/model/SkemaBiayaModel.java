package id.ac.univ.regismaba.model;

import java.sql.Date;

import lombok.Data;

@Data
public class SkemaBiayaModel
{
    int golongan_id;
    int jumlah_biaya_ipa;
    int uang_pangkal_ipa;
    int jumlah_biaya_ips;
    int uang_pangkal_ips;
    int jumlah_biaya_ik;
    int uang_pangkal_ik;
    String created_by;
    String updated_by;
}
