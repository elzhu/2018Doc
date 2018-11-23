package ab.Sep;

import java.util.ArrayList;
import java.util.List;

public class csvparser {
    public static String csvParser(String str) {
        String[] strArray = str.split("\n");
        String result = "";
        for (int i = 0; i < strArray.length; i++) {
            String current = strArray[i].replace(",", "|");
            System.out.println("------current: " + current);
            result = result +  current + "\n";
        }

        return result;
    }

    public static String csvParser2(String str) {
       List<String> res = new ArrayList<>();
       boolean inQuote = false;
       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (inQuote) {
                if (str.charAt(i) == '\"') {
                    if (i < str.length() - 1 && str.charAt(i + 1) == '\"') {
                        sb.append("\"");
                        i++;
                    } else {
                        inQuote = false;
                    }
                } else {
                    sb.append(str.charAt(i));
                }
            }else {
                if (str.charAt(i) == '\"') {
                    inQuote = true;
                } else if (str.charAt(i) == ',') {
                    res.add(sb.toString());
                    sb.setLength(0);
                }
                else {
                    sb.append(str.charAt(i));
                }
            }
        }
        if (sb.length() > 0) {
            res.add(sb.toString());
        }
        return String.join("|", res);
    }

    public static void main(String[] arge) {
        String str = "John, Smith, john.smith@gmail.com, Los Angeles, 1\n \"jane\", Roberts\n Alexandra, alex \n";

        System.out.println("------csvParser: " + csvParser2(str));
    }
}
