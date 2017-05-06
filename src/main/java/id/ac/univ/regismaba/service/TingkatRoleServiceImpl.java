package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.TingkatRoleMapper;
import id.ac.univ.regismaba.model.TingkatRoleModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TingkatRoleServiceImpl implements TingkatRoleService {

	@Autowired
	TingkatRoleMapper trm;

	@Override
	public TingkatRoleModel selectTRM(int tingkat_role_id) {
		// TODO Auto-generated method stub
		log.info ("select tingkat role with id {}", tingkat_role_id);
		return trm.selectTRM(tingkat_role_id);
	}

	@Override
	public List<TingkatRoleModel> selectAllTRM() {
		// TODO Auto-generated method stub
		log.info ("select all tingkat role");
		return trm.selectAllTRM();
	}
}
