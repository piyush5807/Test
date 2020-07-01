package com.example.HibernateMappings;

import com.example.HibernateMappings.entity.Course;
import com.example.HibernateMappings.entity.Instructor;
import com.example.HibernateMappings.entity.InstructorDetail;
import com.example.HibernateMappings.repository.CourseRepository;
import com.example.HibernateMappings.repository.InstructorDetailRepository;
import com.example.HibernateMappings.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateMappingsApplication implements CommandLineRunner {

	@Autowired
	InstructorRepository instructorRepository;

	@Autowired
	InstructorDetailRepository instructorDetailRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingsApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Instructor i1 = new Instructor("Sachin",25,"test@123");
		InstructorDetail id1 = new InstructorDetail("sachinYoutube", "playing football");

		Instructor i2 = new Instructor("Thakur",25,"test1@123");
		InstructorDetail id2 = new InstructorDetail("thakurYoutube", "Video games");

		// binding instructor to instructor detail.
		i1.setInstructorDetail(id1);
		i2.setInstructorDetail(id2);

		// as we have used CascadeType.ALL so save Instructor will also save Instructor detail.
		instructorRepository.save(i1);
		instructorRepository.save(i2);

		int theId = 1;
		Instructor newInstructor = null;
		newInstructor = instructorRepository.findById(theId);
//		try{
//			newInstructor = instructorRepository.findById(theId);
//		}
//		catch (NullPointerException e) {
//			System.out.println("No Instructor found for id " + theId);
//		}

		Course course1 = new Course("CS01 - Operating System");
		Course course2 = new Course("CS02 - Computer Networks");

		newInstructor.addCourse(course1);
		newInstructor.addCourse(course2);

		courseRepository.save(course1);
		courseRepository.save(course2);






//		Instructor i3 = new Instructor("Sachin Thakur",25,"sachin@123");
//		InstructorDetail id3 = new InstructorDetail("CS Hijack", "Studying");
//		id3.setInstructor(i3);
//		instructorDetailRepository.save(id3);

		//Deleting instructor. s we have used CascadeType.ALL so delete Instructor will also delete corresponding Instructor detail.

//		int theId = 1;
//		Instructor newInstructor = instructorRepository.getOne(theId);
//		if(newInstructor != null) {
//			instructorRepository.deleteById(theId);
//		}
	}
}
