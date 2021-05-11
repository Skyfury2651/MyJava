package service;

import entity.Account;
import entity.Student;
import helper.GenericModel;
import helper.PasswordHash;
import repository.AccountRepository;

import java.sql.Date;

public class AccountService {

    protected AccountRepository accountRepository = new AccountRepository();

    public boolean register(Account account) {
        try {
            String hashPass = PasswordHash.hash(account.getHashPassword().toCharArray(), "123443322");
            account.setHashPassword(hashPass);
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
            account.setCreatedAt(date);
            account.setUpdatedAt(date);
            account.setDeletedAt(date);
            accountRepository.save(account);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Account login(String username, String password) {
        AccountRepository accountRepository = new AccountRepository();
        Account account = accountRepository.findByUserName(username);

        if (PasswordHash.isExpectedPassword(password.toCharArray(),account.getSalt(),account.getHashPassword().toCharArray())){
            System.out.println("go login");
            return account;
        }

        return new Account();
    }
}
