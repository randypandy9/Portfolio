package Question1;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author ysj13kxu
 */
public class Card implements Comparable<Card>, Serializable {

    //rank and suit
    public Rank rank;
    public Suit suit;

    private static final long serialVersionUID = 100;

    public Card() {
        //empty constructor
    }

    public Card(Rank rank, Suit suit) {
        //card constructor 
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getNext() {
        //wrap around 
        if (this.rank == Rank.ACE) {
            return Rank.TWO;
        } else {
            //get next rank
            return Rank.values()[this.rank.ordinal() + 1];
        }
    }

    public int getValue() {
        //offset
        int rawvalue = this.rank.ordinal() + 2;
        //if ace
        if (rawvalue == 14) {
            //ace is 11
            rawvalue = 11;
        } else if (rawvalue > 10) {
            //picture card / 10
            rawvalue = 10;
        }
        //otherwise return ordinal value
        return rawvalue;
    }

    public static int sum(Card a, Card b) {
        //local variables
        int aval, bval, sum;
        //get both values
        aval = a.getValue();
        bval = b.getValue();
        //calulate total value of 2 cards passed in
        sum = aval + bval;
        return sum;
    }

    public Rank getRank() {
        //return this rank
        return this.rank;
    }

    public Suit getSuit() {
        //return this suit
        return this.suit;
    }

    public static boolean isBlackjack(Card a, Card b) {
        //check if 2 passed cards combine to make a 21 (blackjack)
        return (a.getValue() == 11 && b.getValue() == 10)
                || (a.getValue() == 10 && b.getValue() == 11);
    }

    @Override
    public String toString() {
        //output this card
        return this.rank + " of " + this.suit;
    }

    @Override
    public int compareTo(Card t) {
        //compares passed card to another card to see which 
        //has a higher value
        //1 is left card is higher
        //-1 is right is higher
        //0 is equal
        int status = 0;
        if (this.rank.ordinal() < t.getRank().ordinal()) {
            status = -1;
        } else if (this.rank.ordinal() > t.getRank().ordinal()) {
            status = 1;
        } else {
            if (this.suit.ordinal() < t.getSuit().ordinal()) {
                status = -1;
            } else if (this.suit.ordinal() > t.getSuit().ordinal()) {
                status = 1;
            } else if (this.suit.ordinal() == t.getSuit().ordinal()
                    && this.rank.ordinal() == t.getRank().ordinal()) {
                status = 0;
            }
        }
        return status;
    }

    public static class CompareDecending implements Comparator<Card> {

        //compares 2 passed cards to each other to see 
        //which has a higher value
        //1 is left card is higher
        //-1 is right is higher
        //0 is equal
        @Override
        public int compare(Card t, Card t1) {
            int a = 0;
            if (t.getRank().ordinal() > t1.getRank().ordinal()) {
                a = 1;
            } else if (t.getRank().ordinal() < t1.getRank().ordinal()) {
                a = -1;
            } else {
                if (t.getSuit().ordinal() > t1.getSuit().ordinal()) {
                    a = 1;
                } else if (t.getSuit().ordinal() < t1.getSuit().ordinal()){
                    a = -1;
                } else if (t.getRank().ordinal() == t1.getRank().ordinal()
                    && t.getSuit().ordinal() == t1.getSuit().ordinal()){
                    a = 0;
                }
            }
            return a;
        }
    }

    public static class CompareSuit implements Comparator<Card> {

        //compares 2 passed cards to each other to see which has a 
        //higher value
        //1 is left card is higher
        //-1 is right is higher
        //0 is equal
        @Override
        public int compare(Card t, Card t1) {
            int status = 0;
            if (t.getSuit().ordinal() > t1.getSuit().ordinal()) {
                status = -1;
            } else if (t.getSuit().ordinal() < t1.getSuit().ordinal()){
                status = 1;
            } else {
                if (t.getRank().ordinal() > t1.getRank().ordinal()) {
                    status = -1;
                } else if (t.getRank().ordinal() < t1.getRank().ordinal()){
                    status = 1;
                } else if (t.getSuit().ordinal() == t1.getSuit().ordinal()
                    && t.getRank().ordinal() == t1.getRank().ordinal()){
                    status = 0;
                }
            }
            return status;
        }
    }

}
