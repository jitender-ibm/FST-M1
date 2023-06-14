package org.activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Name 1");
        arrayList.add("Name 2");
        arrayList.add("Name 3");
        arrayList.add("Name 4");
        arrayList.add("Name 5");

        for(int i =0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        arrayList.get(2);
        if(arrayList.contains("Name 1"))
            System.out.println("Contains is working if is displayed");

        System.out.println("The size of the array is: " + arrayList.size());
        arrayList.remove(2);
        System.out.println("The size of the array is: " + arrayList.size());
        for(String temp : arrayList){
            System.out.println(temp);
        }
        arrayList.add(2, "Name 3");
        arrayList.set(4, "Name Last");
        for(String temp : arrayList){
            System.out.println(temp);
        }
    }
}
