package openu.java.unit2.exercises;

/*
 * this class is related to question number 1 in section 2.4 in the website.
 * writen by Edith Kamkhaji
 * req was to write a class that gets two int one for height and one for width from a user
 * and will calculate the perimeter and the area of a rectangle
 */

import java.util.Scanner;

public class Rectangle {

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        int height, width, perimeter, area;
        System.out.println("Insert the number for height: ");
        height = scan.nextInt();
        System.out.println("Insert the number for width: ");
        width = scan.nextInt();

        perimeter = 2*height + 2*width;
        area = width*height;

        System.out.println("This is the perimeter value: " + perimeter);
        System.out.println("This is the area value: " + area);
        // not related to task

        System.out.println("this is modulo: " + height%width);
        System.out.println("this is diviser: " + height/width);

    }

}