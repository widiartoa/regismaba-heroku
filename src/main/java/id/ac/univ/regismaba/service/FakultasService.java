package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.FakultasModel;

public interface FakultasService {

	List<FakultasModel> selectAllFakultas();
	
	FakultasModel selectFakultas(int fakultas_id);
}
