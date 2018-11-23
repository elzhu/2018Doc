package ab.Sep;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int index = 0;
        int n = words.length;
        while (index < n) {
            String currentWord = words[index];
            int currentLength = words[index].length();
            int last = index + 1;
            while (last < n && currentLength + words[last].length() + 1 <= maxWidth) {
                currentLength += words[last++].length() + 1;
            }
            StringBuilder sb = new StringBuilder();
            // currently it has numOf space
            int numOfSpace = last - index - 1;
            System.out.println("numOfSpace " + numOfSpace);
            // left justified
            if (last == n || numOfSpace == 0) {
                sb.append(words[index]);
                System.out.println("left justified ---sb appended : " + words[index]);
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ").append(words[i]);
                    System.out.println("---sb appended : " + words[i]);
                }
                for(int i = last; i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int space = (maxWidth - currentLength) / numOfSpace;
                System.out.println("space " + space);
                // extra space add to left spacer
                int extra = (maxWidth - currentLength) % numOfSpace;
                System.out.println("extra " + extra);
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    System.out.println("---sb appended : " + words[i]);
                    for (int j = 0; j <= space + ((i - index) < extra ? 1 : 0);j++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[last - 1]);
                System.out.println("---sb appended words[last - 1] : " + words[last - 1]);
            }
            res.add(String.valueOf(sb));
            index = last;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        System.out.println("fullJustify: " + fullJustify(words, maxWidth));
    }
}
