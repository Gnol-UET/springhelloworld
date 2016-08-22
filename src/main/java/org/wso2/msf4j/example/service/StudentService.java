package org.wso2.msf4j.example.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.model.DTO.StudentDTO;
import org.wso2.msf4j.example.model.Student;
import org.wso2.msf4j.example.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 8/22/2016.
 */
@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> getAll(int quantity) {
        for (int i = 0; i < quantity; i++) {
            createStudent();
        }
        List<StudentDTO> studentDTOs = new ArrayList<>();
        List<Student> studentList = (List<Student>) studentRepository.findAllStudent();
        for (Student student : studentList) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(student.getName());
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }

    private StudentDTO createStudent() {
//
        Student student = new Student();
        student.setName(RandomStringUtils.randomAlphanumeric(1024));
        studentRepository.createStudent(student);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        return studentDTO;
    }
}