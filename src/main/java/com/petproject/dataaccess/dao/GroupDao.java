package com.petproject.dataaccess.dao;


import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.Collection;

public interface GroupDao {
    void save(Group group);
    void update(Group group);
    void delete(Group group);
    void addMembersToGroup(Group group, Collection<Person> members);
    Collection<Person> getMembers(Group group);
}
