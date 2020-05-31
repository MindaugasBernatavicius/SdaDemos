package cf.mindaugas.sdademos._01_codingfundamentals.v2_exercises._03_oop;

import java.util.Scanner;

public class OOP {
    public static void main(String[] args) {
        TicTacToe.play();
    }
}

/**
 * Personal Trainer.
 * Create class Trainee, it should contain fields like: name, stamina, strength.
 * You’ll simulate both sides – Trainer and Trainee. Within a while loop you will tell an exercise to be done.
 * ... Every exercise should add/reduce stamina/strength.
 * Take into account that stamina should not be reduced below 0.
 * Consider adding some supplements that will recover the stamina. Supplement should be additional class.
 */

/**
 * Grocery Shopping
 * Create class Product, it should contain at least two fields – name and price.
 * Create an empty array of Products – it’s size should be at least 5.
 * Fill it within while loop. Simulate the process of doing shopping:
 * ask for a product,
 * add it to the cart (array),
 * change index,
 * if index will be greater than 5 – finish shopping,
 * pay for the products.
 */

/**
 * Petrol Station
 * Simulate the process of refueling. Within the while loop ask user if you should continue or finish.
 * ... For every entered “continue” command you should add a specific amount of petrol and money (both of type double) and view it on the console.
 * At the end user should pay for petrol. Consider multiple possibilities, like:
 * The user paid exactly as much as required.
 * The user paid too much (cashier should return the rest of the money).
 * The user paid too little – should be asked for the rest.
 */


/**
 * Tic Tac Toe. Remember – keep it simple. You may use two-dimensional array to store the results and empty fields.
 * Prepare a method to view present state of the “board”.
 */
class TicTacToe {

    private static String winner = "";
    private static Scanner sc = new Scanner(System.in);

    private static String[][] board = new String[][]{
        {" _ ", " _ ", " _ "},
        {" _ ", " _ ", " _ "},
        {" _ ", " _ ", " _ "},
    };

    private static void printBoard(){
        for (String[] row : board) {
            for (String cell : row)
                System.out.print(cell);
            System.out.println();
        }
    }

    private static void usersMove(){
        String usersMove = sc.nextLine();
        int firstCoordinate = Integer
                .parseInt(usersMove.substring(0, 1));
        int secondCoordinate = Integer
                .parseInt(usersMove.substring(1, 2));
        board[firstCoordinate][secondCoordinate] = " o ";
    }

    private static void computersMove(){
        boolean computerMoved = false;
        for (int row = 0; row < board.length; row++) {
            if(computerMoved) break;
            for (int coll = 0; coll < board[row].length; coll++) {
                if(!board[row][coll].equalsIgnoreCase(" o ")
                && !board[row][coll].equalsIgnoreCase(" x "))
                {
                    board[row][coll] = " x ";
                    computerMoved = true;
                    break;
                }
            }
        }
    }

    private static void checkWinner(){
        // check rows
        for (int row = 0; row < board.length; row++) {
            if(board[row][0].equals(" o ")
            && board[row][1].equals(" o ")
            && board[row][2].equals(" o "))
                winner = "You";

            if(board[row][0].equals(" x ")
            && board[row][1].equals(" x ")
            && board[row][2].equals(" x "))
                winner = "Computer";
        }
        // check columns

        // check diagonals

    }

    static void play(){
        System.out.println("You play with o's, computer plays with x's!");
        do {
            printBoard();
            System.out.print("Your move: ");
            usersMove();
            checkWinner();
            if(!winner.equalsIgnoreCase("")){
                System.out.println(winner + " won! Exiting...");
                printBoard();
                break;
            }
            computersMove();
            checkWinner();
            if(!winner.equalsIgnoreCase("")){
                System.out.println(winner + " won! Exiting...");
                printBoard();
                break;
            }
        } while(winner.equalsIgnoreCase(""));
    }
}
