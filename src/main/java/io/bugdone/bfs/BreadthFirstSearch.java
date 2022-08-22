package io.bugdone.bfs;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class BreadthFirstSearch {

    /**
     * O(V + E)
     * V - vertices
     * E - edges
     */
    public static void main(String[] args) {

        Map<String, List<String>> directedGraph = new HashMap<>();
        directedGraph.put("me", List.of("f1", "f2", "f3"));
        directedGraph.put("f1", List.of("f1.1", "f1.2"));
        directedGraph.put("f1.1", Collections.emptyList());
        directedGraph.put("f1.2", Collections.emptyList());
        directedGraph.put("f2", List.of("f2.1"));
        directedGraph.put("f3", Collections.emptyList());
        directedGraph.put("f2.1", List.of("f2.1.1"));
        directedGraph.put("f2.1.1", Collections.emptyList());

        Queue<String> searchList = new ArrayDeque<>();
        searchList.addAll(directedGraph.get("me"));

        HashSet<String> searched = new HashSet<>();

        while (!searchList.isEmpty()) {
            String person = searchList.poll();
            if (!searched.contains(person)) {
                if (isMangoSeller(person)) {
                    System.out.printf("Mango seller %s%n", person);
                    return;
                }
                searchList.addAll(directedGraph.get(person));
                searched.add(person);
            }
        }

    }

    private static boolean isMangoSeller(String person) {
        return person.strip().endsWith(".1.1");
    }


}
