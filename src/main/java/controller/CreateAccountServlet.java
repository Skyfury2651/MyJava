package controller;

import entity.Account;
import entity.Student;
import helper.GenericValidateClass;
import service.AccountService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateAccountServlet extends HttpServlet {
    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Em đang dùng cái view form này nhưng tạm comment để test
        req.getRequestDispatcher("/admin/accounts/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // khắc phục lỗi utf8 ở view.
        req.setCharacterEncoding("UTF-8");
        Account account = new Account();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");

        account.setEmail(email);
        account.setFullName(fullName);
        account.setHashPassword(password);

        GenericValidateClass<Account> accountGenericValidateClass = new GenericValidateClass<>(Account.class);
        System.out.println("Validate");
        System.out.println(accountGenericValidateClass.validate(account));
        System.out.println("End Validate");
        // validate
        if(!accountGenericValidateClass.validate(account)){
            System.out.println("Have Error");
            HashMap<String, ArrayList<String>> errors = accountGenericValidateClass.getErrors();

            req.setAttribute("errors", errors);
            req.setAttribute("account", account);
            req.getRequestDispatcher("/admin/accounts/form.jsp").forward(req, resp);
            return;
        }
        System.out.println(accountGenericValidateClass.getErrors());
        System.out.println("Register Account");
        accountService.register(account);
        resp.sendRedirect("/admin/accounts/list");
    }
}
