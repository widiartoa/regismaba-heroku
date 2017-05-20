package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;

public interface SkemaBiayaService {

	SkemaBiayaModel selectSBM(int golongan_id);
	
	List<SkemaBiayaModel> selectAllSBM();
	
	void insertSBM(SkemaBiayaModel sbm);
	
	void updateSBM(SkemaBiayaModel sbm);
	
	List<SkemaBiayaModel> selectAllSBMByFacultyLevel();
	
	StatistikManagerSummaryModel summarySchema(int golongan_id);
	
	StatistikManagerSummaryModel selectSchemaType(int golongan_id, int fakultas_id);
	
	List<FakultasModel> getFaculties();
}
