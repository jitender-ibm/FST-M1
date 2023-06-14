package org.activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "Red");
        hashMap.put(2, "Green");
        hashMap.put(3, "Yellow");
        hashMap.put(4, "White");
        hashMap.put(5, "Blue");

        System.out.println("The map is: " + hashMap);

        hashMap.remove(5);
        if (hashMap.containsValue("Green"))
            System.out.println("The green color present in the map");

        System.out.println("The updated size of the map is: " + hashMap.size());
    }
}
