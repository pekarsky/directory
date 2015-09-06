package com.petproject.app;

import com.petproject.configuration.AppConfig;
import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import com.petproject.datasvc.GroupService;
import com.petproject.datasvc.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PersonService service = (PersonService) context.getBean("personService");

        Person person2 = service.getPersonById(2L);
        System.out.println(person2);

        List<Group> groups = service.getAllGroups(person2);
        System.out.println(groups);

        GroupService groupService = (GroupService) context.getBean("groupService");

        Group group1 = groupService.getById(1L);

        List<Person> members = groupService.getMembers(group1);
        System.out.println(members);
        service.addGroupToPerson(person2, group1);
        System.out.println("AllDone");
    }
}
