package com.first.demo.controller;

import com.first.demo.services.CourseService;
import com.first.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {
    @Autowired
    private CourseService courseServicesObj;
    @GetMapping("/home")
    public String home() {
        return "This is Home Page.";
    }
    @GetMapping("/courses")
    public List<Course> getCourses() {
        List<Course> courses = this.courseServicesObj.getCourses();
        return courses;
    }
    @GetMapping("/courses/{courseId}")
    public Course getCourses(@PathVariable String courseId) {
        return this.courseServicesObj.getCourses(Long.parseLong(courseId));
    }
    @RequestMapping (path="/courses", method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course course) {
        return this.courseServicesObj.addCourse(course);
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try{
            this.courseServicesObj.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
