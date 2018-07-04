package by.itacademy.routes.routesOperations.sortOpertations;

import by.itacademy.routes.Route;

import java.util.Comparator;

public class SortByTimeInWay implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        if (o1.getTimeInWay() - o2.getTimeInWay() == 0) return 1;
        else return o1.getTimeInWay() - o2.getTimeInWay();
    }
}
