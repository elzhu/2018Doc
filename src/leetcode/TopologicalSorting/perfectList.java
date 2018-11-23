package leetcode.TopologicalSorting;

import java.util.*;

public class perfectList {
    public List<Integer> getPerfectList(List<List<Integer>> preferences) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> degree = new HashMap<Integer, Integer>();
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

        for(List<Integer> list : preferences) {
            for (int i = 0; i < list.size() - 1; i++) {
                int from = list.get(i);
                int to = list.get(i + 1);
                if (!map.containsKey(from)) {
                    degree.put(from, 0);
                    map.put(from, new HashSet<>());
                }
                if (!map.containsKey(to)) {
                    degree.put(to, 0);
                    map.put(to, new HashSet<>());
                }
                if (!map.get(from).contains(to)) {
                    Set<Integer> set = map.get(from);
                    set.add(to);
                    map.put(from, set);
                }
                degree.put(to, degree.getOrDefault(to, 0) + 1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int k : degree.keySet()) {
            if (degree.get(k) == 0) {
                ((LinkedList<Integer>) q).add(k);
            }
        }

        while (!q.isEmpty()){
            Integer current = q.poll();
            res.add(current);
            Set<Integer> neighbours = map.get(current);
            for (int i : neighbours) {
                int weight = degree.get(i) - 1;
                degree.put(i, weight);
                if (degree.get(i) == 0) {
                    ((LinkedList<Integer>) q).add(i);
                }
            }
        }

        return res;
    }
}
