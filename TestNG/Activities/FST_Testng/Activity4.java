package testPackage;

import org.testng.annotations.Test;

public class Activity4 {
}

class FirstClass {
    @Test
    public void firstTestCase() {
        System.out.println("I'm in first test case from First Class");
    }

    @Test
    public void secondTestCase() {
        System.out.println("I'm in second test case from First Class");
    }
}

class SecondClass {
    @Test
    public void TestCase() {
        System.out.println("I'm in the test case from Second Class");
    }
}