package org.wso2.msf4j.example.repository;

import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.model.Student;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Long on 8/22/2016.
 */
@Component
public class StudentRepository extends AbstractRepository {
    public StudentRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void createStudent(Student user) {
        create(user);
    }

    public void removeStudent(Student user) {
        remove(user);
    }

    public Student findStudent(long id) {
        return findStudentById(id);
    }

    public List<Student> findAllStudent() {
        return findAll(Student.class);
    }

    public List<Student> findStudent() {
        return findAll(Student.class);
    }
}
