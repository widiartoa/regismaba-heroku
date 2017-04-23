package id.ac.univ.regismaba.service;

import java.util.ArrayList;
import java.util.List;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.RekapitulasiJaketModel;

public interface RekapitulasiJaketService {

	RekapitulasiJaketModel selectRekapUkuran(String ukuran_jaket);
	
	RekapitulasiJaketModel selectRekapFakultas(int fakultas_id);
	
	List<String> getSizes();
	
	List<FakultasModel> getFaculties();
	
	ArrayList<RekapitulasiJaketModel> selectUkuranOfFakultas(int fakultas_id);
}
