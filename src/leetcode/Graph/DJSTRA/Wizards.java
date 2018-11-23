package leetcode.Graph.DJSTRA;

import java.util.*;

public class Wizards {
    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
        List<Integer> res = new ArrayList<>();
        if (wizards == null || wizards.size() == 0) {
            return res;
        }
        int n = wizards.size();
        int[] parent = new int[n];

        Map<Integer, Wizard> map = new HashMap<>();

        Queue<Wizard> queue = new PriorityQueue<>(n);

        queue.offer(map.get(source));

        while (!queue.isEmpty()) {
            Wizard curr = queue.poll();
            List<Integer> neighbours = wizards.get(curr.id);
            for (int neighbour : neighbours) {
                Wizard next = map.get(neighbour);
                int weight = (int) Math.pow(next.id - curr.id, 2);
                if (curr.dist + weight < next.dist) {
                    parent[next.id] = curr.id;
                    queue.remove(next);
                    next.dist = curr.dist + weight;
                    queue.offer(next);
                }
            }
        }

        int t = target;
        while ( t != source) {
            res.add(t);
            t = parent[t];
        }
        res.add(source);
        Collections.reverse(res);
        return res;
    }
}

class Wizard {
    int id;
    int dist;

    public Wizard(int id, int dist) {
        //id
        this.id = id;
        //cost
        this.dist = dist;
    }
}