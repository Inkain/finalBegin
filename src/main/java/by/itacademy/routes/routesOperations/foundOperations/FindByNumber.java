package by.itacademy.routes.routesOperations.foundOperations;

import by.itacademy.routes.Route;

import java.util.HashSet;
import java.util.Set;

public class FindByNumber implements FoundOperations {
    @Override
    public Set<Route> getData(Set<Route> data, Object... inputData) {
        Set<Route> routes = new HashSet<>();
        for (Route route : data)
            if (route.getRouteNumber() == Integer.valueOf(String.valueOf(inputData[0]))) routes.add(route);
        if (routes.isEmpty()) System.out.println("Don't have route by that number");
        return routes;
    }
}
