package id.ac.univ.regismaba.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TahunAjaranModel {
	int tahun_ajaran_id;
	int term_id;
	String tahun_ajaran;
	Date timestamp_awal;
	Date timestamp_akhir;
	TermModel term;
}
