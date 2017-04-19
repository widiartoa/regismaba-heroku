package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.VerifikasiIDMMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VerifikasiIDMServiceImplement implements VerifikasiIDMService
{
    @Autowired
    VerifikasiIDMMapper verifikasiIDMMapper;


    @Override
    public void updateStatus (String username)
    {
        log.info ("update " + username);
        verifikasiIDMMapper.updateStatus (username);
    }


    @Override
    public String selectStatusVerifikasi (String username)
    {
        log.info ("select status_verifikasi of " + username);
        return verifikasiIDMMapper.selectStatusVerifikasi (username);
    }

}
