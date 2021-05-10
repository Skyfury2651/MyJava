package service;

import entity.Account;
import entity.Student;
import helper.GenericModel;
import helper.PasswordHash;
import repository.AccountRepository;

import java.sql.Date;

public class AccountService {

    private AccountRepository accountRepository = new AccountRepository();
    public public static void main(String[] args) {
        Account account = new Account(){

        };
        String hashPass = PasswordHash.MD5(account.getHashPassword());
        account.setHashPassword(hashPass);
        Date date = (Date) new java.util.Date();
        account.setCreatedAt(date);
        account.setUpdatedAt(date);
        account.setDeletedAt(date);
        accountRepository.save(account);
    }
    public boolean register(Account account){
        try{
            String hashPass = PasswordHash.MD5(account.getHashPassword());
            account.setHashPassword(hashPass);
            Date date = (Date) new java.util.Date();
            account.setCreatedAt(date);
            account.setUpdatedAt(date);
            account.setDeletedAt(date);
            accountRepository.save(account);

            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Account login(String username , String password){
        Account account = accountRepository.findById(username);
        String hashPass = PasswordHash.MD5(account.getHashPassword());
        if (account.getHashPassword().equals(hashPass)){
            return account;
        }
        return null;
    }
}
