// Passenger.java
package org.deepaksntiwari.models;

import java.util.ArrayList;
import java.util.List;

public class Passenger {

    private String name;
    private String passengerNumber;
    private PassengerType type;
    private double balance;
    private List<Activity> activities;

    public Passenger(String name, String passengerNumber, PassengerType type, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
            this.balance = balance;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public PassengerType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
