package by.itacademy.menu.sort;

public enum SortPoints {
    SORT_BY_WAYPOINTS("1.Sort by waypoints"),
    SORT_BY_COST("2.Sort by cost"),
    SORT_BY_STARTTIME("3.Sort by start time"),
    SORT_BY_TIMEINWAY("4.Sort by time in way"),
    SORT_BY_DEFAULT("5.Sort by number"),
    EXIT("6.Back to main menu");

    private final String name;

    SortPoints(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

