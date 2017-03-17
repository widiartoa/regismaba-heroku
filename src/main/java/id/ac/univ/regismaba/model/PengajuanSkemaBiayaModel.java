package id.ac.univ.regismaba.model;

import lombok.Data;

@Data
public class PengajuanSkemaBiayaModel
{
    int pengajuan_id;
    int golongan_id;
    String surat_keterangan_rtrw;
    String foto_rumah;
    String slip_gaji_pribadi;
    String slip_gaji_wali1;
    String slip_gaji_wali2;
    String tagihan_air;
    String tagihan_listrik;
    String tagihan_telepon;
}
