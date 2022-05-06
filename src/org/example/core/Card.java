package org.example.core;

public class Card implements ICard{
    private Suite suite; // access modifier changed to private to implement encapsulation
    private int value;
    public Card(int value,  Suite suite) {
        this.suite = suite;
        this.value = value;
    }

    public int getValue(){ // Getters declared to implement abstraction
        return value;
    }
    @Override
    public String toString() {
        return "Card{" +
                "suite='" + suite + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Object o) { //to incorporate future changes
        if(o instanceof Card ){
            Card c= (Card)o;
            if(this.value > c.getValue()){
                return 1;
            } else if(this.value == c.getValue()) {
                return 0;
            } else {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public int compareTo(ICard c1) {
        // TODO Auto-generated method stub
        Card c= (Card)c1;
        if(this.value > c.getValue()){
            return 1;
        } else if(this.value == c.getValue()) {
            return 0;
        } else {
            return -1;
        }
    }

}
