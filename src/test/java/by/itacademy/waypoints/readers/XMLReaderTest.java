package by.itacademy.waypoints.readers;

import by.itacademy.waypoints.Waypoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class XMLReaderTest {

    @Test
    public void testXMLDeserialize() {
        List<Waypoint> waypoints = new ArrayList<>();
        waypoints.add(new Waypoint("Поселок пионерский", 2, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Минск-Арена", 3, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Университет физкультуры", 4, "ДС ВЕСНЯНКА"));
        XMLReader reader = new XMLReader("testDeserialize.xml");
        reader.readWaypoints();
        List<Waypoint> waypoints1 = reader.getWaypoints();
        assertTrue(waypoints.containsAll(waypoints1) && !waypoints1.isEmpty());
    }
}
