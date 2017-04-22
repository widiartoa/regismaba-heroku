package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.AgamaMapper;
import id.ac.univ.regismaba.model.AgamaModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AgamaServiceImplement implements AgamaService {

	@Autowired
	AgamaMapper agamaMapper;

	@Override
	public AgamaModel selectAgama(int agama_id) {
		// TODO Auto-generated method stub
		return agamaMapper.selectAgama(agama_id);
	}
}
