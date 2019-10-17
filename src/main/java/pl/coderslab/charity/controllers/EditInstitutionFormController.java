package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.model.DTO.InstitutionDTO;
import pl.coderslab.charity.model.services.InstitutionService;

@Controller
@RequestMapping("/admin")
public class EditInstitutionFormController {

    private final InstitutionService institutionService;

    public EditInstitutionFormController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/institution/edit")
    public String prepareInstitutionFormToEdit(Model model,
                                               @RequestParam Long id) {
        InstitutionDTO institutionToEdit = institutionService.getById(id);
        model.addAttribute("institutionToEdit", institutionToEdit);
        return "editInstitutionForm";
    }

    @PostMapping("/institution/edit")
    public String processEditInstitutionForm(InstitutionDTO institutionToEdit) {
        institutionService.update(institutionToEdit);
        return "redirect:/admin/institutions";
    }
}
