package openu.java.unit2.exercises;
import java.util.Scanner;

public class Mamah19 {
    public static void main(String[] arg) {
        char grade;
        int score = 69;
        if (score >= 90) {
            grade = 'A';
            System.out.println("this is 1st print");
        }
        if (score >= 80) {
            grade = 'B';
            System.out.println("this is 2nd print");
        }
        if (score >= 70) {
            grade = 'C';
            System.out.println("this is 3rd print");
        }
        if (score >= 60) {
            grade = 'D';
            System.out.println("this is 4th print");
        } else {
            grade = 'F';
            System.out.println("this is else statement print");
        }
    }
}
