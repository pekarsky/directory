package com.petproject.controller;

import com.petproject.dataaccess.domain.Group;
import com.petproject.datasvc.GroupService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/group")
@SuppressWarnings("unused")
public class GroupController {
    @Autowired
    private GroupService groupService;
    static Logger LOGGER = LogManager.getLogger(GroupController.class);

    // list all groups
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listGroups() {
        LOGGER.debug("Running default method - start");
        List<Group> allGroups = groupService.listGroups();
        ModelAndView mv = new ModelAndView("groupListView");
        mv.addObject("groupList", allGroups);
        return mv;
    }

    // show person
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getPerson(@PathVariable("id") Long id) {
        LOGGER.debug("Running default method - start");
        Group group = groupService.getById(id);
        ModelAndView mv = new ModelAndView("groupView");
        mv.addObject("group", group);
        return mv;
    }
}
