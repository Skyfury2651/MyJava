package repository;

import entity.Account;
import entity.SqlCondition;
import helper.GenericModel;
import helper.GenericValidateClass;

import java.util.HashMap;

public class AccountRepository {
    private GenericModel<Account> genericModel = new GenericModel<>(Account.class);
    private GenericValidateClass<Account> genericValidateClass = new GenericValidateClass<>(Account.class);


    public boolean save(Account account) {
        if (genericValidateClass.validate(account)) {
            genericValidateClass.getErrors();
        }
        genericModel.save(account);

        return false;
    }

    public Account findByUserName(String username) {
        HashMap<String, SqlCondition> condition = new HashMap<>();
        condition.put("email", new SqlCondition('=', username));

        return genericModel.findByColumns(condition);
    }
}
