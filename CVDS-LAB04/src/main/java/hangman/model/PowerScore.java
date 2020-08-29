package hangman.model;

import java.lang.Math;
/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano Garzon
 * @version 1.0 8/27/2020
 *
 * This Class is a type of score, that the game can use
 */

public class PowerScore implements GameScore {
    private int score ;
    private int failure= 8;
    private int bonus= 5;
    private int minScore= 0;
    private int maxScore =500;

    /**
     * this method calculates the actual  score of the match, following the next rules:
     * 1) The Game begins with 0  points
     * 2) Bonus of 5^i  points with every correct attempt, where i is am iterator over the correctCount
     * 3) Failure penalty of 8 points for each incorrect attempt
     * 4) minimum  score is 0
     * 5) max Score is 500
     * @param correctCount, int  that represents the correct attempts of the player
     * @param incorrectCount, int that represents the incorrect attempts of the player
     * @return int ,that represents the score of the match
     * @throws GameScoreException, throws an exception if some of the count numbers are negative
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        score = 0;
        if( correctCount < 0 || incorrectCount <0 ) {
            throw new GameScoreException(GameScoreException.NEGATIVE_NUMBERS);
        }

        for( int i=1 ; i <=correctCount; i++){
            score+= (Math.pow(bonus,i));
        }

        score =( score - (failure*incorrectCount) < minScore )? minScore :  score - (failure*incorrectCount);
        score =( score > maxScore )? maxScore :  score ;
        return score;

    }
}
