package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.RumpunMapper;
import id.ac.univ.regismaba.model.RumpunModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RumpunServiceImpl implements RumpunService {
	
	@Autowired
	RumpunMapper rm;
	
	@Override
	public RumpunModel getRumpun(String username) {
		// TODO Auto-generated method stub
		log.info ("select rumpun with username {}", username);
		return rm.getRumpun(username);
	}

}
