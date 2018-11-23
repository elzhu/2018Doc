package leetcode.HashMap;

import java.util.*;

public class TravelBuddle {
    private List<Buddy> buddies;
    private Set<String> myList;
    private Map<String, Set<String>> friendLists;

    public TravelBuddle(Set<String> myList, Map<String, Set<String>> friendLists) {
        this.myList = myList;
        this.friendLists = friendLists;
    }

    public List<Buddy> findBuddies() {
        List<Buddy> buddies = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : friendLists.entrySet()) {
            Set<String> common = new HashSet<>(myList);
            String name = entry.getKey();
            Set<String> wishList = entry.getValue();
            common.retainAll(wishList);
            if (common.size() >= myList.size() / 2) {
                buddies.add(new Buddy(name, common.size(), wishList));
            }
        }
        Collections.sort(buddies, new Comparator<Buddy>() {
            @Override
            public int compare(Buddy o1, Buddy o2) {
                return o2.sim - o1.sim;
            }
        });

        this.buddies = buddies;
        return buddies;
    }

    public Set<String> recommend(int k) {
        int count = 0;
        Set<String> result = new LinkedHashSet<>();
        for (Buddy buddy : buddies) {
            Set<String> diff = new HashSet<>(buddy.list);
            diff.removeAll(myList);
            for (String city : diff) {
                if (count < k) {
                    if (result.add(city)) {
                        count++;
                    } else {
                        return result;
                    }
                }
            }
        }
        return result;
    }

}
