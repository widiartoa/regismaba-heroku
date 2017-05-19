package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.AssignJadwalMapper;
import id.ac.univ.regismaba.model.AssignJadwalModel;
import id.ac.univ.regismaba.model.TahunAjaranModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AssignJadwalServiceImplement implements AssignJadwalService {

	@Autowired
	AssignJadwalMapper assignJadwalMapper;
	
	@Autowired
	TahunAjaranService tahunAjaranService;
	
	@Autowired
	FakultasService fakultasService;

	@Override
	public AssignJadwalModel selectAssignJadwal(String npm) {
		// TODO Auto-generated method stub
		log.info("select assign jadwal mahasiswa with npm {}", npm);
		return assignJadwalMapper.selectAssignJadwal(npm);
	}

	@Override
	public List<AssignJadwalModel> selectAllAssignJadwal() {
		// TODO Auto-generated method stub
		TahunAjaranModel tahunAjaranSaatIni = tahunAjaranService.selectTahunAjaranSaatIni();
		List<AssignJadwalModel> assignedJadwals = assignJadwalMapper.selectAllAssignJadwal(tahunAjaranSaatIni.getTahun_ajaran_id());
		for (AssignJadwalModel assign : assignedJadwals){
			assign.setFakultas(fakultasService.selectFakultas(assign.getFakultas_id()));
		}
		
		return assignedJadwals;
	
	}

}
