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

    /**
     * Constructor
     */
    GameEngine() {
        ui = new UserInterface();
        hm = new Hangman();

        kb = new Scanner(System.in);
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
        hm.drawEmptyHangman();
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