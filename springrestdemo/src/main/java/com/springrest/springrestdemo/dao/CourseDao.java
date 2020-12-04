package com.springrest.springrestdemo.dao;

//JpaRepository has all the methods that we can add,fetch data to the database,
//JpaRepository will do auto configuration for us and it needs to two things.
// i.e 1. From which entity you are performing configuration and 2. we need to mention the primary key is of which type
// JpaRepository<Course, Long>, here Course is entity and Long is the primary key type.
// we pass Course entity here, if we have User as entity, then JpaRepository<User, Long>

import com.springrest.springrestdemo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {

}
