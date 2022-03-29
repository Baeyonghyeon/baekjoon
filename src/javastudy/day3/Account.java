package javastudy.day3;

public class Account {
    public static void main(String[] args) {
        Account nhnAccount = new Account();
        nhnAccount.deposit(1_000L);
        nhnAccount.withdraw(500L);
        System.out.println("amount = "+nhnAccount.getAmount());
    }

    private long amount = 0L;

    public void deposit(long depositAmt){
        this.amount += depositAmt;
    }

    private void withdraw(long withdraw) {
        this.amount -= withdraw;
    }

    private long getAmount() {
        return this.amount;
    }
}
