package leetcode.HashMap;

import java.util.*;

public class guessNumber {
    public static String guess() {
        List<Integer> res = new ArrayList<>();
        List<Integer> cands = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        int counter = 0;
        Iterator<Integer> iter = cands.iterator();
        while (iter.hasNext() && res.size() < 4) {
            int cand = iter.next();
            int guessedCount = res.size();
            String guessCand = genNumber(res, cand);
            int guessRes = guessServer(guessCand);
            if (guessRes == guessedCount) {
                iter.remove();
            } else if (guessRes > guessedCount){
                for (int i=guessedCount; i< guessRes; i++) {
                    res.add(cand);
                }
                iter.remove();
            } else {
                // something wrong here
                return genNumber(res);
            }
        }

        //System.out.println(res.size());
        if (res.size() < 4) {
            for (int i = res.size(); i < 4; i++) {
                res.add(6);
            }
        }
        // System.out.println("guessed " + counter + " times");
        return genNumber(res);
    }

    private static String genNumber(List<Integer> guessed, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guessed.size(); i++) {
            sb.append(guessed.get(i));
        }
        for (int i = guessed.size(); i < 4; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String genNumber(List<Integer> guessed) {
        if (guessed == null || guessed.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guessed.size(); i++) {
            sb.append(guessed.get(i));
        }
        return sb.toString();
    }

    //这个版本只能handle每次server只返回一位数字，表明guess中有几位存在于target中，因此最后只能求出target中的数字的组合，并不能知道排列
    //如果需要Permutation的话，需要返回2位数字，类似于Bulls and Cows
    private static int guessServer(String guess) {
        int res = 0;
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : target.toCharArray())
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        Map<Character, Integer> guessMap = new HashMap<>();
        for (char c : guess.toCharArray())
            guessMap.put(c, guessMap.getOrDefault(c, 0) + 1);
        for (char k : guessMap.keySet()) {
            if (targetMap.containsKey(k)) {
                res += Math.min(guessMap.get(k), targetMap.get(k));
            }
        }
        return res;
    }


    private static String target = "3536";
    public static void main(String args[])
    {
        System.out.println(guess());
    }
}
