package pl.coderslab.charity.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.DTO.UserDTO;
import pl.coderslab.charity.model.entities.Role;
import pl.coderslab.charity.model.entities.User;
import pl.coderslab.charity.model.repositories.RoleRepository;
import pl.coderslab.charity.model.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final EmailService emailService;
    private final TokenService tokenService;


    public UserService(UserRepository userRepository, ModelMapper modelMapper,
                       RoleRepository roleRepository, EmailService emailService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder();
        this.roleRepository = roleRepository;
        this.emailService = emailService;
        this.tokenService = tokenService;
    }

    public UserDTO findByUsername(String username) {
        return toDto(userRepository.findByUsername(username));
    }

    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    public UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public void saveUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role userRole = roleRepository.findByAuthority("ROLE_USER");
        user.setAuthority(userRole);
        user.setEnabled(false);
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        tokenService.createToken(user, token);

        emailService.sendSimpleMessage(userDTO.getEmail(), "Aktywacja konta",
                "Aby dokończyć proces rejestracji, kliknij w poniższy link: \n " +
                        "http://localhost:8080/activate?token=" + token);

    }

}
