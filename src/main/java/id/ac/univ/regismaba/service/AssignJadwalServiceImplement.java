package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.AssignJadwalMapper;
import id.ac.univ.regismaba.model.AssignJadwalModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AssignJadwalServiceImplement implements AssignJadwalService {

	@Autowired
	AssignJadwalMapper assignJadwalMapper;

	@Override
	public AssignJadwalModel selectAssignJadwal(String npm) {
		// TODO Auto-generated method stub
		log.info("select assign jadwal mahasiswa with npm {}", npm);
		return assignJadwalMapper.selectAssignJadwal(npm);
	}

}
