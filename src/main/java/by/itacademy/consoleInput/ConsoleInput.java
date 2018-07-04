package by.itacademy.consoleInput;

import by.itacademy.menu.Menu;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleInput {
    private static Scanner scanner;
    private final static Logger LOGGER = Logger.getLogger(Menu.class.getSimpleName());

    private ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    public static ConsoleInput getInstance() {
        return ConsoleInputSingleton.instance;
    }

    public static int choosePoint() {
        String index = scanner.nextLine();
        if (!index.matches("[-+]?\\d+")) {
            LOGGER.log(Level.INFO, "This must be number!! Try again!!");
            return choosePoint();
        }
        return Integer.parseInt(index);
    }

    public static String chooseWaypoint() {
        System.out.println("Input station");
        return scanner.nextLine();
    }

    private static class ConsoleInputSingleton {
        private static final ConsoleInput instance = new ConsoleInput();
    }
}
