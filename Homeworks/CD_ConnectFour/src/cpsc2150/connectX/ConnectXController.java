package cpsc2150.connectX;

/**
 * The controller class will handle communication between our View and our Model (IGameBoard)
 *
 * This is where you will write code
 *
 * You will need to include your IGameBoard interface
 * and both of the IGameBoard implementations from Homework 3
 * If your code was correct you will not need to make any changes to your IGameBoard implementation class
 */

public class ConnectXController {

    private int player = 0;

    //our current game that is being played
    private IGameBoard curGame;


    //The screen that provides our view
    private ConnectXView screen;



    public static final int MAX_PLAYERS = 10;
    //our play tokens are hard coded. We could make a screen to get those from the user, but
    //I want to keep this example simple
    private char[] players = {'X', 'O', 'Y', 'Z', 'A', 'K', 'E', 'J', 'N', 'H'};

    private int numPlayers;
    private boolean win;


    /**
     *
     * @param model the board implementation
     * @param view the screen that is shown
     * @post the controller will respond to actions on the view using the model.
     */
    public ConnectXController(IGameBoard model, ConnectXView view, int np) {
        this.curGame = model;
        this.screen = view;
        numPlayers = np;
        win = false;

    }

    /**
     *
     *
     * @param col the column of the activated button
     * @post will allow the player to place a token in the column if it is not full, otherwise it will display an error
     * and allow them to pick again. Will check for a win as well. If a player wins it will allow for them to play another
     * game hitting any button
     */
    public void processButtonClick(int col) {
        //If there is a win, start a new game
        if (win) { newGame(); }

        //If the column is free, place the token, place on screen
        if (curGame.checkIfFree(col)) {
            curGame.placeToken(players[player % numPlayers], col);

            int r = (curGame.getNumRows() - 1);
            while (curGame.whatsAtPos(r, col) == ' ') { r--; }
            screen.setMarker(r, col, players[player % numPlayers]);

        } else {
            //If the column is full, send an error message to the screen
            screen.setMessage("Column " + col + " is full. Please choose another.");
            return;
        }

        //If there's a win or a tie, set win to true
        if (curGame.checkForWin(col)) {
            win = true;
            screen.setMessage("Player " + players[((player) % numPlayers)] + " won! Click any button if you would like to play again.");
        } else if (curGame.checkTie()) {
            win = true;
            screen.setMessage("Tie! Click any button if you would like to play again.");
        } else {
            //Display next players turn, increment player
            screen.setMessage("It is " + players[++player % numPlayers] + "'s turn.");
        }

    }

    /**
     * This method will start a new game by returning to the setup screen and controller
     */
    private void newGame()
    {
        //close the current screen
        screen.dispose();
        //start back at the set up menu
        SetupView screen = new SetupView();
        SetupController controller = new SetupController(screen);
        screen.registerObserver(controller);

    }
}
