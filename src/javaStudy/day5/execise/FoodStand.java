package javaStudy.day5.execise;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

public class FoodStand {
    private  ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food){
        foods.add(food);
    }

    public Food picked(String name){
        for (int i = 0; i < foods.size(); i++) {
            if(name.equals(foods.get(i).getName())){
                return foods.remove(i);
            }
        }
        // 식품이 부족!! 에러!!
        System.out.println("식품이 부족합니다! 죄송합니다!");

        return null;
    }
}
