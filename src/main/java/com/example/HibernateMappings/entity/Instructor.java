package com.example.HibernateMappings.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    // for bidirectional for instructor and course.
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "instructor",cascade =  CascadeType.ALL)
    private List<Course> courseList;

    public Instructor() {
    }

    public Instructor(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    // convenience method for bidirectional relationship
    public void addCourse(Course newCourse) {
        if(courseList == null)
            courseList = new ArrayList<>();
        courseList.add(newCourse);
        newCourse.setInstructor(this); // for bidirectional relationship. for a new course we are adding instructor also.

    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
