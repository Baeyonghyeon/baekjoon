package java.javastudy.day6.Homework;

public class Console {
    public static void main(String[] args) {
        //은행 생성
        Bank nhnBank = new Bank();
        //사용자 생성
        Customer zozo = new Customer();
        //zozo씨 통장 한개 만들었다.
        zozo.addAccounts(nhnBank.openAccount(new Money(10_000, Money.Currency.WON), 0.02f));
        //입금
        zozo.account.deposit(new Money(10_000,Money.Currency.WON));
        //출금
        zozo.account.withdrawal(new Money(10_000,Money.Currency.WON));
        //이자 지급
        zozo.account.payInterest();
        //이자 지급 확인
        zozo.account.depositCheck();
    }
}