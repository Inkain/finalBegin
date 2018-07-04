package by.itacademy.waypoints;

import by.itacademy.waypoints.readers.JsonReader;
import by.itacademy.waypoints.readers.Reader;
import by.itacademy.waypoints.readers.XMLReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WaypointsData {
    private List<Waypoint> waypoints = new ArrayList<>();

    public WaypointsData() {

    }

    public WaypointsData(String localFile, String remotefile) {
        addWaypoints(localFile);
        addWaypoints(remotefile);
        this.waypoints.add(new Waypoint("ДС ЧИЖОВКА", 0, "ДС ЧИЖОВКА"));
        this.waypoints.add(new Waypoint("ДС ВЕСНЯНКА", 0, "ДС ВЕСНЯНКА"));
    }

    private void addWaypoints(String fileName) {
        Pattern pattern = Pattern.compile("(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        Matcher matcher = pattern.matcher(fileName);
        Reader reader = (matcher.matches()) ? new JsonReader(fileName) : new XMLReader(fileName);
        reader.readWaypoints();
        this.waypoints.removeAll(reader.getWaypoints());
        this.waypoints.addAll(reader.getWaypoints());
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }
}
