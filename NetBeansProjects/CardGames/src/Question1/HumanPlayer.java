package Question1;

import java.util.Scanner;

/**
 *
 * @author ysj13kxu
 */
public class HumanPlayer extends BasicPlayer {

    Scanner scan = new Scanner(System.in);

    public HumanPlayer(Hand h) {
        //get all other variables from super class
        super(h);
    }

    @Override
    public boolean hit() {
        //out the balance
        System.out.println("\nBALANCE: " + balance);
        //iterate through human hand
        for (int a = 0; a < myHand.myCards.size(); a++) {
            //output them so user can see
            System.out.println(myHand.myCards.get(a));
        }
        //get my best score
        myHand.scoreCounter();
        //out the score
        System.out.println("SCORE:  " + myHand.getScore());
        //if i have bust then no hit allowed
        if (myHand.getScore() > 21) {
            return false;
        } else {
            //otherwise see if the user wants to hit or not
            System.out.println("Do you wish to 'hit' or 'stick'?");
            String human = scan.next();
            return human.contains("hit");
        }

    }

    @Override
    public int makeBet() {
        //shows balance to help decide how much to bet
        System.out.println("\nBALANCE: " + balance);
        //how much to bet
        System.out.println("How much would you like to bet?");
        int human = scan.nextInt();
        // if i have sufficient funds then allow to make bet
        if (human <= balance) {
            balance -= human;
            pot = human;
        } else {
            //allow to type a valid bet again
            System.out.println("Insufficient funds! retry?");
            makeBet();
        }
        //returns the bet
        return pot;
    }
}
