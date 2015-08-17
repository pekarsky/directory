
package com.petproject.dataaccess.dao;

import com.petproject.configuration.AppConfig;
import com.petproject.configuration.HibernateConfiguration;
import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Person.class,Group.class,AppConfig.class,HibernateConfiguration.class})
@EnableTransactionManagement

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class PersonDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests{


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PersonDao personDao;
    @Autowired
    private GroupDao groupDao;

    private Session session;


    @Before
    public final void before() {
        session = sessionFactory.openSession();
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

    private Person createPersonAndSave(String firstName, String middleName, String lastName, Collection<Group> groups){
        Person result = createPerson(firstName, middleName, lastName, groups);
        personDao.save(result);
        return(result);
    }


    @Test
    public void testUpdate() throws Exception {
        final String NEW_FIRST_NAME= "new_first_name";
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        assertNotNull(person.getId());
        Long oldId = person.getId();
        person.setFirstName(NEW_FIRST_NAME);
        personDao.update(person);
        assertEquals(oldId, person.getId());
        assertEquals(person.getFirstName(), NEW_FIRST_NAME);

    }

    @Test
    public void testDelete() throws Exception {
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Long personId = person.getId();
        personDao.delete(person);
        Person deletedPerson = personDao.findByPersonById(personId);
        assertNull(deletedPerson);
    }

    @Test
    public void testFindByPersonById() throws Exception {
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Long personId = person.getId();
        Person person2 = personDao.findByPersonById(personId);
        assertEquals(person, person2);
    }

    @Test
    public void testGetAllPersons() throws Exception {
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Collection<Person> persons = personDao.getAllPersons();
        assertNotNull(persons);
        assertTrue(persons.size() > 0);
    }

    @Test
    public void testGetAllGroups() throws Exception {

    }

    protected Group createGroupAndSave(String groupName){
        Group group = new Group();
        group.setName(groupName);
        groupDao.save(group);
        return group;
    }

    @Test
    public void testFindByName() throws Exception {

    }

    @Test
    @Transactional
    public void testAddToGroup() throws Exception {
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Group group = createGroupAndSave("new group name");
        personDao.addToGroup(person, group);
        Person persistentPerson = personDao.findByPersonById(person.getId());
        Collection<Group> g = persistentPerson.getGroups();
        for(Group groupElem: g){
            System.out.println(groupElem);
        }
        assertNotNull(persistentPerson.getGroups());
    }

    @After
    public final void after() {
        session.close();
    }
}