package com.springrest.springrestdemo.controller;
//Controller is the first one who is going to handle the request initially i.e any request will first come to Controller.
//Imagine Controller like Waiter i.e it is going to take request before cooking the food.
//To make class as Controller, as annotation @Controller.
//But if you are making REST API, then you can add it as @RestController (Representational State Transfer)
//In rest api, we send data in form of json or xml.
//In rest controller, we are going to define methods i.e mappings i.e whenever the request what you are going to fire. e.g /home
//when any user hits /home and we want to run home() method so that we can add @GetMapping("/home") : whenever we fire /home, that home() function is going to run.
//Course is an entity class, which is going to store the data.

//In MyController, lets call the Service CourseServiceImpl.java, to call it we require of object of its parent i.e CourseService.java
//so lets define interface type variable for Interface CourseService.java in our Controller.

//Autowired - Please create the object for me, I am going not creating it manually. so it will create object according to the rule of dependency injection.

///courses/{courseId} will return dynamic value of any id but if writing /courses/courseId directly then it will be wrong.

//now we require to pass object in addCourse(), this object is coming from body.

import com.springrest.springrestdemo.entities.Course;
import com.springrest.springrestdemo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    //lets define interface type variable for CourseService.java
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "This is homepage.";
    }

    //get the list of courses.
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses(); //this will return courses from interface CourseService.java but there is no direct implementatin provided, so it go into child class body CourseServiceImpl.java and find getCourses() method.
    }

    //creating method that will return single course
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){ //to receive value we will @PathVariable so dynamic of courseId will go to String courseId.
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //method to create new course [Post]
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    //update the course [PUT method]
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course); //we are passing course from Course course which we are getting from the body.
    }

    //delete the course, here we have add Http status also and it is recommended.
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //if exception occurs then entity will be created giving status code 500
        }
    }
}
