package id.ac.univ.regismaba.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import id.ac.univ.regismaba.model.MahasiswaModel;
import id.ac.univ.regismaba.dao.MahasiswaMapper;

@Slf4j
@Service
public class MahasiswaServiceImplement implements MahasiswaService{
	@Autowired
    private MahasiswaMapper mahasiswaMapper;

    @Override
    public MahasiswaModel loginMahasiswa (String username, String password)
    {
        return mahasiswaMapper.loginMahasiswa (username, password);
    }
}
