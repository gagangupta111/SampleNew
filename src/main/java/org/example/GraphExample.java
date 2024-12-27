package org.example;

import org.example.structures.GraphNode;

import java.util.*;

public class GraphExample {

    public static void main(String[] args){

        GraphNode graphNode1 = new GraphNode();
        graphNode1.value = 1;

        GraphNode graphNode2 = new GraphNode();
        graphNode2.value = 2;

        GraphNode graphNode3 = new GraphNode();
        graphNode3.value = 3;

        GraphNode graphNode4 = new GraphNode();
        graphNode4.value = 4;

        graphNode1.nodes = new ArrayList<>();
        graphNode1.nodes.add(graphNode2);

        List<GraphNode> graph = new ArrayList<>();
        graph.add(graphNode1);
        graph.add(graphNode2);
        graph.add(graphNode3);
        graph.add(graphNode4);

        System.out.println(numOfProvices(graph));
    }

    public static int numOfProvices(List<GraphNode> graph){

        Set<Set<GraphNode>> setOfSets = new HashSet<>();
        for (GraphNode graphNode : graph){
            if (!isVisited(setOfSets, graphNode)){
                Set<GraphNode> set = new HashSet<>();
                setOfSets.add(findConnectedGraph(graphNode, set));
            }
        }
        return setOfSets.size();
    }

    public static boolean isVisited(Set<Set<GraphNode>> setOfSets, GraphNode graphNode){

        for (Set<GraphNode> set : setOfSets){
            if (set.contains(graphNode)){
                return true;
            }
        }
        return false;
    }

    public static Set<GraphNode> findConnectedGraph(GraphNode graph, Set<GraphNode> graphNodes){

        graphNodes.add(graph);
        for (GraphNode graphNode : graph.nodes){
            if (!graphNodes.contains(graphNode)){
                graphNodes.addAll(findConnectedGraph(graphNode, graphNodes));
            }
        }
        return graphNodes;
    }
}
