package javaStudy.day5.execise;

import java.util.ArrayList;

public class BuyList {
    //양파 2개
    //계란 3판
    private final ArrayList<Item> items = new ArrayList<>();

    //sc 사용해 값 넣어주자
    public void add(Item item){
        items.add(item);
    }

    //item 무엇이 담겨 있는지 확인해보자
    public ArrayList<Item> checkShoppingList(){
        return items;
    }

    public static class Item{

        private final String name;
        private final int amount;

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }

}
