package Question1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in 
 * Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ysj13kxu
 */
public class CardTest {

    public static void main(String[] args) throws InterruptedException,
            IOException {
        System.out.println("Welcome to Blackjack!");
        System.out.println("\n" + "CONTINUE? y/n");
        Scanner scan = new Scanner(System.in);
        String cont = scan.next();
        if (cont.contains("Y") || cont.contains("y")) {

        } else {
            System.exit(0);
        }

        Deck deck = new Deck();
        Iterator<Card> iterator = deck.iterator();
        Iterator<Card> seciterator = deck.secondCardIterator();

        //PRINT ALL CARDS IN ORDER
        System.out.println("\n" + "EVERY CARD IN ORDER:" + "\n");
        while (iterator.hasNext()) {
            Card card = iterator.next();
            System.out.println(card);
        }

        System.out.println("\n" + "CONTINUE? y/n");

        cont = scan.next();
        if (cont.contains("Y") || cont.contains("y")) {

        } else {
            System.exit(0);
        }

        //OUTPUTS SECONDCARD
        System.out.println("\n" + 
                "SKIPPING EVERY SECOND CARD IN ORDER:");
        while (seciterator.hasNext()) {
            Card seccard = seciterator.next();
            System.out.println(seccard);
        }

        System.out.println("\n" + "CONTINUE? y/n");
        cont = scan.next();
        if (cont.contains("Y") || cont.contains("y")) {

        } else {
            System.exit(0);
        }

        //SHUFFLES DECK
        deck.shuffle();
        System.out.println("\n" + "CREATING 4 HANDS");
        Hand[] arrayOfHands = new Hand[4];
        for (int h = 0; h < arrayOfHands.length; h++) {
            arrayOfHands[h] = new Hand();
        }
        for (int a = 0; a < 13; a++) {
            for (int t = 0; t < 4; t++) {
                Card toHand = deck.deal();
                arrayOfHands[t].addSingleCard(toHand);
            }
        }

        //----------------
        //just prints hands
        for (int h = 0; h < arrayOfHands.length; h++) {
            System.out.println("\n" + "Hand: " + (h + 1));
            System.out.print(arrayOfHands[h]);
        }
        //----------------

        System.out.println("\n" + "CONTINUE? y/n");
        cont = scan.next();
        if (cont.contains("Y") || cont.contains("y")) {

        } else {
            System.exit(0);
        }

        //SAVE ALL HANDS TO FILE
        String file = "file.ser";
        try {
            FileOutputStream fos = new FileOutputStream(file);
            try (ObjectOutputStream out = new ObjectOutputStream(fos)){
                out.writeObject(arrayOfHands);
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
        }

        //DISPLAY TOTAL SUITS + RANKS AND TOTAL VALUE OF EACH HAND
        for (int h = 0; h < arrayOfHands.length; h++) {
            System.out.println("\n" + "Hand " + (h + 1));
            //counts suits
            int noOfClubs = arrayOfHands[h].countSuit(Suit.clubs);
            int noOfDiamonds = arrayOfHands[h].countSuit(Suit.diamonds);
            int noOfHearts = arrayOfHands[h].countSuit(Suit.hearts);
            int noOfSpades = arrayOfHands[h].countSuit(Suit.spades);

            //counts ranks              
            int noOfTwos = arrayOfHands[h].countRank(Rank.TWO);
            int noOfThrees = arrayOfHands[h].countRank(Rank.THREE);
            int noOfFours = arrayOfHands[h].countRank(Rank.FOUR);
            int noOfFives = arrayOfHands[h].countRank(Rank.FIVE);
            int noOfSixes = arrayOfHands[h].countRank(Rank.SIX);
            int noOfSevens = arrayOfHands[h].countRank(Rank.SEVEN);
            int noOfEights = arrayOfHands[h].countRank(Rank.EIGHT);
            int noOfNines = arrayOfHands[h].countRank(Rank.NINE);
            int noOfTens = arrayOfHands[h].countRank(Rank.TEN);
            int noOfJacks = arrayOfHands[h].countRank(Rank.JACK);
            int noOfQueens = arrayOfHands[h].countRank(Rank.QUEEN);
            int noOfKings = arrayOfHands[h].countRank(Rank.KING);
            int noOfAces = arrayOfHands[h].countRank(Rank.ACE);

            int totalcounter = 0;
            Hand temp = arrayOfHands[h];
            if (temp != null) {
                temp.scoreCounter();
                totalcounter = temp.myCardsScore
                        .get(temp.myCardsScore.size() - 1);
            }

            System.out.println("CLUBS:" + noOfClubs + " DIAMONDS:"
                    + noOfDiamonds
                    + " HEARTS:" + noOfHearts + " SPADES:" + noOfSpades);
            System.out.println("TWOS:" + noOfTwos + " THREES:"+noOfThrees
                    + " FOURS:" + noOfFours
                    + " FIVES:" + noOfFives + " SIXES:" + 
                    noOfSixes + " SEVENS:"
                    + noOfSevens
                    + " EIGHTS:" + noOfEights + " NINES:" + noOfNines 
                    + " TENS:"
                    + noOfTens
                    + " JACKS:" + noOfJacks + " QUEENS:" + noOfQueens
                    + " KINGS:" + noOfKings
                    + " ACES:" + noOfAces);
            System.out.println("TOTAL: " + totalcounter);
            System.out.println("IS OVER 100?.." + (totalcounter > 100));

        }

        System.out.println("\n" + "CONTINUE? y/n");
        cont = scan.next();
        if (cont.contains("Y") || cont.contains("y")) {

        } else {
            System.exit(0);
        }

        //SORT HANDS
        arrayOfHands[0].sortAscending();
        arrayOfHands[1].sortAscending();
        arrayOfHands[2].sortDescending();
        arrayOfHands[3].sortSuit();
        System.out.println("\n" + "SORTED HANDS (ASC-ASC-DESC-SUIT)");
        for (int h = 0; h < arrayOfHands.length; h++) {
            System.out.println("\n" + "Hand: " + (h + 1));
            System.out.print(arrayOfHands[h]);
        }

        System.out.println("\n" + "CONTINUE? y/n");
        cont = scan.next();
        if (cont.contains("Y") || cont.contains("y")) {

        } else {
            System.exit(0);
        }

        //LOAD IN FILE
        Hand[] readIn;
        try {
            FileInputStream fis = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            readIn = (Hand[]) in.readObject();
            System.out.println("\n" + "READING IN FILES\n");
            for (int part = 0; part < 4; part++) {
                System.out.println("\nREAD IN FILE: \n"
                        + readIn[part].toString());
            }
            in.close();
        } //ERROR CATCHING
        catch (IOException | ClassNotFoundException ex) {
            System.out.println("ERROR: " + ex);
        }

        //ITERATE OVER FIRST HAND ADD TO SECOND HAND
        Iterator<Card> handiterator = arrayOfHands[0].iterator();
        while (handiterator.hasNext()) {
            Card a = handiterator.next();
            handiterator.remove();
            arrayOfHands[1].addSingleCard(a);
        }
        System.out.println("\n" + "HAND 1 INTO HAND 2");
        for (int h = 0; h < 2; h++) {
            System.out.println("\n" + "Hand: " + (h + 1));
            System.out.print(arrayOfHands[h]);
        }

        System.out.println("\n" + "CONTINUE? y/n");
        cont = scan.next();
        if (cont.contains("Y") || cont.contains("y")) {

        } else {
            System.exit(0);
        }

        //REARRANGE CARDS TO OUTPUT EACH SUIT IN EACH HAND
        Card toShift;
        int cardcounter;
        for (int hands = 0; hands < 4; hands++) {
            cardcounter = arrayOfHands[hands].getCards().size();
            for (int s = 0; s < cardcounter; s++) {
                toShift = arrayOfHands[hands].removeCardByPosition(0);
                arrayOfHands[toShift.suit.ordinal()]
                        .addSingleCard(toShift);
            }
        }
        System.out.println("\n" + "HANDS SORTED BY SUIT");
        for (int h = 0; h < arrayOfHands.length; h++) {
            System.out.println("\n" + "Hand: " + (h + 1));
            System.out.print(arrayOfHands[h]);
        }

    }

}
