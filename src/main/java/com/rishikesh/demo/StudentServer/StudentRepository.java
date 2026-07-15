package com.rishikesh.demo.StudentServer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    public Student save(Student student) {
//        System.out.println("Student Information saved");
//        return student;
//    }
}