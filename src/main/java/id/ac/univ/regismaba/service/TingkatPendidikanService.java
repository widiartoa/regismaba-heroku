package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.TingkatPendidikanModel;

public interface TingkatPendidikanService {
	List<TingkatPendidikanModel> selectAllTingkatPendidikan();
	
	TingkatPendidikanModel selectTingkatPendidikan(int tingkat_pendidikan_id);
}
