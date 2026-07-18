package com.rishikesh.demo.StudentServer;



import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student studentValidator(Student student){
        int id = student.getId();
        String name = student.getName();
        String department = student.getDepartment();
        int age = student.getAge();

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());


        if(id<0 || name==null || age<=0 || department==null ){
            return null;
        }

        Student res = studentRepository.save(student);
        return res;
    }


}