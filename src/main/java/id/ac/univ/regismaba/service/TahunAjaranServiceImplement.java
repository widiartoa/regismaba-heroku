package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.TahunAjaranMapper;
import id.ac.univ.regismaba.dao.TermMapper;
import id.ac.univ.regismaba.model.TahunAjaranModel;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TahunAjaranServiceImplement implements TahunAjaranService {
	@Autowired
	TahunAjaranMapper tahunAjaranMapper;
	TermMapper termMapper;

	@Override
	public TahunAjaranModel selectTahunAjaranSaatIni() {
		// TODO Auto-generated method stub
		TahunAjaranModel tahunAjaran = tahunAjaranMapper.selectTahunAjaranSaatIni();
		tahunAjaran.setTerm(termMapper.selectTerm(tahunAjaran.getTerm_id()));
		return tahunAjaran;
	}

	@Override
	public TahunAjaranModel selectTahunAjaran(int tahun_ajaran_id) {
		// TODO Auto-generated method stub
		TahunAjaranModel tahunAjaran = tahunAjaranMapper.selectTahunAjaran(tahun_ajaran_id);
		tahunAjaran.setTerm(termMapper.selectTerm(tahunAjaran.getTerm_id()));
		return tahunAjaran;
	}
	
	
}
