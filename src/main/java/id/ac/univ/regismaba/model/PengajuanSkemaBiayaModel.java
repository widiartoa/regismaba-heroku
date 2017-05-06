package id.ac.univ.regismaba.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PengajuanSkemaBiayaModel
{
    int pengajuan_id;
    int golongan_id;
    String username;
    int gaji_pribadi;
    int gaji_wali1;
    int gaji_wali2;
    int nilai_tagihan_air;
    int nilai_tagihan_listrik;
    int nilai_tagihan_telepon;
    String surat_keterangan_rtrw;
    String foto_rumah;
    String slip_gaji_pribadi;
    String slip_gaji_wali1;
    String slip_gaji_wali2;
    String tagihan_air;
    String tagihan_listrik;
    String tagihan_telepon;
    Timestamp created_at;
    Timestamp updated_at;
    String created_by;
    String updated_by;
    String status_pengajuan;
    String komentar;
    int uang_pangkal;
    int jumlah_biaya_semester;
    String status_pembayaran;
}
