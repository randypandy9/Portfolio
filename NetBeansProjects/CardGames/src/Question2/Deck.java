package Question2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author ysj13kxu
 */
public class Deck implements Iterable<Card>, Serializable {

    //deck of type cards
    private ArrayList<Card> cards = new ArrayList();
    //deck count
    private int noOfCardsLeft;
    //serial
    private static final long serialVersionUID = 101;

    @Override
    public Iterator<Card> iterator() {
        //iterator
        return cards.listIterator();
    }

    public Iterator<Card> secondCardIterator() {
        //second card iterator
        return new SecondCardIterator(cards);
    }

    public static class SecondCardIterator implements Iterator<Card> {

        private ArrayList<Card> seccards;
        private int cardsleft;
        private int cardpointer = -2;

        public SecondCardIterator(ArrayList<Card> cards) {
            //constructor
            this.seccards = cards;
            this.cardsleft = this.seccards.size();
        }

        @Override
        public boolean hasNext() {
            //make sure theres at least 2 cards left
            return cardpointer < seccards.size() - 2;
        }

        @Override
        public Card next() {
            //get every second card after the first
            return seccards.get(cardpointer += 2);
        }

        @Override
        public void remove() {
            //nothing
        }
    }

    public Deck() {
        //temporary card
        Card c;
        this.noOfCardsLeft = 52;
        //iterate through suits
        for (int s = 0; s < 4; s++) {
            //iterate through ranks
            for (int n = 0; n <= 12; n++) {
                //make a card
                c = new Card(Rank.values()[n], Suit.values()[s]);
                //add to deck
                this.cards.add(c);
            }
        }

    }

    public void shuffle() {
        //ENSURES WELL SHUFFLED DECK
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);

    }

    public Card deal() {
        //temp card
        Card topcard = null;
        //if theres a card available
        if (cards.size() > 0) {
            //get top card
            topcard = this.cards.get(0);
            //remove it from deck
            this.cards.remove(topcard);
            //update counter
            this.noOfCardsLeft--;
        } else {
            //make a new deck
            newDeck();
            //deal again
            deal();
        }
        return topcard;
    }

    public int size() {
        //get deck size
        return this.noOfCardsLeft;
    }

    public void newDeck() {
        //create new deck
        Deck newDeck = new Deck();
        //shuffle new deck
        newDeck.shuffle();
        //assign new deck to last one
        this.cards = newDeck.cards;
        //reset card count
        this.noOfCardsLeft = 52;
    }

}
