package old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class largeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        for (int i = 1; i <= S.length(); i++) {
            if (i == S.length() || S.charAt(i) != S.charAt(start)) {
                if (i - start >= 3) {
                    res.add(Arrays.asList(start, i - 1));
                }
                start = i;
            }
        }
        return res;
    }
}
