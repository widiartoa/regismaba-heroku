package id.ac.univ.regismaba.service;

import id.ac.univ.regismaba.model.StatistikVerifikatorModel;
import id.ac.univ.regismaba.model.StatistikVerifikatorSummaryModel;

public interface StatistikVerifikatorService
{
    StatistikVerifikatorModel selectVerifiedSNMPTN ();

    StatistikVerifikatorModel selectVerifiedSBMPTN ();

    StatistikVerifikatorModel selectVerifiedMANDIRI ();
    
    StatistikVerifikatorSummaryModel summaryFacultySNMPTN(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultyPPKB(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultyTalent(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultySBMPTN(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultySBMPTNReg(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultySBMPTNPar(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultyMANDIRI(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultyMANDIRIReg(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultyMANDIRIPar(int fakultas_id);
    
    StatistikVerifikatorSummaryModel summaryFacultyMANDIRIKKI(int fakultas_id);
}
