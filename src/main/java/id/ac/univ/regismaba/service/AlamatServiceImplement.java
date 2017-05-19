package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.AlamatMapper;
import id.ac.univ.regismaba.model.AlamatModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlamatServiceImplement implements AlamatService {

	@Autowired
	AlamatMapper alamatMapper;

	@Override
	public void insertAlamat(AlamatModel alamat) {
		// TODO Auto-generated method stub
		alamatMapper.insertAlamat(alamat);
	}

	@Override
	public int selectJalanId(AlamatModel alamat) {
		// TODO Auto-generated method stub
		log.info("id alamat " + alamat.getJalan_id());
		Integer iD = alamatMapper.selectJalanId(alamat);
		if (iD == null) {
			return 0;
		} else {
			int id = (int) iD;
			log.info("id " + id);
			String idStr = Integer.toString(id);
			log.info("id Str " + idStr);
			return id;
		}
	}

	@Override
	public AlamatModel selectAlamat(int jalan_id) {
		// TODO Auto-generated method stub
		return alamatMapper.selectAlamat(jalan_id);
	}

	@Override
	public void updateAlamat(AlamatModel alamat) {
		alamatMapper.updateAlamat(alamat);
	
		
	}

	@Override
	public int selectJalanIdByUsername(String username) {
		// TODO Auto-generated method stub
		return alamatMapper.selectJalanIdByUsername(username);
	}
	
	

}
