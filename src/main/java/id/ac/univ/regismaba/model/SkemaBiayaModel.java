package id.ac.univ.regismaba.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SkemaBiayaModel
{
    int golongan_id;
    int jumlah_biaya_ipa_min;
    int uang_pangkal_ipa_min;
    int jumlah_biaya_ips_min;
    int uang_pangkal_ips_min;
    int jumlah_biaya_ik_min;
    int uang_pangkal_ik_min;
    int jumlah_biaya_ipa_max;
    int uang_pangkal_ipa_max;
    int jumlah_biaya_ips_max;
    int uang_pangkal_ips_max;
    int jumlah_biaya_ik_max;
    int uang_pangkal_ik_max;
    String created_by;
    String updated_by;
    Timestamp created_at;
    Timestamp updated_at;
    int tingkat_role_id;
}
