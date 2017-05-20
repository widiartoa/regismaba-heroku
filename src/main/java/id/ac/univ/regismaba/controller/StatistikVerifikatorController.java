package id.ac.univ.regismaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.FakultasModel;
import id.ac.univ.regismaba.model.StatistikVerifikatorSummaryModel;
import id.ac.univ.regismaba.service.StatistikManagerService;
import id.ac.univ.regismaba.service.StatistikVerifikatorService;

@Controller
public class StatistikVerifikatorController
{
    @Autowired
    StatistikVerifikatorService svs;
    
    @Autowired
    StatistikManagerService sms;
    
    @RequestMapping("/staf-verifikasi/statistik-verifikator/snmptn")
    public String statistikVerifSNMPTN (Model model)
    {
        List<FakultasModel> f = sms.getFaculties();
        ArrayList<StatistikVerifikatorSummaryModel> sumSNMPTNVerified = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultySNMPTN(f.get(i).getFakultas_id());
                if(faculty != null) { sumSNMPTNVerified.add(faculty); }
        }
        
        model.addAttribute("sumSNMPTNVerified", sumSNMPTNVerified);
        
        
        ArrayList<StatistikVerifikatorSummaryModel> sumPPKBVerified = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultyPPKB(f.get(i).getFakultas_id());
                if(faculty != null) { sumPPKBVerified.add(faculty); }
        }
        
        model.addAttribute("sumPPKBVerified", sumPPKBVerified);
        
        
        ArrayList<StatistikVerifikatorSummaryModel> sumTalentVerified = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultyTalent(f.get(i).getFakultas_id());
                if(faculty != null) { sumTalentVerified.add(faculty); }
        }
        
        model.addAttribute("sumTalentVerified", sumTalentVerified);
        return "manager_pendidikan-statistik_verifikator-snmptn";
    }
    
    @RequestMapping("/staf-verifikasi/statistik-verifikator/sbmptn")
    public String statistikVerifSBMPTN (Model model)
    {
        List<FakultasModel> f = sms.getFaculties();
        
        ArrayList<StatistikVerifikatorSummaryModel> sumSBMPTNVerified = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultySBMPTN(f.get(i).getFakultas_id());
                System.out.println (faculty.getTotal ());
                if(faculty != null) { sumSBMPTNVerified.add(faculty); }
        }
        
        model.addAttribute("sumSBMPTNVerified", sumSBMPTNVerified);
        
        
        ArrayList<StatistikVerifikatorSummaryModel> sumSBMPTNVerifiedReg = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultySBMPTNReg(f.get(i).getFakultas_id());
                if(faculty != null) { sumSBMPTNVerifiedReg.add(faculty); }
        }
        
        model.addAttribute("sumSBMPTNVerifiedReg", sumSBMPTNVerifiedReg);
        
        
        ArrayList<StatistikVerifikatorSummaryModel> sumSBMPTNVerifiedPar = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultySBMPTNPar(f.get(i).getFakultas_id());
                if(faculty != null) { sumSBMPTNVerifiedPar.add(faculty); }
        }
        
        model.addAttribute("sumSBMPTNVerifiedPar", sumSBMPTNVerifiedPar);
        return "manager_pendidikan-statistik_verifikator-sbmptn";
    }
    
    @RequestMapping("/staf-verifikasi/statistik-verifikator/mandiri")
    public String statistikVerifMANDIRI (Model model)
    {
        List<FakultasModel> f = sms.getFaculties();
        
        ArrayList<StatistikVerifikatorSummaryModel> sumMANDIRIVerified = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultyMANDIRI(f.get(i).getFakultas_id());
                if(faculty != null) { sumMANDIRIVerified.add(faculty); }
        }
        
        model.addAttribute("sumMANDIRIVerified", sumMANDIRIVerified);
        
        
        ArrayList<StatistikVerifikatorSummaryModel> sumMANDIRIRegVerified = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultyMANDIRIReg(f.get(i).getFakultas_id());
                if(faculty != null) { sumMANDIRIRegVerified.add(faculty); }
        }
        
        model.addAttribute("sumMANDIRIRegVerified", sumMANDIRIRegVerified);
        
        
        ArrayList<StatistikVerifikatorSummaryModel> sumMANDIRIParVerified = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultyMANDIRIPar(f.get(i).getFakultas_id());
                if(faculty != null) { sumMANDIRIParVerified.add(faculty); }
        }
        
        model.addAttribute("sumMANDIRIParVerified", sumMANDIRIParVerified);
        
        
        ArrayList<StatistikVerifikatorSummaryModel> sumMANDIRIKKIVerified = new ArrayList<StatistikVerifikatorSummaryModel>();
        
        for(int i=0; i < f.size(); i++)
        {
                StatistikVerifikatorSummaryModel faculty = svs.summaryFacultyMANDIRIKKI(f.get(i).getFakultas_id());
                if(faculty != null) { sumMANDIRIKKIVerified.add(faculty); }
        }
        
        model.addAttribute("sumMANDIRIKKIVerified", sumMANDIRIKKIVerified);
        return "manager_pendidikan-statistik_verifikator-mandiri";
    }
}
