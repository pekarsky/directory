package com.petproject.dataaccess.dao;


import com.petproject.dataaccess.domain.Person;

import java.util.Collection;

public interface PersonDao {
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    Person findByPersonId(Long personId);
    Collection<Person> findByName(String name);
}
