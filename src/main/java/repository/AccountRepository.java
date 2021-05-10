package repository;

import entity.Account;
import helper.GenericModel;
import helper.GenericValidateClass;

public class AccountRepository {
    private GenericModel<Account> genericModel = new GenericModel<>(Account.class);
    private GenericValidateClass<Account> genericValidateClass = new GenericValidateClass<>(Account.class);


    public boolean save(Account account) {
        if (genericValidateClass.validate(account)){
            genericValidateClass.getErrors();
        }
        genericModel.save(account);

        return false;
    }

    public Account findById(String username) {
        return new Account();
    }
}
