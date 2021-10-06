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
        // int reRun = 2;
        // do {
        //     runner();
        //     reRun = reRun();
        // }while (reRun != 0);

        runner();
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
            // System.out.println(fileLength);
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
            // System.out.println("Element at index " + i + " for tempHolder3 is: " + initialArray[i]);
            tempArray2 = tempHolder3.split("/");
            numerator[i] = tempArray2[0];
            denominator[i] =tempArray2[1];
            System.out.println("Element at index " + i + " for numerator is: " + 
            " : "+ numerator[i]);  
            System.out.println("Element at index " + i + " for denominator0 is: " + 
            " : "+ denominator[i]);   
        }

        int tempNumerator1;
        int tempDenominator1;
        int tempNumerator2;
        int tempDenominator2;
        String[] uniqueArray = new String[(initialArray.length)]; 
        int[] uniqueArrayCounter = new int[(initialArray.length)]; 

        // System.out.println("num 1 = " + tempNumerator1);
        // System.out.println("den 1 = " + tempDenominator1);
        // System.out.println("num 2 = " + tempNumerator2);
        // System.out.println("den 2 = " +tempDenominator2);

        boolean answer;

        // System.out.println("the first unique will be " + initialArray[0] + " proof here : " + answer);

        uniqueArray[0] = initialArray[0];
        uniqueArrayCounter[0] = 1;

        // for(int i = 0; i < uniqueArrayCounter.length; i++) {
        //     System.out.println("Element at index " + i + " for uniqueArrayCounter is: " + uniqueArrayCounter[i]);  
        // }

        for(int i = 1; i < initialArray.length; i++) {
            int o = 0;
            int whileLoopCounter = 1;
            tempNumerator2 = Integer.parseInt(numerator[i]);
            tempDenominator2 = Integer.parseInt(denominator[i]);
            System.out.println("In for loop");

            System.out.println("temp numerator 2 = " + tempNumerator2);
            System.out.println("temp denominator 2 = " +tempDenominator2);

            for(int z = 1; z < initialArray.length; z++) {
                if (uniqueArrayCounter[z] == 0) {
                    break;

                } else {
                    whileLoopCounter++;

                }
            }

            while(o < whileLoopCounter) {
                System.out.println("In while loop");
                tempNumerator1 = Integer.parseInt(numerator[o]);
                tempDenominator1 = Integer.parseInt(denominator[o]);
                System.out.println("temp numerator 1 = " + tempNumerator1);
                System.out.println("temp denominator 1 = " +tempDenominator1);
                System.out.println("o has the value of: " + o);
                answer = ((tempNumerator1 * tempDenominator2) == (tempNumerator2 * tempDenominator1) );
                System.out.println("answer has the value of: " + answer);

                if (answer == true) {
                    System.out.println("In if statement");
                    uniqueArrayCounter[o]++;
                    
                    o = whileLoopCounter;
                } else if (answer == false && uniqueArrayCounter[o+1] != 0) {
                    System.out.println("In else if statement");
                    o++;
                } else {
                    System.out.println("In else statement");
                    uniqueArray[(o+1)] = initialArray[i];
                    System.out.println("new uniqueArray entry at index " + (o+1) + " has the value of: " + uniqueArray[(o+1)]);
                    uniqueArrayCounter[(o+1)]++;
                    o= whileLoopCounter;

                }
                
            } 
        }


        

        for(int i = 0; i < uniqueArray.length; i++) {
            System.out.println("Element at index " + i + " for uniqueArray is: " + uniqueArray[i]);  
        }

        System.out.println("");

        for(int i = 0; i < uniqueArrayCounter.length; i++) {
            System.out.println("Element at index " + i + " for uniqueArrayCounter is: " + uniqueArrayCounter[i]);  
        }

    }

    // method which provides the user with an option to run the program again
    static int reRun(){
        Scanner keyboard = new Scanner(System.in); 
        System.out.println("Would you like to enter another file to be read? 0 for no, 1 for yes ");
        int confirm = keyboard.nextInt();
        return confirm;
    }


}

