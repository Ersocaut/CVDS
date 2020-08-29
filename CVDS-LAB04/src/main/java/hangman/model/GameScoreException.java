package hangman.model;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 8/27/2020
 */
public class GameScoreException extends Exception {
    public static final String NEGATIVE_NUMBERS = "Some of the count numbers are negative.";
    public GameScoreException(String message ){
        super( message);
    }
}
