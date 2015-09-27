package com.petproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {

        String message = "home page";
        return message;
    }


}
