package id.ac.univ.regismaba.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.RekapitulasiJaketModel;

public interface RekapitulasiJaketService {

	RekapitulasiJaketModel selectRekapUkuran(String ukuran_jaket);
	
	RekapitulasiJaketModel selectRekapFakultas(int fakultas_id);
	
	List<String> getSizes();
	
	List<FakultasModel> getFaculties();
	
	RekapitulasiJaketModel selectUkuranOfFakultas(int fakultas_id);
}
