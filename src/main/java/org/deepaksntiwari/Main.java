package org.deepaksntiwari;

import org.deepaksntiwari.models.Passenger;
import org.deepaksntiwari.models.PassengerType;
import org.deepaksntiwari.services.TravelPackageService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TravelPackageService travelPackageService = TravelPackageService.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** Welcome to the Nymble Travel Agency ***");
            System.out.println("1. Create a New Travel Package");
            System.out.println("2. Create a New Destination for a Travel Package");
            System.out.println("3. Create a New Activity for a Destination");
            System.out.println("4. Create a New Passenger and add to a Travel Package");
            System.out.println("5. Print all Travel Packages");
            System.out.println("6. Print Travel Package by Package Code");
            System.out.println("7. Print all the Passengers of a Travel Package by Package Code");
            System.out.println("8. Print Passenger by Passenger Name");
            System.out.println("9. Print Activities with Remaining Spaces by Package Code");
            System.out.println("10. Reserve Activity for a Passenger by Package Code, Passenger Name, and Activity Name");
            System.out.println("11. Cancel Reservation for a Passenger by Package Code, Passenger Name, and Activity Name");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Creating a New Travel Package...");
                    System.out.println("Enter package name: ");
                    String packageName = scanner.next();
                    System.out.println("Enter passenger capacity: ");
                    int capacity = scanner.nextInt();
                    String packageCode = travelPackageService.createTravelPackage(packageName, capacity);
                    System.out.println("Travel package created with code: " + packageCode);
                    break;
                case 2:
                    System.out.println("Creating a New Destination...");
                    System.out.println("Enter package code to add destination: ");
                    String pkgCode = scanner.next();
                    System.out.println("Enter destination name: ");
                    String destinationName = scanner.next();
                    System.out.println("Destination created with code: " + travelPackageService.addDestination(pkgCode, destinationName)+" in package with code: "+pkgCode);

                    break;
                case 3:
                    System.out.println("Creating a New Activity...");
                    System.out.println("Enter package code to add activity: ");
                    String pCode = scanner.next();
                    System.out.println("Enter destination code: ");
                    String destCode = scanner.next();
                    System.out.println("Enter activity name: ");
                    String activityName = scanner.next();
                    System.out.println("Enter activity description: ");
                    String activityDescription = scanner.next();
                    System.out.println("Enter activity cost: ");
                    double activityCost = scanner.nextDouble();
                    System.out.println("Enter activity capacity: ");
                    int activityCapacity = scanner.nextInt();
                    travelPackageService.addActivityToDestination(pCode, destCode, activityName, activityDescription, activityCost, activityCapacity);
                    System.out.println("Activity created in destination with code: "+destCode+" in package with code: "+pCode);
                    break;
                case 4:
                    System.out.println("Creating a New Passenger...");
                    System.out.println("Enter passenger name: ");
                    String passengerName = scanner.next();
                    System.out.println("Enter passenger number: ");
                    String passengerNumber = scanner.next();
                    System.out.println("Enter passenger type (STANDARD, GOLD, PREMIUM): ");
                    String passengerTypeStr = scanner.next();
                    PassengerType passengerType = PassengerType.valueOf(passengerTypeStr);
                    System.out.println("Enter balance: ");
                    double balance = scanner.nextDouble();
                    Passenger passenger = new Passenger(passengerName, passengerNumber, passengerType, balance);
                    System.out.println("Enter package code to add passenger: ");
                    String code = scanner.next();
                    travelPackageService.addPassenger(code, passenger);
                    break;
                case 5:
                    System.out.println("Printing all Travel Packages...");
                    travelPackageService.printAllTravelPackages();
                    break;
                case 6:
                    System.out.println("Printing Travel Package by Package Code...");
                    System.out.println("Enter package code: ");
                    String pcCode = scanner.next();
                    travelPackageService.printItinerary(pcCode);
                    break;
                case 7:
                    System.out.println("Printing all the Passengers of a Travel Package by Package Code...");
                    System.out.println("Enter package code: ");
                    String packCode = scanner.next();
                    travelPackageService.printPassengerList(packCode);
                    break;
                case 8:
                    System.out.println("Printing Passenger by Passenger Name...");
                    System.out.println("Enter package code: ");
                     pkgCode = scanner.next();
                    System.out.println("Enter passenger name: ");
                    String passName = scanner.next();
                    travelPackageService.printPassengerDetails(pkgCode, passName);
                    break;
                case 9:
                    System.out.println("Printing Activities with Remaining Spaces by Package Code...");
                    System.out.println("Enter package code: ");
                    String codePkg = scanner.next();
                    travelPackageService.printAvailableActivities(codePkg);
                    break;
                case 10:
                    System.out.println("Reserving Activity for a Passenger...");
                    System.out.println("Enter package code: ");
                    String pckgCode = scanner.next();
                    System.out.println("Enter passenger name: ");
                    String passNameRes = scanner.next();
                    System.out.println("Enter activity name: ");
                    String activityNameRes = scanner.next();
                    travelPackageService.reserveActivity(pckgCode, passNameRes, activityNameRes);
                    break;
                case 11:
                    System.out.println("Canceling Reservation for a Passenger...");
                    System.out.println("Enter package code: ");
                    String pkgCodeCancel = scanner.next();
                    System.out.println("Enter passenger name: ");
                    String passNameCancel = scanner.next();
                    System.out.println("Enter activity name: ");
                    String activityNameCancel = scanner.next();
                    travelPackageService.cancelReservation(pkgCodeCancel, passNameCancel, activityNameCancel);
                    break;
                case 12:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 12.");
            }
        }
    }
}
