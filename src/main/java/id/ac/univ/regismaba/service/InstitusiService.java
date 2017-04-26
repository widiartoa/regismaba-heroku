
package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.InstitusiModel;

public interface InstitusiService {
	InstitusiModel selectInstitusi(int institusi_id);
	
	List<InstitusiModel> selectInstitusiByTingkatPendidikanId(int tingkat_pendidikan_id);
}
