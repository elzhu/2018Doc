package old;

import java.util.ArrayList;
import java.util.List;

public class allPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTargetHelper(graph, res, path, 0);
        return res;
    }

    public void allPathsSourceTargetHelper(int[][] graph, List<List<Integer>> res,List<Integer> path,  int node) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            allPathsSourceTargetHelper(graph, res, path, nextNode);
            path.remove(path.size() - 1);
        }

    }
}
