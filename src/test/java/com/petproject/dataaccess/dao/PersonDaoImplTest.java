package com.petproject.dataaccess.dao;

import com.petproject.configuration.AppConfig;
import com.petproject.configuration.HibernateConfiguration;
import com.petproject.configuration.HibernateTestConfiguration;
import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Properties;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Person.class,Group.class})
public class PersonDaoImplTest {

    @Test
    public void testSave() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.register(HibernateTestConfiguration.class);
        HibernateConfiguration config = (HibernateConfiguration) context.getBean("hibernateConfiguration");
        System.out.println("Context loaded");
        PersonDao personDao = (PersonDao) context.getBean("personDao");
        System.out.println("AllDone");
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testFindByPersonById() throws Exception {

    }

    @Test
    public void testGetAllPersons() throws Exception {

    }

    @Test
    public void testGetAllGroups() throws Exception {

    }

    @Test
    public void testFindByName() throws Exception {

    }

    @Test
    public void testAddToGroup() throws Exception {

    }
}