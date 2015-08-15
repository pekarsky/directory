package com.petproject.dataaccess.dao;

import com.petproject.dataaccess.domain.Person;

import java.util.Collection;


public class PersonDaoImpl extends CustomHibernateDaoSupport implements PersonDao {
    @Override
    public void save(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public Person findByPersonId(Long personId) {
        return null;
    }

    @Override
    public Collection<Person> findByName(String name) {
        return null;
    }
}
