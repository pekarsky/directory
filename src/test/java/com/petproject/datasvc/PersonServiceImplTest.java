package com.petproject.datasvc;

import com.petproject.configuration.AppConfig;
import com.petproject.configuration.HibernateConfiguration;
import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Person.class, Group.class, AppConfig.class, HibernateConfiguration.class})
@EnableTransactionManagement
public class PersonServiceImplTest {

    @Autowired
    PersonService personService;
    @Autowired
    GroupService groupService;

    @Test
    public void testSave() throws Exception {
        Person person = createPerson("firstname", "middlename", "lastname", null);
        personService.save(person);
        assertNotNull(person.getId());
        Person person2 = createPerson("firstname2", "middlename2", "lastname2", null);
        personService.save(person2);
        assertNotNull(person2.getId());
        assertNotSame(person.getId(), person2.getId());
        System.out.println(person);
    }

    private Person createPerson(String firstName, String middleName, String lastName, Set<Group> groups) {
        Person result = new Person();
        result.setFirstName(firstName);
        result.setMiddleName(middleName);
        result.setLastName(lastName);
        result.setGroups(groups);
        return result;
    }

    @Test
    public void testDelete() throws Exception {
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Long personId = person.getId();
        personService.delete(person);
        Person deletedPerson = personService.getPersonById(personId);
        assertNull(deletedPerson);
    }

    private Person createPersonAndSave(String firstName, String middleName, String lastName, Set<Group> groups) {
        Person result = createPerson(firstName, middleName, lastName, groups);
        personService.save(result);
        return (result);
    }

    public void testUpdate() throws Exception {
        final String NEW_FIRST_NAME = "new_first_name";
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        assertNotNull(person.getId());
        Long oldId = person.getId();
        person.setFirstName(NEW_FIRST_NAME);
        personService.update(person);
        assertEquals(oldId, person.getId());
        assertEquals(person.getFirstName(), NEW_FIRST_NAME);

    }

    @Test
    @Transactional
    public void testGetByPersonById() throws Exception {
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Long personId = person.getId();
        Person person2 = personService.getPersonById(personId);
        assertEquals(person, person2);
    }

    @Test
    @SuppressWarnings("unused")
    public void testGetAllPersons() throws Exception {
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Set<Person> persons = personService.getAllPersons();
        assertNotNull(persons);
        assertTrue(persons.size() > 0);
    }

    @Test
    public void testGetAllGroups() throws Exception {

        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Group group = createGroupAndSave("new group name");
        personService.addGroupToPerson(person, group);
        Set<Group> persistentGroups = personService.getAllGroups(person);

        assertNotNull(persistentGroups);
    }

    protected Group createGroupAndSave(String groupName) {
        Group group = new Group();
        group.setName(groupName);
        groupService.save(group);
        return group;
    }

    @Test
    @Transactional
    public void testAddToGroup() throws Exception {
        Person person = createPersonAndSave("firstname", "middlename", "lastname", null);
        Group group = createGroupAndSave("new group name");
        personService.addGroupToPerson(person, group);
        Person persistentPerson = personService.getPersonById(person.getId());
        assertNotNull(persistentPerson.getGroups());
    }
}