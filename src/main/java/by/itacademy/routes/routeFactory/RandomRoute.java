package by.itacademy.routes.routeFactory;

import by.itacademy.routes.Route;
import by.itacademy.waypoints.Waypoint;
import by.itacademy.waypoints.WaypointsData;

import java.util.*;

public class RandomRoute {
    private Set<Route> routes;
    private List<Waypoint> waypoints;
    private CheckForUnique checkForUnique;

    public RandomRoute(WaypointsData data) {
        this.routes = new HashSet<>();
        this.waypoints = data.getWaypoints();
        this.checkForUnique = new CheckForUnique();
    }

    public Set<Route> getRoutes() {
        return this.routes;
    }

    public void createRoute() {
        Route route;
        while (this.routes.size() < 15) {
            route = checkForUnique.uniqueCheck(new RouteCreate().createRouteEngine(), this.routes);
            this.routes.add(route);
        }
    }

    private class RouteCreate {
        private List<Integer> distances;

        RouteCreate() {
            this.distances = new ArrayList<>();
        }

        Route createRouteEngine() {
            Set<Waypoint> route = new TreeSet<>(Comparator.comparingInt(Waypoint::getDistanceFromBaseStation));
            int size = waypoints.size() - 1;
            Waypoint waypoint = waypoints.get((int) (Math.random() * 2) + size - 1);
            route.add(waypoint);
            while (route.size() < (int) (Math.random() * 7) + 3) {
                waypoint = getWaypoint(waypoint);
                route.add(waypoint);
            }
            return new Route(route);
        }

        private Waypoint getWaypoint(Waypoint previosWaypoint) {
            int index = (int) (Math.random() * waypoints.size());
            Waypoint waypoint = waypoints.get(index);
            if (!waypoint.getName().equals(previosWaypoint.getName()) && !this.distances.contains(waypoint.getDistanceFromBaseStation()) && waypoint.getBaseStation().equals(previosWaypoint.getBaseStation())) {
                distances.add(waypoint.getDistanceFromBaseStation());
                return waypoint;
            }
            return getWaypoint(previosWaypoint);
        }
    }
}
