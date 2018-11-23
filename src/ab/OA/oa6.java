package ab.OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
input:
A Paris Move London
B London Hold

Output:
A [dead]
B [dead]
 */
public class oa6 {
    // Complete the evaluateActions function below.
    static List<String> evaluateActions(List<String> actions) {
        Map<String, List<String>> locations = new HashMap<>(); // location, name
        Map<String, Integer> locationStrength = new HashMap<>();
        Map<String, String> names = new HashMap<>(); // name, location
        Map<String, Integer> strength = new HashMap<>(); // name, strength

        List<String[]> nActions = new ArrayList<>();

        List<String> result = new ArrayList<>();

        for (int i = 0; i < actions.size(); i++) {
            nActions.add(actions.get(i).split(" "));
        }

        // O(nActions.size()) Process names and locations map and update strengths without consider support
        for (int i = 0; i < nActions.size(); i++) {
            String[] act = nActions.get(i);
            String name = act[0];
            String location = act[1];
            String action = act[2];

            if (action.equals("Move")) {
                String extra = act[3];
                names.put(name, extra);
                strength.put(name, 1);
                if (locations.get(extra) == null) {
                    locations.put(extra, new ArrayList());
                    locationStrength.put(extra, 1);
                }
                locations.get(extra).add(name);
            } else {
                if (locations.get(location) == null) {
                    locations.put(location, new ArrayList());
                    locationStrength.put(location, 1);
                }
                strength.put(name, 1);
                names.put(name, location);
                locations.get(location).add(name);
            }
        }

        // O(nActions.size()) update strengths consider support and war
        for (int i = 0; i < nActions.size(); i++) {
            String[] act = nActions.get(i);
            String name = act[0];
            String action = act[2];
            String location = names.get(name);

            if (action.equals("Support") && locations.get(location).size() < 2) {
                String extra = act[3];
                int newStrength = strength.get(extra) + 1;
                strength.put(extra, newStrength);

                int newLocationStrength = Math.max(locationStrength.get(location), newStrength);
                locationStrength.put(location, newLocationStrength);
            }
        }

        // Loop by each locations, and get result
        for (int i = 0; i < nActions.size(); i++) {
            String[] act = nActions.get(i);
            String name = act[0];
            String currLocation = names.get(name);
            int currStrength = strength.get(name);
            List<String> allInLocation = locations.get(currLocation);

            if (allInLocation.size() == 1) {
                result.add(name + " " + currLocation);
            } else {
                int maxStrength = 0;

                for (int j = 0; j < allInLocation.size(); j++) {
                    String aName = allInLocation.get(j);
                    if (!aName.equals(name)) {
                        maxStrength = Math.max(strength.get(aName), maxStrength);
                    }
                }

                if (maxStrength >= currStrength) {
                    result.add(name + " " + "[dead]");
                } else {
                    result.add(name + " " + currLocation);
                }
            }
        }

        return result;

    }

    public static void main(String [] args) {
        List<String> actions = new ArrayList<>();
        actions.add("A Paris Move London");
        actions.add("B London Hold");
        actions.add("C London Hold");
        actions.add("D Boling Support F");
        actions.add("E Kyoto Move Toyto");
        actions.add("F Toyto Hold");

        System.out.println("-------evaluateActions : " + evaluateActions(actions));

    }

}
