package com.petproject.datasvc;

import com.petproject.dataaccess.dao.PersonDao;
import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("personService")
@Transactional
@SuppressWarnings("unused")
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonDao personDao;

    public void save(Person person) {
        personDao.save(person);
    }

    public void delete(Person person) {
        personDao.delete(person);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    public Person getPersonById(Long id) {
        return personDao.getPersonById(id);
    }

    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    public List<Group> getAllGroups(Person person) {
        return personDao.getPersonGroups(person);
    }

    @Override
    public void addGroupToPerson(Person person, Group group) {
        personDao.addToGroup(person, group);
    }
}
