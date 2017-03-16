package id.ac.univ.regismaba.model;

import lombok.Data;
import java.util.Date;

@Data
public class JadwalRegisModel {
	int jadwal_registrasi_id;
	Date timestamp_awal;
	Date timestamp_akhir;
}
