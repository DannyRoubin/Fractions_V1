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
        String initialArray[];


        // records file name and sets default length to 0 characters
        System.out.println("Please enter the name of the file which you would like to use");
        // String fileName = keyboard.nextLine();
        String fileName = "data.txt";
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
            runner();
        }



        // provides char length of file to allow me to finish initializing the first array
        // side note, this section counts a whole fraction as a single char
        while (fileData1.hasNext()) {
            // temp holder is needed to scroll through the file and get an accurate count
            String tempHolder = fileData1.next();
            fileLength++;
            System.out.println(fileLength);
        }
        // data stream needs to be closed and then reopened to set us back to the start of the file
        fileData1.close();

        Scanner fileData2 = null;

        // recreating the connection to the file
        try{
            fileData2 =
            new Scanner(new FileInputStream(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        
        initialArray = new String[fileLength];

        int arrayIndexCount = 0;

        while (fileData2.hasNext()) {
            // temp holder is needed to scroll through the file and get an accurate count
            String tempHolder2 = fileData2.next();
            initialArray[arrayIndexCount] = tempHolder2;
            arrayIndexCount++;
        }

        // closing data stream
        fileData2.close();

        // Created new variables and arrays to use
        String[] tempArray2 = new String[(initialArray.length)];
        String[] numerator = new String[(initialArray.length)];
        String[] denominator = new String[(initialArray.length)];
        String tempHolder3;

        // keep for testing, remove before i submit assignment
        for(int i = 0; i < initialArray.length; i++) {
            System.out.println("Element at index " + i + 
            " : "+ initialArray[i]); 
        }

        System.out.println(" ");


        for(int i = 0; i < initialArray.length; i++) {
            tempHolder3 = initialArray[i];
            System.out.println("Element at index " + i + " for tempHolder3 is: " + initialArray[i]);
            tempArray2 = tempHolder3.split("/");
            numerator[i] = tempArray2[0];
            denominator[i] =tempArray2[1];
            System.out.println("Element at index " + i + " for numerator is: " + 
            " : "+ numerator[i]);  
            System.out.println("Element at index " + i + " for denominator0 is: " + 
            " : "+ denominator[i]);   
        }

        int tempNumerator1 = Integer.parseInt(numerator[0]);
        int tempDenominator1 = Integer.parseInt(denominator[0]);
        int tempNumerator2 = Integer.parseInt(numerator[8]);
        int tempDenominator2 = Integer.parseInt(denominator[8]);

        System.out.println("num 1 = " + tempNumerator1);
        System.out.println("den 1 = " + tempDenominator1);
        System.out.println("num 2 = " + tempNumerator2);
        System.out.println("den 2 = " +tempDenominator2);

        int answer = ((tempNumerator1 * tempDenominator2)/ (tempNumerator2 * tempDenominator1) );

        System.out.println("the first unique will be " + initialArray[0] + " proof here : " + answer);



        // use split and delimiter slash make an array as an numerator and denominator
        // use filedata2.split give it a space with  a delimiter slash, will receive an array of two strings, a numorator and a denomiator
        // then to change strings into nums you use Integer something
        // only save a fraction if it is unique

        // What I need to do now 
        // make two new arrays, one where the uniques go to
        // and a second one that keeps track of the uniques
        // I auto set the first index to the unique array and set the count to 1 unique
        // when I scan the second unique and see that it most likely doesn't match then
        // 
    }

    // method which provides the user with an option to run the program again
    static int reRun(){
        Scanner keyboard = new Scanner(System.in); 
        System.out.println("Would you like to enter another file to be read? 0 for no, 1 for yes ");
        int confirm = keyboard.nextInt();
        return confirm;
    }


}

