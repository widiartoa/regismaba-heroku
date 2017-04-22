package id.ac.univ.regismaba.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiodataModel {
	int biodata_id;
	String username;
	int jalan_id;
	Date tanggal_lahir;
	String jenis_kelamin;
	String nomor_telepon;
	String kewarganegaraan;
	String nomor_ktp;
	String sidik_jari;
	String scan_ktp;
	String scan_kk;
	String scan_surat_pernyataan_mahasiswa;
	String status_verifikasi;
	String flag_aktif;
	String ukuran_jaket;
}
