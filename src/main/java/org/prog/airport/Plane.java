package org.prog.airport;

import java.util.ArrayList;

import java.util.HashMap;

public class Plane {

    public String flightId;
    public String destination;
    public ArrayList<Passenger> boardedPassenger = new ArrayList<>();
    //23C
    public final HashMap<String, Passenger> passengerSitting = new HashMap<>();

    public void boardPassenger(Passenger passenger) {
        boardedPassenger.add(passenger);
    }

    public void takeOff() {
        System.out.println("Flight " + flightId + " went to " + destination);
    }
}
