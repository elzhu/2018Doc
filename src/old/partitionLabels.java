package old;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public static List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println("map[i]" + map[i]);
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

    public static void main(String [ ] args)
    {
        String S = "ababcbacadefegdehijhklij";

        System.out.println("leetcode.Aug.partitionLabels: " + partitionLabels(S));
    }
}
