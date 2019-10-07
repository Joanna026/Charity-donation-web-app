package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.services.DonationService;
import pl.coderslab.charity.model.services.InstitutionService;
import pl.coderslab.charity.model.DTO.InstitutionDTO;

import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {

    private InstitutionService institutionService;
    private DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){

        List<InstitutionDTO> institutions = institutionService.getAll();
        if (institutions!=null) {
            model.addAttribute("institutions", institutions);
        }

        model.addAttribute("totalQuantity", donationService.getTotalQuantity());

        Optional<Integer> optionalCountInsititutions = institutionService.countAllBy();
        optionalCountInsititutions.ifPresent(institutionNumber -> {
            model.addAttribute("institutionNumber", institutionNumber);
        });

        return "index";
    }


}
