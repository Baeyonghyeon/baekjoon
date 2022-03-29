package javastudy.day5.execise;

import java.util.ArrayList;
import java.util.Scanner;

public class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        //sc에서 buylist 만들기
        BuyList buyList = inputBuyListFromShell();

        Customer jordan = new Customer(buyList);
        //장바구니를 챙긴다. 현재 빈 바구니를 챙긴상태.
        jordan.bring(mart.provideBasket());
        //식품을 담는다.
        jordan.pickFoods(mart.getFoodStand(jordan)); // 인수 jordan.getBasket, jordan.getBuyList -> jordan
        //카운터에서 계산한다.
        jordan.pay(mart.getCounter(jordan)); // 인수 jordan.basket -> jordan
        //couponRedeem
        jordan.couponRedeem(mart.couponRedeemPrice(jordan));
        //결제
        jordan.checkOut(mart.payment(jordan));
        //coupon 남은거 확인
        jordan.getCouponCountPrint();
        //방문 쿠폰지급
        mart.couponIssuance(jordan);
        //coupon 지급 확인
        jordan.getCouponCountPrint();
    }

    private static BuyList inputBuyListFromShell() {
        Scanner sc = new Scanner(System.in);
        BuyList buyList = new BuyList();

        while (true) {
            System.out.print("구입할 물건을 입력해 주세요. 더이상 구입 하지 않으려면 'q'를 입력하세요. ex)양파 > ");
            String name = sc.next();
            if(name.equals("q")) {
                System.out.println("구매콘솔을 종료합니다.");
                break;
            }

            System.out.print("구입할 개수 입력해 주세요. ex)2 > ");
            int amount = sc.nextInt();
            buyList.add(new BuyList.Item(name, amount));
        }

        return buyList;
    }
}

class NhnMart {
    private final FoodStand foodStand = new FoodStand();
    private Basket basket = new Basket();
    private Counter counter;


    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand(){
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return basket;
    }

    public Basket getFoodStand(Customer customer) {
        //item 에 담은 name, amount를 가져와야한다. 가져오고 basket에 담아야 한다.
        ArrayList<BuyList.Item> items = customer.getBuyList().checkShoppingList();

        //foodStand에서 name을 비교해서 값을 가져옴
        for (int i = 0; i < items.size(); i++) {
            String name = items.get(i).getName();
            int amount = items.get(i).getAmount();

            for (int j = 0; j < amount; j++) {
                customer.getBasket().add(foodStand.picked(name));
            }
        }

        return customer.getBasket();
    }

    //손님인 나는 바스켓을 들고 카운터에가서 바스켓을 맡기면 알아서 계산해준다.
    public int getCounter(Customer customer /*Basket basket*/){
        counter = new Counter(customer.getBasket());

        return counter.getTotalPrice();
    }

    public int couponRedeemPrice(Customer customer){
        int amount = counter.applyDiscount(customer);
        System.out.println("쿠폰 적용(포함)된 가격은 " + amount + " 입니다.");
        return amount;
    }

    public void couponIssuance(Customer customer){
        System.out.println("NHN 마트에 찾아 주셔서 감사합니다 (서비스 : '1000'원 쿠폰 지급)");
        customer.couponBook.setStaticDiscountCouponIssuance();
    }

    public int payment(Customer customer){
        int pay = 0;
        try {
            pay = counter.payment(customer);
        }catch (InsufficientFunds e){
            System.exit(0);
        }
        return pay;
    }
}