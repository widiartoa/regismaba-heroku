package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.ProvinsiMapper;
import id.ac.univ.regismaba.model.ProvinsiModel;

@Service
public class ProvinsiServiceImplements implements ProvinsiService{
//
	@Autowired
	ProvinsiMapper provinsiMapper;
	
//	@Override
//	public int selectProvinsiId(ProvinsiModel provinsi) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
	@Override
	public List<ProvinsiModel> selectAllProvinsi() {
		// TODO Auto-generated method stub
		return provinsiMapper.selectAllProvinsi();
	}

	@Override
	public ProvinsiModel selectProvinsi(int provinsi_id) {
		// TODO Auto-generated method stub
		return provinsiMapper.selectProvinsi(provinsi_id);
	}
}
