package ab.Aug;

import java.util.*;

public class buddyList {
    private List<Buddy> buddies;
    private Set<String> myWishList;

    public buddyList(Set<String> myWishList, Map<String, Set<String>> friendsWishList) {
        this.buddies = new ArrayList<>();
        this.myWishList = myWishList;
        for (String name : friendsWishList.keySet()) {
            Set<String> wishList = friendsWishList.get(name);
            Set<String> intersections = new HashSet<>(wishList);
            intersections.retainAll(myWishList);
            int similarity = intersections.size();
            if (similarity >= wishList.size()/2) {
                buddies.add(new Buddy(name, similarity, wishList));
            }
        }
    }

    public List<Buddy> getSortedBuddy() {
        Collections.sort(buddies);
        List<Buddy>  res = new ArrayList<>(buddies);
        return res;
    }

    public List<String> recommendCities(int k) {
        List<String> res = new ArrayList<>();
        List<Buddy> buddies = getSortedBuddy();
        int i = 0;
        while (k > 0 && i < buddies.size()) {
            Set<String> diff = new HashSet<>(buddies.get(i).wishList);
            diff.removeAll(myWishList);
            if(diff.size() <= k) {
                res.addAll(diff);
                k -= diff.size();
                i++;
            } else {
                Iterator<String> itr = diff.iterator();
                while (k > 0) {
                    res.add(itr.next());
                    k--;
                }
            }
        }
        return res;
    }
}

class Buddy implements Comparable<Buddy>{
    String name;
    int similarity;
    Set<String> wishList;
    Buddy(String name, int similarity, Set<String> wishList) {
        this.name = name;
        this.similarity = similarity;
        this.wishList = wishList;
    }
    @Override
    public int compareTo(Buddy that) {
        return that.similarity - this.similarity;
    }
}
