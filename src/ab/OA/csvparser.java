package ab.OA;
import java.io.*;
import java.util.*;

public class csvparser {

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */


        public static void main(String[] args) {
                //#1
                ArrayList<String> output = parseCSV("John,Smith,john.smith@gmail.com,Los Angeles,1");
            String strOutput = printStr(output);
                    System.out.println(strOutput);
            //#2.留学论坛-一亩-三分地
            output = parseCSV("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0");
            strOutput = printStr(output);
            System.out.println(strOutput);
            output = parseCSV("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1");
            strOutput = printStr(output);
            System.out.println(strOutput);
        }

        public static ArrayList<String> parseCSV(String str) {
            ArrayList<String> res = new ArrayList<String>();
            boolean inQuote = false;
            StringBuilder buffer = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                if(inQuote) {
                    if(str.charAt(i) == '"') {
                        if(i == str.length()-1) {
                            res.add(buffer.toString());
                            return res;
                        } else if(str.charAt(i+1) == '"') {
                            buffer.append('"');
                            i++;
                        } else {
                            res.add(buffer.toString());
                            buffer.setLength(0);
                            inQuote = false;
                            i++;
                        }
                    } else buffer.append(str.charAt(i));
                } else {
                    if(str.charAt(i) == '"') {
                        inQuote = true;
                    } else if( str.charAt(i) == ',') {
                        res.add(buffer.toString());
                        buffer.setLength(0);
                    } else {
                        buffer.append(str.charAt(i));
                    }


                }

            }
            if(buffer.length() > 0) res.add(buffer.toString());
            return res;
        }

        public static String printStr(ArrayList<String> list) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                res.append(list.get(i));
                res.append('|');
            }
            res.append(list.get(list.size() - 1));
            return res.toString();
        }

}
