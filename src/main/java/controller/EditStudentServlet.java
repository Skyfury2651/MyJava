package controller;

import entity.Student;
import repository.StudentRepository;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditStudentServlet extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("rollNumber");
        req.setAttribute("list", studentService.getById(sid));
        req.getRequestDispatcher("/admin/students/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            req.setCharacterEncoding("UTF-8"); // lỗi Utf8 ngoài view

            String sid=req.getParameter("rollNumber");
            String fullName = req.getParameter("fullName");
            String email = req.getParameter("email");
            Student student = new Student(fullName,email);
            studentService.edit(sid,student);
        } catch (InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/admin/students/list");
    }
}
