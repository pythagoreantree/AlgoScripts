package com.maria.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphUtils {

    public static Map<String, List<Edge>> getAdjList(List<CharEdge> graphList) {
        Map<String, List<Edge>> map = new HashMap<>();
        for (CharEdge edge: graphList) {
            if (!map.containsKey(edge.from))
                map.put(edge.from, new ArrayList<>());
            if (edge.to != null) {
                List<Edge> list = map.get(edge.from);
                list.add(new Edge(edge.to, edge.weight));
                map.put(edge.from, list);
            }
        }
        return map;
    }
}
