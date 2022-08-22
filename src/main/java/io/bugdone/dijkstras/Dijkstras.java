package io.bugdone.dijkstras;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Dijkstras {

    public static void main(String[] args) {
        HashMap<String, Map<String, Double>> graph = new HashMap<>();
        HashMap<String, Double> costs = new HashMap<>();
        HashMap<String, String> parents = new HashMap<>();
        Set<String> processed = new HashSet<>();


        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6d);
        graph.get("start").put("b", 2d);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1d);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3d);
        graph.get("b").put("fin", 5d);

        graph.put("fin", new HashMap<>());

        costs.put("a", 6d);
        costs.put("b", 2d);
        costs.put("fin", Double.POSITIVE_INFINITY);


        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        String node = findClosesNode(costs, processed); //B
        while (node != null) {
            Double cost = costs.get(node); //2
            Map<String, Double> neighbours = graph.get(node); //a:3, fin:5
            for (String neighbour : neighbours.keySet()) { //a, fin
                Double newCost = cost + neighbours.get(neighbour); //2+3=5, 2+5=7
                if (costs.get(neighbour) > newCost) {
                    costs.put(neighbour, newCost); //replace 6 with 5, replace infinity with 7
                    parents.put(neighbour, node); //and change to the cheapest parent
                }
            }
            processed.add(node);
            node = findClosesNode(costs, processed);
        }

    }

    private static String findClosesNode(HashMap<String, Double> costs, Set<String> processed) {
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;
        for (String node : costs.keySet()) {
            Double cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }
}
