package Question2;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ysj13kxu
 */
public class BlackjackDealer implements Dealer {

    //list of players
    ArrayList<Player> players;
    //list of dealt cards
    ArrayList<Card> dealtCards = new ArrayList();

    //dealers hand
    Hand dealersHand;
    //dealers record of players bets
    int[] bets;
    //dealer controls deck
    private Deck deck;
    //starting balance for advanced player
    int startbal = 0;

    @Override
    public void assignPlayers(ArrayList<Player> p) {
        //player gets assigned
        this.players = p;
        //dealer gets new hand
        dealersHand = new Hand();
        //new deck
        deck = new Deck();
        //decks shuffled
        deck.shuffle();
        //new record of players bets
        bets = new int[players.size()];
        //assign advanced players starting balance
        startbal = players.get(players.size() - 1).getBalance();
    }

    @Override
    public void takeBets() {
        //iterate through players
        for (int a = 0; a < players.size(); a++) {
            //let players see dealers first card
            players.get(a).viewCards(dealtCards);
            //get everyones bets
            bets[a] = players.get(a).makeBet();
        }
        System.out.println("All bets taken!");
    }

    @Override
    public void dealFirstCards() {
        //if theres more than a quarter of the deck left
        if (deck.size() > 12) {
            //give each player 1 card
            for (int p = 0; p < players.size(); p++) {
                players.get(p).newHand();
                Card firstcards = deck.deal();
                dealtCards.add(firstcards);
                //add to dealt card for card counting
                players.get(p).takeCard(firstcards);
            }
            //give dealer a card
            dealersHand.myCards.clear();
            Card dealersfirstcard = deck.deal();
            //add to dealt card for card counting
            //add to dealers hand
            dealtCards.add(dealersfirstcard);
            //iterate through players
            for (int p = 0; p < players.size(); p++) {
                //everyone sees dealers first card
                players.get(p).viewDealerCard(dealersfirstcard);
            }
            //dealer takes another card
            dealersHand.addSingleCard(dealersfirstcard);
            //iterate through players
            for (int p = 0; p < players.size(); p++) {
                //everyone gets another card
                Card secondcards = deck.deal();
                dealtCards.add(secondcards);
                players.get(p).takeCard(secondcards);
            }
            //dealer gets a second card that remains hidden to players
            Card dealersSecondCard = deck.deal();
            dealtCards.add(dealersSecondCard);
            dealersHand.addSingleCard(dealersSecondCard);
        } else {
            //new deck created
            deck.newDeck();
            //saves win after each game not each deck
            try (PrintWriter out = new PrintWriter(new FileWriter
        ("file.txt", true))) {
                Player ad = players.get(players.size() - 1);
                out.print("Advanced Player\r\n");
                out.print("Balance before: £" + startbal + "\r\n");
                out.print("Balance after: £" + ad.getBalance() +"\r\n");
                out.print("PROFIT/LOSS: £" + (Math.abs(startbal
                        - ad.getBalance())) + "\r\n");
                System.out.println("\nSAVE SCORE SUCCESSFUL");
            } catch (IOException ex) {
                Logger.getLogger(BlackjackDealer.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            //clear dealt cards
            dealtCards.clear();
            //re deal
            dealFirstCards();
        }

    }

    @Override
    public int play(Player p) {
        int a = 0;
        //calculate scores
        p.getHand().scoreCounter();
        //while they can hit
        while (p.hit() == true && p.isBust() == false) {
            //give player a card
            Card toPlayer = deck.deal();
            //add to dealt cards
            dealtCards.add(toPlayer);
            //player takes this card
            p.takeCard(toPlayer);
            //recalculate score for player
            p.getHand().scoreCounter();
        }
        //recalculate score for player
        a = p.getHandTotal();
        return a;
    }

    @Override
    public int playDealer() {
        int toreturn = 0;
        //keep hitting while scores less than 17
        while (dealersHand.getScore() <= 17) {
            //give dealer a card
            Card toDealer = deck.deal();
            //add to dealt cards
            dealtCards.add(toDealer);
            //dealer adds to his hand
            dealersHand.addSingleCard(toDealer);
        }
        //get dealers score
        toreturn = dealersHand.getScore();
        return toreturn;
    }

    @Override
    public int scoreHand(Hand h) {
        //get hands score
        return h.getScore();
    }

    public Hand getDealersHand() {
        //return dealers hand
        return dealersHand;
    }

    @Override
    public void settleBets() {
        for (int p = 0; p < players.size(); p++) {
            //get first 2 cards of each player and dealer to 
            //check for blackjack
            Card bja = dealersHand.myCards.get(0);
            Card bjb = dealersHand.myCards.get(1);
            Card pbja = players.get(p).getHand().getCards().get(0);
            Card pbjb = players.get(p).getHand().getCards().get(1);

            //blackjack draw
            if (Card.isBlackjack(bja, bjb) && 
                    (Card.isBlackjack(pbja, pbjb))) {
                //push
                players.get(p).settleBet(0);
                System.out.println("Player " + (p + 1) + ": PUSH");
            } else if (Card.isBlackjack(bja, bjb) && players.get(p)
                    .getHandTotal() < 22) {
                //dealer wins
                players.get(p).settleBet(-players.get(p).getBet());
                System.out.println("Player " + (p + 1) + ": LOSES");
            } else if (dealersHand.getScore() < 22
                    && ((Card.isBlackjack(pbja, pbjb)))) {
                //player wins
                players.get(p).settleBet(players.get(p).getBet());
                System.out.println("Player " + (p + 1) + ": WINS");
            } else if (players.get(p).getHandTotal() > 21) {
                //dealer wins
                players.get(p).settleBet(-players.get(p).getBet());
                System.out.println("Player " + (p + 1) + ": LOSES");
            } else if (dealersHand.getScore() > 21 && players.get(p)
                    .getHandTotal() < 22) {
                //player wins
                players.get(p).settleBet(players.get(p).getBet());
                System.out.println("Player " + (p + 1) + ": WINS");
            } else if (players.get(p).getHandTotal()>dealersHand.getScore()
                    && players.get(p).getHandTotal() < 22) {
                //player wins
                players.get(p).settleBet(players.get(p).getBet());
                System.out.println("Player " + (p + 1) + ": WINS");
            } else if (players.get(p).getHandTotal()<dealersHand.getScore()
                    && dealersHand.getScore() < 22) {
                //dealer wins
                players.get(p).settleBet(-players.get(p).getBet());
                System.out.println("Player " + (p + 1) + ": LOSES");
            } else if (dealersHand.getScore() == 
                    players.get(p).getHandTotal()) {
                //draw/push
                players.get(p).settleBet(0);
                System.out.println("Player " + (p + 1) + ": PUSH");
            }
        }
    }
}
