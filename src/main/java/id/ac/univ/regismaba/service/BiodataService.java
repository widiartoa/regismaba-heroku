package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.IjazahModel;

public interface BiodataService
{
    IjazahModel selectIjazah(String nomor_ijazah);
    
    void addIjazah(String nomor_ijazah);
}
