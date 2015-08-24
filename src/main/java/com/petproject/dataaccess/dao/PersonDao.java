package com.petproject.dataaccess.dao;


import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.Set;

public interface PersonDao {
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    Person getPersonById(Long personId);
    Set<Person> getAllPersons();
    Set<Group> getAllGroups(Person person);
    Set<Person> findByName(String name);
    void addToGroup(Person person, Group group);
}
