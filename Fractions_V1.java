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
        runner();
    }

    // Method that runs the program
    static void runner(){
        Scanner fileData1 = null;
        String initialArray[];


        // records file name and sets default length to 0 characters
        String fileName = "fractions.txt";
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

        // Scrolls through the file and transfers the content of the file to initialArray
        while (fileData2.hasNext()) {
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

        // Splits the numerator and denominator into their own arrays
        for(int i = 0; i < initialArray.length; i++) {
            tempHolder3 = initialArray[i];
            tempArray2 = tempHolder3.split("/");
            numerator[i] = tempArray2[0];
            denominator[i] =tempArray2[1];
        }

        int tempNumerator1;
        int tempDenominator1;
        int tempNumerator2;
        int tempDenominator2;
        String[] uniqueArray = new String[(initialArray.length)]; 
        int[] uniqueArrayCounter = new int[(initialArray.length)]; 
        boolean answer;

        // Since the first fraction will always be unique, I auto set it to be the first index in
        // the uniqueArray and increase the count by one immediately
        uniqueArray[0] = initialArray[0];
        uniqueArrayCounter[0] = 1;

        // Essentially what this for loop does is at this point it grabs the numbers from index 1 since we already
        // recorded index 0
        for(int i = 1; i < initialArray.length; i++) {
            int o = 0;
            int whileLoopCounter = 1;
            tempNumerator2 = Integer.parseInt(numerator[i]);
            tempDenominator2 = Integer.parseInt(denominator[i]);

            // for loop to determine how long the while loop will run
            for(int z = 1; z < initialArray.length; z++) {
                if (uniqueArrayCounter[z] == 0) {
                    break;

                } else {
                    whileLoopCounter++;

                }
            }

            // this while loop will go one by one through the array of fractions checking if it can find a match
            // to the fractions we set in the parent for loop (tempNumerator2 and tempDenominator2)
            while(o < whileLoopCounter) {
                tempNumerator1 = Integer.parseInt(numerator[o]);
                tempDenominator1 = Integer.parseInt(denominator[o]);
                answer = ((tempNumerator1 * tempDenominator2) == (tempNumerator2 * tempDenominator1) );

                // if they are equal then we know it is the same fraction and we record at the index
                // an increase of 1 and we force an exit out of the while loop by setting o to whileLoopCounter
                if (answer == true) {
                    uniqueArrayCounter[o]++;
                    
                    o = whileLoopCounter;
                    // if they aren't equal and there are more indexes that we need to check,
                    // then move onto the next index
                } else if (answer == false && uniqueArrayCounter[o+1] != 0) {
                    o++;
                    // if they aren't equal and the next index is 0 then it sets
                    // a new unique in the unique array and counter, as well as exits the while loop
                } else {
                    uniqueArray[(o+1)] = initialArray[i];
                    uniqueArrayCounter[(o+1)]++;
                    o= whileLoopCounter;

                }
                
            } 
        }

        System.out.println("");

        // simple for loop to print out the results for the user
        for(int i = 0; i < uniqueArray.length; i++) {
            if (uniqueArray[i] != null) {
            System.out.println(uniqueArray[i] + " has " + uniqueArrayCounter[i] + " occurrences"); 
            System.out.println("");
            } else {
             break;
            } 
        }

    }

}

