//Clare DuVal
//CPSC 2150 Sec 002
//Homework 3

package cpsc2150.connectX;

/**
 *
 * The board that holds the Connect X game
 * The Character Tokens are alternating player's tokens that fill the bottom most open space of a column.
 * The game ends when someone ends with the desired amount of tokens or there is a tie.
 *
 * Initialization ensures the board game begins with rows = getNumRows
 * and cols = getNumCols set by the user and that they need getNumToWin
 * tokens in order to win the game.
 *
 * The game board is bounded by MIN_ALL, MAX_SPACES, MAX_TOKENS, MIN_PLAYERS, and MAX_PLAYERS.
 *
 * The variables rows, cols, and toWin are all Z integers.
 *
 * Constraints: MIN_ALL <= rows <= MAX_SPACES
 *              MIN_ALL <= cols <= MAX_SPACES
 *              MIN_ALL <= toWin <= MAX_TOKENS
 *
 */
public interface IGameBoard {
    int MAX_SPACES = 20;
    int MAX_TOWIN = 20;
    int MIN_ALL = 3;
    int MIN_PLAYERS = 2;
    int MAX_PLAYERS = 10;

    /**
     *
     * @return the int number of rows set by the user
     *
     * @pre [ rows != null ]
     * @post [ MIN_ALL <= rows <= MAX_SPACES ]
     *
     */
    int getNumRows();

    /**
     *
     * @return the int number of columns set by the user
     *
     * @pre [ cols != null ]
     * @post [ MIN_ALL <= cols <= MAX_SPACES ]
     *
     */
    int getNumColumns();

    /**
     *
     * @return the int number of tokens taken to win set by the user
     *
     * @pre [ toWin != null ]
     * @post [ (MIN_ALL <= toWin <= MAX_TOWIN) && (toWin <= Math.max(rows, cols)) ]
     *
     */
    int getNumToWin();

    /**
     *
     * @param r is an integer that represents a row in the board
     * @param c is an integer that represents a column in the board
     * @return a character either X, O, or ' ' in the position of the board at [r][c]
     *
     * @pre
     *      [ 0 <= r <= (rows-1) and
     *        0 <= c <= (cols-1) ]
     *
     * @post
     *      [ char == 'X' || char == 'O' || char == ' ' ]
     *
     */
    //What's At Position
    char whatsAtPos(int r, int c);

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
    void placeToken(char p, int c);

    //SECONDARY METHODS

    /**
     *
     * @param c column number to check if it's available
     * @return true or false if the column has an available space or not
     *
     * @pre
     *      [ 0 <= c <= (cols-1) ]
     *
     * @post
     *      [ checkIfFree returns true if the column c is has at least 1 available space
     *      and false if the column c is full ]
     *
     */
    //Check If Free
    default boolean checkIfFree(int c) {

        //If there is one empty character in column c, return true
        if (whatsAtPos((getNumRows() - 1), c) == ' ') {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param c is an integer column to check for a win given the last move
     * @return true or false to show if there is a win on the board or not
     *
     * @pre
     *      [ 0 <= c <= (cols-1) ]
     *
     * @post
     *      [ checkForWin returns false if there is not a win on
     *      the board and true if there is a win on the board ]
     *
     */
    //Check For Win
    default boolean checkForWin(int c) {
        boolean win;

        //Find the last player's token in the last move made
        int r = (getNumRows() - 1);
        while (whatsAtPos(r, c) == ' ') {
            r--;
        }
        char p = whatsAtPos(r, c);

        //Check for diagonal win first
        win = checkDiagWin(r, c, p);

        //Check for horizontal if no diagonal win
        if (!win) {
            win = checkHorizWin(r, c, p);

            //Check for vertical win if no horizontal or diagonal win
            if (!win) {
                win = checkVertWin(r, c, p);
            }
        }

        return win;
    }

    /**
     *
     * @param r is an integer that represents a row in the board
     * @param c is an integer that represents a column in the board
     * @param p is a character that represent's one player's tokens in the board
     * @return true or false whether or not there are at least 4 tokens of the same p in a row r
     *
     * @pre
     *      [ 0 <= r <= (rows-1) and
     *        p is a valid char pre-chosen a user and
     *        0 <= c <= (cols-1) ]
     *
     * @post
     *      [ return true if there are integer getNumToWin of the char p in row r,
     *        otherwise return false ]
     *
     */
    //Check Horizontal Win
    default boolean checkHorizWin(int r, int c, char p) {
        int HorizWin = 0, colCheck = 0;
        boolean win = false;

        //Checks the row r for toWin amount of char p in a row
        while (colCheck < getNumColumns()) {

            //Increments HorizWin until a char other than p is found
            while (whatsAtPos(r, colCheck) == p) {
                HorizWin++;
                colCheck++;

                //Breaks true when HorizWin is more than toWin amount
                if (HorizWin >= getNumToWin()) {
                    win = true;
                    break;
                }

                //Breaks when out of bounds
                if (colCheck == getNumColumns()) { break; }
            }

            //Resets if there are less than toWin amount in a row
            if (HorizWin < getNumToWin()) {
                HorizWin = 0;
            }

            colCheck++;
        }

        return win;
    }

    /**
     *
     * @param r is an integer that represents a row in the board
     * @param c is an integer that represents a column in the board
     * @param p is a character that represent's one player's tokens in the board
     * @return true or false whether or not there are at least 4 tokens of the same p in a column c
     *
     * @pre
     *      [ 0 <= r <= (rows-1) and
     *        p is a valid char pre-chosen a user and
     *        0 <= c <= (cols-1) ]
     *
     * @post
     *      [ return true is there are getNumToWin of the char p in column c,
     *        otherwise return false ]
     *
     */
    //Check Vertical Win
    default boolean checkVertWin(int r, int c, char p) {
        int VertWin = 0;
        boolean win = false;

        //Checks the column c for toWin amount of char p in a row
        while (r >= 0) {

            //Increments VertWin until a char other than p is found
            while (whatsAtPos(r, c)== p) {
                VertWin++;
                r--;

                //Breaks true when VertWin is more than toWin amount
                if (VertWin == getNumToWin()) {
                    win = true;
                    break;
                }

                //Breaks when out of bounds
                if (r < 0) { break; }
            }

            //Resets if there are less than toWin amount in a row
            if (VertWin < getNumToWin()) {
                VertWin = 0;
            }

            r--;
        }

        return win;
    }

    /**
     *
     * @param r is an integer that represents a row in the board
     * @param c is an integer that represents a column in the board
     * @param p is a character that represent's one player's tokens in the board
     * @return true or false whether or not there are at least toWin amount tokens of the same p in a diagonal
     *
     * @pre
     *      [ 0 <= r <= (rows-1) and
     *        p is a valid char pre-chosen a user and
     *        0 <= c <= (cols-1) ]
     *
     * @post
     *      [ return true if there is a diagonal win of getNumToWin on the board with char p,
     *        otherwise return false ]
     *
     */
    //Check Diagonal Win
    default boolean checkDiagWin(int r, int c, char p) {
        int checkr, checkc, diagWin = 0;
        boolean win = false;

        //Starting matrix check variables
        checkc = (1 - getNumToWin());
        checkr = (1 - getNumToWin());

        //Check for diagonal win from lower left to upper right
        while (checkr <= (getNumToWin() - 1)) {

            //Checks within board boundaries
            if (((0 <= (r + checkr)) && ((r + checkr) < getNumRows())) && ((0 <= (c + checkc)) && ((c + checkc) < getNumColumns()))) {

                //Continue in a diagonal "/" line while char p is in the line
                while (whatsAtPos(r + checkr, c + checkc) == p) {
                    diagWin++;
                    checkr++;
                    checkc++;

                    //Break once there are getNumToWin in a row
                    if (diagWin >= getNumToWin()) {
                        win = true;
                        break;
                    }

                    //Break if next check is outside the boundaries
                    if (!((0 <= (r + checkr)) && ((r + checkr) < getNumRows())) || !((0 <= (c + checkc)) && ((c + checkc) < getNumColumns()))) {
                        break;
                    }
                }
            }

            //Reset if there's a break
            diagWin = 0;

            checkr++;
            checkc++;
        }

        //Reset matrix check variables
        diagWin = 0;
        checkc = (getNumToWin() - 1);
        checkr = (1 - getNumToWin());

        //Check for diagonal win from upper left to lower right
        while (checkr <= (getNumToWin() - 1)) {

            //Checks within board boundaries
            if (((0 <= (r + checkr)) && ((r + checkr) < getNumRows())) && ((0 <= (c + checkc)) && ((c + checkc) < getNumColumns()))) {

                //Continue in a diagonal "/" line while char p is in the line
                while (whatsAtPos(r + checkr, c + checkc) == p) {
                    diagWin++;
                    checkr++;
                    checkc--;

                    //Break once there are getNumToWin in a row
                    if (diagWin >= getNumToWin()) {
                        win = true;
                        break;
                    }

                    //Break if next check is outside the boundaries
                    if (!((0 <= (r + checkr)) && ((r + checkr) < getNumRows())) || !((0 <= (c + checkc)) && ((c + checkc) < getNumColumns()))) {
                        break;
                    }
                }
            }

            //Reset if there's a break
            diagWin = 0;

            checkr++;
            checkc--;
        }

        return win;
    }

    /**
     *
     * @return true or false if there is a tie or not
     *
     *
     * @pre [ checkForWin returns false ]
     * @post
     *      [ checkTie returns true if the board is full and there are no wins
     *      returns false if there is an open space on the board or checkForWin returns true ]
     *
     */
    default boolean checkTie() {
        int c;
        boolean tie = true;
        for (c = 0; c < getNumColumns(); c++) {

            //If there is one empty space in the board (at the top of a col), there is no tie
            if (whatsAtPos((getNumRows()-1), c) == ' ') {
                tie = false;
                break;
            }
        }
        return tie;
    }

}
