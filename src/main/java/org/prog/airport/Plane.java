package org.prog.airport;

import java.util.ArrayList;

public class Plane {

    public String flightId;
    public String destination;
    public ArrayList<Passenger> boardedPassenger = new ArrayList<>();

    public void boardPassenger(Passenger passenger) {
        boardedPassenger.add(passenger);
    }

    public void takeOff() {
        System.out.println("Flight " + flightId + " went to " + destination);
    }
}
