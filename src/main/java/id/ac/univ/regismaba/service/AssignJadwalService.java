package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.AssignJadwalModel;

public interface AssignJadwalService {

	AssignJadwalModel selectAssignJadwal(String npm);
	
	List<AssignJadwalModel> selectAllAssignJadwal();

}
