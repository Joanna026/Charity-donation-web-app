package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.DTO.CategoryDTO;
import pl.coderslab.charity.model.services.CategoryService;
import pl.coderslab.charity.model.services.DonationService;
import pl.coderslab.charity.model.services.InstitutionService;
import pl.coderslab.charity.model.DTO.DonationDTO;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private DonationService donationService;
    private InstitutionService institutionService;
    private CategoryService categoryService;

    public DonationController(DonationService donationService, InstitutionService institutionService, CategoryService categoryService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String prepareDonationFormPage(Model model) {

        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("institutions", institutionService.getAll());
        model.addAttribute(new DonationDTO());
        return "donationForm";
    }


    @PostMapping
    public String processDonationForm(DonationDTO donationDTO) {

        donationService.save(donationDTO);
        return "redirect:/";
    }
}
