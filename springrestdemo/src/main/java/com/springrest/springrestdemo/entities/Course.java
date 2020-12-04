package com.springrest.springrestdemo.entities;

//In the Course class, we are going to take all the data about the course.
//@Entity will create table Course, it should be defined which table you want to create in the database.

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    private long id;
    private String title;
    private String description;

    //making constructor
    public Course(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    //adding default constructor with super class
    public Course(){
        super();
    }

    //adding getters and setters.
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //overriding toString() method.
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
