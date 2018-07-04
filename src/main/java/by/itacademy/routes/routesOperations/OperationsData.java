package by.itacademy.routes.routesOperations;

import by.itacademy.routes.Route;
import by.itacademy.routes.routesOperations.foundOperations.FindByNumber;
import by.itacademy.routes.routesOperations.foundOperations.FindByWaypoints;
import by.itacademy.routes.routesOperations.foundOperations.FoundOperations;
import by.itacademy.routes.routesOperations.sortOpertations.SortByCost;
import by.itacademy.routes.routesOperations.sortOpertations.SortByStartTime;
import by.itacademy.routes.routesOperations.sortOpertations.SortByTimeInWay;
import by.itacademy.routes.routesOperations.sortOpertations.SortByWaypoints;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OperationsData {
    private List<FoundOperations> foundOperations;
    private List<Comparator<Route>> sortOperations;

    public OperationsData() {
        this.foundOperations = new ArrayList<>();
        this.foundOperations.add(new FindByNumber());
        this.foundOperations.add(new FindByWaypoints());
        this.sortOperations = new ArrayList<>();
        this.sortOperations.add(new SortByWaypoints());
        this.sortOperations.add(new SortByCost());
        this.sortOperations.add(new SortByStartTime());
        this.sortOperations.add(new SortByTimeInWay());
    }

    public List<FoundOperations> getFoundOperations() {
        return foundOperations;
    }

    public List<Comparator<Route>> getSortOperations() {
        return sortOperations;
    }
}
