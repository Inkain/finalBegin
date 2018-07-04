package by.itacademy.routes.routesOperations.sortOpertations;

import by.itacademy.routes.Route;

import java.util.Comparator;

public class SortByStartTime implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        return o1.getStartTime().compareTo(o2.getStartTime());
    }
}
