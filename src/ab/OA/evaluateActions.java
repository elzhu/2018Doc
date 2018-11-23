package ab.OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class evaluateActions {
    static List<String> evaluateActions(List<String> actions) {
        List<String> result = new ArrayList<>();
        List<String[]> nActions = new ArrayList<>();

        HashMap<String, String> names = new HashMap<>(); // name , location
        HashMap<String, List<String>> locations = new HashMap<>();// location, list of names
        HashMap<String, Integer> strengths = new HashMap<>();// name strength
        HashMap<String, Integer> locationStrengths = new HashMap<>();// location strength
        HashMap<Integer, List<String>> sameStrengths = new HashMap<>();// locationstrength locationlist

        // O(actions.size()) get all String[] of actions
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
                String extraVariable = act[3];
                names.put(name, extraVariable);
                strengths.put(name, 1);
                if (locations.get(extraVariable) == null) {
                    locations.put(extraVariable, new ArrayList());
                    locationStrengths.put(extraVariable, 1);
                }
                locations.get(extraVariable).add(name);

            } else {
                if (locations.get(location) == null) {
                    locations.put(location, new ArrayList());
                    locationStrengths.put(location, 1);
                }
                strengths.put(name, 1);
                names.put(name, location);
                locations.get(location).add(name);
            }
        }

        // O(nActions.size()) update strengths and locationStrengths consider support and war
        for (int i = 0; i < nActions.size(); i++) {
            String[] act = nActions.get(i);
            String name = act[0];
            String location = names.get(name);
            String action = act[2];

            if (action.equals("Support") && locations.get(location).size() < 2) {
                String extra = act[3];
                int newStrength = locationStrengths.get(names.get(extra))  + 1;
                strengths.put(extra, newStrength);
                int newLocationStrength = Math.max(locationStrengths.get(names.get(extra)), newStrength);
                locationStrengths.put(names.get(extra), newLocationStrength);

                if (sameStrengths.get(newLocationStrength) == null ) {
                    ArrayList locationWithSameStrength = new ArrayList<String>();
                    locationWithSameStrength.add(names.get(extra));
                    sameStrengths.put(newLocationStrength, locationWithSameStrength);
                } else {
                    sameStrengths.get(newLocationStrength).add(names.get(extra));
                    sameStrengths.put(newLocationStrength,  sameStrengths.get(newLocationStrength));
                }
            } else {

            }
        }

        //  O(nActions.size()) Prepare output
        for (int i = 0; i < nActions.size(); i++) {
            String[] act = nActions.get(i);
            String name = act[0];
            String location = names.get(name);
            List<String> allInLocation = locations.get(location);
            if (allInLocation.size() == 1) {
                result.add(name + " " + location);
            } else {
                    if (!locationStrengths.get(location).equals(strengths.get(name))) {
                        result.add(name + " " + "[dead]");
                    } else {
                        if (sameStrengths.get(locationStrengths.get(location)) == null || sameStrengths.get(locationStrengths.get(location)).size() < 2) {
                            result.add(name + " " + location);
                        } else {
                            result.add(name + " " + "[dead]");
                        }
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

        System.out.println( evaluateActions(actions));

    }
}
