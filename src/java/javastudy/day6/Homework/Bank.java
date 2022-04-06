package java.javastudy.day6.Homework;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts = new ArrayList<>();

    Account openAccount(Money initMoney, float interestRate) {
        Account account = new Account(initMoney, interestRate);
        //accounts.add(account);
        System.out.println("계좌개설! 현재 잔액 : "+ initMoney.getAmount());
        return account;
    }


//    public void payInterestOnAllAccounts() {
//        for(Account account : accounts) {
//            account.payInterest();
//        }
//    }
}