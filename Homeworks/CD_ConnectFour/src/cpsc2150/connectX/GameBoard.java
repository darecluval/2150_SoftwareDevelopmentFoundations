//Clare DuVal
//CPSC 2150 Sec 002
//Homework 3

package cpsc2150.connectX;

/**
 *
 * @invariant ( board contains valid chars contained in the vector set by the user in the main and
 *              only board[0 through (rows-1)][0 through (cols-1)] can be accessed )
 *
 */
public class GameBoard implements IGameBoard {

    //Variables and char 2D array
    private int rows, cols, toWin;
    private char [][] board;

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
        return board[r][c];
    }

    /**
     *
     * @param C4rows integer number of rows to make the game board
     * @param C4cols integer number of cols to make the game board
     * @param C4toWin integer number of tokens in a row needed to win the game
     *
     * @return a game board char [][] of size rows x cols
     * @pre [ MIN_ALL <= C4rows <= MAX_SPACES
     *        MIN_ALL <= C4cols <= MAX_SPACES
     *        MIN_ALL <= C4toWin <= MAX_TOKENS ]
     * @post [ MIN_ALL <= rows <= MAX_SPACES
     *         MIN_ALL <= cols <= MAX_SPACES
     *         MIN_ALL <= toWin <= MAX_TOKENS
     *         board is a 2D char array of desired dimensions [rows][cols]]
     *
     */
    //Constructor
    GameBoard(int C4rows, int C4cols, int C4toWin) {

        //Set private variables
        rows = C4rows;
        cols = C4cols;
        toWin = C4toWin;

        //Allocate an empty board
        board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                board[i][j] = ' ';
            }
        }

    }

    /**
     *
     * @param p is the character chosen by the player placed into the game board
     * @param c is the column integer the token is placed into
     *
     * @pre
     *      [ checkIfFree(c) returns true and
     *      0 <= c <= (cols-1) ]
     *
     * @post
     *      [ changes the private int[][] board by placing the char p
     *      into the lowest row in column c ]
     */
    //Place Token
    public void placeToken(char p, int c) {
        int r = 0;

        //Place token into the lowest most row
        while (this.whatsAtPos(r, c) != ' ') {
            r++;
        }

        //Alters private board by inserting char p
        board[r][c] = p;
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
