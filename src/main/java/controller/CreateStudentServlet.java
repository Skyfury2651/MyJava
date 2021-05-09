package controller;

import entity.Student;
import helper.GenericValidateClass;
import repository.StudentRepository;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateStudentServlet extends HttpServlet {

    private StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Em đang dùng cái view form này nhưng tạm comment để test
        req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // khắc phục lỗi utf8 ở view.
        req.setCharacterEncoding("UTF-8");
        String rollNumber = req.getParameter("rollNumber");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        Student student = new Student(rollNumber, fullName, email);

        GenericValidateClass<Student> studentGenericValidateClass = new GenericValidateClass<>(Student.class);
        System.out.println("Validate");
        System.out.println(studentGenericValidateClass.validate(student));
        System.out.println("End Validate");
        // validate
        if(!studentGenericValidateClass.validate(student)){
            System.out.println("Have Error");
            HashMap<String, ArrayList<String>> errors = studentGenericValidateClass.getErrors();

            req.setAttribute("errors", errors);
            req.setAttribute("student", student);
            req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
            return;
        }
        System.out.println(studentGenericValidateClass.getErrors());
        System.out.println("Create Student");
        studentService.create(student);
        resp.sendRedirect("/admin/students/list");
        //req.setAttribute("student", student);
        //req.getRequestDispatcher("/admin/students/success.jsp").forward(req, resp);
    }
}
