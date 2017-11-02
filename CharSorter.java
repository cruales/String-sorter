package com.company;
import java.util.*;
import java.lang.*;

public class CharSorter {

    public static void main(String[] args) {

        System.out.println("Welcome to Character Sorter Program");

        Scanner in = new Scanner(System.in);

        System.out.println("Please input a string to be sorted");
        String userInput = in.nextLine();

        convertAscii(userInput);
    }

    public static void convertAscii(String convert){

        int [] asciiValues = new int[convert.length()];
        for(int i=0; i<convert.length(); i++){
            char eachLetter = convert.charAt(i);
            int ascii = eachLetter; // converts to ascii value
            asciiValues[i] = ascii;
        }
        Scanner input = new Scanner(System.in);

        int keepGoing = 0;

        while(keepGoing==0){
            System.out.println();
            System.out.println("Please select the option you would like to see");
            System.out.println();
            System.out.println("1. Display character frequencies alphabetically");
            System.out.println("2. Display sorted frequencies");
            System.out.println("3. Show types of character frequencies");
            System.out.println("4. Exit");
            int userChoice = 0;

            try{
                userChoice = input.nextInt();
            }

            catch (Exception e){
                //System.out.println("Invalid input");
                input.nextLine();
                userChoice = 40;
            }

            if(userChoice==1){
                alphabeticalSort(asciiValues);
            }
            else if(userChoice==2){
                frequencySort(asciiValues);
            }
            else if(userChoice==3){
                charTypes(asciiValues);
            }
            else if(userChoice==4){
                keepGoing++;
                System.out.println();
                System.out.println("Character Sorter Exited Successfully");
            }
            else{
                System.out.println("Error, bad input, please enter a number 1-4");
            }

        }
    }

    public static void alphabeticalSort(int[] array){
        int[] holdValues = new int[127];

        for(int i=0; i<array.length; i++){
            int position = array[i]-32;
            holdValues[position]++;
        }
        for(int j=0; j<holdValues.length; j++){
            if(holdValues[j]!=0) {
                int findValue = j+32;
                char actualValue = (char)findValue;
                System.out.println(actualValue + " freq: " + holdValues[j]);
            }
        }
    }

    public static void frequencySort(int[] array){

        int[] holdValues = new int[127];
        for(int i=0; i<array.length; i++){
            int position = array[i]-32;
            holdValues[position]++;
        }


        int max = 0;
        int maxPosition = 0;
        for(int j=0; j<holdValues.length; j++){

            max=0;
            maxPosition=0;

            for(int k=0; k<holdValues.length;k++) {
                if (holdValues[k]>max) {
                    max = holdValues[k];
                    maxPosition=k;
                }
            }
            if(max==0){
                break;
            }
            System.out.println((char)(maxPosition+32) + " freq: " + max);
            holdValues[maxPosition]=0;
        }


    }

    public static void charTypes(int[] array){

        int letterCount = 0;
        int numberCount = 0;
        int spaceCount = 0;
        int symbolCount = 0;

        for(int i=0; i<array.length; i++){
            if((array[i]>=65 && array[i]<=90) || (array[i]>=97 && array[i]<=122)){
                letterCount++;
            }
            else if(array[i]>=48 && array[i]<=57){
                numberCount++;
            }
            else if(array[i]==32){
                spaceCount++;
            }
            else{
                symbolCount++;
            }
        }
        System.out.println("Textual Character count: " + letterCount);
        System.out.println("Numerical Character count: " + numberCount);
        System.out.println("WhiteSpace Character count: " + spaceCount);
        System.out.println("Symbol Character count: " + symbolCount);

    }
}
