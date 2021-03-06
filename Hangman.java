/**
 * Hangman
 * 
 * Author: Miguel Menjivar 
 * Date: February 24, 2020
 * 
 * Hangman.java 
 * This is where the hangman logic will occur
 */
import java.util.Random;
class Hangman {
    // words to be used for hangman game
    private String[] wordList = {"developer", "pillow", "cart", "bullet", "stool", "spray", "door", "octopus"};

    private int tries; // will keep track of how many tries it takes to solve word
    private String randomWord; // will get current random word
    private int count; // keeps track of result word

    Random rand; // to randomize the different values to choose from within array

    /**
     * default constructor
     */
    Hangman() {
        randomWord = "";
        tries = 0;
        count = 0;
        rand = new Random();
    }

    /**
     * The visual representation of the hangman
     * 
     */
    public void drawHangman() {
        System.out.println(" __________");
        System.out.println(" |         |");
        System.out.println(" |         " + ((tries >= 1) ? "O" : " "));
        System.out.println(" |         " + ((tries >= 2) ? "\\/" : " "));
        System.out.println(" |         " + ((tries >= 3) ? "|" : " "));
        System.out.println(" |         " + ((tries >= 4) ? "/\\" : " "));
        System.out.println(" |");
        System.out.println("---------------");
        System.out.println();

    }

    /**
     * after user has incorrectly guessed
     * the word and game is over
     */
    public boolean isOver() {
        if(tries == 4){
            return true;
        }

        return false;
    }

    /**
     * Will print all the words in the array to be viewed by user
     */
    public void printWordList() {
        System.out.println("Word List:");
        for (int i = 0; i < wordList.length; i++) {
            System.out.println(wordList[i] + " | ");
        }
    }

    /**
     * randomizes a word to use for the game
     * 
     * @return
     */
    public String randomWord() {
        randomWord = wordList[rand.nextInt(wordList.length)];
        // return wordList[rand.nextInt(wordList.length)];
        setRandomWord(randomWord);
        count = randomWord.length();
        // count = "cat".length();
        // return "cat";
        return randomWord;

    }

    /**
     * checks if answer is correct
     * 
     * @param counts
     * @return
     */
    public boolean isWordCorrect(int counts) {
        if(count == counts){
            return true;
        } else {
            return false;
        }
    }

    /**
     * the length of the word
     * 
     * @return
     */
    public int randomWordSize(){
        return  randomWord.length();
    }

    /**
     * for every wrong answer user takes
     * it increments
     */
    public void incrementTries(){
        tries++;
    }

    ////////////////////////////////////////////////////
    //       SETTERS AND GETTERS
    ////////////////////////////////////////////////////

    /**
     * setter for array wordList
     */
    public void setWordList(String[] array) {
        this.wordList = array;
    }

    /**
     * getter for array wordList
     * @return
     */
    public String[] getWordList(){
        return wordList;
    }

    /**
     * setter for tries
     * 
     * @param tries
     */
    public void setTries(int tries) {
        this.tries = tries;
    }

    /**
     * getter for tries
     * 
     * @return
     */
    public int getTries(){
        return tries;
    }

    public void setRandomWord(String randomWord){
        this.randomWord = randomWord;
    }

    public String getRandomWord(){
        return randomWord;
    }
}