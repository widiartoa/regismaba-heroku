package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.KotaKabupatenMapper;
import id.ac.univ.regismaba.model.KotaKabupatenModel;

@Service
public class KotaKabupatenServiceImplement implements KotaKabupatenService {

	@Autowired
	KotaKabupatenMapper kotaKabupatenMapper;
	
	@Override
	public List<KotaKabupatenModel> selectKotaKabupatenByProvinsiId(int provinsi_id) {
		return kotaKabupatenMapper.selectKotaKabupatenByProvinsiId(provinsi_id);
	}

}
