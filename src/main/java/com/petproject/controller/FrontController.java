package com.petproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

//    @RequestMapping(method = RequestMethod.GET)
 //   @ResponseBody
  //  public String default(){
   //     System.out.println("sdgsdgsdfgsdfg");
        //return "<br><div style='text-alig:center;'><h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from Fron";
        //return new ModelAndView("welcome", "message", message);
    //}


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from FronController.java **********</div><br><br>";
        return message;
    }


}
