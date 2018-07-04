package by.itacademy.routes.routeFactory;

import by.itacademy.routes.Route;

import java.util.Set;

public class CheckForUnique {
    public Route uniqueCheck(Route route, Set<Route> routes) {
        for (Route checkRoute : routes) {
            if (checkRoute.equals(route)) {
                return new Route(checkRoute);
            }
        }
        return route;
    }
}
