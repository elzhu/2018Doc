package leetcode.BFS;

import java.util.*;

public class BusRoutes {
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        Set<Integer> visited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Integer> queue = new LinkedList<>();

        int res = 0;

        if (S == T) {
            return 0;
        }

        //graph
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }
        // BFS in graph
        ((LinkedList<Integer>) queue).add(S);

        while (!queue.isEmpty()) {
            int len  = queue.size();
            res++;
            System.out.println("len : " + len);
            System.out.println("res : " + res);
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                System.out.println("dequeue : cur:" + cur);
                ArrayList<Integer> buses = map.get(cur);
                for (Integer bus : buses) {
                    if (visited.contains(bus)) {
                        continue;
                    }
                    System.out.println("current bus :" + bus);
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) {
                            return res;
                        }
                        System.out.println("inqueue : routes[bus][j]:" + routes[bus][j]);
                        ((LinkedList<Integer>) queue).add(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = {{1,2,7}, {3,6,7}};
        int S = 1;
        int T = 6;
        System.out.println(numBusesToDestination(routes, S, T));
    }
}
