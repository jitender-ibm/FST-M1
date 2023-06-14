package org.activities;

public class Activity3 {

    public static void calculation(double ageInSec){
        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;
        System.out.println("Age on Mercury: " + ageInSec / EarthSeconds / MercurySeconds);
        System.out.println("Age on Venus: " + ageInSec / EarthSeconds / VenusSeconds);
        System.out.println("Age on Earth: " + ageInSec / EarthSeconds);
        System.out.println("Age on Mars: " + ageInSec / EarthSeconds / MarsSeconds);
        System.out.println("Age on Jupiter: " + ageInSec / EarthSeconds / JupiterSeconds);
        System.out.println("Age on Saturn: " + ageInSec / EarthSeconds / SaturnSeconds);
        System.out.println("Age on Uranus: " + ageInSec / EarthSeconds / UranusSeconds);
        System.out.println("Age on Neptune: " + ageInSec / EarthSeconds / NeptuneSeconds);

    }

    public static void main(String[] args) {
        calculation(1000000000);


    }
}
