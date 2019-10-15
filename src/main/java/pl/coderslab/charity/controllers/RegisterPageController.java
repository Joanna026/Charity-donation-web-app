package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.DTO.UserDTO;
import pl.coderslab.charity.model.services.TokenService;
import pl.coderslab.charity.model.services.UserService;

@Controller
public class RegisterPageController {

    private final UserService userService;
    private final TokenService tokenService;


    public RegisterPageController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping("/add")
    public String prepareRegisterPage(Model model) {
        model.addAttribute(new UserDTO());
        return "register";
    }

    @PostMapping("/add")
    public String processRegisterPage(UserDTO userDTO){
        userDTO.setId(null);
        userService.saveUser(userDTO);

        return "confirmationRequest";
    }

    @RequestMapping("/activate")
    public String processActivationLink(@RequestParam String token) {

        tokenService.findUserByTokenAndEnable(token);

        return "redirect:/login";
    }
}
