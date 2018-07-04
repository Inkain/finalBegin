package by.itacademy.routes.routesFactory;

import by.itacademy.routes.Route;
import by.itacademy.routes.routeFactory.CheckForUnique;
import by.itacademy.waypoints.Waypoint;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CheckForUniqueTest {

    @Test
    public void checkForUniqueRoute() {
        Set<Waypoint> waypoints = new TreeSet<>(Comparator.comparingInt(Waypoint::getDistanceFromBaseStation));
        waypoints.add(new Waypoint("Нарочанская", 1, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Лермонтова", 8, "ДС ВЕСНЯНКА"));
        Route route1 = new Route(waypoints);
        Set<Route> routes = new HashSet<>();
        routes.add(route1);
        Assert.assertEquals(route1.getRouteNumber(), new CheckForUnique().uniqueCheck(new Route(waypoints), routes).getRouteNumber());
    }

}
