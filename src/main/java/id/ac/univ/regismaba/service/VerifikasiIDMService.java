package id.ac.univ.regismaba.service;

public interface VerifikasiIDMService
{
    String selectStatusVerifikasi (String username);
    
    void updateStatus (String username);
}
