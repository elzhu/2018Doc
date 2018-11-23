package old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class uncommonFromSentences {
    public String[] uncommonFromSentences(String A, String B) {
        String[] res = new String[A.length()];
        if (A == null || B == null) {
            return res;
        }
        HashMap<String, Integer> mapA = new HashMap<>();
        HashMap<String, Integer> mapB = new HashMap<>();
        String[] AString = A.split(" ");
        String[] BString = B.split(" ");
        for (String s : AString) {
            mapA.put(s, mapA.getOrDefault(s,0) + 1);
        }
        for (String s : BString) {
            mapB.put(s, mapB.getOrDefault(s,0) + 1);
        }
        int index = -1;
        for(String s : AString) {
            if (mapA.get(s) == 1 && !mapB.containsKey(s)) {
                res[index++] = s;
            }
        }
        for(String s : BString) {
            if (mapB.get(s) == 1 && !mapA.containsKey(s)) {
                res[index++] = s;
            }
        }
        return res;
    }

    public static String[] uncommonFromSentences2(String A, String B) {

        String[] AString = A.split(" ");
        String[] BString = B.split(" ");
        ArrayList<String> res = new ArrayList<>();

        if (AString.length <= 0 || BString.length <= 0) {
            return res.toArray(new String[0]);
        }

        Arrays.sort(AString);
        Arrays.sort(BString);
        AString = removeDup(AString);
        BString = removeDup(BString);
        int i = 0;
        int j = 0;
        while (i < AString.length && j < BString.length) {
            if (!AString[i].equals(BString[j])) {
                res.add(AString[i]);
                res.add(BString[j]);
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        if (i == AString.length) {
            while (j < BString.length) {
                res.add(BString[j]);
                j++;
            }
        }
        if (j == B.length()) {
            while (i < AString.length) {
                res.add(AString[i]);
                i++;
            }
        }

        return res.toArray(new String[0]);
    }

    public static String[] removeDup(String[] AString) {
        String[] res = new String[AString.length];
        if (AString.length <= 1) {
            return AString;
        }

        if (AString.length == 2 && AString[0].equals(AString[1])) {
            AString = new String[]{""};
        }

        int newi = -1;
        int i = 1;
      while (i < AString.length) {
          if (!AString[i].equals(AString[i - 1])) {
              res[newi++] = AString[i - 1];

          }
          i++;

      }
        return res;
    }

    public static void main(String [ ] args)
    {
        String A = "this apple is sweet";

        String B = "this apple is sour";
        System.out.println("uncommonFromSentences2: " + uncommonFromSentences2(A, B));
    }
}
