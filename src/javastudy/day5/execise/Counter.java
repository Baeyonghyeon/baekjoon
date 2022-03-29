package javastudy.day5.execise;

import java.util.ArrayList;
import java.util.Scanner;

public class Counter {
    ArrayList<Food> foods;

    public Counter(Basket basket) {
        this.foods = basket.getFoods();
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i).getName() +"의 가격: "+foods.get(i).getPrice() + "원 합산되었습니다.");
            totalPrice += foods.get(i).getPrice();
        }

        System.out.println("총 계산된 가격은 : " + totalPrice + "원 입니다.");
        return totalPrice;
    }

    public int applyDiscount(Customer customer){
        Scanner sc = new Scanner(System.in);
        int amount;

        System.out.println("---------------------------------------");
        System.out.println("현재 가지고 계신 쿠폰은");
        customer.couponBook.getCouponPrint();
        System.out.println("쿠폰을 사용 하시겠습니까? 사용 X : '0' , 10%할인 사용 : '1' , 1000원 할인 사용 : '2' , 2장 모두 사용 : '3'");
        int select = sc.nextInt();

        if (select == 1) {
            amount = customer.couponBook.getRateDiscountPrice(customer);
        } else if(select == 2){
            amount = customer.couponBook.getStaticDiscountPrice(customer);
        } else if(select == 3){
            amount = customer.couponBook.discountTwice(customer);
        } else{
            System.out.println("쿠폰 사용을 하지 않았습니다.");
            amount = customer.getReceipt();
        }

        return amount;
    }

    public int payment(Customer customer) throws InsufficientFunds{
        if(customer.getWallet() - customer.getReceipt() < 0){
            throw new InsufficientFunds("자금이 부족합니다.");
        }else {
            System.out.println("고객님 잔액 :" + (customer.getWallet() - customer.getReceipt()) + "원 입니다.");
            return customer.getWallet() - customer.getReceipt();
        }
    }
}
