package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.RekapitulasiJaketMapper;
import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.RekapitulasiJaketModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RekapitulasiJaketServiceImpl implements RekapitulasiJaketService {

	@Autowired
	RekapitulasiJaketMapper rjm;

	@Override
	public RekapitulasiJaketModel selectRekapUkuran(String ukuran_jaket) {
		// TODO Auto-generated method stub
		log.info ("select ukuran_jaket with size {}", ukuran_jaket);
		return rjm.selectRekapUkuran(ukuran_jaket);
	}

	@Override
	public RekapitulasiJaketModel selectRekapFakultas(int fakultas_id) {
		// TODO Auto-generated method stub
		log.info ("select fakultas_id with id {}", fakultas_id);
		return rjm.selectRekapFakultas(fakultas_id);
	}

	@Override
	public List<String> getSizes() {
		// TODO Auto-generated method stub
		log.info ("get list of jacket sizes");
		return rjm.getSizes();
	}

	@Override
	public List<FakultasModel> getFaculties() {
		// TODO Auto-generated method stub
		log.info ("get list of faculty names");
		return rjm.getFaculties();
	}

	@Override
	public RekapitulasiJaketModel selectUkuranOfFakultas(int fakultas_id) {
		// TODO Auto-generated method stub
		log.info ("select fakultas_id with id {}", fakultas_id);
		return rjm.selectUkuranOfFakultas(fakultas_id);
	}
}
