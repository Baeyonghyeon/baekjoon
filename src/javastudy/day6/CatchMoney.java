package javastudy.day6;

public class CatchMoney {
    public static void main(String[] args) {
        Money money;
        try {
            money = new Money(-1000, "WON");
        } catch (InvalidMoneyException e) {
            System.out.println("d");
        }
    }
}

class Money {
    long amount;
    String currency;

    public Money(long amount, String currency){
        if (amount < 0L) { //돈이음수가될수있나?
            throw new InvalidMoneyException("Money is not negative. " + amount);
        }
        if (!isSupportedCurrency(currency)) { // 지원되지 않는 통화의 경우.
            throw new InvalidMoneyException("Not supported currency. " + currency);
        }
        this.amount = amount;
        this.currency = currency;
    }

    private boolean isSupportedCurrency(String currency) {
        return !("WON".equals(currency) || "DOLOR".equals(currency));
    }
}

class InvalidMoneyException extends IllegalArgumentException {

    public InvalidMoneyException(String s) {
        super(s);
    }
}


