package pl.coderslab.charity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.model.entities.User;
import pl.coderslab.charity.model.repositories.UserRepository;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void findByUsernameTestExistingUser() {
        User user = new User();
        user.setUsername("user12");
        user.setEmail("u@uu");
        user.setPassword("pass");
        entityManager.persist(user);

        User resultUser = userRepository.findByUsername("user12");
        assertEquals(resultUser.getUsername(), user.getUsername());
    }



    @Test
    public void findByUsernameTestNoResult() {
        User user = new User();
        user.setUsername("realUser");
        user.setEmail("u@uu");
        user.setPassword("pass");
        entityManager.persist(user);

        User resultUser = userRepository.findByUsername("fakeUser");
        assertNull(resultUser);
    }
}
