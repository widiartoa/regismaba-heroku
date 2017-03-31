package id.ac.univ.regismaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KotaKabupatenModel {
	int kota_kabupaten_id;
	int provinsi_id;
	String nama_kota_kabupaten;
}
