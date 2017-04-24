package id.ac.univ.regismaba.service;

import java.util.List;

import id.ac.univ.regismaba.model.AlamatModel;
import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.model.IjazahModel;
import id.ac.univ.regismaba.model.InstitusiModel;
import id.ac.univ.regismaba.model.KotaKabupatenModel;
import id.ac.univ.regismaba.model.ProvinsiModel;

public interface VerifikasiIDMService
{
    String selectStatusVerifikasi (String username);
    
    String selectKomentar(String username);
    
    List<BiodataModel> selectAllBiodata ();
    
    List<AlamatModel> selectAllAlamat ();
    
    List<KotaKabupatenModel> selectAllKotaKab ();
    
    List<ProvinsiModel> selectAllProvinsi ();
    
    List<IjazahModel> selectAllIjazah ();
    
    List<InstitusiModel> selectAllInstitusi ();
    
    List<DataKesehatanModel> selectAllDataKesehatan ();
    
    void updateStatusVerify (String username);
    
    void updateStatusUnverify (String username);
    
    void updateComment(String username, String komentar);
    
    String parseHariUpdateBiodata(BiodataModel biodata);
    
    String parseTanggalUpdateBiodata(BiodataModel biodata);
    
    String parseWaktuUpdateBiodata(BiodataModel biodata);
    
    String parseTanggalLahirBiodata(BiodataModel biodata);
}
