package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.KotaKabupatenModel;

public interface KotaKabupatenService {
	List<KotaKabupatenModel> selectKotaKabupatenByProvinsiId(int provinsi_id);
	
	KotaKabupatenModel selectKotaKabupaten(int kota_kabupaten_id);
}
