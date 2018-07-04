package by.itacademy.menu;

import by.itacademy.consoleInput.ConsoleInput;

public abstract class Menu<T> {
    protected ConsoleInput input;

    protected Menu() {
        this.input = ConsoleInput.getInstance();
    }

    protected void showMenu(T[] menuValues) {
        for (T menuPoints : menuValues)
            System.out.println(menuPoints);
    }

    abstract public void startMenu();
}
