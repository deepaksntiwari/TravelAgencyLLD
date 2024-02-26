import org.deepaksntiwari.models.Destination;
import org.deepaksntiwari.models.Passenger;
import org.deepaksntiwari.models.PassengerType;
import org.deepaksntiwari.models.TravelPackage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TravelPackageTest {

    private TravelPackage travelPackage;
    private Destination destination1;
    private Destination destination2;
    private Passenger passenger1;
    private Passenger passenger2;

    @Before
    public void setUp() {
        travelPackage = new TravelPackage("Uttrakhand Tour", "PKG001", 10);
        destination1 = new Destination("Rishikesh", "DESC1");
        destination2 = new Destination("Haridwar", "DESC2");
        passenger1 = new Passenger("Deepak", "P001", PassengerType.STANDARD, 1000);
        passenger2 = new Passenger("Harsh", "P002", PassengerType.GOLD, 1500);
    }

    @Test
    public void testAddDestination() {
        travelPackage.addDestination(destination1);
        assertEquals(1, travelPackage.getDestinations().size());
        assertTrue(travelPackage.getDestinations().contains(destination1));
    }

    @Test
    public void testRemoveDestination() {
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);
        travelPackage.removeDestination(destination1);
        assertEquals(1, travelPackage.getDestinations().size());
        assertFalse(travelPackage.getDestinations().contains(destination1));
        assertTrue(travelPackage.getDestinations().contains(destination2));
    }

    @Test
    public void testAddPassenger() {
        travelPackage.addPassenger(passenger1);
        assertEquals(1, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger1));
    }

    @Test
    public void testRemovePassenger() {
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.removePassenger(passenger1);
        assertEquals(1, travelPackage.getPassengers().size());
        assertFalse(travelPackage.getPassengers().contains(passenger1));
        assertTrue(travelPackage.getPassengers().contains(passenger2));
    }
}
