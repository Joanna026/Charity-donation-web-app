package pl.coderslab.charity;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.charity.model.DTO.UserDTO;
import pl.coderslab.charity.model.entities.User;
import pl.coderslab.charity.model.repositories.RoleRepository;
import pl.coderslab.charity.model.repositories.UserRepository;
import pl.coderslab.charity.model.services.UserService;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    private UserService userService;
    private UserRepository userRepository;
    private EntityManager entityManager;
    private BCryptPasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;
    private RoleRepository roleRepository;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = mock(BCryptPasswordEncoder.class);
        modelMapper = mock(ModelMapper.class);
        roleRepository = mock(RoleRepository.class);
        userService = new UserService(userRepository, modelMapper, passwordEncoder, roleRepository);
    }

    @Test
    public void findByUsernameTestExistingUser() {
        User user = new User();
        user.setUsername("user12");
        when(userRepository.findByUsername("user12")).thenReturn(user);
        UserDTO resultUser = userService.findByUsername("user12");
        assertEquals("user12", resultUser.getUsername());
    }

    @Test
    public void saveTest() {
        User user = new User();
        user.setUsername("user12");
        user.setEmail("u@uu");
        user.setPassword("pass");
        when(userRepository.save(user)).thenReturn(user);

        userService.saveUser(userService.toDto(user));
//        assertNotNull();
    }

}
