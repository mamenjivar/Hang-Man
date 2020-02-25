/**
 * Hangman
 * 
 * Author: Miguel Menjivar 
 * Date: February 24, 2020
 * 
 * GameEngine.java
 * This is where the logic of the game to be handled
 */
import java.util.Scanner;

class GameEngine{
    UserInterface ui;
    Scanner kb;

    /**
     * Constructor
     */
    GameEngine() {
        ui = new UserInterface();
        kb = new Scanner(System.in);
    }

    /**
     * The start of the
     * game
     */
    public void start() {

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