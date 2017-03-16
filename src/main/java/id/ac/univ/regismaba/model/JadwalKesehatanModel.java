package id.ac.univ.regismaba.model;

import lombok.Data;
import java.util.Date;

@Data
public class JadwalKesehatanModel {
	int jadwal_tes_kesehatan_id;
	Date timestamp_awal;
	Date timestamp_akhir;
}
