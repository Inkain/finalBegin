package by.itacademy.menu.main;

enum MainPoints {
    SHOW_ROUTES("1.Show all routes"),
    FIND_ROUTES("2.Find route"),
    EXIT("3-Exit");

    private final String name;

    MainPoints(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

