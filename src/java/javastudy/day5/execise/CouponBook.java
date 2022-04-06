package java.javastudy.day5.execise;

public class CouponBook {

    private int rateDiscountCouponCount = 0;
    private int staticDiscountCouponCount = 0;

    private int rateDiscount = 10;
    private int staticDiscount = 1_000;

    public CouponBook() {
        this.rateDiscountCouponCount++;
        this.staticDiscountCouponCount++;
    }

    public void getCouponPrint() {
        System.out.println("남은 " + rateDiscount + "% 할인쿠폰: " + rateDiscountCouponCount + "개");
        System.out.println("남은 " + staticDiscount + "원 할인쿠폰: " + staticDiscountCouponCount + "개");
    }

    public void rateDiscountCouponIssuance() {
        this.rateDiscountCouponCount++;
    }

    public void setStaticDiscountCouponIssuance() {
        this.staticDiscountCouponCount++;
    }

    //할인율 변경가능
    public void setRateDiscount(int rateDiscount) {
        this.rateDiscount = rateDiscount;
    }

    //할인율 변경가능
    public void setStaticDiscount(int staticDiscount) {
        this.staticDiscount = staticDiscount;
    }

    public int getRateDiscountPrice(Customer customer) {
        this.rateDiscountCouponCount--;
        return customer.getReceipt() - (customer.getReceipt() * 10 / 100);
    }

    public int getStaticDiscountPrice(Customer customer) {
        this.staticDiscountCouponCount--;
        return customer.getReceipt() - 1000;
    }

    public int getStaticDiscountPrice(int price) {
        this.staticDiscountCouponCount--;
        return price - 1000;
    }

    public int discountTwice(Customer customer) {
        return getStaticDiscountPrice(getRateDiscountPrice(customer));
    }
}