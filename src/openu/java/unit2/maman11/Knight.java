package openu.java.unit2.maman11;
import java.util.Scanner;

/*
class name: Knight
this class is related to Maman11 question #1
in this question we are required to:
1. read from a given input the location of the Knight on the chess board (2 integers)
2. output - print all locations over the board to which the knight can move
testing methode - TDD (class name: KnightTest)
@author: Edith Kamkhaji
@version: v0.0.1
 */


public class Knight {
    public static void main (String [] args){
        //Declaration of variables and constants
        final int MIN_NUM = 1;
        final int MAX_NUM = 8;
        final int BIG_STEP = 2;
        final int SMALL_STEP = 1;

        Scanner scan = new Scanner (System.in);
        System.out.println ("This program reads two integers which " +
                "represent the knight's location on the chess board: "); //presnet to the user what the method does
        System.out.println ("Please enter the number of row");
        int row = scan.nextInt(); // get row input from the user
        System.out.println ("Please enter the number of column");
        int col = scan.nextInt(); // get col input from user

        // first check: if input parameters are valid
        if (Math.min(row, MIN_NUM) >=MIN_NUM && Math.max(row, MAX_NUM)<=MAX_NUM &&
                Math.min(col, MIN_NUM) >=MIN_NUM && Math.max(col, MAX_NUM)<=MAX_NUM){
        //if (row >= MIN_NUM && row <=MAX_NUM && col >= MIN_NUM && col <= MAX_NUM)
            if(row + BIG_STEP <= MAX_NUM){
                if (col + SMALL_STEP <=MAX_NUM){
                    System.out.println("");
                }
            }



            // check the option of using flags
            // Check if movement is not out of range
                // if movement is not out of range print all options
            // if movement is out of range print possible options
            System.out.println(row + " " + col);
        } //end of if statement
        else {
            System.out.println("input is illegal");
        } //end of else
    } // end of method main
} //end of class Knight

