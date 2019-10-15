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

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private  final EmailService emailService;
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

    public Long saveUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByAuthority("ROLE_USER");
        user.setAuthority(userRole);
        user.setEnabled(false);
        userRepository.save(user);
        User savedUser = userRepository.findByUsername(user.getUsername());

        String token = UUID.randomUUID().toString();
        tokenService.createToken(savedUser, token);

        emailService.sendSimpleMessage(userDTO.getEmail(), "Aktywacja konta",
                "Aby dokończyć proces rejestracji, kliknij w poniższy link: \n " +
                        "http://localhost:8080/activate?token=" + token);

        return savedUser.getId();
    }

//    public void findByIdAndEnable(Long userId) {
//        Optional<User> optionalUser = userRepository.findById(userId);
//        optionalUser.ifPresent(user -> {
//            user.setEnabled(true);
//            userRepository.save(user);
//        });
//    }
}
