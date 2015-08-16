package com.petproject.dataaccess.dao;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository("personDao")
@SuppressWarnings("unused")
public class PersonDaoImpl extends CustomHibernateDaoSupport implements PersonDao {
    public void save(Person person) {
        getHibernateTemplate().save(person);
    }

    public void update(Person person) {
        getHibernateTemplate().update(person);
    }

    public void delete(Person person) {
        getHibernateTemplate().delete(person);
    }

    public Person findByPersonById(Long personId) {
        return getHibernateTemplate().get(Person.class, personId);
    }

    @SuppressWarnings("unchecked")
    public Collection<Person> getAllPersons() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Person.class);
        return (List<Person>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public Collection<Group> getAllGroups(Person person) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Group.class, "group");
        criteria.createAlias("group.members", "m");
        criteria.add(Restrictions.eq("m.id", person.getId()));
        return (List<Group>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public Collection<Person> findByName(String name) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Person.class);
        criteria.add(Restrictions.like("lastName", name));
        return (List<Person>) criteria.list();
    }

    @Override
    public void addToGroup(Person person, Group group) {
        Collection<Group> personGroups = person.getGroups();
        if(personGroups == null){
            personGroups = new ArrayList<>();
        }
        getSessionFactory().getCurrentSession().update(person);
        if(!personGroups.contains(group)){
            personGroups.add(group);
        }
        update(person);
    }
}
