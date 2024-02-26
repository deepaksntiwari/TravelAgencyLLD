// TravelPackageService.java
package org.deepaksntiwari.services;

import org.deepaksntiwari.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPackageService {
    private static TravelPackageService instance;
    private Map<String, TravelPackage> travelPackages;
    private List<Activity> activities;

    private TravelPackageService() {
        this.activities = new ArrayList<>();
        travelPackages = new HashMap<>();
    }

    public static TravelPackageService getInstance() {
        if (instance == null) {
            synchronized (TravelPackageService.class) {
                if (instance == null) {
                    instance = new TravelPackageService();
                }
            }
        }
        return instance;
    }

    public String createTravelPackage(String packageName, int capacity) {
        String packageCode = generatePackageCode();
        TravelPackage travelPackage = new TravelPackage(packageName, packageCode, capacity);
        travelPackages.put(packageCode, travelPackage);
        return packageCode;
    }

    public void addPassenger(String packageCode, Passenger passenger) {
        TravelPackage travelPackage = travelPackages.get(packageCode);
        if (travelPackage != null) {
            travelPackage.addPassenger(passenger);
        } else {
            System.out.println("Travel Package not found.");
        }
    }

    public String addDestination(String packageCode, String destinationName) {
        TravelPackage travelPackage = travelPackages.get(packageCode);
        if (travelPackage != null) {
            String destinationCode = generateDestinationCode();
            Destination destination = new Destination(destinationName, destinationCode);
            travelPackage.addDestination(destination);
            return destinationCode;
        } else {
            System.out.println("Travel Package not found.");
        }
        return "";
    }

    public void addActivityToDestination(String packageCode, String destinationCode, String activityName, String activityDescription, double activityCost, int activityCapacity) {
        TravelPackage travelPackage = travelPackages.get(packageCode);
        if (travelPackage != null) {
            Destination destination = travelPackage.getDestination(destinationCode);
            if (destination != null) {
                Activity activity = new Activity(activityName, activityDescription, activityCost, activityCapacity, destinationCode);
                if (!activities.isEmpty() && activities.contains(activity)) {
                    System.out.println("Can't have duplicate activity");
                }
                destination.addActivity(activity);
                activities.add(activity);
            } else {
                System.out.println("Destination not found.");
            }
        } else {
            System.out.println("Travel Package not found.");
        }
    }



    int randomNumber = 0;

    private String generatePackageCode() {
        return "PKG" + ++randomNumber;
    }

    private String generateDestinationCode() {
        return "DEST" + ++randomNumber;
    }

    public void reserveActivity(String pckgCode, String passNameRes, String activityNameRes) {
        ReservationService reservationService = new ReservationService();
        Passenger passenger = travelPackages.get(pckgCode).getPassenger(passNameRes);
        for (Activity activity : activities) {
            if (activity.getName().equals(activityNameRes)) {
                reservationService.reserveActivity(passenger, activity);
                break;
            }
        }

    }

    public void cancelReservation(String pkgCodeCancel, String passNameCancel, String activityNameCancel) {
        ReservationService reservationService = new ReservationService();
        Passenger passenger = travelPackages.get(pkgCodeCancel).getPassenger(passNameCancel);
        for (Activity activity : activities) {
            if (activity.getName().equals(activityNameCancel)) {
                reservationService.cancelReservation(passenger, activity);
                break;
            }
        }
    }

    public void printAllTravelPackages() {
        System.out.println("All Travel Packages:");
        for (String packageCode : travelPackages.keySet()) {
            printItinerary(packageCode);
        }
    }

    public void printItinerary(String packageCode) {
        TravelPackage travelPackage = travelPackages.get(packageCode);
        if (travelPackage != null) {
            System.out.println("Travel Package: " + travelPackage.getName());
            System.out.println("Passenger Capacity: " + travelPackage.getCapacity());
            System.out.println("Itinerary:");

            List<Destination> destinations = travelPackage.getDestinations();
            for (Destination destination : destinations) {
                System.out.println("Destination: " + destination.getName());
                List<Activity> activities = destination.getActivities();
                for (Activity activity : activities) {
                    System.out.println("\tActivity: " + activity.getName());
                    System.out.println("\tDescription: " + activity.getDescription());
                    System.out.println("\tCost: " + activity.getCost());
                    System.out.println("\tAvailable Spaces: " + activity.getAvailableSpaces());
                }
            }
        } else {
            System.out.println("Travel Package not found.");
        }
    }

    public void printPassengerList(String packageCode) {
        TravelPackage travelPackage = travelPackages.get(packageCode);
        if (travelPackage != null) {
            System.out.println("Passenger List for Travel Package: " + travelPackage.getName());
            System.out.println("Package Code: " + packageCode);
            System.out.println("Passenger Capacity: " + travelPackage.getCapacity());
            System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
            System.out.println("Passenger Details:");

            List<Passenger> passengers = travelPackage.getPassengers();
            for (Passenger passenger : passengers) {
                System.out.println("\tPassenger Name: " + passenger.getName());
                System.out.println("\tPassenger Number: " + passenger.getPassengerNumber());
            }
        } else {
            System.out.println("Travel Package not found.");
        }
    }

    public void printPassengerDetails(String packageCode, String passengerName) {
        TravelPackage travelPackage = travelPackages.get(packageCode);
        if (travelPackage != null) {
            Passenger passenger = travelPackage.getPassenger(passengerName);
            if (passenger != null) {
                System.out.println("Passenger Details:");
                System.out.println("\tName: " + passenger.getName());
                System.out.println("\tPassenger Number: " + passenger.getPassengerNumber());
                if (passenger.getType().equals(PassengerType.STANDARD)) {
                    System.out.println("\tPassenger Type: Standard");
                    System.out.println("\tBalance: " + passenger.getBalance());
                } else if (passenger.getType().equals(PassengerType.GOLD)) {
                    System.out.println("\tPassenger Type: Gold");
                    System.out.println("\tBalance: " + passenger.getBalance());
                } else{
                    System.out.println("\tPassenger Type: Premium");
                }

                List<Activity> activities = passenger.getActivities();
                if (!activities.isEmpty()) {
                    System.out.println("\tActivities Signed Up:");

                    for (Activity activity : activities) {
                        System.out.println("\t\tActivity: " + activity.getName());
                        System.out.println("\t\tDestination: " + activity.getDestinationCode());
                        System.out.println("\t\tCost: " + activity.getCost());
                    }
                } else {
                    System.out.println("\tNo activities signed up yet.");
                }
            } else {
                System.out.println("Passenger not found.");
            }
        } else {
            System.out.println("Travel Package not found.");
        }
    }

    public void printAvailableActivities(String packageCode) {
        TravelPackage travelPackage = travelPackages.get(packageCode);
        if (travelPackage != null) {
            System.out.println("Available Activities for Travel Package: " + travelPackage.getName());
            System.out.println("Package Code: " + packageCode);

            List<Destination> destinations = travelPackage.getDestinations();
            for (Destination destination : destinations) {
                System.out.println("Destination: " + destination.getName());
                List<Activity> activities = destination.getActivities();
                for (Activity activity : activities) {
                    if (activity.getAvailableSpaces() > 0) {
                        System.out.println("\tActivity: " + activity.getName());
                        System.out.println("\tDestination: " + destination.getName());
                        System.out.println("\tCost: " + activity.getCost());
                        System.out.println("\tAvailable Spaces: " + activity.getAvailableSpaces());
                    }
                }
            }
        } else {
            System.out.println("Travel Package not found.");
        }
    }


}
