package by.itacademy.routes.routesOperations.sortOpertations;

import by.itacademy.routes.Route;

import java.util.Comparator;

public class SortByNumber implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        if (o1.getRouteNumber() - o2.getRouteNumber() == 0) return 1;
        else return (o1.getRouteNumber() - o2.getRouteNumber());
    }
}
