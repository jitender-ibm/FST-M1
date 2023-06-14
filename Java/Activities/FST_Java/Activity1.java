package org.activities;

import static org.activities.Car.*;

public class Activity1 {

public static void main(String[] args) {
        Car car = new Car();
        car.make = 2014;
        car.color = "Black";
        car.transmission = "Manual";
        displayCharacteristics();
        accelarate();
        brake();
    }
}


class Car {
        static String color;
        static String transmission;
        static int make;
        static int tyres;
        static int doors;

        Car(){
                this.tyres = 4;
                this.doors = 4;
        }

        public static void displayCharacteristics(){
                System.out.println("The color is: " + color);
                System.out.println("The transmission is: " + transmission);
                System.out.println("The make is: " + make);
                System.out.println("The tyres is: " + tyres);
                System.out.println("The doors is: " + doors);
        }

        public static void accelarate(){
                System.out.println("Car is moving forward.");
        }

        public static void brake(){
                System.out.println("Car has stopped.");
        }


}