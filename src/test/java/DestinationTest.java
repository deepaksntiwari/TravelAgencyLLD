import org.deepaksntiwari.models.Activity;
import org.deepaksntiwari.models.Destination;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DestinationTest {

    private Destination destination;
    private Activity activity1;
    private Activity activity2;

    @Before
    public void setUp() {
        destination = new Destination("Rishikesh", "DESC1");
        activity1 = new Activity("Ganga Aarti", "Watch the enchanting Ganga Aarti at Parmath Niketan Aashram.", 50.0, 20, "DEST1");
        activity2 = new Activity("River Rafting", "Enjoy the thrill of Ma Ganga flow...", 50.0, 20, "DEST1");
    }

    @Test
    public void testAddActivity() {
        destination.addActivity(activity1);
        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity1));
    }

    @Test
    public void testRemoveActivity() {
        destination.addActivity(activity1);
        destination.addActivity(activity2);
        destination.removeActivity(activity1);
        assertEquals(1, destination.getActivities().size());
        assertFalse(destination.getActivities().contains(activity1));
        assertTrue(destination.getActivities().contains(activity2));
    }
}
