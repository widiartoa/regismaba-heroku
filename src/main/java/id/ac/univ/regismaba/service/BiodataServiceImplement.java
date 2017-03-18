package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.BiodataMapper;
import id.ac.univ.regismaba.model.IjazahModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BiodataServiceImplement implements BiodataService
{
    @Autowired
    BiodataMapper biodataMapper;
    
    @Override
    public IjazahModel selectIjazah(String nomor_ijazah)
    {
        log.info ("select ijazah with nomor_ijazah {}", nomor_ijazah);
        return biodataMapper.selectIjazah (nomor_ijazah);
    }
    
    @Override
    public void addIjazah(String nomor_ijazah)
    {
        log.info ("add ijazah with nomor_ijazah {}", nomor_ijazah);
    }
}
