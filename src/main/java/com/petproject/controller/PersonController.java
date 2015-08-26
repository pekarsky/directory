package com.petproject.controller;

import com.petproject.dataaccess.domain.Person;
import com.petproject.datasvc.PersonService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class PersonController {
    private PersonService personService;
    static Logger LOGGER = LogManager.getLogger(PersonController.class);

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // list all persons
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        LOGGER.debug("Running default method - start");
        Set<Person> allPersons = personService.getAllPersons();
        ModelAndView mv = new ModelAndView("personListView");
        mv.addObject("personList", allPersons);
        return mv;
    }
}
