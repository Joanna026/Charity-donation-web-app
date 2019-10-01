package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.services.InstitutionService;
import pl.coderslab.charity.model.utils.InstitutionDTO;

import java.util.List;


@Controller
public class HomeController {

    private InstitutionService institutionService;

    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){

        List<InstitutionDTO> institutions = institutionService.getAll();
        if (institutions!=null) {
            model.addAttribute("institutions", institutions);
        }
//        log.debug("kotr");
        return "index";
    }


}
