package by.itacademy.routes.routesOperations.foundOperations;

import by.itacademy.routes.Route;
import by.itacademy.waypoints.Waypoint;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

public class FindByWaypointsTest {
    private static List<Waypoint> waypoints = new ArrayList<>();
    private static Set<Route> routes = new HashSet<>();

    @BeforeClass
    public static void setUpRoutesData() {
        waypoints.add(new Waypoint("Нарочанская", 1, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Лермонтова", 8, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Васечкина", 4, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Пушкина", 5, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Толстого", 7, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Менделеева", 2, "ДС ВЕСНЯНКА"));
        int x = 0, y = 1, z = 2;
        for (int i = 0; i < 2; i++) {
            Set<Waypoint> route = new TreeSet<>(Comparator.comparingInt(Waypoint::getDistanceFromBaseStation));
            route.add(waypoints.get(x));
            route.add(waypoints.get(y));
            route.add(waypoints.get(z));
            routes.add(new Route(route));
            x += 1;
            y += 2;
            z += 3;
        }
    }

    @BeforeClass
    public static void reset() {
        try {
            Route route = new Route(new HashSet<>());
            Field fieldA = route.getClass().getDeclaredField("index");
            fieldA.setAccessible(true);
            fieldA.set(route, 1);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByWaypoints() {
        FindByWaypoints operation = new FindByWaypoints();
        Set<Waypoint> waypointSet = new TreeSet<>(Comparator.comparingInt(Waypoint::getDistanceFromBaseStation));
        waypointSet.add(waypoints.get(0));
        waypointSet.add(waypoints.get(1));
        waypointSet.add(waypoints.get(2));
        Route routeCheck = new Route(waypointSet);
        for (Route route : operation.getData(routes, "Нарочанская", "Васечкина")) {
            Assert.assertEquals(route, routeCheck);
        }
    }
}
