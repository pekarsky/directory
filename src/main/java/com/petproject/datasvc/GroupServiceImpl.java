package com.petproject.datasvc;

import com.petproject.dataaccess.dao.GroupDao;
import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service("groupService")
@Transactional
@SuppressWarnings("unused")
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    public void save(Group group) {
        groupDao.save(group);
    }

    public void update(Group group) {
        groupDao.update(group);
    }

    public void delete(Group group) {
        groupDao.delete(group);
    }

    public Group getById(Long groupId) {
        return groupDao.getById(groupId);
    }

    public Set<Person> getMembers(Group group) {
        return groupDao.getMembers(group);
    }

}
