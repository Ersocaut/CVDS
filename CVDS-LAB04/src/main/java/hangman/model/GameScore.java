package hangman.model;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano Garzon
 * @version 1.0 8/27/2020
 */
public interface GameScore {
    /**
     * this method calculates the actual  score of the match
     * @param correctCount, int  that represents the correct attempts of the player
     * @param incorrectCount, int that represents the incorrect attempts of the player
     * @return int ,that represents the score of the match
     * @throws GameScoreException, throws an exception if some of the count numbers are negative
     */
    public int calculateScore( int correctCount, int incorrectCount ) throws GameScoreException;

}
