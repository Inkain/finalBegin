package by.itacademy.menu.found;

import by.itacademy.consoleInput.ConsoleInput;
import by.itacademy.menu.Menu;
import by.itacademy.menu.main.MainMenu;
import by.itacademy.menu.sort.SortMenu;
import by.itacademy.routes.Route;
import by.itacademy.routes.RoutesData;
import by.itacademy.routes.routesOperations.OperationsData;
import by.itacademy.routes.routesOperations.foundOperations.FoundOperations;

import java.util.Set;

public class FoundMenu extends Menu {
    private OperationsData operations;
    private RoutesData data;

    public FoundMenu(RoutesData data) {
        this.operations = new OperationsData();
        this.data = data;
        showMenu(FoundPoints.values());
    }

    @Override
    public void startMenu() {
        FoundOperations operation = operations.getFoundOperations().get(ConsoleInput.choosePoint() - 1);
        String operationType = operation.getClass().getSimpleName();
        Set<Route> routes = operationType.equals("FindByNumber") ? operation.getData(data.getRoutes(), ConsoleInput.choosePoint())
                : operation.getData(data.getRoutes(), ConsoleInput.chooseWaypoint(), ConsoleInput.chooseWaypoint());
        routes.forEach(Route::show);
        if (!routes.isEmpty()) new SortMenu(routes).startMenu();
        else new MainMenu().startMenu();
    }
}

