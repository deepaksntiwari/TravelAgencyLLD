package org.deepaksntiwari.models;

public class Activity {

    private String name;
    private String description;
    private double cost;
    private int capacity;
    private int availableSpaces;
    private String destinationCode;

    public Activity(String name, String description, double cost, int capacity, String destinationCode) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destinationCode=destinationCode;
        this.availableSpaces = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public boolean reserveSpace() {
        if (availableSpaces > 0) {
            availableSpaces--;
            return true;
        } else {
            return false;
        }
    }

    public void cancelReservation() {
        availableSpaces++;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }
}
