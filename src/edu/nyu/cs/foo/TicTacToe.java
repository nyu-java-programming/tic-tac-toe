package edu.nyu.cs.foo;

import java.util.Scanner;

/**
 * A simple bame of Tic Tac Toe.
 * 
 * @author Foo Barstein
 * @version 0.2
 */
public class TicTacToe {

  // a constant that represents an empty spot on the board.
  public static final String EMPTY = "-";

  /**
   * Return a new blank tic-tac-toe board.
   * @return The board as a two-dimensional array
   */
  public static String[][] getBlankBoard() {
    // create a board with empty "-" marks in all positions
    String[][] board = {
      {EMPTY, EMPTY, EMPTY},
      {EMPTY, EMPTY, EMPTY},
      {EMPTY, EMPTY, EMPTY}
    };
    
    return board;
  }

  public static int[] getUsersMove(String player) {
      System.out.println("Player " + player + ", where would you like to go?");
      Scanner scn = new Scanner(System.in);
      String response = scn.nextLine(); // get the user's response as a string
      String[] vals = response.split(","); // split the user's response by comma

      // get the user's desired position as integers starting from zero
      int row = Integer.parseInt(vals[0]) - 1; // get the row
      int col = Integer.parseInt(vals[1]) - 1; // get the column

      int[] usersMove = { row, col };
      return usersMove;

  }


  /**
   * Place the player's symbol on the board.
   * @param player The player, either "X" or "O"
   * @param board The two-dimensional array representing the board
   * @param row The row index to place the symbol at
   * @param col The column index to place the symbol at
   * @return The updated board.
   */
  public static String[][] makeMove(String player, String[][] board, int row, int col) {
    board[row][col] = player;
    return board;
  }

  /**
   * Print out the board so the user can see it!
   * @param board The two-dimensional array representing the game board
   */
  public static void printBoard(String[][] board) {
    System.out.println(); // a blank line
    // loop through teh rows
      for (String[] r : board) {
        // loop through the columns
        for (String c : r) {
          System.out.print(c + " ");
        }
        System.out.println();
      }
    System.out.println(); // a blank line
  }

  /**
   * Check whether the desired spot on the board is empty and within bounds
   * @param board The board, as a two-dimensional array
   * @param row The row where the user wants to move.
   * @param col The column where the user wants to move.
   * @return True if the spot is empty and within bounds, false otherwise
   */
  public static boolean isValidMove(String[][] board, int row, int col) {
    boolean isWithinBounds = (row >= 0 && row <= 2 && col >=0 && col <=2);
    if (isWithinBounds) {
      // the move is within bounds of the board
      boolean isEmpty = board[row][col].equals(EMPTY); // whether the spot is empty
      return isEmpty;
    }
    else {
      // the move is out of bounds of the board
      return false;
    }
  }

  /**
   * Checks whether the board is already full.
   * @param board The board, represented as a two-dimemsional array.
   * @return True if the board is full, false otherwise;
   */
  public static boolean isBoardFull(String[][] board) {
    // finish this method yourself!
    return false; // replace with correct logic
  }

  /**
   * Check for a win.
   * @param board The board, represented as a two-dimensional array
   * @param player The current player to check for a win.
   * @return True if the player has won, false if they have not.
   */
  public static boolean isWin(String[][] board, String player) {
    // finish this method yourself!
    return false; // replace with correct logic
  }

  /**
   * This is the man method of the program that is automaticallyc called by the interpreter.
   * @param args An array of command-line arguments, if any
   */
  public static void main(String[] args) {

    // the starting values of the game board
    String[][] board = getBlankBoard();

    // print out some helpful instructinos so the player knows how to respond
    System.out.println("\nWelcome to Tic Tac Toe!!!");
    System.out.println("Enter all positions as [row],[column]");

    boolean gameOver = false;
    String player = "X"; // start with player "X"

    // print the initial state of the board
    printBoard(board);

    // while loop until the game is over
    while (!gameOver) {


      int[] usersMove = getUsersMove(player);
      int row = usersMove[0];
      int col = usersMove[1];

      // make the move if the move is valid
      if (isValidMove(board, row, col)) {
        // it's a valid move... make it
        board = makeMove(player, board, row, col);
      }
      else {
        // it's an invalid move... do not switch players and simply ask again
        System.out.println("Invalid move! Enter all positions as [row],[column]");
        continue; // skip to the next iteration of the loop
      }

      // print the current state of the board
      printBoard(board);

      // check for a win
      if (isWin(board, player)) {
        // the current player won!
        gameOver = true; // stop the loop
        System.out.println(player + " wins!!!");
      }
      // check whether the board is full and stop the game if so
      else if (isBoardFull(board)) {
        // the board is full!
        gameOver = true; // stop the loop
        System.out.println("Tie game!!!");
      }
      else {
        // the game is not over... so swap players
        player = (player.equals("X")) ? "O" : "X";
      }

    } // while


  } // main method

}