package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.PengajuanSkemaBiayaModel;

public interface PengajuanSkemaBiayaService {

	PengajuanSkemaBiayaModel selectPSBM (int pengajuan_id);
	
	PengajuanSkemaBiayaModel selectPSBMFromUsername (String username);
	
	List<PengajuanSkemaBiayaModel> selectAllPSBM ();

	void insertPSBM(PengajuanSkemaBiayaModel psbm);
	
	void updatePSBM(PengajuanSkemaBiayaModel psbm);
	
	void insertGolongan(PengajuanSkemaBiayaModel psbm);
	
	void updateGolongan(PengajuanSkemaBiayaModel psbm);
	
	void updatePengajuan(PengajuanSkemaBiayaModel psbm);
}
