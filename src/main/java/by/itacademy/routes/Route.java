package by.itacademy.routes;

import by.itacademy.waypoints.Waypoint;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Route {
    private int routeNumber;
    private float routeCost;
    private Set<Waypoint> waypoints;
    private LocalDateTime startTime;
    private int timeInWay;
    private static int index = 1;
    private int maxDistance;

    public Route(Set<Waypoint> waypoints) {
        this.waypoints = waypoints;
        this.routeNumber = index;
        this.startTime = LocalDateTime.now().plusMinutes((int) (Math.random() * 800));
        countCost();
        this.timeInWay = this.maxDistance * 10 + this.waypoints.size() * 2;
        index++;
    }

    public Route(Route route) {
        this.waypoints = route.getWaypoints();
        this.routeNumber = route.getRouteNumber();
        this.startTime = LocalDateTime.now().plusMinutes((int) (Math.random() * 800));
        countCost();
        this.timeInWay = route.getTimeInWay();
    }

    public Set<Waypoint> getWaypoints() {
        return waypoints;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public float getRouteCost() {
        return routeCost;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getTimeInWay() {
        return timeInWay;
    }

    public void show() {
        System.out.printf("%d ", routeNumber);
        Iterator<Waypoint> iterator = waypoints.iterator();
        String waypointName;
        while (iterator.hasNext()) {
            waypointName = iterator.next().getName();
            System.out.print(iterator.hasNext() ? waypointName + "-" : waypointName + " ");
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM.dd kk-mm");
        System.out.printf("%sруб %s %s%n", routeCost, startTime.format(format), timeInWay);
    }

    private void countCost() {
        for (Waypoint waypoint : this.waypoints) {
            if (waypoint.getDistanceFromBaseStation() > this.maxDistance) {
                this.maxDistance = waypoint.getDistanceFromBaseStation();
            }
        }
        this.routeCost = this.maxDistance * 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;
        Route route = (Route) o;
        return Objects.equals(getWaypoints(), route.getWaypoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWaypoints());
    }
}
