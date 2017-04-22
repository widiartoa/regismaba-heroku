package id.ac.univ.regismaba.service;

public interface VerifikasiIDMService
{
    String selectStatusVerifikasi (String username);
    
    String selectKomentar(String username);
    
    void updateStatusVerify (String username);
    
    void updateStatusUnverify (String username);
    
    void updateComment(String username, String komentar);
}
