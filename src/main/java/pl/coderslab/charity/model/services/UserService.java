package pl.coderslab.charity.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.DTO.UserDTO;
import pl.coderslab.charity.model.entities.Role;
import pl.coderslab.charity.model.entities.User;
import pl.coderslab.charity.model.repositories.RoleRepository;
import pl.coderslab.charity.model.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public UserDTO findByUsername(String username) {
        return toDto(userRepository.findByUsername(username));
    }


    public UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public Long saveUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByAuthority("ROLE_USER");
        user.setAuthority(userRole);

        userRepository.save(user);
        User savedUser = userRepository.findByUsername(user.getUsername());

        return savedUser.getId();
    }

    public void findByIdAndEnable(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(user -> {
            user.setEnabled(true);
        });
    }
}
