/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.Scanner;


/**
 *
 * @author win7
**/
    
    

public class TicTacToe {

    // A 3x3 array to represent the board
    private static char[][] board = new char[3][3];

    // A boolean to keep track of the current player
    private static boolean xTurn = true;

    // A scanner to get the user input
    private static Scanner scanner = new Scanner(System.in);

    // A method to initialize the board with empty spaces
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // A method to print the board on the console
    private static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }

    // A method to get the row and column from the user input
    private static int[] getMove() {
        int[] move = new int[2];
        System.out.print("Enter the row and column (1-3) separated by a space: ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        try {
            move[0] = Integer.parseInt(tokens[0]) - 1;
            move[1] = Integer.parseInt(tokens[1]) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            return getMove();
        }
        return move;
    }

    // A method to check if the move is valid
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    // A method to make the move on the board
    private static void makeMove(int row, int col) {
        board[row][col] = xTurn ? 'X' : 'O';
        xTurn = !xTurn;
    }

    // A method to check if the game is over
    private static boolean isGameOver() {
        return isWin() || isDraw();
    }

    // A method to check if there is a win
    private static boolean isWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        // No win
        return false;
    }

    // A method to check if there is a draw
    private static boolean isDraw() {
        // Check if the board is full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        // No empty spaces
        return true;
    }

    // A method to display the result of the game
    private static void showResult() {
        if (isWin()) {
            System.out.println("The winner is " + (xTurn ? 'O' : 'X') + "!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    // The main method to run the game
    public static void main(String[] args) {
        // Initialize the board
        initializeBoard();

        // Start the game loop
        while (!isGameOver()) {
            // Print the board
            printBoard();

            // Get the move from the current player
            int[] move = getMove();

            // Check if the move is valid
            if (isValidMove(move[0], move[1])) {
                // Make the move on the board
                makeMove(move[0], move[1]);
            } else {
                // Invalid move
                System.out.println("Invalid move. Please try again.");
            }
        }

        // Print the final board
        printBoard();

        // Show the result of the game
        showResult();
    }
}
    

