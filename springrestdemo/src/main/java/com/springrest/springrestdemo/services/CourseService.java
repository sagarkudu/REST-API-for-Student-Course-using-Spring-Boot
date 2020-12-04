package com.springrest.springrestdemo.services;

//As this is interface, we all method here will be abstract and public by default.
// we have made abstract method here to get loose coupling.
//we will give implementation of getCourses() in another class called CourseServiceImpl.java

import com.springrest.springrestdemo.entities.Course;

import java.util.List;

public interface CourseService {

    //method that will return list of courses.
     List<Course> getCourses();

     //getting single course
    Course getCourse(Long courseId);

    //add course
    public Course addCourse(Course course);

    //updating course
    Course updateCourse(Course course);

    //delete the course
    void deleteCourse(long parseLong);
}
