package org.example;

// import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

import org.example.core.Game;
import org.example.core.Player;

public class App {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) { 
            System.out.print("Enter the number of players: ");
            int numPlayer= s.nextInt();
            System.out.print("Enter the number of cards for each player: ");
            int numDeals= s.nextInt();

            boolean valid= validArgs(numPlayer , numDeals); // check if cards can be dealt

            if(valid == false){
                System.out.print(numDeals+ " cannot be dealt in "+ numPlayer+ "\nPlease enter other value");    
            }
            else{
                Player[] player = new Player[numPlayer];
                for(int i=0; i<numPlayer;i++) {
                    player[i] = new Player();
                }
                try(Game game = Game.getInstance()) { //Try with resources to prevent resource leak and enable auto close
                    for (int i= 0; i < numDeals; i++) {
                        for(int p =0;p<numPlayer;p++) {
                            game.dealCard(player[p]);
                        }
                    }

                    for(int p =0;p<numPlayer;p++) {
                        player[p].showHand();
                    }
            
                    game.printWinner(player);
                } catch(Exception e) {
                    System.err.print(e.getMessage());
                }
            }
            
        }
        catch(Exception e) {
            System.err.print(e.getMessage());
        }
    }
    public static boolean validArgs(int numPlayer, int numDeals){
        //System.out.print(numPlayer * numDeals);
        return (numPlayer * numDeals<= 52 && numPlayer >0 && numDeals>0);    
    }
}
