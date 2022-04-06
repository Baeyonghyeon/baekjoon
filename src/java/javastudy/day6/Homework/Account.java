package java.javastudy.day6.Homework;

public class Account {
    private Money balance;
    private float interestRate;

    public Account(Money balance, float interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void depositCheck(){
        this.balance.getAmount();
        System.out.println("현재 잔액 : "+ balance.getAmount());
    }

    // 입금
    public Money deposit(Money amount) {
        // 제약 조건
        this.balance = this.balance.add(amount);
        System.out.println("-------------입금중----------------");
        System.out.println("입금 금액 : " +amount.getAmount());
        System.out.println("현재 잔액 : " +this.balance.getAmount());
        System.out.println("---------------------------------");
        return this.balance;
    }

    // 출금
    public Money withdrawal(Money amount) {
        // 제약 조건
        this.balance = this.balance.subtract(amount);
        System.out.println("-------------출금중----------------");
        System.out.println("출금 금액 : " +amount.getAmount());
        System.out.println("현재 잔액 : " +this.balance.getAmount());
        System.out.println("---------------------------------");
        return this.balance;
    }

    // 이자 지급
    Money payInterest() {
        Money interest = cacluateInterest();
        this.balance = this.balance.add(interest);
        return this.balance;
    }

    private Money cacluateInterest() {
        // TODO
        return new Money((long) (this.balance.getAmount() * 12 * this.interestRate / 12), Money.Currency.WON);
    }
}

/*// 마이너스 통장. 상속으로 가능?
class OverdraftAccount extends Account {

    public OverdraftAccount(Money balance, float interestRate) {
        super(balance, interestRate);
    }
}*/
