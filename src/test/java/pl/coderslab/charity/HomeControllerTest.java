package pl.coderslab.charity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.charity.controllers.HomeController;
import pl.coderslab.charity.model.DTO.InstitutionDTO;
import pl.coderslab.charity.model.services.InstitutionService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;
//    @Autowired
//    private ModelMapper modelMapper;
    private final String HOME_VIEW = "index";

    public HomeControllerTest() {
    }

    @MockBean
    private InstitutionService institutionService;

    @Before
    public void setUp() {
//      Mock mockMvc = webAppContextSetup(webApplicationContext).build();

        List<InstitutionDTO> institutions = Arrays.asList(new InstitutionDTO());
        when(this.institutionService.getAll()).thenReturn(institutions);
    }

    @Test
    public void test_home_contains_institution_list() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(model().attributeExists("institutions"))
                .andExpect(model().attribute("institutions", hasSize(1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name(HOME_VIEW));
    }
}
