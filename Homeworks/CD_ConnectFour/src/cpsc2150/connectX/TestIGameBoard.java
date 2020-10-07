package cpsc2150.connectX;

    import org.junit.Test;
    import static org.junit.Assert.*;

public class TestIGameBoard {

    int ROWS = 5, COLS = 5, TO_WIN = 3, MIDDLEC = COLS/2;
    Character X = 'X', O = 'O';

    private IGameBoard makeGB(int rows, int cols, int to_Win) { return new GameBoard(rows, cols, to_Win); }

    private String charToString(char [][] gameboard, int rows, int cols) {

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
                printBoard += gameboard[r][c] + "|";
            }

            //Adds a new line character at the end of the game board row
            printBoard += "\n";
        }

        return printBoard;
    }

    private char [][] allocateGB(int rows, int cols) {

        char [][] gameboard = new char [rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                gameboard[r][c] = ' ';
            }
        }

        return gameboard;
    }

    // 3 Constructor
    @Test
    public void Consturctor_Cols() {

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        int foundCols = game.getNumColumns();
        int expectedCols = COLS;

        assertTrue(foundCols == expectedCols);
    }

    @Test
    public void Constructor_Rows() {


        IGameBoard game = makeGB(ROWS+1, COLS, TO_WIN);

        int foundCols = game.getNumRows();
        int expectedRows = ROWS+1;

        assertTrue(foundCols == expectedRows);
    }

    @Test
    public void Constructor_toWin() {

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        int foundToWin = game.getNumToWin();
        int expectedToWin = TO_WIN;

        assertTrue(foundToWin == expectedToWin);
    }

    // 3 CheckIfFree
    @Test
    public void CheckIfFree_EmptyCol() {

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        boolean foundFree = game.checkIfFree(COLS-1);
        boolean expectedFree = true;

        assertTrue(foundFree == expectedFree);
    }

    @Test
    public void CheckIfFree_FullCol() {

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        int colToCheck = COLS - 1;

        for (int i = 0; i < ROWS; i++) {
            if ((i % 2) == 0) {
                game.placeToken(X, colToCheck);
            } else {game.placeToken(O, colToCheck);}
        }

        boolean foundFree = game.checkIfFree(colToCheck);
        boolean expectedFree = false;

        assertTrue(foundFree == expectedFree);
    }

    @Test
    public void CheckIfFree_AlmostFullCol() {

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        int colToCheck = COLS - 1;

        for (int i = 0; i < ROWS - 1; i++) {
            if ((i % 2) == 0) {
                game.placeToken(X, colToCheck);
            } else {game.placeToken(O, colToCheck);}
        }

        boolean foundFree = game.checkIfFree(colToCheck);
        boolean expectedFree = true;

        assertTrue(foundFree == expectedFree);
    }

    // 5 CheckHorizWin
    @Test
    public void CheckHorizWin_End_T() {

        int i, rowToCheck = 0, colToCheck = TO_WIN - 1;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < TO_WIN; i++) {
            game.placeToken(X, i);
        }

        boolean foundWin = game.checkHorizWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckHorizWin_Middle_F() {

        int i, rowToCheck = 0, colToCheck = MIDDLEC;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < COLS; i++) {
            if (i == colToCheck) {
                game.placeToken(O, i);
            }
            else { game.placeToken(X, i); }
        }

        boolean foundWin = game.checkHorizWin(rowToCheck, colToCheck, X);
        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckHorizWin_RowXO_F() {

        int i, rowToCheck = 0, colToCheck = COLS-1;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < colToCheck-1; i++) {
            game.placeToken(X, i);
        }
        game.placeToken(O, i);

        boolean foundWin = game.checkHorizWin(rowToCheck, colToCheck, O);

        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckHorizWin_Middle_T() {

        int i, rowToCheck = 0, colToCheck = TO_WIN - 2;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < TO_WIN; i++) {
            game.placeToken(X, i);
        }

        boolean foundWin = game.checkHorizWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckHorizWin_FullRow_T() {

        int i, rowToCheck = 0, colToCheck = TO_WIN - 1;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < COLS; i++) {
            game.placeToken(X, i);
        }

        boolean foundWin = game.checkHorizWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    // 5 CheckVertWin
    @Test
    public void CheckVertWin_RowX_CheckX_T() {

        int i, rowToCheck = TO_WIN-1, colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < TO_WIN; i++) {
            game.placeToken(X, colToCheck);
        }

        boolean foundWin = game.checkVertWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckVertWin_RowX_CheckO_F() {

        int i, rowToCheck = TO_WIN-1, colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < TO_WIN; i++) {
            game.placeToken(X, colToCheck);
        }

        boolean foundWin = game.checkVertWin(rowToCheck, colToCheck, O);
        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckVertWin_XXOXX_F() {

        int i, rowToCheck = 0, colToCheck = ROWS - 1;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < ROWS; i++) {
            if (i == colToCheck) {
                game.placeToken(O, rowToCheck);
            }
            else { game.placeToken(X, rowToCheck); }
        }

        boolean foundWin = game.checkVertWin(rowToCheck, colToCheck, X);
        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckVertWin_LineX0_F() {

        int i, rowToCheck = ROWS-1, colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < ROWS-1; i++) {
            game.placeToken(X, colToCheck);
        }
        game.placeToken(O, colToCheck);

        boolean foundWin = game.checkHorizWin(rowToCheck, colToCheck, O);

        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckVertWin_FullCol_T() {

        int i, rowToCheck = ROWS-1, colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        for (i = 0; i < ROWS; i++) {
            game.placeToken(X, colToCheck);
        }

        boolean foundWin = game.checkVertWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    // 8 CheckDiagWin
    @Test
    public void CheckDiagWin_BL_UpRight_End() {

        int rowToCheck = 2, colToCheck = 2;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(X, 0);

        game.placeToken(O, 1);
        game.placeToken(X, 1);

        game.placeToken(O, 2);
        game.placeToken(O, 2);
        game.placeToken(X, 2);

        boolean foundWin = game.checkDiagWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckDiagWin_BR_UpRight_End() {

        int rowToCheck = 2, colToCheck = 2;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(O, 2);
        game.placeToken(O, 2);
        game.placeToken(X, 2);

        game.placeToken(O, 3);
        game.placeToken(X, 3);

        game.placeToken(X, 4);

        boolean foundWin = game.checkDiagWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckDiagWin_BL_UpRight_Middle() {

        int rowToCheck = 1, colToCheck = 1;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(X, 0);

        game.placeToken(O, 1);
        game.placeToken(X, 1);

        game.placeToken(O, 2);
        game.placeToken(O, 2);
        game.placeToken(X, 2);

        boolean foundWin = game.checkDiagWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckDiagWin_BR_UpLeft_Middle() {

        int rowToCheck = 1, colToCheck = 3;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(O, 2);
        game.placeToken(O, 2);
        game.placeToken(X, 2);

        game.placeToken(O, 3);
        game.placeToken(X, 3);

        game.placeToken(X, 4);

        boolean foundWin = game.checkDiagWin(rowToCheck, colToCheck, X);
        boolean expectedWin = true;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckDiagWin_BL_UpRight_Middle_O() {

        int rowToCheck = 1, colToCheck = 1;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(X, 0);

        game.placeToken(O, 1);
        game.placeToken(O, 1);

        game.placeToken(O, 2);
        game.placeToken(O, 2);
        game.placeToken(X, 2);

        boolean foundWin = game.checkDiagWin(rowToCheck, colToCheck, X);
        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);

    }

    @Test
    public void CheckDiagWin_BR_UpLeft_Middle_O() {

        int rowToCheck = 1, colToCheck = 3;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(O, 2);
        game.placeToken(O, 2);
        game.placeToken(X, 2);

        game.placeToken(O, 3);
        game.placeToken(O, 3);

        game.placeToken(X, 4);

        boolean foundWin = game.checkDiagWin(rowToCheck, colToCheck, X);
        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckDiagWin_SpacedOut_TopRightToBottomLeft() {

        int rowToCheck = 2, colToCheck = 2;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(X, 0);

        game.placeToken(O, 2);
        game.placeToken(O, 2);
        game.placeToken(X, 2);

        game.placeToken(O, 4);
        game.placeToken(O, 4);
        game.placeToken(O, 4);
        game.placeToken(O, 4);
        game.placeToken(X, 4);

        boolean foundWin = game.checkDiagWin(rowToCheck, colToCheck, X);
        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckDiagWin_SpacedOut_TopLeftToBottomRight() {

        int rowToCheck = 2, colToCheck = 2;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(O, 0);
        game.placeToken(O, 0);
        game.placeToken(O, 0);
        game.placeToken(O, 0);
        game.placeToken(X, 0);

        game.placeToken(O, 2);
        game.placeToken(O, 2);
        game.placeToken(X, 2);

        game.placeToken(X, 4);

        boolean foundWin = game.checkDiagWin(rowToCheck, colToCheck, X);
        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    // 4 CheckTie
    @Test
    public void CheckTie_Full_WithWin() {

        int colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN+1);

        //First Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck++);

        //Second Column
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck++);

        //Third Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck++);

        //Fourth Column
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck++);

        //Fifth Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);

        boolean foundWin = game.checkTie();
        boolean expectedWin = false;


        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckTie_EmptySpace() {

        int colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN+1);

        //First Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck++);

        //Second Column
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck++);

        //Third Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck++);

        //Fourth Column
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck++);

        //Fifth Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);

        boolean foundWin = game.checkTie();
        boolean expectedWin = false;


        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckTie_Full_NoWin() {

        int colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN+1);

        //First Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck++);

        //Second Column
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck++);

        //Third Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck++);

        //Fourth Column
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck++);

        //Fifth Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);

        boolean foundWin = game.checkTie();
        boolean expectedWin = true;


        assertTrue(foundWin == expectedWin);
    }

    @Test
    public void CheckTie_Empty_WithWin() {

        int colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        //First Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck++);

        //Second Column
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck++);

        //Third Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck++);

        //Fourth Column
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck++);

        //Fifth Column
        game.placeToken(O, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);

        boolean foundWin = game.checkTie();
        boolean expectedWin = false;

        assertTrue(foundWin == expectedWin);
    }

    // 7 WhatsAtPos
    @Test
    public void WhatsAtPos_EmptyBL_Boundary() {

        int rowToCheck = 0, colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        Character foundChar = game.whatsAtPos(rowToCheck, colToCheck);
        Character expectedChar = ' ';

        assertTrue(foundChar.equals(expectedChar));
    }

    @Test
    public void WhatsAtPos_0MiddleCX_CheckX() {

        int rowToCheck = 0, colToCheck = MIDDLEC;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(X, colToCheck);

        Character foundChar = game.whatsAtPos(rowToCheck, colToCheck);
        Character expectedChar = X;

        assertTrue(foundChar.equals(expectedChar));
    }

    @Test
    public void WhatsAtPos_Group() {

        int rowToCheck = 0, colToCheck = MIDDLEC;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(O, colToCheck-1);
        game.placeToken(O, colToCheck-1);

        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);

        game.placeToken(O, colToCheck+1);
        game.placeToken(O, colToCheck+1);

        Character foundChar = game.whatsAtPos(rowToCheck, colToCheck);
        Character expectedChar = O;

        assertTrue(!foundChar.equals(expectedChar));
    }

    @Test
    public void WhatsAtPos_EmptyBR_Boundary() {

        int rowToCheck = 0, colToCheck = COLS-1;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        Character foundChar = game.whatsAtPos(rowToCheck, colToCheck);
        Character expectedChar = ' ';

        assertTrue(foundChar.equals(expectedChar));
    }

    @Test
    public void WhatsAtPos_EmptyTL_Boundary() {

        int rowToCheck = ROWS-1, colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        Character foundChar = game.whatsAtPos(rowToCheck, colToCheck);
        Character expectedChar = ' ';

        assertTrue(foundChar.equals(expectedChar));
    }

    @Test
    public void WhatsAtPos_EmptyTR_Boundary() {

        int rowToCheck = ROWS-1, colToCheck = COLS-1;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        Character foundChar = game.whatsAtPos(rowToCheck, colToCheck);
        Character expectedChar = ' ';

        assertTrue(foundChar.equals(expectedChar));
    }

    @Test
    public void WhatsAtPos_XOXXX_Col() {

        int rowToCheck = 1, colToCheck = 0;

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);

        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);
        game.placeToken(X, colToCheck);

        Character foundChar = game.whatsAtPos(rowToCheck, colToCheck);
        Character expectedChar = O;

        assertTrue(foundChar.equals(expectedChar));
    }

    // 5 PlaceToken
    @Test
    public void PlaceToken_Empty_PlaceX() {

        int rowToCheck = 0, colToCheck = 2;

        char [][] gameboard = allocateGB(ROWS, COLS);

        gameboard[rowToCheck][colToCheck] = X;
        String expectedOutput = charToString(gameboard, ROWS, COLS);

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);
        game.placeToken(X, colToCheck);
        String foundOutput = game.toString();

        assertEquals(expectedOutput, foundOutput);

    }

    @Test
    public void PlaceToken_ColX_PlaceO() {

        int i, colToCheck = 2;

        char [][] gameboard = allocateGB(ROWS, COLS);
        for(i = 0; i < ROWS-1; i++) {
            gameboard[i][colToCheck] = X;
        }
        gameboard[i][colToCheck] = O;
        String expectedOutput = charToString(gameboard, ROWS, COLS);

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);
        for(i = 0; i < ROWS-1; i++) {
            game.placeToken(X, colToCheck);
        }
        game.placeToken(O, colToCheck);
        String foundOutput = game.toString();

        assertEquals(expectedOutput, foundOutput);
    }

    @Test
    public void PlaceToken_X_PlaceO() {

        int rowToCheck = 0, colToCheck = 2;

        char [][] gameboard = allocateGB(ROWS, COLS);
        gameboard[rowToCheck++][colToCheck] = X;
        gameboard[rowToCheck][colToCheck] = O;
        String expectedOutput = charToString(gameboard, ROWS, COLS);

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);
        game.placeToken(X, colToCheck);
        game.placeToken(O, colToCheck);
        String foundOutput = game.toString();

        assertEquals(expectedOutput, foundOutput);
    }

    @Test
    public void PlaceToken_RowX_PlaceO() {

        int rowToCheck = 0, colToCheck = 2;

        char [][] gameboard = allocateGB(ROWS, COLS);
        for (int i = 0; i < COLS; i++) {
            gameboard[rowToCheck][i] = X;
        }
        gameboard[++rowToCheck][colToCheck] = O;
        String expectedOutput = charToString(gameboard, ROWS, COLS);

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);
        for (int i = 0; i < COLS; i++) {
            game.placeToken(X, i);
        }
        game.placeToken(O, colToCheck);
        String foundOutput = game.toString();

        assertEquals(expectedOutput, foundOutput);
    }

    @Test
    public void PlaceToken_PlaceX_OnStack() {

        int i, rowToCheck = 3, colToCheck = 2;

        char [][] gameboard = allocateGB(ROWS, COLS);
        for(i = 0; i < rowToCheck; i++) {
            gameboard[i][colToCheck] = X;
        }
        gameboard[i][colToCheck] = O;
        String expectedOutput = charToString(gameboard, ROWS, COLS);

        IGameBoard game = makeGB(ROWS, COLS, TO_WIN);
        for(i = 0; i < rowToCheck; i++) {
            game.placeToken(X, colToCheck);
        }
        game.placeToken(O, colToCheck);
        String foundOutput = game.toString();

        assertEquals(expectedOutput, foundOutput);
    }


}
