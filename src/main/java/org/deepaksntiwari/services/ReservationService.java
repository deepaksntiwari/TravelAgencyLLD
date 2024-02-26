// ReservationService.java
package org.deepaksntiwari.services;

import org.deepaksntiwari.models.Activity;
import org.deepaksntiwari.models.Passenger;
import org.deepaksntiwari.models.PassengerType;

public class ReservationService {
    public boolean reserveActivity(Passenger passenger, Activity activity) {
        if (activity.getAvailableSpaces() <= 0) {
            System.out.println("Activity is full. Reservation failed.");
            return false;
        }

        if (passenger.getType() == PassengerType.STANDARD && passenger.getBalance() < activity.getCost()) {
            System.out.println("Insufficient funds to reserve activity.");
            return false;
        }

        double costToDeduct = activity.getCost();
        if (passenger.getType() == PassengerType.GOLD) {
            costToDeduct *= 0.9; // Apply 10% discount for Gold passengers
        }

        if (passenger.getType() != PassengerType.PREMIUM) {
            if (passenger.getBalance() < costToDeduct) {
                System.out.println("Insufficient funds to reserve activity.");
                return false;
            }
            passenger.setBalance(passenger.getBalance() - costToDeduct);
        }

        if (activity.reserveSpace()) {
            passenger.addActivity(activity);
            System.out.println("Activity booked.");

        } else {
            System.out.println("Activity is full. Reservation failed.");
        }
        return false;
    }

    public void cancelReservation(Passenger passenger, Activity activity) {
        activity.cancelReservation();
        passenger.removeActivity(activity);
        double refundAmount = activity.getCost();
        if (passenger.getType() == PassengerType.GOLD) {
            refundAmount *= 0.9; // Apply 10% refund for Gold passengers
        }
        passenger.setBalance(passenger.getBalance() + refundAmount);
    }
}
