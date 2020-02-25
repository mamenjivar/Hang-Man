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

class GameEngine{
    UserInterface ui;
    Hangman hm;

    Scanner kb;

    String[] splitWord;
    String[] rebuildWord;
    Boolean[] ifLetterExists;

    String gameWord;
    String guessLetter;

    /**
     * Constructor
     */
    GameEngine() {
        ui = new UserInterface();
        hm = new Hangman();

        kb = new Scanner(System.in);

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
            // will print blank lines and spaces to signify number of characters
            // in word that needs to be guessed
            for(int i = 0; i < hm.randomWordSize(); i++){

                System.out.print("_ ");
            }

            takeAGuess();

            loop = false;
        }
    }

    public void settingUp() {
        gameWord = hm.getRandomWord();
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

        for(int i = 0; i < gameWord.length(); i++){
            if(splitWord[i].equals(guessLetter)){
                // ifLetterExists[i] = true; 
                rebuildWord[i] = splitWord[i]; // adds letter to guessing word
            }
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

            } catch (InputMismatchException e) {
                System.out.println(e);
                ui.mainMenuLetterError();
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