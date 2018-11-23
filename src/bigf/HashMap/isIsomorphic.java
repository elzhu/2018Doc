package bigf.HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class isIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) != value) {
                    return false;
                }
            } else {
                if(map.values().contains(value)) {
                    return false;
                }
                map.put(key, value);
                System.out.println("value used: " + value);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "add";
        String t = "egg";
        System.out.println(isIsomorphic(s, t));
    }
}
