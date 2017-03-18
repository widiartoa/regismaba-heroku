package id.ac.univ.regismaba.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;

public interface PengajuanSkemaBiayaService {

	PengajuanSkemaBiayaModel selectPSBM (int pengajuan_id);

	void insertPSBM(PengajuanSkemaBiayaModel psbm);
	
	void updatePSBM(PengajuanSkemaBiayaModel psbm);
}
