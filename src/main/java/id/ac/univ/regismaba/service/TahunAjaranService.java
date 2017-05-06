package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.TahunAjaranModel;

public interface TahunAjaranService {
	TahunAjaranModel selectTahunAjaranSaatIni();

	TahunAjaranModel selectTahunAjaran(int tahun_ajaran_id);
}
