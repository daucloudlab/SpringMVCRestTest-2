package kz.tezdet.lessons.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(ModelMap model){
        model.addAttribute("message", "Hello! I am Testing Spring Rest!") ;
        return "hello" ;
    }
}
