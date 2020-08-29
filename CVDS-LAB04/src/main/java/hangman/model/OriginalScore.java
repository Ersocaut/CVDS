package hangman.model;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano Garzon
 * @version 1.0 8/27/2020
 *
 * This Class is a type of score, that the game can use
 */
public class OriginalScore implements GameScore{
    private int score ;
    private int failure=10;
    private int minScore=0;


    /**
     * this method calculates the actual  score of the match, following the next rules:
     * 1) The Game begins with 100 points
     * 2) No bonus with correct attempts
     * 3) failure penalty of 10 points for each incorrect attempt
     * 4) minimum  score is 0
     * @param correctCount, int  that represents the correct attempts of the player
     * @param incorrectCount, int that represents the incorrect attempts of the player
     * @return int ,that represents the score of the match
     * @throws GameScoreException, throws an exception if some of the count numbers are negative
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        score = 100;
        if( correctCount < 0 || incorrectCount <0 ){
            throw new GameScoreException( GameScoreException.NEGATIVE_NUMBERS);
        }
        score =( score - (failure*incorrectCount) < minScore )? minScore :  score - (failure*incorrectCount);
        return score;

    }
}
