package by.itacademy.routes.routesOperations.foundOperations;

import by.itacademy.routes.Route;

import java.util.Set;

public interface FoundOperations {
    Set<Route> getData(Set<Route> data, Object... inputData);
}
