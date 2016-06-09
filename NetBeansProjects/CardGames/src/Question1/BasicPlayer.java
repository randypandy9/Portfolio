package Question1;

import java.util.ArrayList;

/**
 *
 * @author ysj13kxu
 */
public class BasicPlayer implements Player {

    //this hand
    Hand myHand;
    //dealt cards
    Deck dealtdeck;
    //start balance
    int balance = 200;
    //empty pot
    int pot = 0;
    //dealers first card
    Card dealersFirst = null;
    //card count value
    int cardCount = 0;

    public BasicPlayer(Hand h) {
        //set hands to whats passed in
        this.myHand = h;
    }

    @Override
    public Hand newHand() {
        //iterate through cards in each hand
        for (int a = 0; a < myHand.myCards.size(); a++) {
            //remove all those cards
            myHand.myCards.remove(a);
        }
        return myHand;
    }

    @Override
    public int makeBet() {
        //if balance is more than 10
        if (balance > 10) {
            //bet 10
            balance -= 10;
            pot = 10;

        } else {
            //bet whats left
            pot = balance;
            balance = 0;
        }
        return pot;
    }

    @Override
    public int getBet() {
        //return this bet
        return this.pot;
    }

    @Override
    public int getBalance() {
        //return balance
        return this.balance;
    }

    @Override
    public boolean hit() {
        boolean over17 = true;
        //iterate through scores
        for (Integer myCardsScore : myHand.myCardsScore) {
            //if its between parameters that say i've got a good score
            if (myCardsScore > 16 && myCardsScore < 22) {
                //dont hit anymore
                over17 = false;
            }
        }
        //otherwise hit
        return over17;
    }

    @Override
    public void takeCard(Card c) {
        //card adds to my hand
        myHand.addSingleCard(c);
    }

    @Override
    public boolean settleBet(int p) {
        //p is win or lost money
        //add it to pot
        pot += p;
        //move pot to balance
        balance += pot;
        //pot is now empty
        pot = 0;
        //return if you can carry on playing or not
        return balance > 0;
    }

    @Override
    public int getHandTotal() {

        int toReturn = 0;
        //iterate through scores
        for (int h = 0; h < myHand.myCardsScore.size(); h++) {
            //if it's a valid score that's highest
            if (myHand.myCardsScore.get(h) <= 21) {
                //return that value
                toReturn = myHand.myCardsScore.get(h);
            }
        }
        //otherwise get next lowest value thats more than 21
        if (toReturn == 0) {
            toReturn = myHand.myCardsScore.get(0);
        }
        return toReturn;
    }

    @Override
    public boolean blackjack() {
        //check is blackjack or not
        return Card.isBlackjack(myHand.myCards.get(0), myHand.myCards.get(1));
    }

    @Override
    public boolean isBust() {
        //check if score is bust or not
        return myHand.getScore() > 21;
    }

    @Override
    public Hand getHand() {
        //return hand
        return myHand;
    }

    @Override
    public void viewDealerCard(Card c) {
        //gives dealers card
        dealersFirst = c;
    }

    @Override
    public void viewCards(ArrayList<Card> cards) {
        //initialise cardcount as 0
        cardCount = 0;
        //iterate through cards
        for (int a = 0; a < cards.size(); a++) {
            //if there's a low card count goes up
            if (cards.get(a).getRank().ordinal() < 5) {
                cardCount++;
            } //if there's a high card count goes down
            else if (cards.get(a).getRank().ordinal() > 7) {
                cardCount--;
            }
        }
    }

    @Override
    public void newDeck() {
        //create new deck
        System.out.println("A new deck is now being used!");
        //reset cardcount
        cardCount = 0;
    }

}
