package org.activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();


        System.out.println("Enter the values: ");
        while (scanner.hasNext()){
            arrayList.add(scanner.nextInt());
        }

        Integer nums[] = arrayList.toArray(new Integer[0]);
        int index = random.nextInt(nums.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + nums[index]);

        scanner.close();
    }
}

class RandomScannerActivity {

}