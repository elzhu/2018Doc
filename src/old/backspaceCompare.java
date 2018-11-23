package old;

public class backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return process(S).equals(process(T));
    }

    public String process(String str) {
        String res = "";
        int n=str.length(), count=0;
        if (str == null || str.length() == 0) {
            return res;
        }
        for(int i=n-1; i>=0; i--) {
            char ch = str.charAt(i);
            if (ch == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res += ch;
                }
            }
        }
        return res;
    }
}
