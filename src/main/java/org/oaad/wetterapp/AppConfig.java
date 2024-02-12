package org.oaad.wetterapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * This class is the main configuration class of the application. It contains the main method and the bean definitions.
 * @Author Alexander Iwan
 */
@Configuration
@ComponentScan
public class AppConfig{

    private static ApplicationContext applicationContext;
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
