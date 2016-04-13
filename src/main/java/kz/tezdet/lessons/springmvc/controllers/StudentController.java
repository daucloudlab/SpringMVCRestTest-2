package kz.tezdet.lessons.springmvc.controllers;

import kz.tezdet.lessons.springmvc.models.Student;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public HashMap<String, Object> getStudent(@PathVariable("id") int id){
        Student student = new Student (id, "Arman", "Kuandikov") ;
        HashMap<String, Object> map = new HashMap<String, Object>() ;
        map.put("status", "OK") ;
        map.put("student", student) ;
        return map ;
    }
}
