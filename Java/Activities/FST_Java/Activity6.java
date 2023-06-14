package org.activities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Plane {
    private Date takeOffDate;
    private Date landingDate;
    private int maxPassengers;
    private List<String> passanders;

    public Plane(int maxPassengers){
        this.maxPassengers = maxPassengers;
        this.passanders = new ArrayList<>();
    }
    public void onboard(String passenger) {
        passanders.add(passenger);
    }

    public static LocalDateTime takeOff() {
        LocalDateTime now = LocalDateTime.now();
        return now;
    }

    LocalDateTime lastTimeLanded;
    public void land() {
        lastTimeLanded = LocalDateTime.now();
        passanders.clear();
    }

    public LocalDateTime getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassesngers() {
        return passanders;
    }
}
public class Activity6 {


    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("First");
        plane.onboard("Second");
        plane.onboard("Third");
        System.out.println(plane.takeOff());
        System.out.println(plane.getPassesngers());
        Thread.sleep(5000);
        plane.land();
        System.out.println(plane.getLastTimeLanded());
    }
}
