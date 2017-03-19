package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.BiodataMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BiodataServiceImplement implements BiodataService
{
    @Autowired
    BiodataMapper biodataMapper;
}
