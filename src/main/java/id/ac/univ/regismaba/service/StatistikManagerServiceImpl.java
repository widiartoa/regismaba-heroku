package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.StatistikManagerMapper;
import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.JalurModel;
import id.ac.univ.regismaba.model.JenjangModel;
import id.ac.univ.regismaba.model.ProgramModel;
import id.ac.univ.regismaba.model.ProgramStudiModel;
import id.ac.univ.regismaba.model.StatistikManagerModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StatistikManagerServiceImpl implements StatistikManagerService{
	
	@Autowired
	StatistikManagerMapper smm;
	
	@Override
	public StatistikManagerModel selectPemilihFakultas(int fakultas_id) {
		// TODO Auto-generated method stub
		log.info ("select fakultas with id {}", fakultas_id);
		return smm.selectPemilihFakultas(fakultas_id);
	}

	@Override
	public StatistikManagerModel selectPemilihProdi(int program_studi_id) {
		// TODO Auto-generated method stub
		log.info ("select prodi with id {}", program_studi_id);
		return smm.selectPemilihProdi(program_studi_id);
	}

	@Override
	public StatistikManagerModel selectJenjang(int jenjang_id) {
		// TODO Auto-generated method stub
		log.info ("select jenjang with id {}", jenjang_id);
		return smm.selectJenjang(jenjang_id);
	}

	@Override
	public StatistikManagerModel selectProgram(int program_id) {
		// TODO Auto-generated method stub
		log.info ("select program with id {}", program_id);
		return smm.selectProgram(program_id);
	}

	@Override
	public List<FakultasModel> getFaculties() {
		// TODO Auto-generated method stub
		log.info ("select faculties");
		return smm.getFaculties();
	}

	@Override
	public List<ProgramStudiModel> getMajors() {
		// TODO Auto-generated method stub
		log.info ("select study programs");
		return smm.getMajors();
	}

	@Override
	public List<JenjangModel> getLevels() {
		// TODO Auto-generated method stub
		log.info ("select levels");
		return smm.getLevels();
	}

	@Override
	public List<ProgramModel> getPrograms() {
		// TODO Auto-generated method stub
		log.info ("select programs");
		return smm.getPrograms();
	}

	@Override
	public StatistikManagerModel selectRegistranFakultas(int fakultas_id) {
		// TODO Auto-generated method stub
		log.info ("select registran fakultas with id {}", fakultas_id);
		return smm.selectRegistranFakultas(fakultas_id);
	}

	@Override
	public StatistikManagerModel selectRegistranProdi(int program_studi_id) {
		// TODO Auto-generated method stub
		log.info ("select registran prodi with id {}", program_studi_id);
		return smm.selectRegistranProdi(program_studi_id);
	}

	@Override
	public StatistikManagerModel selectRegistranJenjang(int jenjang_id) {
		// TODO Auto-generated method stub
		log.info ("select registran jenjang with id {}", jenjang_id);
		return smm.selectRegistranJenjang(jenjang_id);
	}

	@Override
	public StatistikManagerModel selectRegistranProgram(int program_id) {
		// TODO Auto-generated method stub
		log.info ("select registran program with id {}", program_id);
		return smm.selectRegistranProgram(program_id);
	}

	@Override
	public StatistikManagerSummaryModel summaryFaculty(int fakultas_id) {
		// TODO Auto-generated method stub
		log.info ("select summary fakultas with id {}", fakultas_id);
		return smm.summaryFaculty(fakultas_id);
	}

	@Override
	public StatistikManagerSummaryModel summaryMajor(int program_studi_id) {
		// TODO Auto-generated method stub
		log.info ("select summary prodi with id {}", program_studi_id);
		return smm.summaryMajor(program_studi_id);
	}

	@Override
	public StatistikManagerSummaryModel summaryLevel(int jenjang_id) {
		// TODO Auto-generated method stub
		log.info ("select summary jenjang with id {}", jenjang_id);
		return smm.summaryLevel(jenjang_id);
	}

	@Override
	public StatistikManagerSummaryModel summaryProgram(int program_id) {
		// TODO Auto-generated method stub
		log.info ("select summary program with id {}", program_id);
		return smm.summaryProgram(program_id);
	}

	@Override
	public StatistikManagerModel selectJalur(int jalur_id) {
		// TODO Auto-generated method stub
		log.info ("select jalur with id {}", jalur_id);
		return smm.selectJalur(jalur_id);
	}

	@Override
	public List<JalurModel> getPaths() {
		// TODO Auto-generated method stub
		log.info ("select paths");
		return smm.getPaths();
	}

	@Override
	public StatistikManagerModel selectRegistranJalur(int jalur_id) {
		// TODO Auto-generated method stub
		log.info ("select registran jalur with id {}", jalur_id);
		return smm.selectRegistranJalur(jalur_id);
	}

	@Override
	public StatistikManagerSummaryModel summaryPath(int jalur_id) {
		// TODO Auto-generated method stub
		log.info ("select summary path with id {}", jalur_id);
		return smm.summaryPath(jalur_id);
	}

}
