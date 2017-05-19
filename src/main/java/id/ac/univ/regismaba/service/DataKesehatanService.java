package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.DataKesehatanModel;


public interface DataKesehatanService {
	int selectDataKesehatanId(DataKesehatanModel dataKesehatan);
	
	void insertDataKesehatan(DataKesehatanModel dataKesehatan);
	
	DataKesehatanModel selectDataKesehatanByUsername(String username);
	
	void updateDataKesehatan(DataKesehatanModel dataKesehatan);
	
//	List<DataKesehatanModel> selectAllDataKesehatan();
}
