package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class FindOcean {


    private static void markOcean(char[][] graph, int i, int j, char water, char ocean) {
        if (graph[i][j] != water || graph[i][j] == ocean) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        int mod = graph[0].length;
        ((LinkedList<Integer>) queue).add(i * mod + j);
        graph[i][j] = ocean;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int m = pos / mod;
            int n = pos % mod;

            if (m + 1 < graph.length && graph[m + 1][n] == water) {
                ((LinkedList<Integer>) queue).add((m + 1) * mod + n);
                graph[m + 1][n] = ocean;
            }
            if (m - 1 >= 0 && graph[m - 1][n] == water) {
                ((LinkedList<Integer>) queue).add((m - 1) * mod + n);
                graph[m - 1][n] = ocean;
            }
            if (n + 1 < graph[0].length && graph[m][n + 1] == water) {
                ((LinkedList<Integer>) queue).add(m * mod + n + 1);
                graph[m][n + 1] = ocean;
            }
            if (n - 1 >= 0 && graph[m][n - 1] == water) {
                ((LinkedList<Integer>) queue).add(m * mod + n - 1);
                graph[m][n- 1] = ocean;
            }
        }
    }

    private final static int[] dirX ={0, 0, 1, -1};
    private final static int[] dirY = {1, -1, 0, 0};
    private static int n;
    private static int m;
    private static void markOcean2(char[][] graph, int _x, int _y, char water, char ocean) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return;
        }
        n = graph.length;
        m = graph[0].length;
        Queue<Point> queue = new LinkedList<>();
        ((LinkedList<Point>) queue).add(new Point(_x, _y));
        graph[_x][_y] = ocean;
        while (!queue.isEmpty()) {
            Point curt = queue.poll();
            for (int i = 0; i < 4; i++) {
                int next_x = curt.x + dirX[i];
                int next_y = curt.y + dirX[i];
                if ( !inBound(next_x, next_y)|| graph[next_x][next_y] != water) {
                    continue;
                }
                graph[next_x][next_y] = ocean;
                ((LinkedList<Point>) queue).add(new Point(next_x, next_y));

            }
        }
    }

    private static boolean inBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}


class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
