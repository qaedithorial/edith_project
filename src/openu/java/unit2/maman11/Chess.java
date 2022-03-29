package openu.java.unit2.maman11;
import java.util.Scanner;

/*
class name: Chess
this class is related to Maman11 question #2
in this question we are required to:
1. read from a given input the 2 chessman (bishop, rook, knight) and their location in the chessboard
2, check if any of the chessman is a threat to the other
2. outputs:
    1. if inserted chessman are the same: Chessmen should be different from each other - done
    2. if chessman position is illegal: Position is not legal
    3. if chessmen positions are the same: Chessmen positions should not be identical -done
    4. if there is a threat: rook threats knight
    5. if there is no threat: no threat
testing methode - TDD (class name: KnightTest)
@author: Edith Kamkhaji
@version: v0.0.1
 */

public class Chess {
    public static void main (String [] args) {
        //Declaration of variables and constants
        final int MIN_NUM = 1;
        final int MAX_NUM = 8;
        final int BIG_STEP = 2;
        final int SMALL_STEP = 1;
        final char KNIGHT = 'K';
        final char ROOK = 'r';
        final char BISHOP = 'b';


        boolean threat = false; //flag

        //given code part from question 2
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the type" +
                " of the first chessman");
        char first = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row1 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col1 = scan.nextInt();
        System.out.println("Please enter the type" +
                " of the second chessman");
        char second = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row2 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col2 = scan.nextInt();
        // end of given code part

        //verifications:
        // verity that  inserted chessman are not the same
        if (first == second) {
            System.out.println("Chessmen should be different from each other");
        } else {// verify that chessman position is illegal >> Position is not legal
            if (row1 < MIN_NUM || col1 < MIN_NUM || row1 > MAX_NUM || col1 > MAX_NUM) {
                System.out.println("Position is not legal");
            } else {
                if (row2 < MIN_NUM || col2 < MIN_NUM || row2 > MAX_NUM || col2 > MAX_NUM) {
                    System.out.println("Position is not legal");
                } else {
                    // verify that chessmen positions aren't the same
                    if (row1 == row2 && col1 == col2) {
                        System.out.println("Chessmen positions should not be identical");
                    } else {
                        switch (first) { //check if first chessman threats the second one
                            case KNIGHT: //took data from first question and adjust it to this one
                                if (row1 + BIG_STEP == row2 && !threat) {
                                    if (col1 + SMALL_STEP == col2) {
                                        System.out.println("knight threats " + (second == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                    if (col1 - SMALL_STEP == col2) {
                                        System.out.println("knight threats " + (second == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                } //End of if statement
                                if (row1 - BIG_STEP == row2 && !threat) {
                                    if (col1 + SMALL_STEP == col2) {
                                        System.out.println("knight threats " + (second == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                    if (col1 - SMALL_STEP == col2) {
                                        System.out.println("knight threats " + (second == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                } //end of if statement
                                if (row1 - SMALL_STEP == row2 && !threat) {
                                    if (col1 + BIG_STEP == col2) {
                                        System.out.println("knight threats " + (second == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                    if (col1 - SMALL_STEP == col2) {
                                        System.out.println("knight threats " + (second == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                } //end of if statement
                                if (row1 + SMALL_STEP == row2 && !threat) {
                                    if (col1 + BIG_STEP == col2) {
                                        System.out.println("knight threats " + (second == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                }
                                    if (col1 - SMALL_STEP == col2) {
                                        System.out.println("knight threats " + (second == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                }
                                break;
                            case ROOK: //covers full row or full column
                                if((row1 == row2) || (col1==col2) && !threat){
                                    System.out.println("rook threats " + (second == KNIGHT ? "knight" : "bishop"));
                                    threat = true;
                                }
                                break;

                            case BISHOP: // Going diagonally
                                if (Math.abs(col2-col1) == Math.abs(row2-row1) && !threat){
                                    System.out.println("bishop threats " + (second == KNIGHT ? "knight" : "rook"));
                                    threat = true;
                                }
                                break;
                            } // end of switch(first)
                        switch (second) { //check if second chessman threats the first one
                            case KNIGHT: //took data from first question and adjust it to this one
                                if (row2 + BIG_STEP == row1 && !threat) {
                                    if (col2 + SMALL_STEP == col1) {
                                        System.out.println("knight threats " + (first == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                    if (col2 - SMALL_STEP == col1) {
                                        System.out.println("knight threats " + (first == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                } //End of if statement
                                if (row2 - BIG_STEP == row1 && !threat) {
                                    if (col2 + SMALL_STEP == col1) {
                                        System.out.println("knight threats " + (first == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                    if (col2 - SMALL_STEP == col1) {
                                        System.out.println("knight threats " + (first == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                } //end of if statement
                                if (row2 - SMALL_STEP == row1 && !threat) {
                                    if (col2 + BIG_STEP == col1) {
                                        System.out.println("knight threats " + (first == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                    if (col2 - SMALL_STEP == col1) {
                                        System.out.println("knight threats " + (first == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                } //end of if statement
                                if (row2 + SMALL_STEP == row1 && !threat) {
                                    if (col2 + BIG_STEP == col1) {
                                        System.out.println("knight threats " + (first == BISHOP ? "bishop" : "rook"));
                                        threat = true;
                                    }
                                }
                                if (col2 - SMALL_STEP == col1) {
                                    System.out.println("knight threats " + (first == BISHOP ? "bishop" : "rook"));
                                    threat = true;
                                }
                                break;
                            case ROOK:
                                if ((row1 == row2) || (col1 == col2) && !threat) {
                                    System.out.println("rook threats " + (first == KNIGHT ? "knight" : "bishop"));
                                    threat = true;
                                }
                                break;

                            case BISHOP:
                                if (Math.abs(col2 - col1) == Math.abs(row2 - row1) && !threat) {
                                    System.out.println("bishop threats " + (first == KNIGHT ? "knight" : "rook"));
                                    threat = true;
                                }
                                break;
                        }//end of switch(second)
                    if (!threat){
                        System.out.println("no threat");
                    }//end of if threat
                    } // end of else statement
                } // end of else statement
                } // end of else statement
            } // end of else statement
        } //end on main
    } //end of class chess
