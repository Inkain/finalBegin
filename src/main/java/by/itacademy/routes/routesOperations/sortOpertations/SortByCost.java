package by.itacademy.routes.routesOperations.sortOpertations;

import by.itacademy.routes.Route;

import java.util.Comparator;


public class SortByCost implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        if (((int) (o1.getRouteCost() - o2.getRouteCost()) == 0)) return 1;
        else return (int) (o1.getRouteCost() - o2.getRouteCost());
    }
}
