package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.DataKesehatanModel;


public interface DataKesehatanService {
	int selectDataKesehatanId(DataKesehatanModel dataKesehatan);
	
	void insertDataKesehatan(DataKesehatanModel dataKesehatan);
	
	DataKesehatanModel selectDataKesehatanByUsername(String username);
}
