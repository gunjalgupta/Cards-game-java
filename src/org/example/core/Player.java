package org.example.core;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand; // ArrayList converted to List

    public Player() {
        hand = new ArrayList<>();
    }

    public void showHand() {
        System.out.println(hand);
    }

    //getters and setter to implement abstraction
    public void addHand(Card c) { 
        hand.add(c);
    }

    public List<Card> getHand() {
        List<Card> handRet= new ArrayList<>();
        for(int i=0; i<hand.size(); i++){
            handRet.add(hand.get(i));
        }
        return handRet;
    }

    public int getHandsize() {
        return hand.size();
    }
}
