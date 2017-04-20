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
    public String selectStatusVerifikasi (String username)
    {
        log.info ("select status_verifikasi of " + username);
        return verifikasiIDMMapper.selectStatusVerifikasi (username);
    }
    
    @Override
    public void updateStatusVerify (String username)
    {
        log.info ("update " + username);
        verifikasiIDMMapper.updateStatusVerify (username);
    }

    @Override
    public void updateStatusUnverify (String username)
    {
        log.info ("update " + username);
        verifikasiIDMMapper.updateStatusUnverify (username);
    }
    
    @Override
    public void updateComment(String username, String komentar)
    {
        log.info ("update comment " + username);
        verifikasiIDMMapper.updateComment (username, komentar);
    }
}
