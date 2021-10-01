/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Fractions V1
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Fractions_V1
{

    //shell that will run the methods
    public static void main(String[] args)
    {
        int reRun = 2;
        do {
            runner();
            reRun = reRun();
        }while (reRun != 0);
    }

    static void runner(){
        Scanner fileData = null;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the name of the file which you would like to use");
        String filename = keyboard.nextLine();

        try{
            fileData =
            new Scanner(new FileInputStream(filename));
            System.out.println("File found");
        }
        catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();

        }
    }

    static int reRun(){
        Scanner keyboard = new Scanner(System.in); 
        System.out.println("Would you like to enter another file to be read? 0 for no, 1 for yes ");
        int confirm = keyboard.nextInt();
        return confirm;
    }


}

