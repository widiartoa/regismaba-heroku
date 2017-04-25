package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.ProvinsiModel;

public interface ProvinsiService {
//	int selectProvinsiId(ProvinsiModel provinsi);
//
	List<ProvinsiModel> selectAllProvinsi();
	
	ProvinsiModel selectProvinsi(int provinsi_id);
}
