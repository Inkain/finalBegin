package by.itacademy.routes.routesOperations.sortOperations;

import by.itacademy.routes.Route;
import by.itacademy.routes.routesOperations.sortOpertations.Sort;
import by.itacademy.routes.routesOperations.sortOpertations.SortByNumber;
import by.itacademy.waypoints.Waypoint;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

public class SortByNumberTest {
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
        int x = 0, y = 1;
        for (int i = 0; i < 3; i++) {
            Set<Waypoint> route = new TreeSet<>(Comparator.comparingInt(Waypoint::getDistanceFromBaseStation));
            route.add(waypoints.get(x));
            route.add(waypoints.get(y));
            routes.add(new Route(route));
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
    public void testNotNullSortByNumber() {
        Sort instance = new Sort();
        Assert.assertNotNull(instance.sort(routes, new SortByNumber()));
    }

    @Test
    public void testSortByNumber() {
        Sort instance = new Sort();
        int i = 0;
        for (Route route : instance.sort(routes, new SortByNumber())) {
            if (i == 0) Assert.assertEquals(1, route.getRouteNumber());
            if (i == 1) Assert.assertEquals(2, route.getRouteNumber());
            if (i == 2) Assert.assertEquals(3, route.getRouteNumber());
            i++;
        }
    }
}
