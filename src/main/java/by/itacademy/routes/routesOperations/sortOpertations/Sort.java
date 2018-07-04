package by.itacademy.routes.routesOperations.sortOpertations;

import by.itacademy.routes.Route;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Sort {
    public Set<Route> sort(Set<Route> routes, Comparator comparator) {
        Set<Route> toSort = new TreeSet<>(comparator);
        toSort.addAll(routes);
        return toSort;
    }
}
