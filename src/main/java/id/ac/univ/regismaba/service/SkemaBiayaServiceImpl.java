package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.SkemaBiayaMapper;
import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SkemaBiayaServiceImpl implements SkemaBiayaService {

	@Autowired
	SkemaBiayaMapper sbmd;

	@Override
	public SkemaBiayaModel selectSBM(int golongan_id) {
		// TODO Auto-generated method stub
		log.info ("select skema biaya with golongan_id {}", golongan_id);
		return sbmd.selectSBM(golongan_id);
	}

	@Override
	public void insertSBM(SkemaBiayaModel sbm) {
		// TODO Auto-generated method stub
		log.info ("insert skema biaya");
		sbmd.insertSBM(sbm);
	}

	@Override
	public void updateSBM(SkemaBiayaModel sbm) {
		// TODO Auto-generated method stub
		log.info ("update skema biaya");
		sbmd.updateSBM(sbm);
	}

	@Override
	public List<SkemaBiayaModel> selectAllSBM() {
		// TODO Auto-generated method stub
		log.info ("select all skema biaya");
		return sbmd.selectAllSBM();
	}

	@Override
	public List<SkemaBiayaModel> selectAllSBMByFacultyLevel() {
		// TODO Auto-generated method stub
		log.info ("select all skema biaya on faculty level");
		return sbmd.selectAllSBMByFacultyLevel();
	}

	@Override
	public StatistikManagerSummaryModel summarySchema(int golongan_id) {
		// TODO Auto-generated method stub
		log.info ("select skema summary with golongan_id {}", golongan_id);
		return sbmd.summarySchema(golongan_id);
	}

	@Override
	public StatistikManagerSummaryModel selectSchemaType(int golongan_id, int fakultas_id) {
		// TODO Auto-generated method stub
		log.info ("select skema golongan with fakultas");
		return sbmd.selectSchemaType(golongan_id, fakultas_id);
	}

	@Override
	public List<FakultasModel> getFaculties() {
		// TODO Auto-generated method stub
		log.info ("select all fakultas");
		return sbmd.getFaculties();
	}
}
