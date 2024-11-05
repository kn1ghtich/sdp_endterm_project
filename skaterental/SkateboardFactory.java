package skaterental;

import skaterental.boards.Cruiser;
import skaterental.boards.Longboard;
import skaterental.boards.Skateboard;

import java.util.HashMap;
import java.util.Map;

public class SkateboardFactory {
    private static Map<String, Skateboard> boards = new HashMap<>();

    public SkateboardFactory(){
        boards.put("Cruiser", new Cruiser());
        boards.put("Longboard", new Longboard());
        boards.put("Classic", new Classic());
    }

    public Skateboard createSkateboard(String type) {
        if (boards.containsKey(type)) {
            return boards.get(type);
        } else {
            throw new IllegalArgumentException("No such board type: " + type);
        }
    }
}
