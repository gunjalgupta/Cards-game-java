package org.example.core;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck; //Initialization moved to constructors
    //private List<Card> delt; // Access modifier changed to private 
    // ArrayList changed to list to implement runtime polymorphism

    public Deck() {
        deck = new ArrayList<Card>();
        //delt = new ArrayList<Card>(); // It is not used anywhere

        for(int i = 1 ; i <= 13 ; i++){
            deck.add(new Card(i,Suite.CLUBS));
            deck.add(new Card(i,Suite.DIAMONDS));
            deck.add(new Card(i,Suite.HEARTS));
            deck.add(new Card(i,Suite.SPADE));
        }
    }
    public int getDeck(){   //Getter
        return deck.size();
    }

    public Card dealCard(){
        int rand = (int)(Math.random() * ((deck.size() - 1)));
        Card c = deck.get(rand);
        deck.remove(c);
        //delt.add(c);
        return c;
    }
}
