package by.itacademy.routes;

import by.itacademy.routes.routeFactory.RandomRoute;
import by.itacademy.routes.routesOperations.sortOpertations.SortByNumber;
import by.itacademy.waypoints.WaypointsData;

import java.util.Set;
import java.util.TreeSet;

public class RoutesData {
    private static RoutesData data;
    private Set<Route> routes;

    private RoutesData() {
        this.routes = new TreeSet<>(new SortByNumber());
        WaypointsData waypointsData = new WaypointsData("waypoints.xml", "https://raw.githubusercontent.com/Inkain/finalResources/master/waypoints.json");
        RandomRoute randomRoute = new RandomRoute(waypointsData);
        randomRoute.createRoute();
        this.routes.addAll(randomRoute.getRoutes());
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public static RoutesData getData() {
        if (data == null) data = new RoutesData();
        return data;
    }
}
