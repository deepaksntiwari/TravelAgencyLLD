package org.deepaksntiwari.models;

import java.util.ArrayList;
import java.util.List;

public class Destination {

    private String name;
    private String destinationCode;
    private List<Activity> activities;

    public Destination(String name, String destinationCode) {
        this.name = name;
        this.destinationCode = destinationCode;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }
}
