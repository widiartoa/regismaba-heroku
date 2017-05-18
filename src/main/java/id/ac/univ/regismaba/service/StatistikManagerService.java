package id.ac.univ.regismaba.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JalurModel;
import id.ac.univ.regismaba.model.JenjangModel;
import id.ac.univ.regismaba.model.ProgramModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;
import id.ac.univ.regismaba.model.StatistikManagerModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;

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
	
	StatistikManagerModel selectRegistranProdi(int program_studi_id);
	
	StatistikManagerModel selectRegistranJenjang(int jenjang_id);
	
	StatistikManagerModel selectRegistranProgram(int program_id);

	StatistikManagerSummaryModel summaryFaculty(int fakultas_id);
	
	StatistikManagerSummaryModel summaryMajor(int program_studi_id);
	
	StatistikManagerSummaryModel summaryLevel(int jenjang_id);
	
	StatistikManagerSummaryModel summaryProgram(int program_id);
	
	StatistikManagerModel selectJalur(int jalur_id);
	
	List<JalurModel> getPaths();
	
	StatistikManagerModel selectRegistranJalur(int jalur_id);
	
	StatistikManagerSummaryModel summaryPath(int jalur_id);
}
