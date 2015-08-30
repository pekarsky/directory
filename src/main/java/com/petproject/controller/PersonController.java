package com.petproject.controller;

import com.petproject.dataaccess.domain.Person;
import com.petproject.datasvc.PersonService;
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
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;
    static Logger LOGGER = LogManager.getLogger(PersonController.class);

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // show person
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getPerson(@PathVariable("id") Long id) {
        LOGGER.debug("Running default method - start");
        Person person = personService.getPersonById(id);
        ModelAndView mv = new ModelAndView("personView");
        mv.addObject("person", person);
        return mv;
    }

    // list all persons
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listPersons() {
        LOGGER.debug("Running default method - start");
        List<Person> allPersons = personService.getAllPersons();
        ModelAndView mv = new ModelAndView("personListView");
        mv.addObject("personList", allPersons);
        return mv;
    }
}
