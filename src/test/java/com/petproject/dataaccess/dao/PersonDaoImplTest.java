
package com.petproject.dataaccess.dao;

import com.petproject.configuration.AppConfig;
import com.petproject.configuration.HibernateConfiguration;
import com.petproject.configuration.HibernateTestConfiguration;
import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Person.class,Group.class})
@EnableTransactionManagement
public class PersonDaoImplTest {

    private PersonDao personDao;

    @Before
    public void setUp(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.register(HibernateTestConfiguration.class);
//        HibernateConfiguration config = (HibernateConfiguration) context.getBean("hibernateConfiguration");
        System.out.println("Context loaded");
        personDao = (PersonDao) context.getBean("personDao");

    }

    @Test
    public void testSave() throws Exception {
        Person person = createPerson("firstname", "middlename", "lastname", null);
        personDao.save(person);
        assertNotNull(person.getId());
        Person person2 = createPerson("firstname2", "middlename2", "lastname2", null);
        personDao.save(person2);
        assertNotNull(person2.getId());
        assertNotSame(person.getId(), person2.getId());
        System.out.println(person);
    }

    private Person createPerson(String firstName, String middleName, String lastName, Collection<Group> groups){
        Person result = new Person();
        result.setFirstName(firstName);
        result.setMiddleName(middleName);
        result.setLastName(lastName);
        result.setGroups(groups);
        return result;
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