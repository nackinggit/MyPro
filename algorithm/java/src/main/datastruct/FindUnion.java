package datastruct;

import java.util.*;

public class FindUnion {
    Map<Integer, Set<Integer>> coned = new HashMap<>();
    Map<Integer, Integer> nodes = new HashMap<>();

    public int makeConnected(int n, int[][] connections) {
        if (connections.length == 0) {
            return 0;
        }
        // If we don't have enough edges in the graph, it cannot be connected.
        if (connections.length < n - 1) {
            return -1;
        }

        //Assign each node to a disjoint set.
        //There will be at max N disjoint sets for N nodes.
        for (int i=0; i<n; i++) {
            HashSet<Integer> singletonSet = new HashSet<>();
            singletonSet.add(i);
            coned.put(i, singletonSet);
            nodes.put(i, i);
        }

        for (int[] connection : connections) {
            int lNode = connection[0];
            int rNode = connection[1];
            union(lNode, rNode);
            System.out.println(lNode + "," + rNode + ":");
            System.out.println(coned);
            System.out.println(nodes);
        }

        return coned.keySet().size() - 1;
    }

    //Join the set which contains lNode with the set that contains rNode.
    private void union(int left, int right) {
        int lpair = nodes.get(left);
        int rpair = nodes.get(right);
        if (lpair == rpair) {
            return;
        }

        //Make the right nodes become part of the left set.
        Set<Integer> lNodes = coned.get(lpair);
        Set<Integer> rNodes = coned.get(rpair);
        for (Integer node : rNodes) {
            nodes.put(node, lpair);
            lNodes.add(node);
        }
        coned.put(lpair, lNodes);
        coned.remove(rpair);
    }

    public static void main(String[] args) {
        int[][] connections = {{0,1},{0,2},{3,4},{2,3}};
        FindUnion findUnion = new FindUnion();
        System.out.println(findUnion.makeConnected(5, connections));
    }
}
