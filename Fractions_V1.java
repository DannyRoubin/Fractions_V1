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

    public static void main(String[] args)
    {
        int reRun = 2;
        do {
            runner();
            reRun = reRun();
        }while (reRun != 0);
    }

    // Method that runs the program
    static void runner(){
        Scanner fileData1 = null;
        Scanner keyboard = new Scanner(System.in);
        Object initialArray[];


        // records file name and sets default length to 0 characters
        System.out.println("Please enter the name of the file which you would like to use");
        String fileName = keyboard.nextLine();
        int fileLength = 0;

        // try-catch to find file
        try{
            fileData1 =
            new Scanner(new FileInputStream(fileName));
            System.out.println("File found");
        }
        catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();
        }



        // provides char length of file to allow me to finish initializing the first array
        // side note, this section counts a whole fraction as a single char
        while (fileData1.hasNext()) {
            // temp holder is needed to scroll through the file and get an accurate count
            String tempHolder = fileData1.next();
            fileLength++;
            System.out.println(fileLength);
        }
        
        initialArray = new Object[fileLength];

    }

    // method which provides the user with an option to run the program again
    static int reRun(){
        Scanner keyboard = new Scanner(System.in); 
        System.out.println("Would you like to enter another file to be read? 0 for no, 1 for yes ");
        int confirm = keyboard.nextInt();
        return confirm;
    }


}

