package org.activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("E");
        hs.add("F");

        System.out.println("The size of set is: " + hs.size());
        hs.remove("F");

            hs.remove("H");

        if(hs.contains("A"))
            System.out.println("The contains is working");

        for (String element: hs) {
            System.out.println(element);
        }

    }
}
