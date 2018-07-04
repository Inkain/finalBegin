package by.itacademy.menu.found;

public enum FoundPoints {
    FIND_BY_NUMBER("1.Find by number"),
    FIND_BY_WAYPOINTS("2.Find by waypoints");

    private final String name;

    FoundPoints(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
