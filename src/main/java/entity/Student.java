package entity;

import hannotation.Column;
import hannotation.Entity;
import hannotation.Id;
import hannotation.Validate;

import helper.GenericValidateClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Entity(tableName = "sinhvien")
public class Student {
    @Id
    @Column(columnName = "rollNumber", columnType = "varchar(200)")
    @Validate(required = true, requiredMessage = "Roll number is required")
    private String rollNumber;

    @Column(columnName = "fullName", columnType = "varchar(200)")
    @Validate(required = true, requiredMessage = "Full name is required")
    private String fullName;

    @Column(columnName = "email", columnType = "varchar(200)")
    @Validate(requiredMessage = "Email can't be null", isEmail = true, required = true)
    private String email;
    private Date createdAt;

    private HashMap<String, ArrayList<String>> errors;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Student() {
    }

    public Student(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public Student(String rollNumber, String fullName, String email) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValid() {
        return false;
    }

    private void checkReflection() {
        GenericValidateClass<Student> demoGeneric = new GenericValidateClass<>(Student.class);
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return new HashMap<>();
    }
}
