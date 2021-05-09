package controller;

import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Em đang dùng cái view form này nhưng tạm comment để test
//        req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
        req.getRequestDispatcher("/admin/students/test.jsp").forward(req, resp);
    }
}
