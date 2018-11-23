package leetcode.Graph.DJSTRA;

import java.util.*;

public class CheapestFlight {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];


        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        Map<Integer, Integer> best = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0, src});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int cost = info[0];
            int k = info[1];
            int place = info[2];

            if (k > K || cost > best.getOrDefault(k * 100 + place,Integer.MAX_VALUE)) {
                continue;
            }

            if (place == dst) {
                return cost;
            }

            for (int i = 0; i < n; i++) {
                if (graph[place][i] > 0) {
                    int newCost = cost + graph[place][i];
                    if (newCost < best.getOrDefault(k * 100 + place, Integer.MAX_VALUE)) {
                        pq.add(new int[]{newCost, k + 1, i});
                        best.put((k + 1)* 100, newCost);
                    }
                }
            }
        }
        return -1;
    }
}
