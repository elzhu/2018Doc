package leetcode.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pyramidTransition {
    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0,2);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s.substring(2));
        }
        return helper(bottom, map);
    }

    public static boolean helper(String bottom, Map<String, List<String>> map ) {
        if (bottom.length() == 1) {
            return true;
        }

        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i + 2))) {
                return false;
            }
        }
        List<String> ls = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), ls, map);
        for (String s : ls) {
            if (helper(s, map)) {
                return true;
            }
        }
        return false;
    }

    public static void getList(String bottom, int idx, StringBuilder sb, List<String> ls, Map<String, List<String>> map) {
        if (idx == bottom.length() - 1) {
            ls.add(sb.toString());
            return;
        }
        for(String s : map.get(bottom.substring(idx, idx + 2))) {
            sb.append(s);
            getList(bottom, idx + 1, sb, ls, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String bottom = "XYZ";
        List<String> allowed = new ArrayList<>();
        allowed.add("XYD");
        allowed.add("YZE");
        allowed.add("DEA");
        allowed.add("FFF");
        System.out.println(pyramidTransition(bottom, allowed));
    }
}
