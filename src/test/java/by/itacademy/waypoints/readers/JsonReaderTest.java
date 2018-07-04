package by.itacademy.waypoints.readers;

import by.itacademy.waypoints.Waypoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class JsonReaderTest {
    @Test
    public void testJsonDeserialize() {
        List<Waypoint> waypoints = new ArrayList<>();
        waypoints.add(new Waypoint("Нарочанская", 1, "ДС ВЕСНЯНКА"));
        JsonReader reader = new JsonReader("https://raw.githubusercontent.com/Inkain/finalResources/master/waypoints.json");
        reader.readWaypoints();
        List<Waypoint> waypoints1 = reader.getWaypoints();
        assertTrue(waypoints.containsAll(waypoints1) && !waypoints1.isEmpty());
    }
}
