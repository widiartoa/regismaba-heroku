package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.FakultasMapper;
import id.ac.univ.regismaba.model.FakultasModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FakultasServiceImplement implements FakultasService {

	@Autowired
	FakultasMapper fakultasMapper;

	@Override
	public List<FakultasModel> selectAllFakultas() {
		// TODO Auto-generated method stub
		log.info("select all fakultas unordered");
		List<FakultasModel> fakultasList = fakultasMapper.selectAllFakultas();

		return fakultasList;
	}

	@Override
	public FakultasModel selectFakultas(int fakultas_id) {
		// TODO Auto-generated method stub
		FakultasModel fakultas = fakultasMapper.selectFakultas(fakultas_id);
		
		return fakultas;
	}

}
