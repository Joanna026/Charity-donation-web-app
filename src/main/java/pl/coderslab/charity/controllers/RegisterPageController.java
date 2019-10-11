package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.DTO.UserDTO;
import pl.coderslab.charity.model.services.EmailService;
import pl.coderslab.charity.model.services.UserService;

@Controller
public class RegisterPageController {

    private final UserService userService;
    private final EmailService emailService;

    public RegisterPageController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping("/add")
    public String prepareRegisterPage(Model model) {
        model.addAttribute(new UserDTO());
        return "register";
    }

    @PostMapping("/add")
    public String processRegisterPage(UserDTO userDTO){
        userDTO.setId(null);
        Long newUserId = userService.saveUser(userDTO);
        emailService.sendSimpleMessage(userDTO.getEmail(), "Aktywacja konta",
                "Aby dokończyć proces rejestracji, kliknij w poniższy link: \n " +
                        "http://localhost:8080/activate?id="+newUserId);

        return "confirmationRequest";
    }

    @RequestMapping("/activate")
    public String processActivationLink(@PathVariable Long userToActivateId) {
        userService.findByIdAndEnable(userToActivateId);

        return "redirect:/login";
    }
}
