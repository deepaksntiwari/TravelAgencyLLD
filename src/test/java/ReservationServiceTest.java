import org.deepaksntiwari.models.Activity;
import org.deepaksntiwari.models.Passenger;
import org.deepaksntiwari.models.PassengerType;
import org.deepaksntiwari.services.ReservationService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ReservationServiceTest {

    private ReservationService reservationService;
    private Passenger standardPassenger;
    private Passenger goldPassenger;
    private Activity activity1;
    private Activity activity2;

    @Before
    public void setUp() {
        reservationService = new ReservationService();
        standardPassenger = new Passenger("Deepak", "P001", PassengerType.STANDARD, 100.0);
        goldPassenger = new Passenger("Harsh", "P002", PassengerType.GOLD, 150.0);
        activity1 = new Activity("Ganga Aarti", "Watch the enchanting Ganga Aarti at Parmath Niketan Aashram.", 50.0, 20, "DEST1");
        activity2 = new Activity("River Rafting", "Enjoy the thrill of Ma Ganga flow...", 50.0, 20, "DEST1");
    }

    @Test
    public void testReserveActivityStandardPassenger() {
        reservationService.reserveActivity(standardPassenger, activity1);
        assertEquals(1, standardPassenger.getActivities().size());
        assertTrue(standardPassenger.getActivities().contains(activity1));
        assertEquals(50.0, standardPassenger.getBalance(), 0.0);
        assertEquals(19, activity1.getAvailableSpaces());
    }

    @Test
    public void testReserveActivityGoldPassenger() {
        reservationService.reserveActivity(goldPassenger, activity2);
        assertEquals(1, goldPassenger.getActivities().size());
        assertTrue(goldPassenger.getActivities().contains(activity2));
        assertEquals(114.0, goldPassenger.getBalance(), 0.0); // 150 - (40 * 0.9)
        assertEquals(29, activity2.getAvailableSpaces());
    }

    @Test
    public void testReserveActivityInsufficientFunds() {
        standardPassenger.setBalance(10.0); // Set balance lower than activity cost
        reservationService.reserveActivity(standardPassenger, activity1);
        assertEquals(0, standardPassenger.getActivities().size());
        assertEquals(10.0, standardPassenger.getBalance(), 0.0); // Balance should remain unchanged
        assertEquals(20, activity1.getAvailableSpaces()); // No space reserved
    }

    @Test
    public void testCancelReservation() {
        reservationService.reserveActivity(standardPassenger, activity1);
        reservationService.cancelReservation(standardPassenger, activity1);
        assertEquals(0, standardPassenger.getActivities().size());
        assertEquals(100.0, standardPassenger.getBalance(), 0.0); // Refund activity cost
        assertEquals(20, activity1.getAvailableSpaces()); // Space should be available again
    }
}