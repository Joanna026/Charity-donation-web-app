package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.DTO.InstitutionDTO;
import pl.coderslab.charity.model.services.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class InstitutionListController {

    private InstitutionService institutionService;

    public InstitutionListController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }


    @GetMapping("/institutions")
    public String prepareInstitutionListPage(Model model) {
        List<InstitutionDTO> institutions = institutionService.getAll();
        if (institutions!=null) {
            model.addAttribute("institutions", institutions);
        }
        return "institutionList";
    }

    @PostMapping("/institutions")
    public String processInstitutionEdition(@RequestParam Long institutionId) {
        return "redirect:/admin/institution/edit?institutionId="+institutionId;
    }

    @GetMapping("/institutions/delete")
    public String processDeleteInstitution(@RequestParam Long id) {
        institutionService.softDeleteById(id);

        return "redirect:/admin/institutions";
    }
}

