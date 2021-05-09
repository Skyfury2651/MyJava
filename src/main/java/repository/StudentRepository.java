package repository;

import entity.Student;
import helper.GenericModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static  List<Student> list = new ArrayList<>();
    private GenericModel<Student> genericModel = new GenericModel<>(Student.class);

    public boolean save(Student student){
        genericModel.save(student);
        return true;
    }

    public boolean update(String id, Student updateStudent) throws InstantiationException, IllegalAccessException, SQLException {
        Student existStudent = genericModel.findById(id);
        if(existStudent == null){
            return false;
        }
        genericModel.update(id,updateStudent);
        return true;
    }
    public boolean delete(String id) throws SQLException {
        Student existStudent = genericModel.findById(id);
        if(existStudent == null){
            return false;
        }
        genericModel.delete(id);
        return true;
    }
    public Student findById(String id){
        return genericModel.findById(id);
    }
    public List<Student> findAll(){
        List<Student> list = genericModel.findAll();
        return list;
    }
}
