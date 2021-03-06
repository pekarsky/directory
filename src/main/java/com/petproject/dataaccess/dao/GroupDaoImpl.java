package com.petproject.dataaccess.dao;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("groupDao")
@Transactional(propagation = Propagation.REQUIRED)
@SuppressWarnings("unused")
public class GroupDaoImpl extends CustomHibernateDaoSupport implements GroupDao {
    public void save(Group group) {
        getHibernateTemplate().save(group);
    }

    public void update(Group group) {
        getSessionFactory().getCurrentSession().update(group);
    }

    public void delete(Group group) {
        getSessionFactory().getCurrentSession().delete(group);
    }

    @SuppressWarnings("unchecked")
    public List<Group> listGroups() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Group.class);
        return criteria.list();
    }

    public Group getById(Long id) {
        return (Group)getSessionFactory().getCurrentSession().get(Group.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Person> getMembers(Group group) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Person.class, "person");
        criteria.createAlias("person.groups", "group");
        criteria.add(Restrictions.eq("group.id", group.getId()));
        return criteria.list();
    }
}
