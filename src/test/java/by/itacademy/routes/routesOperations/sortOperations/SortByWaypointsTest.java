package by.itacademy.routes.routesOperations.sortOperations;

import by.itacademy.routes.Route;
import by.itacademy.routes.routesOperations.sortOpertations.Sort;
import by.itacademy.routes.routesOperations.sortOpertations.SortByWaypoints;
import by.itacademy.waypoints.Waypoint;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

public class SortByWaypointsTest {
    private static Set<Route> routes = new HashSet<>();
    private static List<Waypoint> waypoints = new ArrayList<>();
    private static Route route1;
    private static Route route2;
    private static Route route3;

    @BeforeClass
    public static void setUpRoutesData() {
        waypoints.add(new Waypoint("Нарочанская", 1, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Лермонтова", 8, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Васечкина", 4, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Пушкина", 5, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Толстого", 7, "ДС ВЕСНЯНКА"));
        waypoints.add(new Waypoint("Менделеева", 2, "ДС ВЕСНЯНКА"));
        int x = 0, y = 1;
        for (int i = 0; i < 3; i++) {
            Set<Waypoint> route = new TreeSet<>(Comparator.comparingInt(Waypoint::getDistanceFromBaseStation));
            route.add(waypoints.get(x));
            route.add(waypoints.get(y));
            if (i == 0) routes.add(route1 = new Route(route));
            if (i == 1) routes.add(route2 = new Route(route));
            if (i == 2) routes.add(route3 = new Route(route));
            x += 2;
            y += 2;
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
    public void testNotNullSortByWaypoints() {
        Sort instance = new Sort();
        Assert.assertNotNull(instance.sort(routes, new SortByWaypoints()));
    }

    @Test
    public void testSortByWaypoints() {
        Sort instance = new Sort();
        int i = 0;
        for (Route route : instance.sort(routes, new SortByWaypoints())) {
            if (i == 0) Assert.assertEquals(route, route2);
            if (i == 1) Assert.assertEquals(route, route3);
            if (i == 2) Assert.assertEquals(route, route1);
            i++;
        }
    }
}
