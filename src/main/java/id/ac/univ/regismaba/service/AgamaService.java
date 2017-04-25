package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.AgamaModel;

public interface AgamaService {
	AgamaModel selectAgama(int agama_id);
	
	List<AgamaModel> selectAllAgama();
	
}
