package org.gopas.springbootdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.gopas.springbootdemo.api.PersonDetailedViewDto;
import org.gopas.springbootdemo.facade.PersonFacade;
import org.gopas.springbootdemo.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@OpenAPIDefinition(
        info = @Info(
                title = "Gopas REST API Docs Example",
                version = "1.0.0"
        )
)
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(SpringBootDemoApplication.class, args);
        PersonFacade personFacade = applicationContext.getBean(PersonFacade.class);
        PersonDetailedViewDto person = personFacade.findById(5L);
        System.out.println(person);
    }

}
