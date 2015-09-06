package com.petproject.dataaccess.dao;


import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.List;

public interface GroupDao {
    void save(Group group);
    void update(Group group);
    void delete(Group group);
    Group getById(Long id);
    List<Group> listGroups();
    List<Person> getMembers(Group group);
}
