package kz.tezdet.lessons.springmvc.controllers;

import kz.tezdet.lessons.springmvc.models.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(value = "/student/", method = RequestMethod.POST)
    public ResponseEntity<Void> createStudent(@RequestBody Student student,
                                              UriComponentsBuilder uriComponentsBuilder){
        HttpHeaders httpHeaders = new HttpHeaders() ;
        httpHeaders.setLocation(uriComponentsBuilder.path("/student/{id}")
            .buildAndExpand(student.getStudentID()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED) ;
    }
}
