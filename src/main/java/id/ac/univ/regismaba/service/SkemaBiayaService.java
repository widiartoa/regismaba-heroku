package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.SkemaBiayaModel;

public interface SkemaBiayaService {

	SkemaBiayaModel selectSBM(int golongan_id);
	
	List<SkemaBiayaModel> selectAllSBM();
	
	void insertSBM(SkemaBiayaModel sbm);
	
	void updateSBM(SkemaBiayaModel sbm);
	
}
