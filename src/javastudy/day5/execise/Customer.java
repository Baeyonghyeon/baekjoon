package javastudy.day5.execise;

import java.util.ArrayList;

public class Customer {
    CouponBook couponBook = new CouponBook();

    private int wallet = 20_000;

    // 영수증(총 구입 비용)
    private int receipt;
    // 고객의 구매 목록
    private final BuyList buyList;
    // 고객의 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    public void getBasketPrint() {
        ArrayList<Food> foods = basket.getFoods();
        for (int i = 0; i < foods.size(); i++) {
            System.out.println("사용자 바스켓의 값 : " + foods.get(i).getName());

        }
    }

    public void pay(int totalPrice) {
        this.receipt = totalPrice;
    }


    // 장바구니를 챙김

    public void bring(Basket basket) {
        this.basket = basket;
    }
    // 장을본 장바구니

    public void pickFoods(Basket basket) {
        this.basket = basket;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public BuyList getBuyList() {
        return buyList;
    }

    public Basket getBasket() {
        return basket;
    }

    public void getCouponCountPrint() {
        couponBook.getCouponPrint();
    }

    public void couponRedeem(int amount) {
        this.receipt = amount;
    }

    public int getReceipt() {
        return receipt;
    }

    public void checkOut(int change){
        this.wallet = change;
    }
}
