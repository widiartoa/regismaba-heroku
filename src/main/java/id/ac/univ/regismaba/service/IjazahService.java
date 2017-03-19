package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.IjazahModel;

public interface IjazahService
{
    IjazahModel selectIjazah(String nomor_ijazah);
    
    void addIjazah(IjazahModel ijazah);
}