package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.JenjangModel;

public interface JenjangService {
	List<JenjangModel> selectAllJenjang();
	
	JenjangModel selectJenjang(int jenjang_id);
	
}
