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
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Person.class, Group.class, AppConfig.class, HibernateConfiguration.class})
@EnableTransactionManagement
@TransactionConfiguration(defaultRollback=true)
@WebAppConfiguration
public class GroupServiceImplTest {

    @Autowired
    PersonService personService;
    @Autowired
    GroupService groupService;

    public static final String NEW_GROUP_NAME = "new_group_name";

    @Test
    public void testSave() throws Exception {
        Group group = createGroup("test group", null);
        groupService.save(group);
        assertNotNull(group.getId());
    }

    protected Group createGroup(String name, Set<Person> members){
        Group group = new Group();
        group.setName(name);
        group.setMembers(members);
        return group;
    }

    @Test
    public void testUpdate() throws Exception {
        Group group = createGroup("test group", null);
        groupService.save(group);
        assertNotNull(group.getId());
        group.setName(NEW_GROUP_NAME);
        groupService.update(group);

        Group persistentGroup = groupService.getById(group.getId());
        assertEquals(NEW_GROUP_NAME, persistentGroup.getName());

    }

    @Test
    public void testDelete() throws Exception {
        Group group = createGroup("test group", null);
        groupService.save(group);
        assertNotNull(group.getId());
        group.setName(NEW_GROUP_NAME);
        groupService.delete(group);

        Group persistentGroup = groupService.getById(group.getId());
        assertNull(persistentGroup);
    }

    @Test
    public void testGetById() throws Exception {
        Group group = createGroup("test group", null);
        groupService.save(group);
        assertNotNull(group.getId());
        group.setName(NEW_GROUP_NAME);
        groupService.update(group);

        Group persistentGroup = groupService.getById(group.getId());
        assertNotNull(persistentGroup);
    }

    //TODO implement or remove dao and service methods
    @Test
    public void testGetMembers() throws Exception {

    }
}