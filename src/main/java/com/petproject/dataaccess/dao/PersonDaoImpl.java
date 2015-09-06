package com.petproject.dataaccess.dao;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Repository("personDao")
@Transactional(propagation = Propagation.REQUIRED)
@SuppressWarnings("unused")
public class PersonDaoImpl extends CustomHibernateDaoSupport implements PersonDao {
    public void save(Person person) {
        getSessionFactory().getCurrentSession().save(person);
    }

    public void update(Person person) {
        getSessionFactory().getCurrentSession().update(person);
    }

    public void delete(Person person) {
        getSessionFactory().getCurrentSession().delete(person);
    }

    public Person getPersonById(Long personId) {
        return (Person) getSessionFactory().getCurrentSession().get(Person.class, personId);
    }

    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Person.class);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Group> getPersonGroups(Person person) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Group.class, "group");
        criteria.createAlias("group.members", "m");
        criteria.add(Restrictions.eq("m.id", person.getId()));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Person> findByName(String name) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Person.class);
        criteria.add(Restrictions.like("lastName", name, MatchMode.ANYWHERE)); //TODO match all names, not just lastname
        return criteria.list();
    }

    @Override
    public void addToGroup(Person person, Group group) {
        List<Group> personGroups = person.getGroups();
        if(personGroups == null){
            personGroups = new ArrayList<>();
            person.setGroups(personGroups);
        }
        getSessionFactory().getCurrentSession().update(person);
        if(!personGroups.contains(group)){
            personGroups.add(group);
        }
        update(person);
    }
}
