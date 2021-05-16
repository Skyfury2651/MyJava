package controller;

import entity.Account;
import entity.Student;
import helper.GenericValidateClass;
import service.AccountService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(value = "/accounts/create")
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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Account account = new Account();
        account.setFullName(username);
        account.setHashPassword(password);
        account.setEmail(email);
        System.out.println(account.toString());

        GenericValidateClass<Account> accountGenericValidateClass = new GenericValidateClass<>(Account.class);
        accountGenericValidateClass.validate(account);
        // validate
        if(!accountGenericValidateClass.validate(account)){
            System.out.println("Have Error");
            HashMap<String, ArrayList<String>> errors = accountGenericValidateClass.getErrors();
            System.out.println(errors);
            req.setAttribute("errors", errors);
            req.setAttribute("account", account);
            req.getRequestDispatcher("/admin/accounts/form.jsp").forward(req, resp);
            return;
        }
        System.out.println(accountGenericValidateClass.getErrors());
        System.out.println("Register Account");
        System.out.println(accountService.register(account));
//        resp.sendRedirect("/admin/accounts/list");
    }
}
