package Question2;

/**
 *
 * @author ysj13kxu
 */
public class AdvancedPlayer extends BasicPlayer {

    public AdvancedPlayer(Hand h) {
        //get other variables from super class
        super(h);
    }

    @Override
    public int makeBet() {
        //pot is 0
        pot = 0;
        //if count is more than 1 then bet higher
        if (cardCount > 1 && (10 * cardCount) > balance) {
            pot = 10 * cardCount;
            balance -= pot;
        }
        //if its less then bet 10
        if (cardCount <= 1 && balance > 10) {
            pot = 10;
            balance -= pot;
        } //otherwise bet what you have left in balance
        else if (balance > 0) {
            pot = balance;
            balance = 0;
        }
        //return bet
        return pot;
    }
}
