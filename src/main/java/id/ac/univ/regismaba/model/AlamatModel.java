package id.ac.univ.regismaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlamatModel {
	int jalan_id;
	int kota_kabupaten_id;
	String jalan;
	String kecamatan;
	String kelurahan;
	String kode_pos;
	String created_at;
	String created_by;
	String updated_by;
	String updated_at;
}
