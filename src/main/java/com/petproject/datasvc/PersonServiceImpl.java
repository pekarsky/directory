package com.petproject.datasvc;

import com.petproject.dataaccess.dao.PersonDao;
import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonDao personDao;

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void delete(Person person) {
        personDao.delete(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personDao.findByPersonById(id);
    }

    @Override
    public Collection<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    @Override
    public Collection<Group> getAllGroups(Person person) {
        return personDao.getAllGroups(person);
    }
}
