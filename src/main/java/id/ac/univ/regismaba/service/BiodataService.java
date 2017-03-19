package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.BiodataMapper;
import id.ac.univ.regismaba.model.BiodataModel;
import lombok.extern.slf4j.Slf4j;

public interface BiodataService {
	BiodataModel selectBiodata(int biodata_id);
		
	void insertBiodata(BiodataModel biodata);
		
	String updateBiodata(String biodata_id);
		
}
