package Question2;

/**
 *
 * @author ysj13kxu
 */
public class IntermediatePlayer extends BasicPlayer {

    //players max stop value
    int playermax;

    public IntermediatePlayer(Hand h) {
        super(h);
        //gets all other values from superclass
    }

    @Override
    public boolean hit() {
        //result shows whether to hit or not
        boolean result = false;
        //iterate through the cards that are in my hand at the moment
        for (int s = 0; s < myHand.myCards.size() - 1; s++) {
            //if there's an ace
            if (myHand.myCards.get(s).getRank() == Rank.ACE) {
                //and there's then a 9 or 10
                if (myHand.getScore() == 9 || myHand.getScore() == 10){
                    //don't hit as i have a score of 20/21
                    result = false;
                } else if (myHand.getScore() <= 8) {
                    //else hit as it's lower, even if i bust the 
                    //ace becomes a one so i have another chance 
                    //to get a good score
                    result = true;
                }
            } else {
                //if the dealers hand is greater than 6
                if (dealersFirst.getValue() > 6) {
                    //my max to hit towards becomes 17
                    playermax = 17;
                } else {
                    //otherwise my max is 12
                    playermax = 12;
                }
            }
        }
        //iterate through my hand
        for (int s = 0; s < myHand.myCardsScore.size() - 1; s++) {
            //check if my hand is between my max hit value 
            //and i haven't busted
            if (myHand.myCardsScore.get(s) >= playermax
                    && myHand.myCardsScore.get(s) < 22) {
                //if it is then no more hitting
                result = false;
            } else {
                //otherwise hit
                result = true;
            }
        }
        //return weather to hit or not
        return result;
    }

}
