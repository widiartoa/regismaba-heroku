package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.SkemaBiayaMapper;
import id.ac.univ.regismaba.model.SkemaBiayaModel;
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
}
