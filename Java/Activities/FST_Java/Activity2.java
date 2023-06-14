package org.activities;

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args) {

        int[] array = {10, 77, 10, 54, -11, 10};
        System.out.println("The array is :" +Arrays.toString(array));

        System.out.println("The result is :" +verification(array));
    }

    public static String verification(int[] intArray){
        int counter = 0;
        String stringToReturn = "";
        for (int tempVar : intArray) {
            if(tempVar == 10){
                counter = counter + 10;
            }
        }
        if(counter == 30)
            stringToReturn = "The sum of 10's of the array is 30";
        else
        stringToReturn = "The sum of 10's of the array is not equal to 30";

        return stringToReturn;
    }
}
