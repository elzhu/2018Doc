package old;

public class reverseOnlyLetters {
    public static String reverseOnlyLetters(String S) {
        char[] reversed = new char[S.length()];

        for (int i = 0 ; i < S.length(); i++) {
            if (!Character.isLetterOrDigit(S.charAt(i))) {
                reversed[i] = S.charAt(i);
                System.out.println("reversed[i]" + reversed[i]);
            }else {
               // reversed[i] = '*';
                System.out.println("S.charAt(i): " + reversed[i]);
            }
        }

        int start = 0;

        int end = S.length() - 1;
        while (start < S.length()) {
            if (reversed[start] == '\0') {
                if (!Character.isLetterOrDigit(S.charAt(end))) {
                    end--;
                }
                reversed[start] = S.charAt(end);
                System.out.println("reversed[start] : " + reversed[start]);
                start++;
                end--;
            }else {
                start++;
            }
        }

        return new String(reversed);
    }

    public static void main(String[] args) {
        String input = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(input));
    }
}
