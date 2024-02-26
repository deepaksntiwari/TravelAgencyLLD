import org.deepaksntiwari.models.Activity;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {

    private Activity activity;

    @Before
    public void setUp() {
        activity = new Activity("Ganga Aarti", "Watch the enchanting Ganga Aarti at Parmath Niketan Aashram.", 50.0, 20, "DEST1");
    }

    @Test
    public void testReserveSpace() {
        assertTrue(activity.reserveSpace());
        assertEquals(19, activity.getAvailableSpaces());
    }

    @Test
    public void testCancelReservation() {
        activity.reserveSpace();
        activity.cancelReservation();
        assertEquals(20, activity.getAvailableSpaces());
    }
}
