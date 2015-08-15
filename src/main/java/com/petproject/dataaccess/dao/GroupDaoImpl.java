package com.petproject.dataaccess.dao;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;

import java.util.Collection;

public class GroupDaoImpl extends CustomHibernateDaoSupport implements GroupDao {
    @Override
    public void save(Group group) {

    }

    @Override
    public void update(Group group) {

    }

    @Override
    public void delete(Group group) {

    }

    @Override
    public void addMembersToGroup(Group group, Collection<Person> members) {

    }

    @Override
    public Collection<Person> getMembers(Group group) {
        return null;
    }
}
