package org.activities;

interface BicycleParts  {
    public int gears = 0;
    public int speed = 0;
}

interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}

class Bicycle implements BicycleOperations, BicycleParts{
    int speed;
    int gears;

    public Bicycle(int gears, int speed){
        this.gears = gears;
        this.speed = speed;
    }
    public void applyBrake(int decrement){
        speed = speed - decrement;
    }

    public void speedUp(int increment){
        speed = speed + increment;
    }

    public String bicycleDesc(){
        return ("Current speed is: "+ speed +" & Number of gears are: "+ gears);
    }
}

class MountainBike extends Bicycle{
    int seatHeight;
    public MountainBike(int gears, int speed, int seatStartHeight){
        super(gears, speed);
        seatHeight = seatStartHeight;
    }

    public void setHeight(int newHeight){
        seatHeight = newHeight;
    }

    public String bicycleDesc(){

        return (super.bicycleDesc() +   " & the seat height is: " + seatHeight);
    }

}

public class Activity7{
    public static void main(String[] args) {
        MountainBike mountainBike = new MountainBike(10, 5, 15);
        System.out.println(mountainBike.bicycleDesc());
        mountainBike.speedUp(20);
        mountainBike.applyBrake(5);
    }
}