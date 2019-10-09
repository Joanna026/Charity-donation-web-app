package pl.coderslab.charity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.persistence.EntityManager;
import java.util.List;


public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final EntityManager entityManager;
    private ApplicationContext applicationContext;


    public WebMvcConfig(EntityManager entityManager, ApplicationContext applicationContext) {
        this.entityManager = entityManager;
        this.applicationContext = applicationContext;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(this.applicationContext).build();
    }


}
