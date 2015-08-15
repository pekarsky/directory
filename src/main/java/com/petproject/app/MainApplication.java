package com.petproject.app;

import com.petproject.configuration.AppConfig;
import com.petproject.dataaccess.domain.Person;
import com.petproject.datasvc.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PersonService service = (PersonService) context.getBean("personService");

        Person person1 = service.getPersonById(1L);
        System.out.println(person1);
    }
}
