package javastudy.day5.execise;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();

    //바스켓에 무엇이 담겨있는지 확인해 보자.
    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void add(Food food){
        foods.add(food);
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (int i = 0; i < foods.size(); i++) {
            totalPrice += foods.get(i).getPrice();
        }

        return totalPrice;
    }
}
