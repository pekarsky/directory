package com.petproject.dataaccess.dao;


import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.Collection;

public interface GroupDao {
    void save(Group group);
    void update(Group group);
    void delete(Group group);
    Group getById(Long id);
    Collection<Person> getMembers(Group group);
}
