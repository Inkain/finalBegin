package by.itacademy.menu.main;

import by.itacademy.consoleInput.ConsoleInput;
import by.itacademy.menu.Menu;
import by.itacademy.menu.found.FoundMenu;
import by.itacademy.menu.sort.SortMenu;
import by.itacademy.routes.RoutesData;

public class MainMenu extends Menu {
    private RoutesData data;

    public MainMenu() {
        this.data = RoutesData.getData();
    }

    @Override
    public void startMenu() {
        showMenu(MainPoints.values());
        int index = ConsoleInput.choosePoint();
        if (index != 1 && index != 2 && index != 3) {
            System.out.println("Incorrect operation,try again");
            startMenu();
        }
        if (index != 3) {
            Menu menu = (index == 1) ? new SortMenu(data.getRoutes()) : new FoundMenu(data);
            menu.startMenu();
        }
    }
}


