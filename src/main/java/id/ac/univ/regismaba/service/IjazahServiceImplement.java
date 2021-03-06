package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.IjazahMapper;
import id.ac.univ.regismaba.model.IjazahModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IjazahServiceImplement implements IjazahService
{
    @Autowired
    IjazahMapper ijazahMapper;
    
//    @Override
//    public IjazahModel selectIjazahByNomor(String nomor_ijazah)
//    {
//        log.info ("select ijazah with nomor_ijazah {}", nomor_ijazah);
//        return ijazahMapper.selectIjazah (nomor_ijazah);
//    }
    
    @Override
    public void addIjazah(IjazahModel ijazah)
    {
        log.info ("add ijazah with nomor_ijazah {}", ijazah);
        ijazahMapper.addIjazah(ijazah);
    }
    
    @Override
    public IjazahModel selectIjazahByUsername(String username)
    {
        log.info ("select ijazah with username {}", username);
        return ijazahMapper.selectIjazahByUsername(username);
    }

	@Override
	public void updateIjazah(IjazahModel ijazah) {
		ijazahMapper.updateIjazah(ijazah);
		
	}
}