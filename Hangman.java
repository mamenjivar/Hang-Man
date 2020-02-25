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
    private String[] wordList = {"Developer", "Pillow", "Cart", "Bullet", "Stool", "Spray", "Door", "Octopus"};

    private int tries; // will keep track of how many tries it takes to solve word
    private String randomWord; // will get current random word

    Random rand; // to randomize the different values to choose from within array

    /**
     * default constructor
     */
    Hangman() {
        randomWord = "";
        tries = 0;
        rand = new Random();
    }

    /**
     * The visual representation of the hangman
     * 
     */
    public void drawHangman() {
        System.out.println(" __________");
        System.out.println(" |         |");
        System.out.println(" |         " + ((tries == 1) ? "O" : " "));
        System.out.println(" |         " + ((tries == 2) ? "\\/" : " "));
        System.out.println(" |         " + ((tries == 3) ? "|" : " "));
        System.out.println(" |         " + ((tries == 4) ? "/\\" : " "));
        System.out.println(" |");
        System.out.println("---------------");
        System.out.println();

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
        return wordList[rand.nextInt(wordList.length)];
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