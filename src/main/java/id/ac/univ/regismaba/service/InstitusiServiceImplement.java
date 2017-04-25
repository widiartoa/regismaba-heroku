package id.ac.univ.regismaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.InstitusiMapper;
import id.ac.univ.regismaba.model.InstitusiModel;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class InstitusiServiceImplement implements InstitusiService {
	@Autowired
	InstitusiMapper institusiMapper;

	@Override
	public InstitusiModel selectInstitusi(int institusi_id) {
		// TODO Auto-generated method stub
		return institusiMapper.selectInstitusi(institusi_id);
	}
	
	@Override
	public List<InstitusiModel> selectInstitusiByTingkatPendidikanId(int tingkat_pendidikan_id) {
		return institusiMapper.selectInstitusiByTingkatPendidikanId(tingkat_pendidikan_id);
	}
}
