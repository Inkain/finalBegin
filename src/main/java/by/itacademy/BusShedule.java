package by.itacademy;

import by.itacademy.menu.main.MainMenu;

public class BusShedule {
    private MainMenu menu;

    public BusShedule() {
        this.menu = new MainMenu();
    }

    public void start() {
        this.menu.startMenu();
    }
}
