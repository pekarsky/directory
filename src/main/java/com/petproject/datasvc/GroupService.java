package com.petproject.datasvc;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.Set;

public interface GroupService {
    void save(Group group);
    void update(Group group);
    void delete(Group group);
    Group getById(Long groupId);
    Set<Person> getMembers(Group group);
}
