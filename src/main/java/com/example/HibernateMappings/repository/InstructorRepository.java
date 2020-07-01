package com.example.HibernateMappings.repository;

import com.example.HibernateMappings.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    public Instructor findById(int id);
}
