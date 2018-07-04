package by.itacademy.waypoints.readers;

import by.itacademy.waypoints.Waypoint;

import java.util.List;

public interface Reader {
    void readWaypoints();

    List<Waypoint> getWaypoints();
}
