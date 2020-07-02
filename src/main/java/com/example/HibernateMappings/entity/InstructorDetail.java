package com.example.HibernateMappings.entity;

import javax.persistence.*;

@Entity
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String youTubeChannel;
    private String hobby;

    //telling hibernate that instructor field is mapped by instructorDetail field in Instructor class. This is for bi-directional mapping
    @OneToOne
    @JoinColumn
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youTubeChannel, String hobby, Instructor instructor) {
        this.youTubeChannel = youTubeChannel;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youTubeChannel='" + youTubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
