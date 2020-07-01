package com.example.HibernateMappings.repository;

import com.example.HibernateMappings.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {

    public InstructorDetail findById(int id);
}
