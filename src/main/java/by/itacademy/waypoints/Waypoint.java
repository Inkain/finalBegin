package by.itacademy.waypoints;


import java.util.Objects;

public class Waypoint {
    private String name;
    private int distanceFromBaseStation;
    private String baseStation;


    public Waypoint(String name, int distanceFromBaseStation, String baseStation) {
        this.name = name;
        this.distanceFromBaseStation = distanceFromBaseStation;
        this.baseStation = baseStation;
    }

    public Waypoint() {
    }

    public String getName() {
        return name;
    }

    public int getDistanceFromBaseStation() {
        return distanceFromBaseStation;
    }

    public String getBaseStation() {
        return baseStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waypoint waypoint = (Waypoint) o;
        return Objects.equals(name, waypoint.name) &&
                Objects.equals(baseStation, waypoint.baseStation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, baseStation);
    }
}
