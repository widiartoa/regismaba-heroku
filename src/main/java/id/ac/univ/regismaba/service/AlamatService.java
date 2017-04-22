package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.AlamatModel;

public interface AlamatService {

	void insertAlamat(AlamatModel alamat);

	int selectJalanId(AlamatModel alamat);
		
	AlamatModel selectAlamat(int jalan_id);
	
}
