package javastudy.day6.Homework;

public class Money {
    private long amount;
    private Currency currency;

    public long getAmount() {
        return amount;
    }

    public Money(long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money amount) {
        this.amount += amount.amount;
        return (new Money(this.amount, amount.currency));
    }

    public Money subtract(Money amount) {
        this.amount -= amount.amount;
        return (new Money(this.amount, amount.currency));
    }

    public enum Currency {
        WON, DOLLAR;
    }

    public String toString() {
        return amount + " " + currency;
    }
}
