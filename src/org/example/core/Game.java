package org.example.core;

public class Game implements AutoCloseable {
    private static Game instance; // data memebers on top for readability
    private Deck deck;

    private Game() {
        deck = new Deck();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Cleaning up instance");
        instance = null;
    }

    public void dealCard(Player p) {
        p.addHand(deck.dealCard());
    }

    private Card findBestCard(Player p) { //finds the card with highest value
        Card c1 = null;
        for (Card c : p.getHand()) {
            if (c1 == null) {
                c1 = c;
            } else if (c.getValue() > c1.getValue())  {// Abstraction implemented 
                 c1 = c;
            }
        }
        return c1;
    }

    private int findWinner(Card[] card) {
        
        int winner = 0;
        Card maxcard = card[0];
        // System.out.println(0 + ": maxcard:" + card[0].getValue() );
        for(int c=1; c<card.length; c++) {
            // System.out.println(c + ": maxcard:" + card[c].getValue() );
            int compare = card[c].compareTo(maxcard);
            if(compare ==0 ) {
                winner = -1;
            } else if(compare >0) {
                maxcard = card[c];
                winner = c;
            }
        }
        return winner;
    }
    public void printWinner(Player[] player) { 
        Card[] card = new Card[player.length];

        for(int p =0;p<player.length;p++) {
            card[p] = findBestCard(player[p]);
        }
       
        int winner = findWinner(card);
        if(winner!=-1){
            System.out.println("Player "+ (winner+1) + " wins");
        }
        else {
            System.out.println("It is a tie");
        }
        
    }

    public static Game getInstance() {
        if (instance == null) {
        synchronized(Game.class){ // thread safe singletom
            if (instance == null) {
                instance = new Game();
            }
        }
    }
            return instance;
    } 
}
