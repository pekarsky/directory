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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Person.class, Group.class, AppConfig.class, HibernateConfiguration.class})
@EnableTransactionManagement
@TransactionConfiguration(defaultRollback=false)
@WebAppConfiguration
public class GroupDaoImplTest  extends AbstractTransactionalJUnit4SpringContextTests {

    public static final String NEW_GROUP_NAME = "new_group_name";
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
        Group group = createGroup("test group", null);
        groupDao.save(group);
        assertNotNull(group.getId());
    }

    protected Group createGroup(String name, List<Person> members){
        Group group = new Group();
        group.setName(name);
        group.setMembers(members);
        return group;
    }

    @Test
    public void testUpdate() throws Exception {
        Group group = createGroup("test group", null);
        groupDao.save(group);
        assertNotNull(group.getId());
        group.setName(NEW_GROUP_NAME);
        groupDao.update(group);

        Group persistentGroup = groupDao.getById(group.getId());
        assertEquals(NEW_GROUP_NAME, persistentGroup.getName());

    }

    @Test
    public void testDelete() throws Exception {
        Group group = createGroup("test group", null);
        groupDao.save(group);
        assertNotNull(group.getId());
        group.setName(NEW_GROUP_NAME);
        groupDao.delete(group);

        Group persistentGroup = groupDao.getById(group.getId());
        assertNull(persistentGroup);
    }

    @Test
    public void testGetById() throws Exception {
        Group group = createGroup("test group", null);
        groupDao.save(group);
        assertNotNull(group.getId());
        group.setName(NEW_GROUP_NAME);
        groupDao.update(group);

        Group persistentGroup = groupDao.getById(group.getId());
        assertNotNull(persistentGroup);
    }

    @Test
    //@Transactional(isolation = Isolation.REPEATABLE_READ)
    public void testGetMembers() throws Exception {

        System.out.println("1");
        Person person = createPerson("firstname", "middlename", "lastname", null);
        System.out.println("2");

        Group group = createGroup("new group name", null);
        System.out.println("3");
        group.getMembers().add(person);
        person.getGroups().add(group);

     //   personDao.addToGroup(person, group);

        System.out.println("4");

   //     group.setMembers(new ArrayList<>(Arrays.asList(person)));
        personDao.save(person);
        groupDao.save(group);

   //     Group group1 = groupDao.getById(group.getId());
        System.out.println("5");

       // session.close();
     //   session = sessionFactory.openSession();

//        session.getTransaction().commit();
        List<Person> members = groupDao.getMembers(group);
    //    Set<Person> members1 = groupDao.getMembers(group1);
        System.out.println("6");

        assertNotNull(members);
    //    assertTrue(members.size() > 0);

    }

    private Person createPerson(String firstName, String middleName, String lastName, List<Group> groups) {
        Person result = new Person();
        result.setFirstName(firstName);
        result.setMiddleName(middleName);
        result.setLastName(lastName);
        result.setGroups(groups);
        return result;
    }

    private Person createPersonAndSave(String firstName, String middleName, String lastName, List<Group> groups) {
        Person result = createPerson(firstName, middleName, lastName, groups);
        personDao.save(result);
        return (result);
    }

    protected Group createGroupAndSave(String groupName) {
        Group group = new Group();
        group.setName(groupName);
        groupDao.save(group);
        return group;
    }

    @After
    public final void after() {
        System.out.println("10");
        session.close();
        System.out.println("11");

    }
}