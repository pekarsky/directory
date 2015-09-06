package com.petproject.dataaccess.dao;


import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.List;

public interface PersonDao {
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    Person getPersonById(Long personId);
    List<Person> getAllPersons();
    List<Group> getPersonGroups(Person person);
    List<Person> findByName(String name);
    void addToGroup(Person person, Group group);
}
