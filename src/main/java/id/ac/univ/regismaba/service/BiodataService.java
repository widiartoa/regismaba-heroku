package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.BiodataModel;

public interface BiodataService {
	BiodataModel selectBiodata(int biodata_id);
		
	void insertBiodata(BiodataModel biodata);
		
	String updateBiodata(String biodata_id);
	
	BiodataModel selectBiodataByUsername(String username);
		
}
