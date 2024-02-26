package org.deepaksntiwari.models;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {

    private String name;
    private int capacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    public TravelPackage(String name, String s, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Package is full. Passenger cannot be added.");
        }
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + capacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println("\t- " + passenger.getName() + " (" + passenger.getPassengerNumber() + ")");
        }
    }

    public Destination getDestination(String destinationCode) {
        for(Destination destination : destinations){
            if(destination.getDestinationCode().equals(destinationCode))
                return destination;
        }
        return null;
    }

    public Passenger getPassenger(String passengerName) {
        for(Passenger passenger : passengers){
            if(passenger.getName().equals(passengerName))
                return passenger;
        }
        return null;
    }
}
