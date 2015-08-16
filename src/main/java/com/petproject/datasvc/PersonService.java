package com.petproject.datasvc;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.Collection;

public interface PersonService {
    void save(Person person);
    void delete(Person person);
    void update(Person person);
    Person getPersonById(Long id);
    Collection<Person> getAllPersons();
    Collection<Group> getAllGroups(Person person);
    void addGroupToPerson(Person person, Group group);
}
