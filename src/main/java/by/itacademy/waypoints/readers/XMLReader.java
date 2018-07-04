package by.itacademy.waypoints.readers;

import by.itacademy.waypoints.Waypoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLReader implements Reader {
    private DocumentBuilderFactory INPUT_FACTORY = DocumentBuilderFactory.newInstance();
    private List<Waypoint> waypoints;
    private String fileName;
    private final Logger LOGGER = Logger.getLogger(XMLReader.class.getSimpleName());

    public XMLReader(String fileName) {
        this.waypoints = new ArrayList<>();
        this.fileName = fileName;
    }

    @Override
    public void readWaypoints() {
        try {
            File xmlFile = new File(XMLReader.class.getClassLoader().getResource(fileName).getFile());
            DocumentBuilder builder = INPUT_FACTORY.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("station");
            readEngine(nList);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }

    private void readEngine(NodeList nList) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String baseStation = eElement.getElementsByTagName("BaseStation").item(0).getTextContent();
                int distance = Integer.valueOf(eElement.getElementsByTagName("distanceFromBaseStation").item(0).getTextContent());
                this.waypoints.add(new Waypoint(name, distance, baseStation));
            }
        }
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }
}
