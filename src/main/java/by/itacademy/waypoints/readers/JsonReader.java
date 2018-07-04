package by.itacademy.waypoints.readers;

import by.itacademy.waypoints.Waypoint;
import by.itacademy.waypoints.WaypointsData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonReader implements Reader {
    private WaypointsData waypoints;
    private String fileName;
    private final Logger LOGGER = Logger.getLogger(JsonReader.class.getSimpleName());

    public JsonReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void readWaypoints() {
        try (InputStream reader = new URL(fileName).openConnection().getInputStream()) {
            {
                ObjectMapper mapper = new ObjectMapper();
                this.waypoints = mapper.readValue(reader, WaypointsData.class);
            }
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }

    @Override
    public List<Waypoint> getWaypoints() {
        return this.waypoints.getWaypoints();
    }
}

