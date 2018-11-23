package ab.Sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalidromPair {
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String firstPart = words[i].substring(0, j);
                String secondPart = words[i].substring(j);
                System.out.println("------firstPart : " + firstPart);
                System.out.println("------secondPart : " + secondPart);
                if (isPalindrome(firstPart)) {
                    String secondReverse = new StringBuilder(secondPart).reverse().toString();
                    if (map.containsKey(secondReverse) && map.get(secondReverse) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(secondReverse));
                        list.add(i);
                        res.add(list);
                    }
                }

                if (isPalindrome(secondPart)) {
                    String firstReverse = new StringBuilder(firstPart).reverse().toString();
                    if (map.containsKey(firstReverse) && map.get(firstReverse) != i && secondPart.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(firstReverse));
                        res.add(list);
                    }
                }
            }

        }
        return res;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> res = palindromePairs(words);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
