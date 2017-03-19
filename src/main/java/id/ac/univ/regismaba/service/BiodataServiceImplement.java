package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.BiodataMapper;
import id.ac.univ.regismaba.model.BiodataModel;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BiodataServiceImplement implements BiodataService{
	@Autowired
	private BiodataMapper biodataMapper;

	@Override
	public BiodataModel selectBiodata(int biodata_id) {
		// TODO Auto-generated method stub
		biodataMapper.selectBiodata(biodata_id);
		return null;
	}

	@Override
	public void insertBiodata(BiodataModel biodata) {
		log.info("insert "+biodata.getBiodata_id());
		biodataMapper.insertBiodata(biodata);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String updateBiodata(String biodata_id) {
		// TODO Auto-generated method stub
		return null;
		
	}
}
