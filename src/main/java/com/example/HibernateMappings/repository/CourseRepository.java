package com.example.HibernateMappings.repository;

import com.example.HibernateMappings.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
