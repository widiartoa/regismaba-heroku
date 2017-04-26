package id.ac.univ.regismaba.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.VerifikasiIDMMapper;
import id.ac.univ.regismaba.model.AlamatModel;
import id.ac.univ.regismaba.model.BiodataModel;
import id.ac.univ.regismaba.model.DataKesehatanModel;
import id.ac.univ.regismaba.model.IjazahModel;
import id.ac.univ.regismaba.model.InstitusiModel;
import id.ac.univ.regismaba.model.KotaKabupatenModel;
import id.ac.univ.regismaba.model.ProvinsiModel;
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
    public String selectKomentar(String username)
    {
       log.info ("select komentar of " + username);
       return verifikasiIDMMapper.selectKomentar (username);
    }
    
    @Override
    public List<BiodataModel> selectAllBiodata ()
    {
        log.info ("select all biodata");
        List<BiodataModel> biodataList = verifikasiIDMMapper.selectAllBiodata ();

        for (BiodataModel biodata : biodataList) {
                String hariUpdate = this.parseHariUpdateBiodata (biodata);
                String tanggalUpdate = this.parseTanggalUpdateBiodata (biodata);
                String waktuUpdate = this.parseWaktuUpdateBiodata (biodata);
                String tanggalLahir = this.parseTanggalLahirBiodata (biodata);

                biodata.setHari_update (hariUpdate);
                biodata.setTanggal_update (tanggalUpdate);
                biodata.setWaktu_update (waktuUpdate);
                biodata.setTanggal_lahirr (tanggalLahir);
               
                log.info("updated_at {}", biodata.getCreated_by ());
        }
        return biodataList;
    }
    
    @Override
    public List<AlamatModel> selectAllAlamat ()
    {
        log.info ("select all alamat");
        return verifikasiIDMMapper.selectAllAlamat ();
    }
    
    @Override
    public List<KotaKabupatenModel> selectAllKotaKab ()
    {
        log.info ("select all kota/kab");
        return verifikasiIDMMapper.selectAllKotaKab ();
    }
    
    @Override
    public List<ProvinsiModel> selectAllProvinsi ()
    {
        log.info ("select all provinsi");
        return verifikasiIDMMapper.selectAllProvinsi ();
    }
    
    @Override
    public List<IjazahModel> selectAllIjazah ()
    {
        log.info ("select all ijazah");
        return verifikasiIDMMapper.selectAllIjazah ();
    }
    
    @Override
    public List<InstitusiModel> selectAllInstitusi ()
    {
        log.info ("select all institusi");
        return verifikasiIDMMapper.selectAllInstitusi ();
    }
    
    @Override
    public List<DataKesehatanModel> selectAllDataKesehatan ()
    {
        log.info ("select all data kesehatan");
        return verifikasiIDMMapper.selectAllDataKesehatan ();
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
    
    @Override
    public String parseHariUpdateBiodata(BiodataModel biodata) {
            // TODO Auto-generated method stub
            Date date = biodata.getUpdated_at ();
            DateFormat dateFormat = new SimpleDateFormat("EEEEEE");
            String hari = dateFormat.format(date);
            return hari;
    }

    @Override
    public String parseTanggalUpdateBiodata(BiodataModel biodata) {
            // TODO Auto-generated method stub
            Date date = biodata.getUpdated_at ();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
            String tanggal = dateFormat.format(date);
            return tanggal;
    }

    @Override
    public String parseWaktuUpdateBiodata(BiodataModel biodata) {
            // TODO Auto-generated method stub
            Date date = biodata.getUpdated_at ();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            String waktu = dateFormat.format(date);
            return waktu;
    }

    @Override
    public String parseTanggalLahirBiodata(BiodataModel biodata) {
            // TODO Auto-generated method stub
            Date date = biodata.getTanggal_lahir ();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
            String tanggalLahir = dateFormat.format(date);
            return tanggalLahir;
    }
}
