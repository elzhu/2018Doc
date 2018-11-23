package old;

public class checkRecord {
    public static boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int numberA = 0;
        int numberL = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                numberA++;
            } else if (ch == 'L') {
                numberL++;
            } else {
                continue;
            }
        }
        if (numberA>1 || numberL > 2) {
            return false;
        }
        return true;
    }

    public boolean checkRecordsimple(String s) {
        return !s.contains("LLL") && s.indexOf('A') == s.lastIndexOf('A');
    }

    public static void main(String [ ] args)
    {
        String s = "ALLPPPPA";

        System.out.println("leetcode.Aug.checkRecord: " + checkRecord(s));
    }
}
