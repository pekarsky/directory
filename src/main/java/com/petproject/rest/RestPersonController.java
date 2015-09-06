package com.petproject.rest;

import com.petproject.dataaccess.domain.Person;
import com.petproject.datasvc.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/")
@SuppressWarnings("unused")
public class RestPersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> listPersons(){
        return personService.getAllPersons();
    }

    @RequestMapping(value={"/persons/{id}"}, method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") Long id){
        return personService.getPersonById(id);
    }


}
