
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
	String komentar;
	String created_by;
	String updated_by;
	Date updated_at;
	String created_at;
	int agama_id;
	String hari_update;
	String tanggal_update;
	String waktu_update;
	String tanggal_lahirr;
}
