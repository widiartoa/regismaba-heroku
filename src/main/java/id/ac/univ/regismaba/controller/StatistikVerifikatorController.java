package id.ac.univ.regismaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.univ.regismaba.model.JalurModel;
import id.ac.univ.regismaba.model.StatistikManagerModel;
import id.ac.univ.regismaba.model.StatistikManagerSummaryModel;
import id.ac.univ.regismaba.service.StatistikManagerService;

@Controller
public class StatistikVerifikatorController
{
    @Autowired
    StatistikVerifikatorService svs;
    
    @RequestMapping("/manajer-pendidikan/statistik-verifikator/jalur")
    public String statistikVerifJalur (Model model)
    {
        List<JalurModel> j = svs.getPaths();
        ArrayList<StatistikManagerModel> paths = new ArrayList<StatistikManagerModel>();
        ArrayList<StatistikManagerModel> regPaths = new ArrayList<StatistikManagerModel>();
        ArrayList<StatistikManagerSummaryModel> sumPaths = new ArrayList<StatistikManagerSummaryModel>();
        
        for(int i=0; i < j.size(); i++)
        {
                StatistikManagerModel jalur = svs.selectJalur(j.get(i).getJalur_id());
                if(jalur != null) { paths.add(jalur); }
                
                StatistikManagerModel jalur2 = svs.selectRegistranJalur(j.get(i).getJalur_id());
                if(jalur2 != null) { regPaths.add(jalur2); }
                
                StatistikManagerSummaryModel jalur3 = svs.summaryPath(j.get(i).getJalur_id());
                if(jalur3 != null) { sumPaths.add(jalur3); }
        }
        
        model.addAttribute("paths", paths);
        model.addAttribute("regPaths", regPaths);
        model.addAttribute("sumPaths", sumPaths);
        
        return "manager_pendidikan-statistik_verifikator_jalur";
    }
}
