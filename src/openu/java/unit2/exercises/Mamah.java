package openu.java.unit2.exercises;
import java.util.Scanner;

public class Mamah {
    public static void main (String [] args){
        boolean b1 = false, b2 = true, b3 = true;

        System.out.print((b1 && b2 && b3) + " ");
        System.out.print((b3 || !(b3 && b2)) + " ");
        System.out.print((!b1 && b2 || b3));
    } //close main
}// close public class
