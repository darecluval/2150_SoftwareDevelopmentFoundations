//Clare DuVal
//CPSC 2150 Sec 002
//Homework 3

package cpsc2150.connectX;

//Scanner Import Library
import java.util.Scanner;
import java.util.*;

//MAIN FUNCTION
public class Connect4Game {

    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);

        //Variables
        char player = ' ', playAgain = 'y';
        Character m = 'm', M = 'M', f = 'f', F = 'F', gameM;
        boolean win, play;
        int rows, cols, toWin, players, column = 0;
        IGameBoard game;

        //Set first game to play, then loop again if they want to continue playing
        while (playAgain == 'y') {

            //Takes in the amount of players for the game
            players = 0;
            while ((players < IGameBoard.MIN_PLAYERS) || (IGameBoard.MAX_PLAYERS < players)) {
                System.out.println("How many players?");
                players = input.nextInt();

                //Error if rows is not within the constraints
                if (players < IGameBoard.MIN_PLAYERS) {
                    System.out.println("Must be at least" + IGameBoard.MIN_PLAYERS + " players");
                } else if (IGameBoard.MAX_PLAYERS < players) {
                    System.out.println("Must be " + IGameBoard.MAX_PLAYERS + " or fewer");
                }
            }

            //Create the list and variables needed to create the amount of players requested
            List<Character> characters = new ArrayList<>();
            boolean exists;

            //Add player's tokens to the list
            for (int i = 0; i < players; i++) {
                exists = true;

                //Retiterates while the token exists in the list, handles repetitions
                while (exists) {
                    System.out.println("Enter the character to represent player " + (i + 1));
                    player = input.next().charAt(0);

                    player = Character.toUpperCase(player);

                    //Error if player is already in the list
                    if (characters.contains(player)) {
                        System.out.println("'" + player + "' is already taken.");
                    } else { exists = false; }
                }

                characters.add(player);
            }

            //Takes in the amount of rows on the board from the user.
            rows = 0;
            while ((rows < IGameBoard.MIN_ALL) || (IGameBoard.MAX_SPACES < rows)) {
                System.out.println("How many rows should be on the board?");
                rows = input.nextInt();

                //Error if rows is not within the constraints
                if (rows < IGameBoard.MIN_ALL) {
                    System.out.println("Must be at least " + IGameBoard.MIN_ALL + " rows");
                } else if (IGameBoard.MAX_SPACES < rows) {
                    System.out.println("Must be " + IGameBoard.MAX_SPACES + " rows or fewer");
                }
            }

            //Takes in the amount of cols on the board from the user.
            cols = 0;
            while ((cols < IGameBoard.MIN_ALL) || (IGameBoard.MAX_SPACES < cols)) {
                System.out.println("How many columns should be on the board?");
                cols = input.nextInt();

                //Error if cols is not within the constraints
                if (cols < IGameBoard.MIN_ALL) {
                    System.out.println("Must be at least " + IGameBoard.MIN_ALL + " columns");
                } else if (IGameBoard.MAX_SPACES < cols) {
                    System.out.println("Must be " + IGameBoard.MAX_SPACES + " columns or fewer");
                }
            }

            //Takes in the amount of tokens taken to win a game
            toWin = 0;
            while ((toWin < IGameBoard.MIN_ALL) || (IGameBoard.MAX_TOWIN < toWin)) {
                System.out.println("How many in a row to win?");
                toWin = input.nextInt();

                //Error if cols is not within the constraints
                if (toWin > Math.max(rows, cols)) {
                    System.out.println("You'll never win that way. Please enter a number less than " + Math.max(rows, cols) + ".");
                    toWin = 0;
                } else if (toWin < IGameBoard.MIN_ALL) {
                    System.out.println("Must be at least " + IGameBoard.MIN_ALL + " tokens");
                } else if (IGameBoard.MAX_TOWIN < toWin) {
                    System.out.println("Must be " + IGameBoard.MAX_TOWIN + " tokens or fewer");
                }
            }

            //Asks the user whether they want a fast or memory efficient game
            gameM = 'z';
            while ((!gameM.equals(f)) && (!gameM.equals(F)) && (!gameM.equals(m)) && (!gameM.equals(M))) {
                System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
                gameM = input.next().charAt(0);

                //Error if their input is not an option
                if ((!gameM.equals(f)) && (!gameM.equals(F)) && (!gameM.equals(m)) && (!gameM.equals(M))) {
                    System.out.println("Not a valid option.");
                }
            }

            //Implements a memory efficient game
            if ((gameM.equals(M)) || (gameM.equals(m))) {
                //Constructs a game of GameBoardMem
                game = new GameBoardMem(rows, cols, toWin);

            } else {
                //Implements a fast game
                game = new GameBoard(rows, cols, toWin);

            }

            System.out.print(game.toString());

            //Loops through the current game until there is a win
            win = false;
            while (!win) {

                //Sets the player's tokens per turn
                player = characters.remove(0);

                //Reiterates through the player's turn
                play = true;
                while (play) {
                    System.out.println("Player " + player + ", what column do you want to place your marker in?");
                    column = input.nextInt();

                    //Error if the column input is not an option
                    if ((column < 0) || (game.getNumColumns() <= column)) {
                        System.out.println("Please enter a number between 0 and " + (cols - 1) + ".");

                    } else if(game.checkIfFree(column)) {

                        //Places the game token in the game's board, then ends the turn
                        game.placeToken(player, column);
                        play = false;

                    } else {

                        //Error message if the column is full
                        System.out.println("Column " + column + " is full. Please choose another.");
                    }
                }

                //Prints current game board with the last move
                System.out.print(game.toString());

                //Checks for a win, if there's a win, stop the game
                if (game.checkForWin(column)) {
                    System.out.println("Player " + player + " Won!");
                    win = true;
                    break;

                } else {
                    //If no win, check for a tie, if there's a tie, stop the game
                    if (game.checkTie()) {
                        System.out.println("It's a tie!");
                        win = true;
                        break;
                    }
                }

                //Switch players
                characters.add(player);

            }

            //Once there is a win, ask the user if they would like to play again
            playAgain = 'm';
            while((playAgain != 'y') && (playAgain != 'n')) {

                System.out.println("Would you like to play again? (yes/no)");
                playAgain = input.next().charAt(0);
                if ((playAgain != 'y') && (playAgain != 'n')) {
                    System.out.println("Please choose a valid option.");
                }
            }

            //Exit game if 'no'
            if (playAgain == 'n') {
                System.out.println("Goodbye!");
            }
        }
    }
}
