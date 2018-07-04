package by.itacademy.menu.sort;

import by.itacademy.consoleInput.ConsoleInput;
import by.itacademy.menu.Menu;
import by.itacademy.menu.main.MainMenu;
import by.itacademy.routes.Route;
import by.itacademy.routes.routesOperations.OperationsData;
import by.itacademy.routes.routesOperations.sortOpertations.Sort;

import java.util.Set;

public class SortMenu extends Menu {
    private OperationsData operations;
    private Set<Route> routes;
    private Menu mainMenu;
    private Sort sort;

    public SortMenu(Set<Route> routes) {
        this.operations = new OperationsData();
        this.routes = routes;
        this.sort = new Sort();
        this.mainMenu = new MainMenu();
        showMenu(SortPoints.values());
    }

    @Override
    public void startMenu() {
        int index = ConsoleInput.choosePoint();
        if (index < 1 || index > 6) {
            System.out.println("Incorrect operation,try again");
            startMenu();
        }
        if (index < 5) showResult(sort.sort(routes, operations.getSortOperations().get(index - 1)));
        else if (index == 5) showResult(routes);
        else mainMenu.startMenu();
        mainMenu.startMenu();
    }

    private void showResult(Set<Route> result) {
        result.forEach(Route::show);
    }
}
