package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.AsuransiKesehatanModel;

public interface AsuransiKesehatanService {
    void insertAsuransiKesehatan(AsuransiKesehatanModel asuransiKesehatan);
    
    AsuransiKesehatanModel selectAsuransiKesehatanByUsername(String username);
    
    void updateAsuransiKesehatan(AsuransiKesehatanModel asuransiKesehatan);
}
