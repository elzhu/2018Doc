package ab.OA;

import java.util.*;

public class Pageination {
    public static List<String> displayPages(List<String> input, int pageSize) {
        List<String> res = new ArrayList<>();
        if (input == null || input.size() == 0) {
            return res;
        }
        List<String> visited = new ArrayList<>();
        Iterator<String> iter = input.iterator();
        boolean reachEnd = false;
        while (iter.hasNext()) {
            String curr = iter.next();
            String hostId = curr.split(",")[0];
            if (!visited.contains(hostId) || reachEnd) {
                res.add(curr);
                visited.add(hostId);
                iter.remove();
            }

            if (visited.size() == pageSize) {
                visited.clear();
                reachEnd = false;
                if (!input.isEmpty()) {
                    res.add("");
                }
                iter = input.iterator();
            }
            if (!iter.hasNext()) {
                iter = input.iterator();
                reachEnd = true;
            }
        }
        return res;
    }
    public static List<String> displayPages2(List<String> input, int pageSize) {
        List<String> res = new ArrayList<>();
        if (input == null || input.size() == 0) {
            return res;
        }
        Iterator<String> iter = input.iterator();
        Set<String> set = new HashSet<>();
        boolean reachEnd = false;
        int counter = 0;
        while (iter.hasNext()) {
            String cur = iter.next();
            String id = cur.split(",")[0];
            if (!set.contains(id) || reachEnd) {
                res.add(cur);
                set.add(id);
                iter.remove();
                counter++;
            }
            if (counter == pageSize) {
                if (!input.isEmpty())
                    res.add(" ");

                set.clear();
                counter = 0;
                reachEnd = false;
                iter = input.iterator();
            }

            if (!iter.hasNext()) {
                reachEnd = true;
                iter = input.iterator();
            }
        }
        return res;
    }
    public static void main(String [] args) {
        int PER_PAGE = 12;

        ArrayList<String> input = new ArrayList<String>();
  //      input.add("host_id,listing_id,score,city");
        input.add("1,28,300.1,San Francisco");
        input.add("4,5,209.1,San Francisco");
        input.add("20,7,208.1,San Francisco");
        input.add("23,8,207.1,San Francisco");
        input.add("16,10,206.1,Oakland");
        input.add("1,16,205.1,San Francisco");
        input.add("6,29,204.1,San Francisco");
        input.add("7,20,203.1,San Francisco");
        input.add("8,21,202.1,San Francisco");
        input.add("2,18,201.1,San Francisco");
        input.add("2,30,200.1,San Francisco");
        input.add("15,27,109.1,Oakland");
        input.add("10,13,108.1,Oakland");
        input.add("11,26,107.1,Oakland");
        input.add("12,9,106.1,Oakland");
        input.add("13,1,105.1,Oakland");
        input.add("22,17,104.1,Oakland");
        input.add("1,2,103.1,Oakland");
        input.add("28,24,102.1,Oakland");
        input.add("18,14,11.1,San Jose");
        input.add("6,25,10.1,Oakland");
        input.add("19,15,9.1,San Jose");
        input.add("3,19,8.1,San Jose");
        input.add("3,11,7.1,Oakland");
        input.add("27,12,6.1,Oakland");
        input.add("1,3,5.1,Oakland");
        input.add("25,4,4.1,San Jose");
        input.add("5,6,3.1,San Jose");
        input.add("29,22,2.1,San Jose");
        input.add("30,23,1.1,San Jose");
        System.out.println("-------displayPages2 : " + displayPages2(input, PER_PAGE));
    }
}
