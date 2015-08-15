package com.petproject.dataaccess.dao;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository("personDao")
public class PersonDaoImpl extends CustomHibernateDaoSupport implements PersonDao {
    @Override
    public void save(Person person) {
        getHibernateTemplate().save(person);
    }

    @Override
    public void update(Person person) {
        getHibernateTemplate().update(person);
    }

    @Override
    public void delete(Person person) {
        getHibernateTemplate().delete(person);
    }

    @Override
    public Person findByPersonById(Long personId) {
        return getHibernateTemplate().get(Person.class, personId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Person> getAllPersons() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Person.class);
        return (List<Person>) criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Group> getAllGroups(Person person) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Group.class, "group");
        criteria.createAlias("group.members", "m");
        criteria.add(Restrictions.eq("m", person));
        return (List<Group>) criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Person> findByName(String name) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Person.class);
        criteria.add(Restrictions.like("lastName", name));
        return (List<Person>) criteria.list();
    }
}
