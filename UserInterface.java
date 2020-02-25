/**
 * Hangman
 * 
 * Author: Miguel Menjivar 
 * Date: February 24, 2020
 * 
 * UserInterface.java 
 * This is where the logic of the game to be handled
 */
class UserInterface {

    /**
     * Main menu choices
     */
    public void mainMenuChoices() {
        System.out.print("Main Menu: \n"
                        + "1) Start Game\n"
                        + "2) Exit Game\n"
                        + ">> ");
    }

    /**
     * title of the game
     */
    public void title() {
        System.out.println("Hangman\n");
    }

    /**
     * Choose a letter for the game word
     */
    public void chooseALetter() {
        System.out.print("Choose a letter: \n"
                        +">> ");
    }

    /**
     * When the user chooses a letter instead of a number
     * in the main menu
     */
    public void mainMenuLetterError() {
        System.out.println("Please enter a NUMBER not a LETTER...");
    }

    /**
     * When user chooses a number that is out of range from options given
     */
    public void mainMenuRangeError() {
        System.out.println("Please choose a number provided by the main menu");
    }

    /**
     * When user exits the game
     */
    public void exit() {
        System.out.println("Game has been terminated...");
    }
}