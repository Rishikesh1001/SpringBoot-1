
package com.rishikesh.demo.StudentServer;

import com.rishikesh.demo.StudentServer.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}