package hangman.model;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano Garzon
 * @version 1.0 8/27/2020
 *
 * This Class is a type of score, that the game can use
 */
public class BonusScore implements GameScore {
    private int score = 0;
    private int failure= 5;
    private int bonus=10;
    private int minScore= 0;

    /**
     * this method calculates the actual  score of the match, following the next rules:
     * 1) The Game begins with 0  points
     * 2) Bonus of 10 points with every correct attempt
     * 3) Failure penalty of 5 points for each incorrect attempt
     * 4) minimum  score is 0
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
        score =( score+(correctCount*bonus) - (failure*incorrectCount) < minScore )? minScore :  score+(correctCount*bonus) - (failure*incorrectCount);
        return score;

    }
}
