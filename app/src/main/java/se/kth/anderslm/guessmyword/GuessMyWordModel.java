package se.kth.anderslm.guessmyword;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * This class represents the game "Guess my word".
 * Created by anderslm@kth.se on 2015-03-02.
 */
public class GuessMyWordModel {

    public GuessMyWordModel() {
        reset();
    }

    /**
     * Initialize the game for a new round.
     */
    public void reset() {
        noOfGuesses = 0;
        noOfMatches = 0;
        // Pick a random word
        int pos = rand.nextInt(wordList.size());
        theWord = wordList.get(pos).toUpperCase(Locale.US).toCharArray();
        // Create a char[] of equal length, filled with '*'
        int n = theWord.length;
        guessSoFar = new char[n];
        for (int i = 0; i < n; i++) {
            guessSoFar[i] = STAR;
        }
    }

    /**
     * Checks whether the guess is correct or not. If so, the guess so far and
     * the number of guesses are updated (repeated guesses on the same character
     * are counted).
     *
     * @param guess
     *            the guess
     * @return true if guess is a match, not previously used, false otherwise.
     */
    public boolean handleGuess(char guess) {
        noOfGuesses++;
        guess = Character.toUpperCase(guess);

        // Check whether theWord contains the guess or not (first time)
        int n = theWord.length;
        boolean match = false;
        for (int i = 0; i < n; i++) {
            if (guessSoFar[i] == STAR && theWord[i] == guess) {
                guessSoFar[i] = guess;
                noOfMatches++;
                match = true;
            }
        }

        return match;
    }

    /**
     * Returns whether all characters are correct or not.
     */
    public boolean isSolved() {
        return (noOfMatches == theWord.length);
    }

    /**
     * Returns the number of guesses made, including repeated guesses on the
     * same character.
     */
    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    /**
     * Returns a string representing the guesses so far; unsolved positions are
     * marked with an asterisk (*).
     */
    public String getGuessSoFar() {
        return new String(guessSoFar);
    }

    private int noOfGuesses, noOfMatches;
    private char[] theWord, guessSoFar; // Java strings are immutable
    private List<String> wordList =
            Arrays.asList(new String[]{
                    "Android",
                    "Smartphone",
                    "Java",
                    "iOS",
                    "Symbian",
                    "JavaME",
                    "Computer",
                    "Network",
                    "Cell",
                    "Cellphone",
                    "Mobile",
                    "Software",
                    "Engineer",
                    "Kernel",
                    "Bandwidth",
                    "Device",
                    "Tiramisu",
                    "Windows"
            });

    private static final Random rand = new Random();
    private static final char STAR = '*';
}