package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.BiodataModel;

public interface VerifikasiIDMService
{
    String selectStatusVerifikasi (String username);
    
    String selectKomentar(String username);
    
    List<BiodataModel> selectAllBiodata ();
    
    void updateStatusVerify (String username);
    
    void updateStatusUnverify (String username);
    
    void updateComment(String username, String komentar);
}
