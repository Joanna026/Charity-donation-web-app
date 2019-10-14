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


    public RegisterPageController(UserService userService) {
        this.userService = userService;
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


        return "confirmationRequest";
    }

    @RequestMapping("/activate")
    public String processActivationLink(@PathVariable String token) {


        return "redirect:/login";
    }
}
