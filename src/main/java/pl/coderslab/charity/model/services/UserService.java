package pl.coderslab.charity.model.services;

import org.modelmapper.ModelMapper;
import pl.coderslab.charity.model.DTO.UserDTO;
import pl.coderslab.charity.model.entities.User;
import pl.coderslab.charity.model.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDTO findByUsername(String username) {
        return toDto(userRepository.findByUsername(username));
    }


    private UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
