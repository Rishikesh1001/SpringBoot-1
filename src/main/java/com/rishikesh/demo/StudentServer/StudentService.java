package com.rishikesh.demo.StudentServer;


import com.rishikesh.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.rishikesh.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.rishikesh.demo.StudentServer.Student;
import com.rishikesh.demo.StudentServer.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = mapToStudent(createStudentRequestDTO);

        // Save into database
        student = studentRepository.save(student);

        return mapToResponseDTO(student);
    }


//    public Student studentValidate(Student student) {
//
//        //int id = student.getId();
//        String name = student.getName();
//        int age = student.getAge();
//        String department = student.getDepartment();
//
//        if (name == null || name.isBlank()
//                || age <= 0
//                || department == null || department.isBlank()) {
//            return null;
//        }
//
//        student.setCreatedAt(LocalDateTime.now());
//        student.setUpdatedAt(LocalDateTime.now());
//
//        return studentRepository.save(student);
//    }

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
        //return studentRepository.findById(id).orElse(null);
    }

    public Student studentUpdate(int id, Student student) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        result.setName(student.getName());
        result.setAge(student.getAge());
        result.setDepartment(student.getDepartment());
        result.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(result);
    }

    public Student deleteStudent(int id) {
        Student result = studentRepository.findById(id).orElse(null);
        if(result == null) {
            return null;
        }
        studentRepository.delete(result);
        return result;
    }
    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());

        return createStudentResponseDTO;

    }
}