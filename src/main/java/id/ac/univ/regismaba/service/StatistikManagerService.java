package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JenjangModel;
import id.ac.univ.regismaba.model.ProgramModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;
import id.ac.univ.regismaba.model.StatistikManagerModel;

public interface StatistikManagerService {

	StatistikManagerModel selectPemilihFakultas(int fakultas_id);
	
	StatistikManagerModel selectPemilihProdi(int program_studi_id);
	
	StatistikManagerModel selectJenjang(int jenjang_id);
	
	StatistikManagerModel selectProgram(int program_id);
	
	List<FakultasModel> getFaculties();
	
	List<ProgramStudiModel> getMajors();
	
	List<JenjangModel> getLevels();
	
	List<ProgramModel> getPrograms();
	
	StatistikManagerModel selectRegistranFakultas(int fakultas_id);
	
}
