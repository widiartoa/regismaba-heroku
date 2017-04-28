package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.TingkatPendidikanMapper;
import id.ac.univ.regismaba.model.TingkatPendidikanModel;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TingkatPendidikanServiceImplement implements TingkatPendidikanService {
	@Autowired
	TingkatPendidikanMapper tingkatPendidikanMapper;

	@Override
	public TingkatPendidikanModel selectTingkatPendidikan(int tingkat_pendidikan_id) {
		// TODO Auto-generated method stub
		return tingkatPendidikanMapper.selectTingkatPendidikan(tingkat_pendidikan_id);
	}
	
	@Override
	public List<TingkatPendidikanModel> selectAllTingkatPendidikan() {
		// TODO Auto-generated method stub
		return tingkatPendidikanMapper.selectAllTingkatPendidikan();
	}
	
	
}
