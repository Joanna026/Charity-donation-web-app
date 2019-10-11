package pl.coderslab.charity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

//    private @Value("#{message_pl.properties['activation.message']}") String activationMessage;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public SimpleMailMessage activationMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("link aktywacyjny");
        return message;
    }
}
