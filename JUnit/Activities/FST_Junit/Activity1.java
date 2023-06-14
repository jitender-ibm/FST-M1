package testPackage;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    static ArrayList<String> arrayList;

    @BeforeEach
    void setUp() throws Exception {
        arrayList = new ArrayList<String>();
        arrayList.add("alpha");
        arrayList.add("beta");
    }

    // Test method to test the insert operation
    @Test
    public void insert() {
        assertEquals(2, arrayList.size(), "Incorrect size");
        arrayList.add(2, "charlie");
        assertEquals(3, arrayList.size(), "Incorrect size");

        assertEquals("alpha", arrayList.get(0), "Wrong element");
        assertEquals("beta", arrayList.get(1), "Wrong element");
        assertEquals("charlie", arrayList.get(2), "Wrong element");
    }

    @Test
    public void replace() {
        arrayList.set(1, "charlie");

        assertEquals(2, arrayList.size(), "Wrong size");

        assertEquals("alpha", arrayList.get(0), "Wrong element");
        assertEquals("charlie", arrayList.get(1), "Wrong element");
    }
}
