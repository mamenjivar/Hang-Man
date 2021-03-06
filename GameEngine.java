/**
 * Hangman
 * 
 * Author: Miguel Menjivar 
 * Date: February 24, 2020
 * 
 * GameEngine.java
 * This is where the logic of the game to be handled
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

class GameEngine{
    UserInterface ui;
    StringBuffer sb;
    Hangman hm;

    Scanner kb;

    String[] splitWord;
    String[] rebuildWord;
    Boolean[] ifLetterExists;
    ArrayList<String> wrongLetters;

    String gameWord;
    String guessLetter;
    Boolean isLetterCorrect;

    int count; // tracks correct letters


    /**
     * Constructor
     */
    GameEngine() {
        ui = new UserInterface();
        hm = new Hangman();
        kb = new Scanner(System.in);
        wrongLetters = new ArrayList<String>();

        count = 0;
        isLetterCorrect = false;
        gameWord = "";
        guessLetter = "";
    }

    /**
     * The start of the
     * game
     */
    public void start() {
        ui.title();
        mainMenu();
    }

    /**
     * Commences game
     */
    public void playGame(){
        settingUp();

        boolean loop = true;
        while(loop){
            hm.drawHangman();

            rebuildWord();

            takeAGuess();

            isItOver();
        }
    }

    /**
     * Checks if the game is over
     * if user ran out of tries,
     * or user won the game
     */
    public void isItOver() {
        if (hm.isWordCorrect(count)) {
            ui.gameWon();
            exit();
        }

        if (hm.isOver()) {
            ui.gameover();
            ui.theWordIs(hm.getRandomWord());
            exit();
        }
    }

    /**
     * prints out the wrong letters that were given by
     * user to have as reference
     */
    public void wrongLetterList() {
        ui.wrongLetterList(wrongLetters);
    }

    /**
     * Will print the empty spaces or
     * letters in the word
     */
    public void rebuildWord(){
        for (int i = 0; i < rebuildWord.length; i++) {
            if (rebuildWord[i] != null) {
                System.out.print(rebuildWord[i]);
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }



    /**
     * setting up the game
     * as in splitting words and empty arrays
     */
    public void settingUp() {
        gameWord = hm.randomWord();
        splitWord = new String[gameWord.length()];
        splitWord = gameWord.split("(?!^)");

        ifLetterExists = new Boolean[gameWord.length()];
        rebuildWord = new String[gameWord.length()];

        // sets array to false to signify if right or wrong choices
        for(int i = 0; i < ifLetterExists.length; i++){
            ifLetterExists[i] = false;
        }
    }

    /**
     * prompts user to guess a letter
     */
    public void takeAGuess(){
        ui.chooseALetter();
        guessLetter = kb.nextLine();
        isLetterCorrect = false;

        for(int i = 0; i < gameWord.length(); i++){
            if(splitWord[i].equals(guessLetter)){
                count++;
                rebuildWord[i] = splitWord[i]; // adds letter to guessing word
                isLetterCorrect = true;
            } 
        }

        if(isLetterCorrect) {
            ui.correctGuessLetter();
        } else {
            wrongLetters.add(guessLetter);
            ui.incorrectGuessLetter();
            hm.incrementTries();
        }
    }

    /**
     * Main menu choices for user
     * to choose from
     */
    public void mainMenu(){
        boolean mainMenuLoop = true;
        int mainMenuChoice = 0;

        while(mainMenuLoop){
            ui.mainMenuChoices();
            try {
                mainMenuChoice = kb.nextInt();
                System.out.println();
                kb.nextLine();

            } catch (InputMismatchException e) {
                System.out.println(e);
                ui.mainMenuLetterError();
                kb.nextLine();
            }

           switch(mainMenuChoice){
               case 1:
                    playGame();
                    mainMenuLoop = false;
                    break;
                case 2:
                    exit();
                    mainMenuLoop = false;
                    break;
                default:
                    ui.mainMenuRangeError();
           }
        }
    }

    /**
     * Exits out the game
     */
    public void exit() {
        ui.exit();
        kb.close();
        System.exit(0);
    }
}