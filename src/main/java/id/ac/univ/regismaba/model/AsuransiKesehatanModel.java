package id.ac.univ.regismaba.model;

import java.security.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AsuransiKesehatanModel {
	String nomor_asuransi;
	String username;
	String nomor_penerbit_asuransi;
	Date expired_date;
	String scan_kartu;
	String created_at;
	String created_by;
	String updated_by;
	String updated_at;
}
