package javaStudy.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("게임 참여자 수 > ");
        int numHands = s.nextInt();
        System.out.print("참여자 당 카드 수 > ");
        int cardsPerHand = s.nextInt();

//        String[] suit = new String[] {"♠", "♥", "♦", "♣"};
//        String[] rank = new String[] {
//                "Ace", "2", "3", "4",
//                "5", "6", "7", "8", "9", "10",
//                "Jack", "Queen", "King" };
        List<Card> deck = new ArrayList<>();
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                deck.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(deck);

//        if (numHands * cardsPerHand > deck.size()) {
//            System.out.println("Not enough cards.");
//            return;
//        }

        for (int i = 0; i < numHands; i++)
            System.out.println(dealHand(deck, cardsPerHand));
    }

    public static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }
}

enum Suit {
    SPADES, DIAMONDS, CLUBS, HEARTS;
}

enum Rank {
    ACE, Two, Three, Four,_5,_6,_7,_8,_9,_10,Jack, Queen, King;
}
class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rankd) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", rank=" + rank + '}';
    }
}