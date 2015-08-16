package com.petproject.dataaccess.dao;


import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.Collection;

public interface PersonDao {
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    Person findByPersonById(Long personId);
    Collection<Person> getAllPersons();
    Collection<Group> getAllGroups(Person person);
    Collection<Person> findByName(String name);
    void addToGroup(Person person, Group group);
}
