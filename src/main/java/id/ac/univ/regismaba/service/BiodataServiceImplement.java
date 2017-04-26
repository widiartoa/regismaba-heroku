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
		return biodataMapper.selectBiodata(biodata_id);
	}

	@Override
	public void insertBiodata(BiodataModel biodata) {
		log.info("insert "+biodata.getBiodata_id());
		biodataMapper.insertBiodata(biodata);
	}

	@Override
	public String updateBiodata(String biodata_id) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public BiodataModel selectBiodataByUsername(String username) {
		return biodataMapper.selectBiodataByUsername(username);
	}
}
