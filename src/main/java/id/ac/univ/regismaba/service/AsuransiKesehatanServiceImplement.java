package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.AsuransiKesehatanMapper;
import id.ac.univ.regismaba.model.AsuransiKesehatanModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsuransiKesehatanServiceImplement implements AsuransiKesehatanService {
	@Autowired
	private AsuransiKesehatanMapper asuransiKesehatanMapper;
	
	@Override
	public void insertAsuransiKesehatan(AsuransiKesehatanModel asuransiKesehatan) {
		// TODO Auto-generated method stub
		asuransiKesehatanMapper.insertAsuransiKesehatan(asuransiKesehatan);	
	}

	@Override
	public AsuransiKesehatanModel selectAsuransiKesehatanByUsername(String username) {
		// TODO Auto-generated method stub
		return asuransiKesehatanMapper.selectAsuransiKesehatanByUsername(username);
	}

}