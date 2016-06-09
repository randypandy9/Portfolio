package Question1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author ysj13kxu
 */
public class Hand implements Iterable, Serializable {

    //cards in a hand
    protected ArrayList<Card> myCards;
    //possible scores list
    protected ArrayList<Integer> myCardsScore = new ArrayList();
    //number of cards left in this hand
    private int noOfCards;
    //serial
    private static final long serialVersionUID = 102;

    //hand constructor
    public Hand() {
        //initialises hand 
        myCards = new ArrayList();
        noOfCards = myCards.size();
    }

    //hand constructor
    public Hand(Card[] arrayOfCards) {
        //adds card array to a hand
        myCards.addAll(Arrays.asList(arrayOfCards));
        noOfCards = myCards.size();
    }

    //hand constructor
    public Hand(Hand aHand) {
        //adds a hand to this hand
        ArrayList<Card> temp = aHand.myCards;
        myCards.addAll(temp);
        noOfCards = myCards.size();
    }

    public int getScore() {
        int biggestvalid = 0;
        //get all possible values
        scoreCounter();
        //sort into ascending order
        Collections.sort(myCardsScore);
        //iterate through scores
        for (int a = 0; a < myCardsScore.size(); a++) {
            //if it's a valid score
            if (myCardsScore.get(a) <= 21) {
                //set as vairable
                biggestvalid = myCardsScore.get(a);
            }
        }
        //if there's none then use the smallest value
        //assuming its the next smallest score thats greater than 21
        if (biggestvalid == 0) {
            biggestvalid = myCardsScore.get(0);
        }
        return biggestvalid;
    }

    public void addSingleCard(Card aCard) {
        //add single card to this hand
        myCards.add(aCard);
        noOfCards = myCards.size();
    }

    public void addCardCollection(Card[] arrayOfCards) {
        //add array of cards to this hand
        myCards.addAll(Arrays.asList(arrayOfCards));
        noOfCards = myCards.size();

    }

    public void addHand(Hand aHand) {
        //add a hand of cards to this hand
        ArrayList<Card> temp = aHand.myCards;
        myCards.addAll(temp);
        noOfCards = myCards.size();
    }

    public boolean removeSingleCard(Card cardtoremove) {
        //make sure it's not empty
        if (!myCards.isEmpty()) {
            //iterate through hand
            for (int i = 0; i < myCards.size(); i++) {
                //if passed card matches one in the hand
                if (myCards.get(i).equals(cardtoremove)) {
                    //remove it
                    myCards.remove(i);
                }
            }
            //return true to show it's been done
            return true;
        } else {
            //otherwise return false to show its not in the hand
            return false;
        }
    }

    public boolean removeAllCards(Hand cardcollection) {
        //boolean to return
        boolean ok = false;
        //if this hand has cards and cardcollection has 
        //less or equal number 
        //of cards then execute

        if (!myCards.isEmpty() && cardcollection.myCards.size()
                <= myCards.size()) {
            for (Card myCard : myCards) {
                //check if all passed cards are in this hand
                for (Card myCard1 : cardcollection.myCards) {
                    if (myCard1.equals(myCard)) {
                        ok = true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            //else we know it cant find all cards so 
            //return false automatically
            ok = false;
        }
        //if they're all there then iterate through again 
        //and actually delete
        //this time
        if (ok == true) {
            for (int a = 0; a < myCards.size(); a++) {
                for (int b = 0; b < cardcollection.myCards.size(); b++){
                    myCards.remove(a);
                }
            }
        }
        //return if it had deleted or not
        return ok;

    }

    public Card removeCardByPosition(int cardno) {
        //local variable of type card
        Card toShow = null;
        //if it's a valid position
        if (myCards.size() >= cardno) {
            //set that card to local variable
            toShow = myCards.get(cardno);
            //remove it from hand
            myCards.remove(myCards.get(cardno));
            //deincrement cards left
            this.noOfCards--;
        }
        //return deleted card
        return toShow;
    }

    public void sortAscending() {
        //sort into ascending
        Collections.sort(myCards);
    }

    public void sortDescending() {
        //sort into descending
        Collections.sort(myCards, Collections.reverseOrder());
    }

    public void sortSuit() {
        //sort by suit
        Collections.sort(myCards, new Card.CompareSuit());
    }

    public int countSuit(Suit aSuit) {
        //initialise suit counter
        int suitCounter = 0;
        //iterate through hand
        for (int s = 0; s < myCards.size(); s++) {
            //if the suit matches that card then count up by 1
            if (myCards.get(s).getSuit().equals(aSuit)) {
                suitCounter++;
            }
        }
        return suitCounter;
    }

    public int countRank(Rank aRank) {
        //initialise rank counter
        int rankCounter = 0;
        //iterate through hand
        for (int s = 0; s < myCards.size(); s++) {
            //if the rank matches that card then count up by 1
            if (myCards.get(s).getRank().equals(aRank)) {
                rankCounter++;
            }
        }
        return rankCounter;
    }

    @Override
    public String toString() {
        //toString method
        StringBuilder sb = new StringBuilder();
        for (int s = 0; s < myCards.size(); s++) {
            sb.append(myCards.get(s)).append("\n");
        }
        return sb.toString();
    }

    public boolean isOver(int givenScore) {
        //boolean to return set as false
        boolean result = false;
        //iterate through hand
        for (int i = 0; i < myCardsScore.size(); i++) {
            //if theres a higher score combination then it becomes true
            result = myCardsScore.get(i) < givenScore;
        }
        return result;
    }

    public Iterator<Card> iterator() {
        //return iterator
        return myCards.listIterator();
    }

    public ArrayList<Card> getCards() {
        //return cards in hand
        return this.myCards;
    }

    public void scoreCounter() {
        //works out scores
        Card tempcard;
        //reset scores in scores arraylist
        myCardsScore.clear();
        //iterate through
        for (int i = 0; i < myCards.size(); i++) {
            tempcard = myCards.get(i);
            //if it's an ace
            if (tempcard.getRank() == Rank.ACE) {
                //iterate through scores
                for (int a = 0; a < myCardsScore.size(); a++) {
                    //add 2 scores
                    myCardsScore.set(a, myCardsScore.get(a) + 1);
                }
                //if its not empty
                if (!myCardsScore.isEmpty()) {
                    //add scores to all values inside
                    myCardsScore.add(myCardsScore.
                            get(myCardsScore.size() - 1)
                            + 11);
                } else {
                    //otherwise add a 1 and an 11 to the arraylist
                    myCardsScore.add(1);
                    myCardsScore.add(11);
                }
            } else {
                //if it's not empty
                if (!myCardsScore.isEmpty()) {
                    //iterate through scores
                    for (int q = 0; q < myCardsScore.size(); q++) {
                        //adding the tempcard value
                        myCardsScore.set(q, myCardsScore.get(q)
                                + tempcard.getValue());
                    }
                } else {
                    //otherwise just add the score to the end
                    myCardsScore.add(tempcard.getValue());
                }

            }
        }
    }

}
