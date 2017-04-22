package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.RekapitulasiJaketModel;

public interface RekapitulasiJaketService {

	RekapitulasiJaketModel selectRekapUkuran(String ukuran_jaket);
	
	RekapitulasiJaketModel selectRekapFakultas(String nama_fakultas);
	
	List<String> getSizes();
	
	List<String> getFaculties();
}
