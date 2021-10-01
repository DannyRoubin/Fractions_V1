/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Fractions V1
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Fractions_V1
{

    //shell that will run the methods
    public static void main(String[] args)
    {
        int reRun;
        do {
            runner();
            reRun = reRun();
        }while (reRun != 1);
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

}