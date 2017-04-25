package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.JenjangMapper;
import id.ac.univ.regismaba.model.JenjangModel;

@Service
public class JenjangServiceImplement implements JenjangService {
	@Autowired
	JenjangMapper jenjangMapper;
	
	@Override
	public List<JenjangModel> selectAllJenjang() {
		// TODO Auto-generated method stub
		return jenjangMapper.selectAllJenjang();
	}

	@Override
	public JenjangModel selectJenjang(int jenjang_id) {
		// TODO Auto-generated method stub
		return jenjangMapper.selectJenjang(jenjang_id);
	}
}
