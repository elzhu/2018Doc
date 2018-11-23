package leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class palindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        if (words == null || words.length < 2) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); i++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalidrome(str1)) {
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rev) && map.get(str2rev) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str2rev));
                        res.add(list);
                    }
                }
                if (isPalidrome(str2)) {
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rev) && map.get(str1rev) != i && str2.length()!= 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str1rev));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalidrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) !=  str.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
