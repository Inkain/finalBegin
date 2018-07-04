package by.itacademy.routes.routesOperations.sortOpertations;

import by.itacademy.routes.Route;
import by.itacademy.waypoints.Waypoint;

import java.util.Comparator;

public class SortByWaypoints implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        return getRoute(o1).compareTo(getRoute(o2));
    }

    private String getRoute(Route route) {
        StringBuilder builder = new StringBuilder();
        for (Waypoint waypoint : route.getWaypoints()) builder.append(waypoint.getName());
        return builder.toString();
    }
}
