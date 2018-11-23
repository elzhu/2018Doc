package leetcode.TopologicalSorting;

import java.util.*;

public class AlienOrder {
    public static String alienOrder(String[] words) {
        StringBuilder res = new StringBuilder();
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();

        for (String word : words) {
            for(Character c : word.toCharArray()) {

                    degree.put(c, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String previous = words[i - 1];
            String current = words[i];

            int minLength = Math.min(previous.length(), current.length());

            for (int j = 0; j < minLength; j++) {
                Character previousChar = previous.charAt(j);
                Character currentChar = current.charAt(j);

                if (previousChar != currentChar) {

                    Set<Character> set=new HashSet<Character>();

                    if (map.containsKey(previousChar)) {
                        set = map.get(previousChar);
                    }
                    if (!set.contains(currentChar)) {
                        set.add(currentChar);
                        map.put(previousChar, set);
                        int newValue = degree.get(currentChar) + 1;
                        degree.put(currentChar, newValue);
                        System.out.println("current degree of : " + currentChar + " is : " + newValue);
                    }
                    //break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<Character>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                ((LinkedList<Character>) queue).add(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.remove();
            res.append(c);
            System.out.println("--------res append : " + c);
            if (map.containsKey(c)) {
                for (char c1 : map.get(c)) {
                    int currentValue = degree.get(c1)  - 1;
                    degree.put(c1, currentValue);


                    if (degree.get(c1) == 0) {
                        ((LinkedList<Character>) queue).add(c1);
                    }
                }
            }
        }
        if(res.length()!=degree.size()) return "";
        return res.toString();
    }

    public static void main(String[] args) {
        String[] words = {"za","zb","ca","cb"};
        System.out.println("----alienOrder : " + alienOrder(words));
    }
}
