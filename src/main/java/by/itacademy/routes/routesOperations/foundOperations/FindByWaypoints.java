package by.itacademy.routes.routesOperations.foundOperations;

import by.itacademy.routes.Route;
import by.itacademy.waypoints.Waypoint;

import java.util.HashSet;
import java.util.Set;

public class FindByWaypoints implements FoundOperations {

    @Override
    public Set<Route> getData(Set<Route> data, Object... inputData) {
        String firstWaypoint = (String) inputData[0], secondWaypoint = (String) inputData[0];
        Set<Route> routes = new HashSet<>();
        for (Route route : data) {
            if (filter(route, firstWaypoint, secondWaypoint)) routes.add(route);
        }
        if (routes.isEmpty()) System.out.println("Don't have route");
        return routes;
    }

    private boolean filter(Route route, String firstWaypoint, String secondWaypoint) {
        boolean first = false;
        boolean second = false;
        for (Waypoint waypoint : route.getWaypoints()) {
            if (waypoint.getName().trim().equalsIgnoreCase(firstWaypoint.trim())) first = true;
            if (waypoint.getName().trim().equalsIgnoreCase(secondWaypoint.trim())) second = true;
        }
        return first && second;
    }
}
