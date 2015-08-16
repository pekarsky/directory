package com.petproject.dataaccess.dao;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("groupDao")
public class GroupDaoImpl extends CustomHibernateDaoSupport implements GroupDao {
    public void save(Group group) {
        getHibernateTemplate().save(group);
    }

    public void update(Group group) {
        getHibernateTemplate().update(group);
    }

    public void delete(Group group) {
        getHibernateTemplate().delete(group);
    }

    public Group getById(Long id) {
        return getHibernateTemplate().get(Group.class, id);
    }


    public Collection<Person> getMembers(Group group) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Person.class, "person");
        criteria.createAlias("person.groups","group");
        criteria.add(Restrictions.eq("group.id", group.getId()));
        return (List<Person>) criteria.list();
    }
}
