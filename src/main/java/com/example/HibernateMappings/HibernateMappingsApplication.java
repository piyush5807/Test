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
		instructorRepository.save(i1);

		Instructor i2 = new Instructor("Thakur",25,"test1@123");
		instructorRepository.save(i2);

		InstructorDetail id1 = new InstructorDetail("sachinYoutube", "playing football", i1);

		InstructorDetail id2 = new InstructorDetail("thakurYoutube", "Video games", i2);

		instructorDetailRepository.save(id1);
		instructorDetailRepository.save(id2);
//
//		// binding instructor to instructor detail.
////		i1.setInstructorDetail(id1);
////		i2.setInstructorDetail(id2);
//
//		// as we have used CascadeType.ALL so save Instructor will also save Instructor detail.
//
////		instructorRepository.save(i1);
////		instructorRepository.save(i2);
//
		int theId = 1;
		Instructor newInstructor = null;
		newInstructor = instructorRepository.findById(theId);

		Course course1 = new Course("CS01 - Operating System", newInstructor);
		Course course2 = new Course("CS02 - Computer Networks", newInstructor);
//
//		newInstructor.addCourse(course1);
//		newInstructor.addCourse(course2);
//
		courseRepository.save(course1);
		courseRepository.save(course2);
	}
}
