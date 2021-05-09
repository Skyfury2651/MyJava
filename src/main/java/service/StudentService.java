package service;

import entity.Student;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// function chính của Student trong hệ thống.
// những thao tác liên quan đến business.
public class StudentService {
    private StudentRepository studentRepository; // model

    public StudentService() {
        this.studentRepository = new StudentRepository();
    }

    public boolean create(Student obj) {
        // mã hoá password
        return studentRepository.save(obj);
    }

    public List<Student> getList(){
        return new ArrayList<>(studentRepository.findAll());
    }

    public Student getById(String rollNumber){
        return studentRepository.findById(rollNumber);
    }

    public boolean edit(String rollNumber, Student obj) throws InstantiationException, IllegalAccessException, SQLException {

        return studentRepository.update(rollNumber,obj);
    }

    public boolean delete(String rollNumber) throws SQLException {

        return studentRepository.delete(rollNumber);
    }
}