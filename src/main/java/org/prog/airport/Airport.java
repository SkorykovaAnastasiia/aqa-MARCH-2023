package org.prog.airport;

import java.util.ArrayList;

public class Airport {

    public ArrayList<Passenger> passengers = new ArrayList<>();
    public ArrayList<Plane> planes = new ArrayList<>();

    public void addPassenger(Passenger arrivingPassenger) {
        passengers.add(arrivingPassenger);
    }

    public void addPlane(Plane arrivingPlane) {
        planes.add(arrivingPlane);
    }

    public void boardPlane(Passenger passenger, Plane plane) {
        plane.boardPassenger(passenger);
    }
}
