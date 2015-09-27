package com.petproject.controller;

import com.petproject.dataaccess.domain.Group;
import com.petproject.dataaccess.domain.Person;
import com.petproject.datasvc.GroupService;
import com.petproject.datasvc.PersonService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/protected")
@SuppressWarnings("unused")
public class ProtectedController {
    @Autowired
    private PersonService personService;
    @Autowired
    private GroupService groupService;
    static Logger LOGGER = LogManager.getLogger(ProtectedController.class);

    // show statistics
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showStatistics() {
        LOGGER.debug("Running default method - start");
        Collection<Person> persons = personService.getAllPersons();
        Collection<Group> groups = groupService.listGroups();
        ModelAndView mv = new ModelAndView("protectedStatisticsView");
        mv.addObject("personCount", persons.size());
        mv.addObject("groupCount", groups.size());
        return mv;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }
}
