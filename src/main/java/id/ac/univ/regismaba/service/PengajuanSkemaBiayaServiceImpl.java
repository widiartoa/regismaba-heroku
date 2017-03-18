package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.PengajuanSkemaBiayaMapper;
import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PengajuanSkemaBiayaServiceImpl implements PengajuanSkemaBiayaService {

	@Autowired
	PengajuanSkemaBiayaMapper psbd;

	@Override
	public PengajuanSkemaBiayaModel selectPSBM(int pengajuan_id) {
		log.info ("select pengajuan skema biaya with pengajuan_id {}", pengajuan_id);
		return psbd.selectPSBM(pengajuan_id);
	}

	@Override
	public void insertPSBM(PengajuanSkemaBiayaModel psbm) {
		// TODO Auto-generated method stub
		log.info ("insert pengajuan skema biaya");
		psbd.insertPSBM(psbm);
	}

	@Override
	public void updatePSBM(PengajuanSkemaBiayaModel psbm) {
		// TODO Auto-generated method stub
		log.info ("update pengajuan skema biaya");
		psbd.updatePSBM(psbm);
	}
}
