package id.ac.univ.regismaba.model;

import lombok.Data;
import java.util.Date;

@Data
public class JadwalEptModel {
	int jadwal_ept_id;
	Date timestamp_awal;
	Date timestamp_akhir;
}
