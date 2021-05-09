package helper;

import entity.Product;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws SQLException {
        GenericModel<Product> demoGeneric = new GenericModel<>(Product.class); // tham số hoá kiểu dữ liệu.
        GenericValidateClass<Student> validateStudent = new GenericValidateClass<>(Student.class);
        Student student = new Student();
        student.setRollNumber("");
        student.setFullName("");
        student.setEmail("skyfury2651@gmail.com");

        if (!validateStudent.validate(student)){
           HashMap<String, ArrayList<String>> errors =  validateStudent.getErrors();

            for (ArrayList<String> value : errors.values()) {
                System.out.println(value);
            }
        }


//        List<Product> list = demoGeneric.findAll();
//        System.out.println(demoGeneric.delete("1"));
    }
}
