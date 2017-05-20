package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.StatistikVerifikatorMapper;
import id.ac.univ.regismaba.model.StatistikVerifikatorModel;
import id.ac.univ.regismaba.model.StatistikVerifikatorSummaryModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StatistikVerifikatorServiceImplement implements StatistikVerifikatorService
{
    @Autowired
    StatistikVerifikatorMapper svm;
    
    @Override
    public StatistikVerifikatorModel selectVerifiedSNMPTN ()
    {
        log.info ("select count mahasiswa verified by SNMPTN");
        return svm.selectVerifiedSNMPTN ();
    }

    @Override
    public StatistikVerifikatorModel selectVerifiedSBMPTN ()
    {
        log.info ("select count mahasiswa verified by SBMPTN");
        return svm.selectVerifiedSBMPTN ();
    }

    @Override
    public StatistikVerifikatorModel selectVerifiedMANDIRI ()
    {
        log.info ("select count mahasiswa verified by MANDIRI");
        return svm.selectVerifiedMANDIRI ();
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultySNMPTN(int fakultas_id)
    {
        log.info ("select summary mahasiswa SNMPTN verified");
        return svm.summaryFacultySNMPTN (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultyPPKB(int fakultas_id)
    {
        log.info ("select count mahasiswa verified by PPKB");
        return svm.summaryFacultyPPKB (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultyTalent(int fakultas_id)
    {
        log.info ("select count mahasiswa verified by Talent");
        return svm.summaryFacultyTalent (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultySBMPTN(int fakultas_id)
    {
        log.info ("select summary mahasiswa SBMPTN verified");
        return svm.summaryFacultySBMPTN (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultySBMPTNReg(int fakultas_id)
    {
        log.info ("select summary mahasiswa SBMPTN reguler verified");
        return svm.summaryFacultySBMPTNReg (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultySBMPTNPar(int fakultas_id)
    {
        log.info ("select summary mahasiswa SBMPTN paralel verified");
        return svm.summaryFacultySBMPTNPar (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultyMANDIRI(int fakultas_id)
    {
        log.info ("select summary mahasiswa MANDIRI verified");
        return svm.summaryFacultyMANDIRI (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultyMANDIRIReg(int fakultas_id)
    {
        log.info ("select summary mahasiswa MANDIRI reguler verified");
        return svm.summaryFacultyMANDIRIReg (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultyMANDIRIPar(int fakultas_id)
    {
        log.info ("select summary mahasiswa MANDIRI paralel verified");
        return svm.summaryFacultyMANDIRIPar (fakultas_id);
    }
    
    @Override
    public StatistikVerifikatorSummaryModel summaryFacultyMANDIRIKKI(int fakultas_id)
    {
        log.info ("select summary mahasiswa MANDIRI KKI verified");
        return svm.summaryFacultyMANDIRIKKI (fakultas_id);
    }
}
