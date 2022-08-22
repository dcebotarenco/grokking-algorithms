package io.bugdone.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Greedy {
    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        HashSet<String> finalStations = new HashSet<>();

        HashMap<String, Set<String>> stations = new HashMap<>();
        stations.put("kfive", Set.of("ca", "az"));
        stations.put("ktwo", Set.of("wa", "id", "mt"));
        stations.put("kone", Set.of("id", "nv", "ut"));
        stations.put("kthree", Set.of("or", "nv", "ca"));
        stations.put("kfour", Set.of("nv", "ut"));

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> bestStationCoverage = new HashSet<>();
            for (Map.Entry<String, Set<String>> entry : stations.entrySet()) {
                Set<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(entry.getValue());
                if (covered.size() > bestStationCoverage.size()) {
                    bestStation = entry.getKey();
                    bestStationCoverage = covered;
                }
            }
            if (bestStation != null) {
                finalStations.add(bestStation);
            }
            statesNeeded.removeIf(bestStationCoverage::contains);
        }
        System.out.println(finalStations);

    }

    private void bestStation() {


    }
}
