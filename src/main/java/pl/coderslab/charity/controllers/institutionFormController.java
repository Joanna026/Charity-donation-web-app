package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.DTO.InstitutionDTO;
import pl.coderslab.charity.model.services.InstitutionService;

@Controller
@RequestMapping("/admin")
public class institutionFormController {

    private final InstitutionService institutionService;

    public institutionFormController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/institution/add")
    public String prepareInstitutionForm(Model model) {
        model.addAttribute(new InstitutionDTO());
        return "institutionForm";
    }


    @PostMapping("/institution/add")
    public String processInstitutionForm(InstitutionDTO institutionDTO) {
        institutionDTO.setId(null);
        institutionService.save(institutionDTO);

        return "redirect:/admin/institutions";
    }
}
