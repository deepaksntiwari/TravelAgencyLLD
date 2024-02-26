import org.deepaksntiwari.models.Activity;
import org.deepaksntiwari.models.Passenger;
import org.deepaksntiwari.models.PassengerType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerTest {

    private Passenger passenger;
    private Activity activity;

    @Before
    public void setUp() {
        passenger = new Passenger("Deepak", "P001", PassengerType.STANDARD, 1000);
        activity = new Activity("Ganga Aarti", "Watch the enchanting Ganga Aarti at Parmath Niketan Aashram.", 50.0, 20, "DEST1");
    }

    @Test
    public void testAddActivity() {
        passenger.addActivity(activity);
        assertEquals(1, passenger.getActivities().size());
        assertTrue(passenger.getActivities().contains(activity));
    }

    @Test
    public void testRemoveActivity() {
        passenger.addActivity(activity);
        passenger.removeActivity(activity);
        assertEquals(0, passenger.getActivities().size());
        assertFalse(passenger.getActivities().contains(activity));
    }
}
