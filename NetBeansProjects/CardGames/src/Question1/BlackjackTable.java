package Question1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ysj13kxu
 */
public class BlackjackTable implements Serializable {

    //serial
    private static final int serialVersionUID = 999;

    //basic game
    public static void basicGame() {
        //carry on for set number of runs
        boolean XXX = true;
        while (XXX = true) {
            //dealer
            BlackjackDealer dealer = new BlackjackDealer();

            ArrayList<Player> players = new ArrayList<>();
            //4 basic players
            Hand ahand = new Hand();
            BasicPlayer aplayer = new BasicPlayer(ahand);
            Hand ahand2 = new Hand();
            BasicPlayer aplayer2 = new BasicPlayer(ahand2);
            Hand ahand3 = new Hand();
            BasicPlayer aplayer3 = new BasicPlayer(ahand3);
            Hand ahand4 = new Hand();
            BasicPlayer aplayer4 = new BasicPlayer(ahand4);

            //basic players created
            players.add(aplayer);
            players.add(aplayer2);
            players.add(aplayer3);
            players.add(aplayer4);

            //players.add(human);
            //players assigned
            dealer.assignPlayers(players);
            System.out.println("Please enter the number of times you want to "
                    + "run the hands:");
            Scanner scan = new Scanner(System.in);
            int noOfScans = scan.nextInt();
            for (int a = 0; a < noOfScans; a++) {
                //take bets
                dealer.takeBets();
                System.out.println("Players have made bets");
                System.out.println("No more bets please!");
                //deal all first cards
                dealer.dealFirstCards();
                //let each player get a score to beat dealer
                for (Player player : players) {
                    int val = dealer.play(player);
                    System.out.println("\n" + "Player " + "\n"
                            + player.getHand().toString() + "SCORE:" + val);
                }
                //print dealer
                System.out.println("\nDEALERS HAND");
                int dealers = dealer.playDealer();
                System.out.println(dealer.getDealersHand() + "SCORE: "
                        + dealers + "\n");
                //comparisons made to see who wins
                dealer.settleBets();
                //reset hands ready for new game
                for (int i = 0; i < players.size(); i++) {
                    players.get(i).newHand();
                }
            }
            //output balances
            System.out.println("\n" + "BALANCE OF PLAYERS");
            for (int g = 0; g < players.size(); g++) {
                System.out.println("Player: " + players.get(g).getBalance());
            }
            //confirm restart
            Scanner scane = new Scanner(System.in);
            System.out.println("Do you wish to restart? y/n");
            String SSS = scane.next();
            if ("y".equals(SSS) != true) {
                XXX = false;
                System.exit(0);
            }
        }
    }

    public static void humanGame() {

        //carry on for set number of runs
        boolean XXX = true;
        while (XXX = true) {
            //dealer
            BlackjackDealer dealer = new BlackjackDealer();
            //players arraylist
            ArrayList<Player> players = new ArrayList<>();
            //human player
            Hand humanhand = new Hand();
            HumanPlayer human = new HumanPlayer(humanhand);
            //1 basic player
            Hand ahand = new Hand();
            BasicPlayer aplayer = new BasicPlayer(ahand);
            //add to game
            players.add(aplayer);
            players.add(human);
            //assign players
            dealer.assignPlayers(players);
            //take bets
            dealer.takeBets();
            System.out.println("Players have made bets");
            System.out.println("No more bets please!");
            //deal first cards
            dealer.dealFirstCards();
            //dealers first card to be shown to players
            System.out.println("\nDEALERS FIRST CARD: "
                    + dealer.dealersHand.myCards.get(0));
            //iterate through players
            for (Player player : players) {
                //let players get their best score
                int val = dealer.play(player);
                System.out.println("\n" + "Player " + "\n" + player.getHand()
                        .toString() + "SCORE:" + val);
            }
            //dealers turn
            System.out.println("\nDEALERS HAND");
            int dealers = dealer.playDealer();
            System.out.println(dealer.getDealersHand() + "SCORE: " + dealers
                    + "\n");
            //comparisons between players and dealer to see who wins
            dealer.settleBets();
            //reset hands ready for new game
            for (int i = 0; i < players.size(); i++) {
                players.get(i).newHand();
            }
            //output balance
            System.out.println("\n" + "BALANCE OF PLAYERS");
            for (int g = 0; g < players.size(); g++) {
                System.out.println("Player: " + players.get(g).getBalance());
            }
        }
        //confirm restart
        Scanner scane = new Scanner(System.in);
        System.out.println("Do you wish to restart? y/n");
        String SSS = scane.next();
        if ("y".equals(SSS) != true) {
                XXX = false;
                System.exit(0);
            }

    }

    public static void advancedGame() throws FileNotFoundException, IOException {
        //carry on for set number of runs
        boolean XXX = true;
        while (XXX = true) {
            //enter number of runs
            System.out.println("How many runs?");
            Scanner scanee = new Scanner(System.in);
            int res = scanee.nextInt();
            //create dealer       
            BlackjackDealer dealer = new BlackjackDealer();
            //list of players
            ArrayList<Player> players = new ArrayList<>();

            //basic intermediate and advanced player created
            Hand ahand = new Hand();
            BasicPlayer aplayer = new BasicPlayer(ahand);
            Hand ahand2 = new Hand();
            IntermediatePlayer iPlayer = new IntermediatePlayer(ahand2);
            Hand ahand3 = new Hand();
            AdvancedPlayer adPlayer = new AdvancedPlayer(ahand3);
            //add players
            players.add(aplayer);
            players.add(iPlayer);
            players.add(adPlayer);
            //assign players
            dealer.assignPlayers(players);
            //continue for number of runs
            while (res > 0) {
                //take players bets
                dealer.takeBets();
                System.out.println("Players have made bets");
                System.out.println("No more bets please!");
                //give first cards out to players
                dealer.dealFirstCards();
                //dealers first card for players to see
                System.out.println("\nDEALERS FIRST CARD: "
                        + dealer.dealersHand.myCards.get(0));
                //iterate through players
                for (Player player : players) {
                    //players play for best score
                    int val = dealer.play(player);
                    //output results
                    System.out.println("\n" + "Player " + "\n"
                            + player.getHand().toString() + "SCORE:" + val);
                }
                //dealers turn
                System.out.println("\nDEALERS HAND");
                int dealers = dealer.playDealer();
                System.out.println(dealer.getDealersHand() + "SCORE: "
                        + dealers + "\n");
                //comparisons are made between players and dealer to see who wins
                dealer.settleBets();
                //reset hands ready for new game
                for (int i = 0; i < players.size(); i++) {
                    players.get(i).newHand();
                }
                //output balance
                System.out.println("\n" + "BALANCE OF PLAYERS");
                for (int g = 0; g < players.size(); g++) {
                    System.out.println("Player: " + players.get(g)
                            .getBalance());
                }
                res--;
            }
            //confirm restart
            Scanner scane = new Scanner(System.in);
            System.out.println("Do you wish to restart? y/n");
            String SSS = scane.next();

            if ("y".equals(SSS) != true) {
                XXX = false;
                System.exit(0);
            }

        }
    }
}
