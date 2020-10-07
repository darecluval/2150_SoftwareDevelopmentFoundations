//Clare DuVal
//CPSC 2150 Sec 002
//Homework 3

package cpsc2150.connectX;
import java.util.*;


/**
 *
 * @invariant ( board contains a map of integers and corresponding list of characters
 *              the integer is set by the user in the main to be between 3 and MAX_SPACES
 *              and the length of the list is between 0 and MAX_SPACES at any given time and
 *              contains valid characters)
 *
 */
public class GameBoardMem implements IGameBoard {

    //Variables and char 2D array
    private int rows, cols, toWin;
    private Map<Integer, List<Character>> board;

    //PRIMARY METHODS
    public int getNumRows() {

        return rows;
    }

    public int getNumColumns(){

        return cols;
    }

    public int getNumToWin(){

        return toWin;
    }

    public char whatsAtPos(int r, int c) {

        //If the desired r coordinate is less than the length of the list,
        // return that list's r-th Character
        if (r+1 <= board.get(c).size()) { return board.get(c).get(r); }

        //If the coordinate is empty, return an empty character
        else { return ' '; }
    }

    /**
     *
     * @param C4rows integer number of rows to make the game board
     * @param C4cols integer number of cols to make the game board
     * @param C4toWin integer number of tokens in a row needed to win the game
     *
     * @return a game board HashMap with cols amount of ArrayLists that contain Characters
     * @pre [ MIN_ALL <= C4rows <= MAX_SPACES
     *        MIN_ALL <= C4cols <= MAX_SPACES
     *        MIN_ALL <= C4toWin <= MAX_TOKENS ]
     * @post [ MIN_ALL <= rows <= MAX_SPACES
     *         MIN_ALL <= cols <= MAX_SPACES
     *         MIN_ALL <= toWin <= MAX_TOKENS
     *         board is a HashMap with cols amount of ArrayLists that contain Characters
     *
     */
    //Constructor
    GameBoardMem(int C4rows, int C4cols, int C4toWin) {

        //Set private variables
        rows = C4rows;
        cols = C4cols;
        toWin = C4toWin;

        //Create a new board HashMap
        board = new HashMap<>();

        //Add Array List of amount of cols to the board
        for (int c = 0; c < cols; c++) {
            board.put(c, new ArrayList<>());
        }
    }

    /**
     *
     * @param p is the character specified by the player placed into the game board
     * @param c is the column-th List the token is placed into
     *
     * @pre
     *      [ checkIfFree(c) returns true and
     *      p is valid and
     *      0 <= c <= (cols-1) ]
     *
     * @post
     *      [ changes the private board's c-th ArrayList by placing the char p
     *      into the lowest last position ]
     */
    //Place Token
    public void placeToken(char p, int c) {

        //Alters private board by inserting char p
        board.get(c).add(p);
    }

    /**
     *
     * @return a string of the current board
     *
     * @post
     *      [printBoard is a valid string and contains the most up-to-date board]
     *
     */
    //To-String
    @Override
    public String toString() {
        String printBoard = "";

        //Print the column numbers for the user to view the columns
        for (int firstRow = 0; firstRow < cols; firstRow++) {
            printBoard += "|";

            //Adds a space if the columns exceeds 10 and the current col being printed is less than 10
            if ((firstRow < 10) && (cols > 10)) {
                printBoard += " ";
            }
            printBoard +=  firstRow;
        }
        printBoard += "|\n";

        for (int r = (rows - 1); r >= 0; r--) {
            printBoard += "|";
            for (int c = 0; c < cols; c++) {

                //Adds a space if the amount of columns exceeds 10
                if (cols > 10) {
                    printBoard += " ";
                }

                //The two nested loops loop through the board adding each coordinate to the sting
                printBoard += whatsAtPos(r, c) + "|";
            }

            //Adds a new line character at the end of the game board row
            printBoard += "\n";
        }

        return printBoard;
    }

}
